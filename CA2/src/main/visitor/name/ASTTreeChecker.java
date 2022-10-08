package main.visitor.name;

import main.ast.nodes.*;
import main.ast.nodes.declaration.classDec.*;
import main.ast.nodes.declaration.classDec.classMembersDec.*;
import main.ast.nodes.declaration.variableDec.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.set.*;

import main.compileError.*;
import main.compileError.nameError.*;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.ClassSymbolTableItem;
import main.symbolTable.items.FieldSymbolTableItem;
import main.symbolTable.items.GlobalVariableSymbolTableItem;
import main.symbolTable.items.LocalVariableSymbolTableItem;
import main.symbolTable.items.MethodSymbolTableItem;
import main.visitor.Visitor;
import main.symbolTable.*;

import java.util.*;

public class ASTTreeChecker extends Visitor<Void> {
    public void messagePrinter(CompileError error){
        System.out.println(error.getMessage());
        errorCount+=1;
    }

    public Map<String, SymbolTable> classSymbolTableHashMap = new HashMap<String, SymbolTable>();
    public Map<String, Boolean> isClassInLoop = new HashMap<String, Boolean>();
    public int errorCount;
    public Map<String, String> classGraph = new HashMap<String, String>();

    private boolean checkClassInCyclicInheritance(ClassDeclaration classDeclaration){
        String node = classDeclaration.getClassName().getName();
        String curr;
        Stack<String>frontier = new Stack<String>();
        Set<String>visited = new HashSet<String>();
        frontier.push(node);
        while(!frontier.empty()){
            curr=frontier.pop();
            visited.add(curr);
            if(!classGraph.containsKey(curr)){
                continue;
            }
            if(node.equals(classGraph.get(curr))) {
                messagePrinter(new ClassInCyclicInheritance(classDeclaration.getLine(), node));
                return true;
            }
            else if(!visited.contains(classGraph.get(curr))){
                frontier.push(classGraph.get(curr));
            }
        }
        return false;
    }

    private void makeSymbolTable(ClassDeclaration classDeclaration) {

        SymbolTable classTable = new SymbolTable(SymbolTable.root);

        SymbolTable.push(classTable);
        FieldSymbolTableItem field;
        for (FieldDeclaration fieldDeclaration : classDeclaration.getFields()) {
            field = new FieldSymbolTableItem(fieldDeclaration);
            try { //field tekrari
                classTable.put(field);
            }
            catch (ItemAlreadyExistsException e) {

            }
        }
        MethodSymbolTableItem method;
        for (MethodDeclaration methodDec : classDeclaration.getMethods()) {
            method = new MethodSymbolTableItem(methodDec);
            try { // method tekrari
                classTable.put(method);
            }
            catch (ItemAlreadyExistsException e2) {

            }
        }
        if(classSymbolTableHashMap.containsKey(classDeclaration.getClassName().getName()))
            classSymbolTableHashMap.replace(classDeclaration.getClassName().getName(), classTable);
        else
            classSymbolTableHashMap.put(classDeclaration.getClassName().getName(), classTable);
    }



    @Override
    public Void visit(Program program) {

        SymbolTable.root=new SymbolTable();

        for (VariableDeclaration varDeclaration:program.getGlobalVariables()) {
            varDeclaration.accept(this);
            try {
                SymbolTable.root.put(new GlobalVariableSymbolTableItem(varDeclaration));
            } catch (ItemAlreadyExistsException e) {
                messagePrinter(new GlobalVarRedefinition(varDeclaration.getLine(), varDeclaration.getVarName().getName()));

                String s1 = varDeclaration.getVarName().getName() + Integer.toString(errorCount);
                varDeclaration.setVarName(new Identifier(s1));
                try{
                    SymbolTable.root.put(new GlobalVariableSymbolTableItem(varDeclaration));
                }catch (ItemAlreadyExistsException e2){
                }
            }
        }

        for (ClassDeclaration classDeclaration: program.getClasses())
            if(classDeclaration.getParentClassName() != null)
                classGraph.put(classDeclaration.getClassName().getName(), classDeclaration.getParentClassName().getName());

        for (ClassDeclaration classDeclaration: program.getClasses()){
            if(classDeclaration.getParentClassName() != null) {
                boolean isInCycle = checkClassInCyclicInheritance(classDeclaration);
                isClassInLoop.put(classDeclaration.getClassName().getName(), isInCycle);
                if(isInCycle)
                    for(ClassDeclaration classDeclaration1: program.getClasses())
                        if(classDeclaration1.getClassName().getName().equals(classDeclaration.getParentClassName().getName()))
                            makeSymbolTable(classDeclaration1);
            }

            try {
                SymbolTable.root.put(new ClassSymbolTableItem(classDeclaration));
            }catch (ItemAlreadyExistsException e) {
                messagePrinter(new ClassRedefinition(classDeclaration.getLine(), classDeclaration.getClassName().getName()));

                String s = classDeclaration.getClassName().getName() + Integer.toString(errorCount);
                classDeclaration.setClassName(new Identifier(s));
                try{
                    SymbolTable.root.put(new ClassSymbolTableItem(classDeclaration));
                }catch (ItemAlreadyExistsException e2){
                }

            }
            classDeclaration.accept(this);
        }
        return null;
    }

