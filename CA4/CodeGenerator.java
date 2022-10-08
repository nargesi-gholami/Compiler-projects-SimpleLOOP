package main.visitor.codeGenerator;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.struct.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.*;
import main.ast.nodes.expression.values.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.ast.types.*;
import main.ast.types.primitives.*;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.items.FunctionSymbolTableItem;
import main.symbolTable.items.StructSymbolTableItem;
import main.symbolTable.items.SymbolTableItem;
import main.visitor.Visitor;
import main.visitor.type.ExpressionTypeChecker;
import java.io.*;
import java.util.*;

public class  CodeGenerator extends Visitor<String> {
    ExpressionTypeChecker expressionTypeChecker = new ExpressionTypeChecker();
    private String outputPath;
    private FileWriter currentFile;
    private int Labels=0;
    private ArrayList<String> localList=new ArrayList<>();
    private boolean isInStruct=false,isInConstructor=false,isLvalue=false;
    public String updateLabelIndex(){
        String strLabel= String.valueOf(Labels);
        Labels++;
        return strLabel;
    }

    public String getJasminType(Type temp){
        if(temp instanceof IntType)
            return "Ljava/lang/Integer;";
        if(temp instanceof BoolType)
            return "Ljava/lang/Boolean;";
        if(temp instanceof ListType)
            return "LList;";
        if(temp instanceof FptrType)
            return "LFptr;";
        if(temp instanceof StructType)
            return "L"+((StructType) temp).getStructName().getName() + ";";
        if(temp instanceof VoidType)
            return "V";
        return null;
    }

    public String getJasminTypeCast(Type temp){
        if(temp instanceof IntType)
            return "java/lang/Integer";
        if(temp instanceof BoolType)
            return "java/lang/Boolean";
        if(temp instanceof ListType)
            return "List";
        if(temp instanceof FptrType)
            return "Fptr";
        if(temp instanceof StructType)
            return ((StructType) temp).getStructName().getName();
        if(temp instanceof VoidType)
            return "V";
        return null;
    }

    public String convertPrimitiveToNonP(Type type){
        if (type instanceof  IntType)
            return  "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
        if(type instanceof BoolType)
            return  "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";
        return null;
    }
    public String convertNonPToPrimitive(Type type){
        if (type instanceof  IntType)
            return  "invokevirtual java/lang/Integer/intValue()I\n";
        if(type instanceof BoolType)
            return  "invokevirtual java/lang/Boolean/booleanValue()Z\n";
        return null;
    }
    private void copyFile(String toBeCopied, String toBePasted) {
        try {
            File readingFile = new File(toBeCopied);
            File writingFile = new File(toBePasted);
            InputStream readingFileStream = new FileInputStream(readingFile);
            OutputStream writingFileStream = new FileOutputStream(writingFile);
            byte[] buffer = new byte[1024];
            int readLength;
            while ((readLength = readingFileStream.read(buffer)) > 0)
                writingFileStream.write(buffer, 0, readLength);
            readingFileStream.close();
            writingFileStream.close();
        } catch (IOException e) {//unreachable
        }
    }

    private void prepareOutputFolder() {
        this.outputPath = "output/";
        String jasminPath = "utilities/jarFiles/jasmin.jar";
        String listClassPath = "utilities/codeGenerationUtilityClasses/List.j";
        String fptrClassPath = "utilities/codeGenerationUtilityClasses/Fptr.j";
        try{
            File directory = new File(this.outputPath);
            File[] files = directory.listFiles();
            if(files != null)
                for (File file : files)
                    file.delete();
            directory.mkdir();
        }
        catch(SecurityException e) {//unreachable

        }
        copyFile(jasminPath, this.outputPath + "jasmin.jar");
        copyFile(listClassPath, this.outputPath + "List.j");
        copyFile(fptrClassPath, this.outputPath + "Fptr.j");
    }

