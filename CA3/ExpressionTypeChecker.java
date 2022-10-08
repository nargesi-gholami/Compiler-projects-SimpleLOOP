package main.visitor.typeChecker;

import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.ast.nodes.expression.values.NullValue;
import main.ast.nodes.expression.values.SetValue;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.types.NoType;
import main.ast.types.Type;
import main.ast.types.array.ArrayType;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.ClassType;
import main.ast.types.primitives.IntType;
import main.ast.types.primitives.VoidType;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.set.SetType;
import main.compileError.CompileError;
import main.compileError.typeError.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.items.ClassSymbolTableItem;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.utils.graph.Graph;
import main.util.ArgPair;
import main.visitor.Visitor;
import main.symbolTable.items.*;
import parsers.SimpleLOOPParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExpressionTypeChecker extends Visitor<Type> {
    private Graph<String> classHierarchy;
    private boolean isIncluded = false;
    private String accessedClassName;
    private String accessedFPTRName;
    Boolean isObjectMemberAccess = false;
    private String currentMethodScope;
    private String currentClassScope;

    public void setCurrentMethod(String newMethod) { currentMethodScope = newMethod; }
    public void setCurrentClass(String newClass) { currentClassScope = newClass; }

    public ExpressionTypeChecker(Graph<String> classHierarchy) {
        this.classHierarchy = classHierarchy;
    }

    public boolean equalType(Type el1,Type el2){
        if(el1 instanceof NoType || el2 instanceof NoType)
            return true;
        if(el1 instanceof IntType  && el2 instanceof IntType)
            return true;
        if(el1 instanceof BoolType && el2 instanceof BoolType)
            return true;
        if(el1 instanceof VoidType && el2 instanceof VoidType)
            return true;
        if (el1 instanceof SetType && el2 instanceof SetType)
            return true;
        if (el1 instanceof ArrayType && el2 instanceof ArrayType)
            return equalType(((ArrayType) el1).getType(), ((ArrayType) el2).getType());

        if (el1 instanceof ClassType && el2 instanceof ClassType)
            if (((ClassType) el1).getClassName().getName().equals(((ClassType) el2).getClassName().getName()))
                return true;

        if(el1 instanceof FptrType && el2 instanceof FptrType) {
            Type el1RetType = ((FptrType) el1).getReturnType();
            Type el2RetType = ((FptrType) el2).getReturnType();
            if (!equalType(el1RetType, el2RetType))
                return false;
            ArrayList<Type> el1ArgsTypes = ((FptrType) el1).getArgumentsTypes();
            ArrayList<Type> el2ArgsTypes = ((FptrType) el2).getArgumentsTypes();

            if (el1ArgsTypes.size() != el2ArgsTypes.size())
                return false;
            else
                for (int i = 0; i < el1ArgsTypes.size(); i++)
                    if (!equalType(el1ArgsTypes.get(i), el2ArgsTypes.get(i)))
                        return false;
            return true;
        }
        return false;
    }
    //class c   a.b = 10;
    public boolean isLeftValue(Expression expr){
        if(expr instanceof Identifier){
            try {
                ClassSymbolTableItem currentClass;
                if(accessedClassName != null)
                    currentClass = (ClassSymbolTableItem) SymbolTable.root
                            .getItem(ClassSymbolTableItem.START_KEY + accessedClassName, true);
                else
                    currentClass = (ClassSymbolTableItem) SymbolTable.root
                            .getItem(ClassSymbolTableItem.START_KEY + currentClassScope, true);
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
            return isLeftValue(((ObjectMemberAccess)expr).getInstance());
        }
        return false;
    }
    //

    private Type getIdentifierType(Identifier id){
        String name = id.getName();
        try {
            String globalKey = GlobalVariableSymbolTableItem.START_KEY + name;
            LocalVariableSymbolTableItem globalItem = (LocalVariableSymbolTableItem) SymbolTable.root.getItem(globalKey, true);
            return globalItem.getType();
        }
        catch(ItemNotFoundException globalNotFound) {
            try {
                ClassSymbolTableItem currentClass = (ClassSymbolTableItem) SymbolTable.root
                        .getItem(ClassSymbolTableItem.START_KEY + name, true);
                return new ClassType(id);
            } catch (ItemNotFoundException classNotFound) {
                try {
                    ClassSymbolTableItem currentClass;
                    if(isIncluded)
                        currentClass = (ClassSymbolTableItem) SymbolTable.root
                                .getItem(ClassSymbolTableItem.START_KEY + accessedClassName, true);
                    else
                        currentClass = (ClassSymbolTableItem) SymbolTable.root
                                .getItem(ClassSymbolTableItem.START_KEY + currentClassScope, true);
                    MethodSymbolTableItem calledMethod = (MethodSymbolTableItem) currentClass.getClassSymbolTable()
                            .getItem(MethodSymbolTableItem.START_KEY + name, true);

                    return calledMethod.getReturnType();
                } catch (ItemNotFoundException methodNotFound) {
                    try{
                        ClassSymbolTableItem currentClass;
                        if(isIncluded)
                            currentClass = (ClassSymbolTableItem) SymbolTable.root
                                    .getItem(ClassSymbolTableItem.START_KEY + accessedClassName, true);
                        else
                            currentClass = (ClassSymbolTableItem) SymbolTable.root
                                    .getItem(ClassSymbolTableItem.START_KEY + currentClassScope, true);
                        MethodSymbolTableItem calledMethod = (MethodSymbolTableItem) currentClass.getClassSymbolTable()
                                .getItem(MethodSymbolTableItem.START_KEY + currentMethodScope, true);
                        LocalVariableSymbolTableItem localVar = (LocalVariableSymbolTableItem) calledMethod.getMethodSymbolTable()
                                .getItem(LocalVariableSymbolTableItem.START_KEY + name, true);
                        return localVar.getType();
                    }
                    catch (ItemNotFoundException localVarNotFound){
                        try {
                            ClassSymbolTableItem currentClass;
                            if(isIncluded)
                                currentClass = (ClassSymbolTableItem) SymbolTable.root
                                        .getItem(ClassSymbolTableItem.START_KEY + accessedClassName, true);
                            else
                                currentClass = (ClassSymbolTableItem) SymbolTable.root
                                        .getItem(ClassSymbolTableItem.START_KEY + currentClassScope, true);
                            FieldSymbolTableItem calledField = (FieldSymbolTableItem) currentClass.getClassSymbolTable()
                                    .getItem(FieldSymbolTableItem.START_KEY + name, true);
                            return calledField.getType();
                        } catch (ItemNotFoundException fieldNotFound) {
                            if (!isObjectMemberAccess) {
                                id.addError(new VarNotDeclared(id.getLine(), id.getName()));
                            }
                            return new NoType();
                        }
                    }
                }
            }
        }
    }

    @Override
    public Type visit(BinaryExpression binaryExpression) {
        Expression le = binaryExpression.getFirstOperand();
        Expression re = binaryExpression.getSecondOperand();
        BinaryOperator operator =  binaryExpression.getBinaryOperator();

        Type tl = le.accept(this);
        Type tr = re.accept(this);

        if (tl instanceof VoidType)
            binaryExpression.addError(new CantUseValueOfVoidMethod(binaryExpression.getLine()));
        if (tr instanceof VoidType)
            binaryExpression.addError(new CantUseValueOfVoidMethod(binaryExpression.getLine()));

        if(tl instanceof VoidType || tr instanceof VoidType)
            return new NoType();

        if (operator.equals(BinaryOperator.and) || operator.equals(BinaryOperator.or))
        {
            if (tl instanceof BoolType && tr instanceof BoolType)
                return new BoolType();

            if ((tl instanceof NoType || tl instanceof BoolType) &&
                    (tr instanceof BoolType || tr instanceof NoType))
                return new NoType();
        }

        else if(operator.equals(BinaryOperator.eq)) {
            if(!equalType(tl,tr)) {
                binaryExpression.addError(new UnsupportedOperandType(re.getLine(), operator.name()));
                return new NoType();
            }
            else {
                if(tl instanceof NoType || tr instanceof NoType)
                    return new NoType();
                else
                    return new BoolType();
            }
        }

        else if(operator.equals(BinaryOperator.assign)) {
            if(!isLeftValue(le))
                binaryExpression.addError(new LeftSideNotLvalue(binaryExpression.getLine()));

            if(!equalType(tl,tr)) {
                binaryExpression.addError(new UnsupportedOperandType(re.getLine(), operator.name()));
                return new NoType();
            }
            else {
                if(tl instanceof NoType || tr instanceof NoType)
                    return new NoType();
                else
                    return tr;
            }
        }

        else if(operator.equals(BinaryOperator.gt) || operator.equals(BinaryOperator.lt)){
            if (tl instanceof IntType && tr instanceof IntType)
                return new BoolType();

            if ((tl instanceof NoType || tl instanceof IntType) &&
                    (tr instanceof IntType || tr instanceof NoType))
                return new NoType();
        }
        else { // + - / *
            if (tl instanceof IntType && tr instanceof IntType)
                return new IntType();
            if ((tl instanceof NoType || tl instanceof IntType) &&
                    (tr instanceof IntType || tr instanceof NoType)) {
                return new NoType();
            }

        }
        le.addError(new UnsupportedOperandType(le.getLine(), operator.name()));
        return new NoType();
    }

    @Override
    public Type visit(NewClassInstance newClassInstance) {
        String className = newClassInstance.getClassType().getClassName().getName();
        if(!classHierarchy.doesGraphContainNode(className)) {
            newClassInstance.addError(new ClassNotDeclared(newClassInstance.getLine(), className));
            return new NoType();
        }

        List<Type> givenArgs = newClassInstance.getArgs().stream().map(a -> a.accept(this)).collect(Collectors.toList());
        for(Expression arg :  newClassInstance.getArgs()){
            Type argTypes = arg.accept(this);
            if (argTypes instanceof VoidType) {
                newClassInstance.addError(new CantUseValueOfVoidMethod(newClassInstance.getLine()));
                return new NoType();
            }
        }

        try {
            ClassSymbolTableItem currentClass = (ClassSymbolTableItem) SymbolTable.root
                    .getItem(ClassSymbolTableItem.START_KEY + className, true);
            try {
                MethodSymbolTableItem calledMethod = (MethodSymbolTableItem)currentClass.getClassSymbolTable()
                        .getItem(MethodSymbolTableItem.START_KEY + "initialize", true);
                List<Type> expectedArgs = calledMethod.getArgTypes();
                List<ArgPair> argPairs = calledMethod.getMethodDeclaration().getArgs();
                if (!argTypesAreSimilar(expectedArgs, givenArgs, argPairs)) {
                    newClassInstance.addError(new ConstructorArgsNotMatchDefinition(newClassInstance));
                    return new NoType();
                }
            } catch (ItemNotFoundException methodNotFound) {
                return new NoType();
            }
        } catch (ItemNotFoundException classNotFound) {
            return new NoType();
        }

        return new ClassType(new Identifier(className));
    }

    @Override
    public Type visit(UnaryExpression unaryExpression) {
        //Todo
        Expression expr = unaryExpression.getOperand();
        UnaryOperator operator =  unaryExpression.getOperator();
        Type exprType = expr.accept(this);

        if (exprType instanceof VoidType) {
            unaryExpression.addError(new CantUseValueOfVoidMethod(unaryExpression.getLine()));
            return new NoType();
        }

        if (operator.equals(UnaryOperator.postinc) || operator.equals(UnaryOperator.postdec))
            if(!isLeftValue(expr))
                unaryExpression.addError(new IncDecOperandNotLvalue(unaryExpression.getLine(),
                        unaryExpression.getOperator().name()));
        if(!(exprType instanceof IntType) && !(exprType instanceof NoType))
            unaryExpression.addError(new UnsupportedOperandType(unaryExpression.getLine(),
                    unaryExpression.getOperator().name()));

        return new IntType();
    }
    private boolean argTypesAreSimilar(List<Type> expectedTypes , List<Type> givenTypes, List<ArgPair> argPairs)
    {
        for (int i = 0; i < expectedTypes.size(); i++) {
            if(i >= givenTypes.size()) {
                if (argPairs.get(i).getDefaultValue() == null)
                    return false;
            }
            else if(!equalType(givenTypes.get(i), expectedTypes.get(i)) &&  !(givenTypes.get(i) instanceof VoidType))
                return false;
        }
        return true;
    }

    @Override
    public Type visit(MethodCall methodCall) {
        //Todo
        Type instanceType = methodCall.getInstance().accept(this);
        if(!(methodCall.getInstance() instanceof ObjectMemberAccess)) {
            methodCall.addError(new CallOnNoneCallable(methodCall.getLine()));
            return new NoType();
        }
        if(instanceType instanceof NoType)
            return new NoType();

        try {
            ClassSymbolTableItem currentClass = (ClassSymbolTableItem) SymbolTable.root
                    .getItem(ClassSymbolTableItem.START_KEY + accessedClassName, true);
            String methodName;
            if(methodCall.getInstance() instanceof ObjectMemberAccess)
                methodName = (((ObjectMemberAccess)methodCall.getInstance()).getMemberName()).getName();
            else
                methodName = (((Identifier)methodCall.getInstance())).getName();
            try {
                MethodSymbolTableItem calledMethod = (MethodSymbolTableItem) currentClass.getClassSymbolTable()
                        .getItem(MethodSymbolTableItem.START_KEY + methodName, true);
                List<Type> givenArgs = methodCall.getArgs().stream().map(a -> a.accept(this)).collect(Collectors.toList());
                for(Expression arg :  methodCall.getArgs()){
                    Type argTypes = arg.accept(this);
                    if (argTypes instanceof VoidType) {
                        methodCall.addError(new CantUseValueOfVoidMethod(methodCall.getLine()));
                    }
                }
                List<Type> expectedArgs = calledMethod.getArgTypes();
                List<ArgPair> argPairs = calledMethod.getMethodDeclaration().getArgs();
                if (!argTypesAreSimilar(expectedArgs, givenArgs, argPairs)) {
                    methodCall.addError(new MethodCallNotMatchDefinition(methodCall.getLine()));
                    return new NoType();
                }
                return calledMethod.getReturnType();
            } catch (ItemNotFoundException methodNotFound) {
                try{
                    FieldSymbolTableItem calledField = (FieldSymbolTableItem) currentClass.getClassSymbolTable()
                            .getItem(MethodSymbolTableItem.START_KEY + methodName, true);
                    methodCall.addError(new CallOnNoneCallable(methodCall.getLine()));
                    return new NoType();
                } catch (ItemNotFoundException fieldNotFound) {
                    methodCall.addError(new MemberNotAvailableInClass(methodCall.getLine(), methodName, currentClass.getName()));
                    return new NoType();
                }
            }
        } catch (ItemNotFoundException classNotFound) {
            if(accessedClassName == null)
                methodCall.addError(new CallOnNoneCallable(methodCall.getLine()));
            return new NoType();
        }
    }

    @Override
    public Type visit(Identifier identifier) {
        return getIdentifierType(identifier);
    }

    @Override
    public Type visit(ArrayAccessByIndex arrayAccessByIndex) {
        //Todo ok
        Type instanceType = arrayAccessByIndex.getInstance().accept(this);
        Type indexType = arrayAccessByIndex.getIndex().accept(this);

        if(indexType instanceof VoidType)
            arrayAccessByIndex.addError(new CantUseValueOfVoidMethod(arrayAccessByIndex.getLine()));
        else if(!(indexType instanceof IntType))
            arrayAccessByIndex.addError(new ArrayIndexNotInt(arrayAccessByIndex.getLine()));


        if(!(instanceType instanceof ArrayType)){
            arrayAccessByIndex.addError(new AccessByIndexOnNoneArray(arrayAccessByIndex.getLine()));
            return new NoType();
        }

        if((indexType instanceof VoidType) || (!(indexType instanceof IntType)))
            return new NoType();
        return ((ArrayType) instanceType).getType();
    }

    @Override
    public Type visit(ObjectMemberAccess objectMemberAccess) {
        //Todo ok
        isObjectMemberAccess = true;
        Type accessType = objectMemberAccess.getInstance().accept(this);
        String memberName = objectMemberAccess.getMemberName().getName();
        if(accessType instanceof ClassType) {
            isIncluded = true;
            accessedClassName = ((ClassType) accessType).getClassName().getName();
            Type instanceType = objectMemberAccess.getMemberName().accept(this);
            if(instanceType instanceof NoType)
                objectMemberAccess.addError(new MemberNotAvailableInClass(objectMemberAccess.getLine(),
                        memberName, accessedClassName));

            isIncluded = false;
            isObjectMemberAccess = false;
            return instanceType;
        }
        if(accessType instanceof FptrType) {
            Type instanceType = objectMemberAccess.getMemberName().accept(this);
            isObjectMemberAccess = false;
            return instanceType;
        } // talk about this error
        else if (accessType instanceof NoType) {
            return new NoType();
        }
        else {
            objectMemberAccess.addError(new AccessOnNonClass(objectMemberAccess.getLine()));
            isObjectMemberAccess = false;
            return new NoType();
        }
    }

    @Override
    public Type visit(SetNew setNew) {
        ArrayList<Expression> args = setNew.getArgs();
        boolean AreIntegers = true;
        for(Expression e : args) {
            Type eType = e.accept(this);
            if(eType instanceof VoidType) {
                setNew.addError(new CantUseValueOfVoidMethod(setNew.getLine()));
                continue;
            }
            if(!(eType instanceof IntType) && !(eType instanceof NoType))
                AreIntegers = false;
        }

        if(!AreIntegers)
        {
            setNew.addError(new NewInputNotSet(setNew.getLine()));
            return new NoType();
        }
        return new SetType();
    }

    @Override
    public Type visit(SetInclude setInclude) {
        //Todo
        Type arg = setInclude.getSetArg().accept(this);
        if(arg instanceof VoidType)
            setInclude.addError(new CantUseValueOfVoidMethod(setInclude.getLine()));
        else if(!(arg instanceof SetType) && !(arg instanceof NoType)) {
            setInclude.addError(new CallOnNoneCallable(setInclude.getLine()));
            return new NoType();
        }

        Type element = setInclude.getElementArg().accept(this);
        if(element instanceof VoidType)
            setInclude.addError(new CantUseValueOfVoidMethod(setInclude.getLine()));
        else if(!(element instanceof IntType) && !(element instanceof NoType)) {
            setInclude.addError(new SetIncludeInputNotInt(setInclude.getLine()));
            return new NoType();
        }
        return new BoolType();
    }

    @Override
    public Type visit(RangeExpression rangeExpression) {
        //Todo
        Type r = rangeExpression.getLeftExpression().accept(this);
        Type l = rangeExpression.getRightExpression().accept(this);

        if(r instanceof VoidType || l instanceof VoidType) {
            rangeExpression.addError(new CantUseValueOfVoidMethod(rangeExpression.getLine()));
        }
        if((!(l instanceof IntType) && !(l instanceof VoidType)) ||
                (!(r instanceof IntType) && !(r instanceof VoidType)))
        {
            rangeExpression.addError(new EachRangeNotInt(rangeExpression.getLine()));
            return new NoType();
        }
        ArrayList<Expression> dimensions = new ArrayList<>();
        dimensions.add(new IntValue(1));
        return new ArrayType(new IntType(), dimensions);
    }

    @Override
    public Type visit(TernaryExpression ternaryExpression) {
        //Todo
        Type c = ternaryExpression.getCondition().accept(this);
        if (c instanceof VoidType)
            ternaryExpression.addError(new CantUseValueOfVoidMethod(ternaryExpression.getLine()));

        Type trueStmt= ternaryExpression.getTrueExpression().accept(this);
        if (trueStmt instanceof VoidType)
            ternaryExpression.addError(new CantUseValueOfVoidMethod(ternaryExpression.getLine()));

        Type falseStmt = ternaryExpression.getFalseExpression().accept(this);
        if (falseStmt instanceof VoidType)
            ternaryExpression.addError(new CantUseValueOfVoidMethod(ternaryExpression.getLine()));
        if(falseStmt instanceof VoidType || trueStmt instanceof VoidType || c instanceof VoidType)
            return new NoType();


        if(!(c instanceof BoolType) && !(c instanceof NoType))
            ternaryExpression.addError(new ConditionNotBool(ternaryExpression.getLine()));
        if(!equalType(trueStmt, falseStmt))
            ternaryExpression.addError(new UnsupportedOperandType(ternaryExpression.getLine(), ternaryExpression.toString()));
        else
            return trueStmt;

        return new NoType();
    }

    @Override
    public Type visit(IntValue intValue) {
        return new IntType();
        //todo ok
    }

    @Override
    public Type visit(BoolValue boolValue) {
        return new BoolType();
        //Todo ok
    }

    @Override
    public Type visit(SelfClass selfClass) {
        //todo ok
        return new ClassType(new Identifier(currentClassScope));
    }

    @Override
    public Type visit(SetValue setValue) {
        //todo ok
        return null;
    }

    @Override
    public Type visit(NullValue nullValue) {
        //todo ok
        return new NoType();
    }
}