    public Void visit(ClassDeclaration classDeclaration) {

        classDeclaration.getClassName().accept(this);
        if(classDeclaration.getParentClassName() != null) {
            classDeclaration.getParentClassName().accept(this);
        }

        SymbolTable classTable = new SymbolTable(SymbolTable.root);
        if(classDeclaration.getParentClassName() != null) {
            if(classSymbolTableHashMap.containsKey(classDeclaration.getParentClassName().getName())) {
                classTable = classSymbolTableHashMap.get(classDeclaration.getParentClassName().getName());
            }
        }

        SymbolTable.push(classTable);
        FieldSymbolTableItem field;
        for (FieldDeclaration fieldDeclaration : classDeclaration.getFields()) {
            field = new FieldSymbolTableItem(fieldDeclaration);
            try { //field tekrari
                classTable.put(field);
            } catch (ItemAlreadyExistsException e) {
                messagePrinter(new FieldRedefinition(fieldDeclaration.getLine(), field.getName()));
                if(isClassInLoop.containsKey(classDeclaration.getClassName().getName()) &&
                        !isClassInLoop.get(classDeclaration.getClassName().getName())) {
                    String f1 = field.getName() + Integer.toString(errorCount);
                    fieldDeclaration.setVarDeclaration(new VariableDeclaration(new Identifier(f1), field.getType()));
                    try {
                        classTable.put(new FieldSymbolTableItem(fieldDeclaration));
                    } catch (ItemAlreadyExistsException e2) {
                        //never
                    }
                }
            }
            fieldDeclaration.accept(this);
        }
        MethodSymbolTableItem method;
        for (MethodDeclaration methodDec : classDeclaration.getMethods()) {
            method = new MethodSymbolTableItem(methodDec);
            try { // method tekrari
                classTable.put(method);
            } catch (ItemAlreadyExistsException e2) {
                messagePrinter(new MethodRedefinition(methodDec.getLine(), method.getName()));
                if(isClassInLoop.containsKey(classDeclaration.getClassName().getName()) &&
                        !isClassInLoop.get(classDeclaration.getClassName().getName())) {
                    String m1 = method.getName() + Integer.toString(errorCount);
                    methodDec.setMethodName(new Identifier(m1));
                    try { //field tekrari
                        classTable.put(new MethodSymbolTableItem(methodDec));
                    } catch (ItemAlreadyExistsException e) {
                        //never
                    }
                }
            }

            try { //method and field tekrari
                classTable.getItem(FieldSymbolTableItem.START_KEY + method.getName(), true);
                messagePrinter(new MethodNameConflictWithField(methodDec.getLine(), method.getName()));
                if(isClassInLoop.containsKey(classDeclaration.getClassName().getName()) &&
                        !isClassInLoop.get(classDeclaration.getClassName().getName())) {
                    String m1 = method.getName() + Integer.toString(errorCount);
                    methodDec.setMethodName(new Identifier(m1));
                    try {
                        classTable.put(new MethodSymbolTableItem(methodDec));
                    } catch (ItemAlreadyExistsException e) {
                        //never
                    }
                }
            } catch (ItemNotFoundException e){ }
            methodDec.accept(this);
        }

        classSymbolTableHashMap.put(classDeclaration.getClassName().getName(), classTable);

        if(classDeclaration.getConstructor() != null) {
            classDeclaration.getConstructor().accept(this);
        }

        return null;
    }


    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {

        constructorDeclaration.getMethodName().accept(this);

        SymbolTable argTable = new SymbolTable(SymbolTable.root);
        SymbolTable.push(argTable);
        LocalVariableSymbolTableItem arg;
        LocalVariableSymbolTableItem localVar;

        for(VariableDeclaration argDec : constructorDeclaration.getArgs()) {
            arg = new LocalVariableSymbolTableItem(argDec);
            try {
                SymbolTable.root.getItem(GlobalVariableSymbolTableItem.START_KEY + arg.getName(), true);
                messagePrinter(new LocalVarConflictWithGlobalVar(argDec.getLine(), arg.getName()));

                String a2 = arg.getName() + Integer.toString(errorCount);
                argDec.setVarName(new Identifier(a2));
                try {
                    argTable.put(new LocalVariableSymbolTableItem(argDec));
                    continue;
                }catch (ItemAlreadyExistsException e) {
                    //never
                }
            }catch (ItemNotFoundException e) {
                //pass
            }
            try {
                argTable.put(arg);
            }catch (ItemAlreadyExistsException e) {
                messagePrinter(new LocalVarRedefinition(argDec.getLine(), arg.getName()));

                String a1 = arg.getName() + Integer.toString(errorCount);
                argDec.setVarName(new Identifier(a1));
                try {
                    argTable.put(new LocalVariableSymbolTableItem(argDec));
                }catch (ItemAlreadyExistsException e2) {
                    //never
                }
            }
            argDec.accept(this);
        }

        for(VariableDeclaration localVarDec : constructorDeclaration.getLocalVars()) {
            localVar = new LocalVariableSymbolTableItem(localVarDec);
            try {
                SymbolTable.root.getItem(GlobalVariableSymbolTableItem.START_KEY + localVar.getName(), true);
                messagePrinter(new LocalVarConflictWithGlobalVar(localVarDec.getLine(), localVar.getName()));
                String a2 = localVar.getName() + Integer.toString(errorCount);
                localVarDec.setVarName(new Identifier(a2));
                try {
                    argTable.put(new LocalVariableSymbolTableItem(localVarDec));
                    continue;
                }catch (ItemAlreadyExistsException e) {
                    //never
                }
            } catch (ItemNotFoundException e) {
                //pass
            }
            try {
                argTable.put(localVar);
            }catch (ItemAlreadyExistsException e) {
                messagePrinter(new LocalVarRedefinition(localVarDec.getLine(), localVar.getName()));

                String a3 = localVar.getName() + Integer.toString(errorCount);
                localVarDec.setVarName(new Identifier(a3));
                try {
                    argTable.put(new LocalVariableSymbolTableItem(localVarDec));
                }catch (ItemAlreadyExistsException e2) {
                    //never
                }
            }
            localVarDec.accept(this);
        }

        for(Statement statement : constructorDeclaration.getBody())
            statement.accept(this);

        return null;
    }


    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        SymbolTable argTable = new SymbolTable(SymbolTable.root);
        SymbolTable.push(argTable);
        LocalVariableSymbolTableItem arg;
        LocalVariableSymbolTableItem localVar;

