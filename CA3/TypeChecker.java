package main.visitor.typeChecker;

import com.sun.jdi.VoidType;
import main.ast.nodes.*;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.NullValue;
import main.ast.nodes.expression.values.SetValue;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.primitives.ClassType;
import main.compileError.typeError.*;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.set.*;
import main.ast.types.NoType;
import main.ast.types.Type;
import main.ast.types.array.*;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.IntType;
import main.ast.types.set.SetType;
import main.compileError.typeError.UnsupportedTypeForPrint;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.ClassSymbolTableItem;
import main.symbolTable.items.MethodSymbolTableItem;
import main.symbolTable.utils.graph.Graph;
import main.util.ArgPair;
import main.visitor.*;

import javax.swing.plaf.nimbus.State;
import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TypeChecker extends Visitor<Void> {
    private Graph<String> classHierarchy;
    ExpressionTypeChecker expressionTypeChecker;
    private ClassDeclaration currentClass;
    private MethodDeclaration currentMethod;
    private Boolean hasReturn = false;
    private String accessedClassName;
    private Boolean allCondHasRet = true;
    private Boolean hasUnReachableStmt = false;
    private Boolean classErrorRaised = false;

    public TypeChecker(Graph<String> classHierarchy){
        this.classHierarchy = classHierarchy;
        this.classHierarchy = classHierarchy;
        this.expressionTypeChecker = new ExpressionTypeChecker(classHierarchy);
    }

    public static boolean isSubType(Type el1, Type el2)
    {
        if(el1 instanceof NoType || el2 instanceof NoType)
            return true;
        if(el1 instanceof IntType  && el2 instanceof IntType)
            return true;
        if(el1 instanceof BoolType && el2 instanceof BoolType)
            return true;
        if(el1 instanceof main.ast.types.primitives.VoidType && el2 instanceof main.ast.types.primitives.VoidType)
            return true;
        if (el1 instanceof SetType && el2 instanceof SetType)
            return true;
        if (el1 instanceof ArrayType && el2 instanceof ArrayType)
            return isSubType(((ArrayType) el1).getType(), ((ArrayType) el2).getType());

        if (el1 instanceof ClassType && el2 instanceof ClassType)
            if (((ClassType) el1).getClassName().getName().equals(((ClassType) el2).getClassName().getName()))
                return true;

        if(el1 instanceof FptrType && el2 instanceof FptrType) {
            Type el1RetType = ((FptrType) el1).getReturnType();
            Type el2RetType = ((FptrType) el2).getReturnType();
            if (!isSubType(el1RetType, el2RetType))
                return false;
            ArrayList<Type> el1ArgsTypes = ((FptrType) el1).getArgumentsTypes();
            ArrayList<Type> el2ArgsTypes = ((FptrType) el2).getArgumentsTypes();

            if (el1ArgsTypes.size() != el2ArgsTypes.size())
                return false;
            else
                for (int i = 0; i < el1ArgsTypes.size(); i++)
                    if (!isSubType(el1ArgsTypes.get(i), el2ArgsTypes.get(i)))
                        return false;
            return true;
        }
        return false;
    }

    public boolean isLeftValue(Expression expr){
        if(expr instanceof Identifier){
            try {
                ClassSymbolTableItem currentClass = (ClassSymbolTableItem) SymbolTable.root
                        .getItem(ClassSymbolTableItem.START_KEY + accessedClassName, true);
                try {
                    String methodKey = MethodSymbolTableItem.START_KEY + ((Identifier) expr).getName();
                    MethodSymbolTableItem calledMethod = (MethodSymbolTableItem) currentClass.getClassSymbolTable()
                            .getItem(methodKey, true);
                } catch (ItemNotFoundException e) {

                    return true;
                }
            } catch (ItemNotFoundException e) {
                return false;
            }
        }
        if(expr instanceof ArrayAccessByIndex){
            return isLeftValue(((ArrayAccessByIndex)expr).getInstance());
        }
        if(expr instanceof ObjectMemberAccess){
            return isLeftValue(((ObjectMemberAccess)expr).getMemberName());
        }
        return false;
    }

    @Override
    public Void visit(Program program) {
        //todo
        for(VariableDeclaration varDeclaration : program.getGlobalVariables())
            varDeclaration.accept(this);

        boolean hasMain = false;
        for(ClassDeclaration classDeclaration : program.getClasses())
            if(classDeclaration.getClassName().getName().equals("Main"))
                hasMain = true;
        if(!hasMain)
            program.addError(new NoMainClass());

        for(ClassDeclaration classDeclaration : program.getClasses())
            classDeclaration.accept(this);

        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        classDeclaration.getClassName().accept(expressionTypeChecker);
        if(classDeclaration.getClassName().getName().equals("Main")) {
            if(classDeclaration.getParentClassName() != null) {
                if (classDeclaration.getParentClassName().getName() != null)
                    classDeclaration.addError(new MainClassCantInherit(classDeclaration.getLine()));

                boolean hasInit = false;
                for (MethodDeclaration methodDeclaration : classDeclaration.getMethods()) {
                    if (methodDeclaration.getMethodName().getName().equals("Initialize")) {
                        hasInit = true;
                        ArrayList<ArgPair> initArgs = methodDeclaration.getArgs();
                        if (initArgs.size() != 0)
                            classDeclaration.addError(new MainConstructorCantHaveArgs(classDeclaration.getLine()));
                    }
                    if (!hasInit)
                        classDeclaration.addError(new NoConstructorInMainClass(classDeclaration));
                }
            }
        }

        if(classDeclaration.getParentClassName() != null) {
            VariableDeclaration temp = new VariableDeclaration(new Identifier("dummy"),
                    new ClassType(classDeclaration.getParentClassName()));
            temp.setLine(classDeclaration.getLine());
            temp.accept(this);
            if(classErrorRaised)
                classDeclaration.addError(new ClassNotDeclared(classDeclaration.getLine(), classDeclaration.getParentClassName().getName()));

            if(classDeclaration.getParentClassName().getName().equals("Main"))
                classDeclaration.addError(new CannotExtendFromMainClass(classDeclaration.getLine()));
        }


        accessedClassName = classDeclaration.getClassName().getName();
        expressionTypeChecker.setCurrentClass(accessedClassName);
        if(classDeclaration.getConstructor() != null)
            classDeclaration.getConstructor().accept(this);

        for(MethodDeclaration methodDeclaration : classDeclaration.getMethods())
            methodDeclaration.accept(this);

        for(FieldDeclaration fieldDeclaration : classDeclaration.getFields())
            fieldDeclaration.accept(this);

        accessedClassName = null;
        expressionTypeChecker.setCurrentClass(null);
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        //todo
        currentMethod = constructorDeclaration;
        expressionTypeChecker.setCurrentMethod(currentMethod.getMethodName().getName());

        constructorDeclaration.getArgs().stream().map(a -> a.getVariableDeclaration().accept(this))
                .collect(Collectors.toList());

        for(ArgPair arg : constructorDeclaration.getArgs()){
            if(arg.getDefaultValue() != null) {
                Type argTypes = arg.getDefaultValue().accept(expressionTypeChecker);
                if (argTypes.toString().equals("VoidType"))
                    constructorDeclaration.addError(new CantUseValueOfVoidMethod(constructorDeclaration.getLine()));
            }
        }

        for(VariableDeclaration vd : constructorDeclaration.getLocalVars())
            vd.accept(this);

        for(Statement b : constructorDeclaration.getBody()) {
            b.accept(this);
        }

        currentMethod = null;
        expressionTypeChecker.setCurrentMethod(null);
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        //todo
        currentMethod = methodDeclaration;
        expressionTypeChecker.setCurrentMethod(currentMethod.getMethodName().getName());

        methodDeclaration.getArgs().stream().map(a -> a.getVariableDeclaration().accept(this))
                .collect(Collectors.toList());

        for(ArgPair arg : methodDeclaration.getArgs()){
            if(arg.getDefaultValue() != null) {
                Type argTypes = arg.getDefaultValue().accept(expressionTypeChecker);
                if (argTypes.toString().equals("VoidType"))
                    methodDeclaration.addError(new CantUseValueOfVoidMethod(methodDeclaration.getLine()));
            }
        }

        for(VariableDeclaration vd : methodDeclaration.getLocalVars())
            vd.accept(this);

        for(Statement b : methodDeclaration.getBody()) {
            if(hasReturn || hasUnReachableStmt) {
                b.addError(new UnreachableStatements(b));
                hasUnReachableStmt = true;
            } else {
                b.accept(this);
            }
            if(b instanceof ReturnStmt)
                hasReturn = true;
        }

        if((!(hasReturn || allCondHasRet) || methodDeclaration.getBody().size() == 0)
                && !((methodDeclaration.getReturnType().toString())).toString().equals("VoidType"))
            methodDeclaration.addError(new MissingReturnStatement(methodDeclaration));

        expressionTypeChecker.setCurrentMethod(null);
        currentMethod = null;
        hasReturn = false;
        hasUnReachableStmt = false;
        allCondHasRet = false;

        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        //todo
        Type givenReturnedType = returnStmt.getReturnedExpr().accept(expressionTypeChecker);
        Type expectedReturnType = currentMethod.getReturnType();
        if(expectedReturnType instanceof VoidType) {
            returnStmt.addError(new VoidMethodHasReturn(currentMethod));
            return null;
        }
        if(!TypeChecker.isSubType(givenReturnedType, expectedReturnType))
            returnStmt.addError(new ReturnValueNotMatchMethodReturnType(returnStmt));
        return null;
    }

    private Boolean blockHasReturn(Statement Stmt) {
        if(Stmt instanceof BlockStmt) {
            for (Statement stmt : ((BlockStmt) Stmt).getStatements())
                if (stmt instanceof ReturnStmt)
                    return true;
            return false;
        }
        else return Stmt instanceof ReturnStmt;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        //todo
        fieldDeclaration.getVarDeclaration().accept(this);
        return null;
    }

    @Override
    public Void visit(VariableDeclaration varDeclaration) {
        //todo
        Type varDec = varDeclaration.getType();

        if(varDec instanceof ArrayType) {
            for (Expression e : ((ArrayType) varDec).getDimensions()) {
                Type arrayDim = e.accept(expressionTypeChecker);
                if (((IntValue) e).getConstant() == 0)
                    varDeclaration.addError(new CannotHaveEmptyArray(varDeclaration.getLine()));
            }
        }
        else if(varDec instanceof ClassType) {
            try{
                ClassSymbolTableItem currentClass = (ClassSymbolTableItem) SymbolTable.root
                        .getItem(ClassSymbolTableItem.START_KEY + ((ClassType)varDec).getClassName().getName(), true);
                classErrorRaised = false;
            } catch(ItemNotFoundException classNotFound) {
                classErrorRaised = true;
                varDeclaration.addError(new ClassNotDeclared(varDeclaration.getLine(), ((ClassType)varDec).getClassName().getName()));
            }
        }

        varDeclaration.getVarName().accept(this);
        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        //todo
        Type lType = assignmentStmt.getlValue().accept(expressionTypeChecker);
        Type rType = assignmentStmt.getrValue().accept(expressionTypeChecker);
        Expression le = assignmentStmt.getlValue();
        if (!isLeftValue(le)) {
            assignmentStmt.addError(new LeftSideNotLvalue(assignmentStmt.getLine()));
        }

        if (rType.toString().equals("VoidType")) {
            assignmentStmt.addError(new CantUseValueOfVoidMethod(assignmentStmt.getLine()));
        }
        else if(!TypeChecker.isSubType(lType, rType))
            assignmentStmt.addError(new UnsupportedOperandType(assignmentStmt.getLine(), "assign"));
        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        Boolean localHasUnReachableStmt = false;
        for (Statement stmt : blockStmt.getStatements()) {
            if(localHasUnReachableStmt) {
                hasUnReachableStmt = true;
                return null;
            }
            stmt.accept(this);
            if(stmt instanceof ReturnStmt)
                localHasUnReachableStmt = true;
        }
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        //todo
        allCondHasRet &= blockHasReturn((conditionalStmt.getThenBody()));
        for (ElsifStmt e : conditionalStmt.getElsif())
            allCondHasRet &= blockHasReturn(e.getThenBody());
        if(conditionalStmt.getElseBody() != null)
            allCondHasRet &= blockHasReturn(conditionalStmt.getElseBody());

        Type condType = conditionalStmt.getCondition().accept(expressionTypeChecker);

        if (condType.toString().equals("VoidType"))
            conditionalStmt.addError(new CantUseValueOfVoidMethod(conditionalStmt.getLine()));

        else if(!(condType instanceof BoolType) && !(condType instanceof NoType))
            conditionalStmt.addError(new ConditionNotBool(conditionalStmt.getLine()));

        conditionalStmt.getThenBody().accept(this);

        for(ElsifStmt elseIf : conditionalStmt.getElsif())
            elseIf.accept(this);


        if(conditionalStmt.getElseBody() != null)
            conditionalStmt.getElseBody().accept(this);
        return null;
    }

    @Override
    public Void visit(ElsifStmt elsifStmt) {
        Type condType = elsifStmt.getCondition().accept(expressionTypeChecker);

        if (condType.toString().equals("VoidType"))
            elsifStmt.addError(new CantUseValueOfVoidMethod(elsifStmt.getLine()));

        else if(!(condType instanceof BoolType) && !(condType instanceof NoType))
            elsifStmt.addError(new ConditionNotBool(elsifStmt.getLine()));

        elsifStmt.getThenBody().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCallStmt methodCallStmt) {
        //todo
        methodCallStmt.getMethodCall().accept(expressionTypeChecker);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        Type argType = print.getArg().accept(expressionTypeChecker);

        if (argType.toString().equals("VoidType")) {
            print.addError(new CantUseValueOfVoidMethod(print.getLine()));
            return null;
        }

        else if(!(argType instanceof IntType || argType instanceof ArrayType || argType instanceof SetType ||
                argType instanceof BoolType || argType instanceof NoType || argType instanceof VoidType)) {
            UnsupportedTypeForPrint exception = new UnsupportedTypeForPrint(print.getLine());
            print.addError(exception);
        }

        return null;
    }

    @Override
    public Void visit(EachStmt eachStmt) {
        Type eachVariable = eachStmt.getVariable().accept(expressionTypeChecker);
        Type eachList = eachStmt.getList().accept(expressionTypeChecker);

        if (eachList instanceof VoidType)
            eachStmt.addError(new CantUseValueOfVoidMethod(eachStmt.getLine()));
        else if(!(eachList instanceof ArrayType) && !(eachList instanceof NoType))
            eachStmt.addError(new EachCantIterateNoneArray(eachStmt.getLine()));
        else if (!(eachList instanceof NoType) && !isSubType(eachVariable, ((ArrayType) eachList).getType()))
            eachStmt.addError(new EachVarNotMatchList(eachStmt));

        if(!(eachStmt.getBody() instanceof BlockStmt))
            if(eachStmt.getBody() instanceof  ReturnStmt)
                hasUnReachableStmt = true;

        eachStmt.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(SetDelete setDelete) {
        Type deleteType = setDelete.getSetArg().accept(expressionTypeChecker);
        if(!(deleteType instanceof SetType) && !(deleteType instanceof NoType))
            setDelete.addError(new CallOnNoneCallable(setDelete.getLine()));

        Type eType = setDelete.getElementArg().accept(expressionTypeChecker);
//        if(!(eType instanceof IntType))
//            setDelete.addError(new AddInputNotInt(setDelete.getLine()));
        return null;
    }

    @Override
    public Void visit(SetMerge setMerge) {
        Type mergeType = setMerge.getSetArg().accept(expressionTypeChecker);

        if (mergeType.toString().equals("VoidType"))
            setMerge.addError(new CantUseValueOfVoidMethod(setMerge.getLine()));
        else if(!(mergeType instanceof SetType) && !(mergeType instanceof NoType))
            setMerge.addError(new CallOnNoneCallable(setMerge.getLine()));

        ArrayList<Expression> elementArgs = setMerge.getElementArgs();
        for(Expression e : elementArgs)
        {
            Type eType = e.accept(expressionTypeChecker);
            if (eType.toString().equals("VoidType"))
                setMerge.addError(new CantUseValueOfVoidMethod(setMerge.getLine()));
            else if(!((eType instanceof IntType) || (eType instanceof SetType))) {
                setMerge.addError(new MergeInputNotSet(setMerge.getLine()));
                return null;
            }
        }
        return null;
    }

    @Override
    public Void visit(SetAdd setAdd) {
        Type addType = setAdd.getSetArg().accept(expressionTypeChecker);
        if (addType.toString().equals("VoidType"))
            setAdd.addError(new CantUseValueOfVoidMethod(setAdd.getLine()));
        else if(!(addType instanceof SetType) && !(addType instanceof NoType))
            setAdd.addError(new CallOnNoneCallable(setAdd.getLine()));

        Expression elementArg = setAdd.getElementArg();
        Type eType = elementArg.accept(expressionTypeChecker);
        if (eType.toString().equals("VoidType"))
            setAdd.addError(new CantUseValueOfVoidMethod(setAdd.getLine()));
        else if(!(eType instanceof IntType))
            setAdd.addError(new AddInputNotInt(setAdd.getLine()));
        return null;
    }
}