    private void createFile(String name) {
        try {
            String path = this.outputPath + name + ".j";
            File file = new File(path);
            file.createNewFile();
            this.currentFile = new FileWriter(path);
        } catch (IOException e) {//never reached
        }
    }

    private void addCommand(String command) {
        try {
            command = String.join("\n\t\t", command.split("\n"));
            if(command.startsWith("Label_"))
                this.currentFile.write("\t" + command + "\n");
            else if(command.startsWith("."))
                this.currentFile.write(command + "\n");
            else
                this.currentFile.write("\t\t" + command + "\n");
            this.currentFile.flush();
        } catch (IOException e) {//unreachable

        }
    }

    private void addStaticMainMethod() {
        addCommand(".method public static main([Ljava/lang/String;)V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("new Main");
        addCommand("invokespecial Main/<init>()V");
        addCommand("return");
        addCommand(".end method");
    }

    private int slotOf(String identifier) {
        if(Objects.equals(identifier,"")){
            localList.add("");
            return localList.size()-1;
        }
        for(int i=1;i<localList.size();i++){
            if(Objects.equals(localList.get(i), identifier))
                return i;
        }
        return 0;
    }

    @Override
    public String visit(Program program) {
        prepareOutputFolder();

        for(StructDeclaration structDeclaration : program.getStructs()){
            structDeclaration.accept(this);
        }

        createFile("Main");

        program.getMain().accept(this);

        for (FunctionDeclaration functionDeclaration: program.getFunctions()){
            functionDeclaration.accept(this);
        }
        return null;
    }

    @Override
    public String visit(StructDeclaration structDeclaration) {
        try{
            String structKey = StructSymbolTableItem.START_KEY + structDeclaration.getStructName().getName();
            StructSymbolTableItem structSymbolTableItem = (StructSymbolTableItem)SymbolTable.root.getItem(structKey);
            SymbolTable.push(structSymbolTableItem.getStructSymbolTable());
        }catch (ItemNotFoundException e){//unreachable
        }
        createFile(structDeclaration.getStructName().getName());
        isInStruct=true;
        createFile(structDeclaration.getStructName().getName());
        addCommand(".class public " + structDeclaration.getStructName().getName());
        addCommand(".super java/lang/Object");
        localList.add(structDeclaration.getStructName().getName());
        structDeclaration.getBody().accept(this);
        isInConstructor=true;
        addCommand(".method public <init>()V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("aload_0");
        addCommand("invokespecial java/lang/Object/<init>()V");
        structDeclaration.getBody().accept(this);
        addCommand("return");
        addCommand(".end method");
        isInConstructor=false;
        isInStruct=false;
        localList.clear();
        SymbolTable.pop();
        return null;
    }

    @Override
    public String visit(FunctionDeclaration functionDeclaration) {
        try{
            String functionKey = FunctionSymbolTableItem.START_KEY + functionDeclaration.getFunctionName().getName();
            FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem)SymbolTable.root.getItem(functionKey);
            SymbolTable.push(functionSymbolTableItem.getFunctionSymbolTable());
        }catch (ItemNotFoundException e){//unreachable
        }
        String argument= ".method public " + functionDeclaration.getFunctionName().getName()+"(";
        localList.add("Main");
        for(VariableDeclaration var: functionDeclaration.getArgs()) {
            Type varType = var.getVarType();
            String varTypeJasmin=getJasminType(varType);
            argument+=varTypeJasmin;
            localList.add(var.getVarName().getName());
        }
        argument+=")";
        Type returnType=functionDeclaration.getReturnType();
        argument+=getJasminType(returnType);
        addCommand(argument);
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        functionDeclaration.getBody().accept(this);
        if(functionDeclaration.getReturnType() instanceof VoidType){
            addCommand("return");
        }
        addCommand(".end method");
        localList.clear();
        SymbolTable.pop();
        return null;
    }

    @Override
    public String visit(MainDeclaration mainDeclaration) {
        try{
            String functionKey = FunctionSymbolTableItem.START_KEY + "main";
            FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem)SymbolTable.root.getItem(functionKey);
            SymbolTable.push(functionSymbolTableItem.getFunctionSymbolTable());
        }catch (ItemNotFoundException e){//unreachable
        }
        localList.add("Main");
        addCommand(".class Main");
        addCommand(".super java/lang/Object");
        addStaticMainMethod();
        addCommand(".method public <init>()V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("aload_0");
        addCommand("invokespecial java/lang/Object/<init>()V");
        mainDeclaration.getBody().accept(this);
        localList.clear();
        addCommand("return");
        addCommand(".end method");
        SymbolTable.pop();

        return null;
    }

    public void initialize(VariableDeclaration variableDeclaration){
        if(variableDeclaration.getDefaultValue() ==null){
            if(isInConstructor)
                addCommand("aload_0");
            if(variableDeclaration.getVarType() instanceof IntType || variableDeclaration.getVarType() instanceof BoolType) {
                addCommand("iconst_0");
                addCommand(convertPrimitiveToNonP(variableDeclaration.getVarType()));
            }
            else if(variableDeclaration.getVarType() instanceof FptrType)
                addCommand("aconst_null");
            else if(variableDeclaration.getVarType() instanceof StructType) {
                addCommand("new " + ((StructType) variableDeclaration.getVarType()).getStructName().getName());
                addCommand("dup");
                addCommand("invokespecial " + ((StructType) variableDeclaration.getVarType()).getStructName().getName() +"/<init>()V");
            }
            else if(variableDeclaration.getVarType() instanceof ListType) {
                addCommand("new List");
                addCommand("dup");
                addCommand("new java/util/ArrayList");
                addCommand("dup");
                addCommand("invokespecial java/util/ArrayList/<init>()V");
                addCommand("invokespecial  List/<init>(Ljava/util/ArrayList;)V");
            }
        }
        else{
            if(isInConstructor)
                addCommand("aload_0");
            addCommand(variableDeclaration.getDefaultValue().accept(this));
        }
        if(isInConstructor)
            addCommand("putfield " + localList.get(0) + "/" + variableDeclaration.getVarName().getName() + " " + getJasminType(variableDeclaration.getVarType()));
        else{
            if (slotOf(variableDeclaration.getVarName().getName()) < 4)
                addCommand("astore_" + slotOf(variableDeclaration.getVarName().getName()));
            else
                addCommand("astore " + slotOf(variableDeclaration.getVarName().getName()));
        }
    }

    @Override
    public String visit(VariableDeclaration variableDeclaration){
        if(isInStruct){
            if(isInConstructor)
                initialize(variableDeclaration);
            else{
                addCommand(".field " + variableDeclaration.getVarName().getName() +" "+ getJasminType(variableDeclaration.getVarType()));
                localList.add(variableDeclaration.getVarName().getName());
            }
        }
        else {
            localList.add(variableDeclaration.getVarName().getName());
            initialize(variableDeclaration);
        }
        return null;
    }

    @Override
    public String visit(SetGetVarDeclaration setGetVarDeclaration) {
        return null;
    }

    @Override
    public String visit(AssignmentStmt assignmentStmt) {
        BinaryExpression binaryExpression=new BinaryExpression(assignmentStmt.getLValue(),assignmentStmt.getRValue(),BinaryOperator.assign);
        addCommand(binaryExpression.accept(this));
        addCommand("pop");
        return null;
    }

    @Override
    public String visit(BlockStmt blockStmt){
        for(Statement statement: blockStmt.getStatements())
            statement.accept(this);
        return null;
    }

    @Override
    public String visit(ConditionalStmt conditionalStmt) {
        String elseLabel="";
        String afterLabel="Label" + updateLabelIndex();
        addCommand(conditionalStmt.getCondition().accept(this));
        addCommand(convertNonPToPrimitive(new BoolType()));
        if(conditionalStmt.getElseBody() != null) {
            elseLabel = "Label" + updateLabelIndex();
            addCommand("ifeq " + elseLabel);
        }
        else addCommand("ifeq " + afterLabel);
        conditionalStmt.getThenBody().accept(this);
        if(conditionalStmt.getElseBody() != null) {
            addCommand("goto " + afterLabel);
            addCommand(elseLabel + ":");
            conditionalStmt.getElseBody().accept(this);
        }
        addCommand(afterLabel + ":");
        return null;
    }

    @Override
    public String visit(FunctionCallStmt functionCallStmt) {
        expressionTypeChecker.setInFunctionCallStmt(true);
        addCommand(functionCallStmt.getFunctionCall().accept(this));
        expressionTypeChecker.setInFunctionCallStmt(false);
        addCommand("pop");
        return null;
    }

    @Override
    public String visit(DisplayStmt displayStmt) {
        addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
        Type argType = displayStmt.getArg().accept(expressionTypeChecker);
        String commandsOfArg = displayStmt.getArg().accept(this);

        addCommand(commandsOfArg);
        if (argType instanceof IntType) {
            addCommand(convertNonPToPrimitive(argType));
            addCommand("invokevirtual java/io/PrintStream/println(I)V");
        }
        if (argType instanceof BoolType) {
            addCommand(convertNonPToPrimitive(argType));
            addCommand("invokevirtual java/io/PrintStream/println(Z)V");
        }

        return null;
    }

    @Override
    public String visit(ReturnStmt returnStmt) {
        if(returnStmt.getReturnedExpr()!=null){
            addCommand(returnStmt.getReturnedExpr().accept(this));
            addCommand("areturn");
        }
        return null;
    }

    @Override
    public String visit(LoopStmt loopStmt) {
        String While="Label"+updateLabelIndex();
        String after="Label"+updateLabelIndex();
        addCommand(While+":");
        addCommand(loopStmt.getCondition().accept(this));
        addCommand(convertNonPToPrimitive(new BoolType()));
        addCommand("ifeq "+ after);
        loopStmt.getBody().accept(this);
        addCommand("goto "+While);
        addCommand(after+":");
        return null;
    }

    @Override
    public String visit(VarDecStmt varDecStmt) {
        for(VariableDeclaration variableDeclaration: varDecStmt.getVars())
            variableDeclaration.accept(this);
        return null;
    }

    @Override
    public String visit(ListAppendStmt listAppendStmt) {
        expressionTypeChecker.setInFunctionCallStmt(true);
        addCommand(listAppendStmt.getListAppendExpr().accept(this));
        expressionTypeChecker.setInFunctionCallStmt(false);
        return null;
    }

    @Override
    public String visit(ListSizeStmt listSizeStmt) {
        addCommand(listSizeStmt.getListSizeExpr().accept(this));
        addCommand("pop");
        return null;
    }

    public String assignExpretion(BinaryExpression binaryExpression){
        String command="";
        if(binaryExpression.getFirstOperand() instanceof StructAccess){
            command+= ((StructAccess) binaryExpression.getFirstOperand()).getInstance().accept(this);
            Type elementType= ((StructAccess) binaryExpression.getFirstOperand()).accept(expressionTypeChecker);
            StructType structType= (StructType) ((StructAccess) binaryExpression.getFirstOperand()).getInstance().accept(expressionTypeChecker);
            Type RvalueType=binaryExpression.getSecondOperand().accept(expressionTypeChecker);
            if(RvalueType instanceof ListType){
                command+="new List\n";
                command+="dup\n";
            }
            command+= binaryExpression.getSecondOperand().accept(this);
            if(RvalueType instanceof ListType){
                command+="invokespecial List/<init>(LList;)V\n";
            }
            command += "putfield " + structType.getStructName().getName() + "/" + ((StructAccess) binaryExpression.getFirstOperand()).getElement().getName() +" "+ getJasminType(elementType) + "\n";
            command+=binaryExpression.getFirstOperand().accept(this);
        }
        else if(binaryExpression.getFirstOperand() instanceof Identifier){
            Type RvalueType=binaryExpression.getSecondOperand().accept(expressionTypeChecker);
            if(RvalueType instanceof ListType){
                command+="new List\n";
                command+="dup\n";
            }
            command+= binaryExpression.getSecondOperand().accept(this);
            if(RvalueType instanceof ListType){
                command+="invokespecial List/<init>(LList;)V\n";
            }
            if(slotOf(((Identifier) binaryExpression.getFirstOperand()).getName()) <4){
                command+="astore_" + slotOf(((Identifier) binaryExpression.getFirstOperand()).getName()) +"\n";
                command+="aload_" + slotOf(((Identifier) binaryExpression.getFirstOperand()).getName()) +"\n";
            }
            else {
                command+="astore " + slotOf(((Identifier) binaryExpression.getFirstOperand()).getName()) +"\n";
                command+="aload " + slotOf(((Identifier) binaryExpression.getFirstOperand()).getName()) +"\n";
            }
        }
        else if(binaryExpression.getFirstOperand() instanceof ListAccessByIndex){
            ListType listName=(ListType) ((ListAccessByIndex) binaryExpression.getFirstOperand()).getInstance().accept(expressionTypeChecker);
            Type elementType=listName.getType();
            command+=((ListAccessByIndex) binaryExpression.getFirstOperand()).getInstance().accept(this);
            command+=((ListAccessByIndex) binaryExpression.getFirstOperand()).getIndex().accept(this);
            command+=convertNonPToPrimitive(new IntType());
            Type RvalueType=binaryExpression.getSecondOperand().accept(expressionTypeChecker);
            if(RvalueType instanceof ListType){
                command+="new List\n";
                command+="dup\n";
            }
            command+= binaryExpression.getSecondOperand().accept(this);
            if(RvalueType instanceof ListType){
                command+="invokespecial List/<init>(LList;)V\n";
            }
            command+="invokevirtual List/setElement(ILjava/lang/Object;)V\n";
            command+=binaryExpression.getSecondOperand().accept(this);
        }
        return command;
    }

    @Override
    public String visit(BinaryExpression binaryExpression) {

        String command="";
        if(binaryExpression.getBinaryOperator() == BinaryOperator.assign)
            command=assignExpretion(binaryExpression);
        BinaryOperator op = binaryExpression.getBinaryOperator();
        Expression left = binaryExpression.getFirstOperand();
        Expression right = binaryExpression.getSecondOperand();
        switch (op) {
            case add, div, mult, sub -> {
                command+=left.accept(this);
                command+="invokevirtual java/lang/Integer/intValue()I\n";
                command+=right.accept(this);
                command+="invokevirtual java/lang/Integer/intValue()I\n";
                switch (op) {
                    case add -> {
                        command+="iadd\n";
                        break;
                    }
                    case sub -> {
                        command+="isub\n";
                        break;
                    }
                    case mult -> {
                        command+="imul\n";
                        break;
                    }
                    case div -> {
                        command+="idiv\n";
                        break;
                    }
                }
                command+=convertPrimitiveToNonP(new IntType());
            }
            case and -> {
                String trueLabel = "Label"+updateLabelIndex();
                String afterLabel = "Label"+updateLabelIndex();
                String nextLabel = "Label"+updateLabelIndex();
                command+= left.accept(this);
                command+=convertNonPToPrimitive(new BoolType());
                command+="ifne " + nextLabel + "\n";
                command+="iconst_0\n";
                command+="goto " + afterLabel + "\n";
                command+=nextLabel+ ":\n";
                command+=right.accept(this);
                command+=convertNonPToPrimitive(new BoolType());
                command+="ifne " + trueLabel + "\n" ;
                command+="iconst_0\n";
                command+="goto " + afterLabel+ "\n" ;
                command+= trueLabel+ ":\n";
                command+="iconst_1\n";
                command+="goto " + afterLabel + "\n";
                command+=afterLabel+ ":\n";
                command+=convertPrimitiveToNonP(new BoolType());
            }
            case or ->{
                String trueLabel = "Label"+updateLabelIndex();
                String afterLabel = "Label"+updateLabelIndex();
                String nextLabel = "Label"+updateLabelIndex();
                command+= left.accept(this);
                command+=convertNonPToPrimitive(new BoolType());
                command+="ifeq " + nextLabel + "\n";
                command+="iconst_1\n";
                command+="goto " + afterLabel + "\n";
                command+=nextLabel+ ":\n";
                command+=right.accept(this);
                command+=convertNonPToPrimitive(new BoolType());
                command+="ifeq " + trueLabel + "\n" ;
                command+="iconst_1\n";
                command+="goto " + afterLabel+ "\n" ;
                command+= trueLabel+ ":\n";
                command+="iconst_0\n";
                command+="goto " + afterLabel + "\n";
                command+=afterLabel+ ":\n";
                command+=convertPrimitiveToNonP(new BoolType());
            }
            case gt ->{
                String trueLabel="Lable" + updateLabelIndex();
                String end="Lable" + updateLabelIndex();
                command+=left.accept(this);
                command+="invokevirtual java/lang/Integer/intValue()I\n";
                command+=right.accept(this);
                command+="invokevirtual java/lang/Integer/intValue()I\n";
                command+="if_icmpge " + trueLabel + "\n";
                command+="iconst_0\n";
                command+=convertPrimitiveToNonP(new BoolType());
                command+="goto "+ end + "\n";
                command+= trueLabel + ":\n";
                command+="iconst_1\n";
                command+=convertPrimitiveToNonP(new BoolType());
                command+=end + ":\n";
            }
            case lt ->{
                String trueLabel="Lable" + updateLabelIndex();
                String end="Lable" + updateLabelIndex();
                command+=left.accept(this);
                command+="invokevirtual java/lang/Integer/intValue()I\n";
                command+=right.accept(this);
                command+="invokevirtual java/lang/Integer/intValue()I\n";
                command+="if_icmpge " + trueLabel + "\n";
                command+="iconst_1\n";
                command+=convertPrimitiveToNonP(new BoolType());
                command+="goto "+ end + "\n";
                command+= trueLabel + ":\n";
                command+="iconst_0\n";
                command+=convertPrimitiveToNonP(new BoolType());
                command+=end + ":\n";
            }
            case eq -> {
                String trueLabel="Lable" + updateLabelIndex();
                String end="Lable" + updateLabelIndex();
                command+=left.accept(this);
                command+="invokevirtual java/lang/Integer/intValue()I\n";
                command+=right.accept(this);
                command+="invokevirtual java/lang/Integer/intValue()I\n";
                command+="if_icmpeq " + trueLabel + "\n";
                command+="iconst_0\n";
                command+=convertPrimitiveToNonP(new BoolType());
                command+="goto "+ end + "\n";
                command+= trueLabel + ":\n";
                command+="iconst_1\n";
                command+=convertPrimitiveToNonP(new BoolType());
                command+=end + ":\n";

            }
        }
        return command;
    }

    @Override
    public String visit(UnaryExpression unaryExpression){
        return null;
    }

    @Override
    //to
    public String visit(StructAccess structAccess){
        String command = structAccess.getInstance().accept(this);
        Type elementType= structAccess.accept(expressionTypeChecker);
        StructType structType= (StructType)structAccess.getInstance().accept(expressionTypeChecker);
        command += "getfield " + structType.getStructName().getName() + "/" + structAccess.getElement().getName() +" "+ getJasminType(elementType) + "\n";
        return command;
    }

    @Override
    public String visit(Identifier identifier){
        String temp="";
        try{
            String functionKey = FunctionSymbolTableItem.START_KEY + identifier.getName();
            FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem)SymbolTable.root.getItem(functionKey);
            temp+="new Fptr\n";
            temp+="dup\n";
            temp+="aload_0\n";
            temp+="ldc \""+identifier.getName()+"\"\n";
            temp+="invokespecial Fptr/<init>(Ljava/lang/Object;Ljava/lang/String;)V\n";
        }catch (ItemNotFoundException e){
            if(slotOf(identifier.getName())<4)
                temp+="aload_"+slotOf(identifier.getName());
            else
                temp+="aload "+slotOf(identifier.getName());
            temp+="\n";
        }

        return temp;
    }