        for(VariableDeclaration argDec : methodDeclaration.getArgs()) {
            arg = new LocalVariableSymbolTableItem(argDec);
            try {
                SymbolTable.root.getItem(GlobalVariableSymbolTableItem.START_KEY + arg.getName(), true);
                messagePrinter(new LocalVarConflictWithGlobalVar(argDec.getLine(), arg.getName()));

                String a2 = arg.getName() + Integer.toString(errorCount);
                argDec.setVarName(new Identifier(a2));
                try {
                    argTable.put(new LocalVariableSymbolTableItem(argDec));
                    continue;
                }catch (ItemAlreadyExistsException e) {
                    //never
                }
            }catch (ItemNotFoundException e) {
                //pass
            }
            try {
                argTable.put(arg);
            }catch (ItemAlreadyExistsException e) {
                messagePrinter(new LocalVarRedefinition(argDec.getLine(), arg.getName()));

                String a1 = arg.getName() + Integer.toString(errorCount);
                argDec.setVarName(new Identifier(a1));
                try {
                    argTable.put(new LocalVariableSymbolTableItem(argDec));
                }catch (ItemAlreadyExistsException e2) {
                    //never
                }
            }
        }

        for(VariableDeclaration localVarDec : methodDeclaration.getLocalVars()) {
            localVar = new LocalVariableSymbolTableItem(localVarDec);
            try {
                SymbolTable.root.getItem(GlobalVariableSymbolTableItem.START_KEY + localVar.getName(), true);
                messagePrinter(new LocalVarConflictWithGlobalVar(localVarDec.getLine(), localVar.getName()));

                String a2 = localVar.getName() + Integer.toString(errorCount);
                localVarDec.setVarName(new Identifier(a2));

                try {
                    argTable.put(new LocalVariableSymbolTableItem(localVarDec));
                    continue;
                }catch (ItemAlreadyExistsException e) {
                    //never
                }
            } catch (ItemNotFoundException e) {
                //pass
            }
            try {
                argTable.put(localVar);
            }catch (ItemAlreadyExistsException e) {
                messagePrinter(new LocalVarRedefinition(localVarDec.getLine(), localVar.getName()));

                String a3 = localVar.getName() + Integer.toString(errorCount);
                localVarDec.setVarName(new Identifier(a3));
                try {
                    argTable.put(new LocalVariableSymbolTableItem(localVarDec));
                } catch (ItemAlreadyExistsException e2) {
                    //never
                }
            }
        }

