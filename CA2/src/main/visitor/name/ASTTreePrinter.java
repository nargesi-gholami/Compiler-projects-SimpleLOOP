package main.visitor.name;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.NullValue;
import main.ast.nodes.expression.values.SetValue;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.set.SetDelete;
import main.ast.nodes.statement.set.SetMerge;
import main.visitor.Visitor;

public class ASTTreePrinter extends Visitor<Void> {
    public void messagePrinter(int line, String message){
        System.out.println("Line " + line + ": " + message);
    }

    @Override
    public Void visit(Program program) {
        messagePrinter(program.getLine(), program.toString());
        for (VariableDeclaration variableDeclaration : program.getGlobalVariables())
            variableDeclaration.accept(this);
        for (ClassDeclaration classDeclaration: program.getClasses())
            classDeclaration.accept(this);
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        messagePrinter(classDeclaration.getLine(), classDeclaration.toString());
        classDeclaration.getClassName().accept(this);
        if(classDeclaration.getParentClassName() != null) {
            classDeclaration.getParentClassName().accept(this);
        }
        if(classDeclaration.getConstructor() != null) {
            classDeclaration.getConstructor().accept(this);
        }

        for(FieldDeclaration fieldDec : classDeclaration.getFields()) {
            fieldDec.accept(this);
        }
        for(MethodDeclaration methodDec : classDeclaration.getMethods()) {
            methodDec.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        // double check!
        messagePrinter(constructorDeclaration.getLine(), constructorDeclaration.toString());
        for(VariableDeclaration argDec : constructorDeclaration.getArgs()) {
            argDec.accept(this);
        }
        for(VariableDeclaration localVarDer : constructorDeclaration.getLocalVars()) {
            localVarDer.accept(this);
        }
        for(Statement statement : constructorDeclaration.getBody()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        messagePrinter(methodDeclaration.getLine(), methodDeclaration.toString());
        methodDeclaration.getMethodName().accept(this);
        for(VariableDeclaration argDec : methodDeclaration.getArgs()) {
            argDec.accept(this);
        }
        for(VariableDeclaration localVarDer : methodDeclaration.getLocalVars()) {
            localVarDer.accept(this);
        }
        for(Statement statement : methodDeclaration.getBody()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        // double check!
        messagePrinter(fieldDeclaration.getLine(), fieldDeclaration.toString());
        fieldDeclaration.getVarDeclaration().accept(this);
        return null;
    }

    @Override
    public Void visit(VariableDeclaration varDeclaration) {
        //todo
        messagePrinter(varDeclaration.getLine(), varDeclaration.toString());
        varDeclaration.getVarName().accept(this);
        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        messagePrinter(assignmentStmt.getLine(), assignmentStmt.toString());
        assignmentStmt.getlValue().accept(this);
        assignmentStmt.getrValue().accept(this);
        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        messagePrinter(blockStmt.getLine(), blockStmt.toString());
        for(Statement statement : blockStmt.getStatements()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        messagePrinter(conditionalStmt.getLine(), conditionalStmt.toString());
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
        messagePrinter(elsifStmt.getLine(), elsifStmt.toString());
        elsifStmt.getCondition().accept(this);
        elsifStmt.getThenBody().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCallStmt methodCallStmt) {
        messagePrinter(methodCallStmt.getLine(), methodCallStmt.toString());
        methodCallStmt.getMethodCall().accept(this);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        messagePrinter(print.getLine(), print.toString());
        print.getArg().accept(this);
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        // double check for return!
        messagePrinter(returnStmt.getLine(), returnStmt.toString());
        if(returnStmt.getReturnedExpr() != null) {
            returnStmt.getReturnedExpr().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(EachStmt eachStmt) {
        messagePrinter(eachStmt.getLine(), eachStmt.toString());
        eachStmt.getVariable().accept(this);
        eachStmt.getList().accept(this);
        eachStmt.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        messagePrinter(binaryExpression.getLine(), binaryExpression.toString());
        binaryExpression.getFirstOperand().accept(this);
        binaryExpression.getSecondOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        messagePrinter(unaryExpression.getLine(), unaryExpression.toString());
        unaryExpression.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(TernaryExpression ternaryExpression) {
        messagePrinter(ternaryExpression.getLine(), ternaryExpression.toString());
        ternaryExpression.getCondition().accept(this);
        ternaryExpression.getTrueExpression().accept(this);
        ternaryExpression.getFalseExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(ObjectMemberAccess objectOrListMemberAccess) {
        messagePrinter(objectOrListMemberAccess.getLine(), objectOrListMemberAccess.toString());
        objectOrListMemberAccess.getInstance().accept(this);
        objectOrListMemberAccess.getMemberName().accept(this);
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        messagePrinter(identifier.getLine(), identifier.toString());
        return null;
    }

    @Override
    public Void visit(ArrayAccessByIndex arrayAccessByIndex) {
        messagePrinter(arrayAccessByIndex.getLine(), arrayAccessByIndex.toString());
        arrayAccessByIndex.getInstance().accept(this);
        arrayAccessByIndex.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCall methodCall) {
        messagePrinter(methodCall.getLine(), methodCall.toString());
        methodCall.getInstance().accept(this);
        for(Expression arg : methodCall.getArgs()) {
            arg.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(NewClassInstance newClassInstance) {
        messagePrinter(newClassInstance.getLine(), newClassInstance.toString());
        for(Expression arg : newClassInstance.getArgs()) {
            arg.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(SelfClass selfClass) {
        messagePrinter(selfClass.getLine(), selfClass.toString());
        return null;
    }
    ///////////////////////////////////////////////////////////////////////
    @Override
    public Void visit(NullValue nullValue) {
        messagePrinter(nullValue.getLine(), nullValue.toString());
        return null;
    }

    @Override
    public Void visit(IntValue intValue) {
        messagePrinter(intValue.getLine(), intValue.toString());
        return null;
    }

    @Override
    public Void visit(BoolValue boolValue) {
        messagePrinter(boolValue.getLine(), boolValue.toString());
        return null;
    }

    @Override
    public Void visit(SetInclude setAdd) {
        // double check
        messagePrinter(setAdd.getLine(), setAdd.toString());
        setAdd.getSetArg().accept(this);
        setAdd.getElementArg().accept(this);
        return null;
    }

    @Override
    public Void visit(SetValue setValue) {
        messagePrinter(setValue.getLine(), setValue.toString());
        for(IntValue intValue : setValue.getElements()) {
            intValue.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(SetNew setMerge) {
        messagePrinter(setMerge.getLine(), setMerge.toString());
        for(Expression arg : setMerge.getArgs()) {
            arg.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(SetDelete setDelete) {
        messagePrinter(setDelete.getLine(), setDelete.toString());
        setDelete.getSetArg().accept(this);
        setDelete.getElementArg().accept(this);
        return null;
    }

    @Override
    public Void visit(SetMerge setAdd) {
        messagePrinter(setAdd.getLine(), setAdd.toString());
        setAdd.getSetArg().accept(this);
        for(Expression arg : setAdd.getElementArgs()) {
            arg.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(RangeExpression rangeExpression) {
        messagePrinter(rangeExpression.getLine(), rangeExpression.toString());
        rangeExpression.getLeftExpression().accept(this);
        rangeExpression.getRightExpression().accept(this);
        return null;
    }
}