    @Override
    public String visit(ListAccessByIndex listAccessByIndex){
        String command="";
        ListType listName= (ListType)listAccessByIndex.getInstance().accept(expressionTypeChecker);
        Type elementType=listName.getType();

        command+=listAccessByIndex.getInstance().accept(this);
        command+=listAccessByIndex.getIndex().accept(this);
        command+=convertNonPToPrimitive(new IntType());
        command+="invokevirtual List/getElement(I)Ljava/lang/Object;\n";
        command+="checkcast "+ getJasminTypeCast(elementType) + "\n";
        return command;
    }

    @Override
    //to
    public String visit(FunctionCall functionCall){
        ArrayList<String>args=new ArrayList<>();

        for(Expression arg:functionCall.getArgs()){
            String commandArg=arg.accept(this);
            Type argType=arg.accept(expressionTypeChecker);
            if(argType instanceof ListType){
                String temp=commandArg;
                commandArg="new List\n";
                commandArg+="dup\n";
                commandArg+=temp;
                commandArg+="invokespecial List/<init>(LList;)V\n";
            }
            //commandArg+=convertPrimitiveToNonP(argType);
            args.add(commandArg);
        }
        String command= functionCall.getInstance().accept(this);
        command+= "new java/util/ArrayList\n";
        command+="dup\n";
        command+="invokespecial java/util/ArrayList/<init>()V\n";
        for(String arg : args){
            command+="dup\n";
            command+=arg;
            command+="invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z\n";
            command+="pop\n";
        }
        command+="invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;\n";
        Type returnType= functionCall.accept(expressionTypeChecker);
        command+="checkcast "+ getJasminTypeCast(returnType) + "\n";
        //command+=convertNonPToPrimitive(returnType);
        return command;
    }