        methodDeclaration.getMethodName().accept(this);
        for(VariableDeclaration argDec : methodDeclaration.getArgs())
            argDec.accept(this);

        for(VariableDeclaration localVarDer : methodDeclaration.getLocalVars())
            localVarDer.accept(this);

        for(Statement statement : methodDeclaration.getBody())
            statement.accept(this);

        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        // double check!
        fieldDeclaration.getVarDeclaration().accept(this);
        return null;
    }

    @Override
    public Void visit(VariableDeclaration varDeclaration) {
        varDeclaration.getVarName().accept(this);
        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        assignmentStmt.getlValue().accept(this);
        assignmentStmt.getrValue().accept(this);
        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        for(Statement statement : blockStmt.getStatements()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        conditionalStmt.getCondition().accept(this);
        conditionalStmt.getThenBody().accept(this);
        if (conditionalStmt.getElsif() != null) {
            for(ElsifStmt elseif : conditionalStmt.getElsif()) {
                elseif.accept(this);
            }
        }
        if(conditionalStmt.getElseBody() != null) {
            conditionalStmt.getElseBody().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ElsifStmt elsifStmt) {
        elsifStmt.getCondition().accept(this);
        elsifStmt.getThenBody().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCallStmt methodCallStmt) {
        methodCallStmt.getMethodCall().accept(this);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        print.getArg().accept(this);
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        // double check for return!
        if(returnStmt.getReturnedExpr() != null) {
            returnStmt.getReturnedExpr().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(EachStmt eachStmt) {
        eachStmt.getVariable().accept(this);
        eachStmt.getList().accept(this);
        eachStmt.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        binaryExpression.getFirstOperand().accept(this);
        binaryExpression.getSecondOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        unaryExpression.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(TernaryExpression ternaryExpression) {
        ternaryExpression.getCondition().accept(this);
        ternaryExpression.getTrueExpression().accept(this);
        ternaryExpression.getFalseExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(ObjectMemberAccess objectOrListMemberAccess) {
        objectOrListMemberAccess.getInstance().accept(this);
        objectOrListMemberAccess.getMemberName().accept(this);
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        return null;
    }

    @Override
    public Void visit(ArrayAccessByIndex arrayAccessByIndex) {
        arrayAccessByIndex.getInstance().accept(this);
        arrayAccessByIndex.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCall methodCall) {
        methodCall.getInstance().accept(this);
        for(Expression arg : methodCall.getArgs()) {
            arg.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(NewClassInstance newClassInstance) {
        for(Expression arg : newClassInstance.getArgs()) {
            arg.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(SelfClass selfClass) {
        return null;
    }
    ///////////////////////////////////////////////////////////////////////
    @Override
    public Void visit(NullValue nullValue) {
        return null;
    }

    @Override
    public Void visit(IntValue intValue) {
        return null;
    }

    @Override
    public Void visit(BoolValue boolValue) {
        return null;
    }

    @Override
    public Void visit(SetInclude setAdd) {
        // double check
        setAdd.getSetArg().accept(this);
        setAdd.getElementArg().accept(this);
        return null;
    }

    @Override
    public Void visit(SetValue setValue) {
        for(IntValue intValue : setValue.getElements()) {
            intValue.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(SetNew setMerge) {
        for(Expression arg : setMerge.getArgs()) {
            arg.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(SetDelete setDelete) {
        setDelete.getSetArg().accept(this);
        setDelete.getElementArg().accept(this);
        return null;
    }

    @Override
    public Void visit(SetMerge setAdd) {
        setAdd.getSetArg().accept(this);
        for(Expression arg : setAdd.getElementArgs()) {
            arg.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(RangeExpression rangeExpression) {
        rangeExpression.getLeftExpression().accept(this);
        rangeExpression.getRightExpression().accept(this);
        return null;
    }
}