    @Override
    public String visit(ListSize listSize){
        String temp="";
        temp+=listSize.getArg().accept(this);
        temp+="invokevirtual List/getSize()I\n";
        temp+= convertPrimitiveToNonP(new IntType());
        return temp;
    }

    @Override
    public String visit(ListAppend listAppend) {
        String temp="";
        String nameOfList=listAppend.getListArg().accept(this);
        temp+= nameOfList;
        String newValue=listAppend.getElementArg().accept(this);
        temp +=newValue;
        temp += "invokevirtual List/addElement(Ljava/lang/Object;)V\n";
        return temp;
    }

    @Override
    public String visit(IntValue intValue) {
        String intCommand="ldc ";
        intCommand+=intValue.getConstant();
        intCommand+="\n";
        intCommand+= convertPrimitiveToNonP(new IntType());
        return intCommand;
    }

    @Override
    public String visit(BoolValue boolValue) {
        String boolCommand="";
        if(boolValue.getConstant())
            boolCommand+="ldc 1\n";
        else boolCommand+="ldc 0\n";
        boolCommand+=convertPrimitiveToNonP(new BoolType());
        return boolCommand;
    }

    @Override
    public String visit(ExprInPar exprInPar) {return exprInPar.getInputs().get(0).accept(this);}
}