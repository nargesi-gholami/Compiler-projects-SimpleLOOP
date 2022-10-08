grammar SimpleLOOP;

@header{
     import main.ast.nodes.*;
     import main.ast.nodes.declaration.*;
     import main.ast.nodes.declaration.classDec.*;
     import main.ast.nodes.declaration.classDec.classMembersDec.*;
     import main.ast.nodes.declaration.variableDec.*;
     import main.ast.nodes.expression.*;
     import main.ast.nodes.expression.operators.*;
     import main.ast.nodes.expression.values.*;
     import main.ast.nodes.expression.values.primitive.*;
     import main.ast.nodes.statement.*;
     import main.ast.nodes.statement.set.*;
     import main.ast.types.*;
     import main.ast.types.primitives.*;
     import main.ast.types.set.*;
     import main.ast.types.functionPointer.*;
     import main.ast.types.array.*;
     import java.util.*;
 }

simpleLOOP returns [Program simpleLOOPProgram]:
    NEWLINE* p = program {$simpleLOOPProgram = $p.programRet;} NEWLINE* EOF;

program returns[Program programRet]:
    {
        $programRet = new Program();
        int line = 1;
        $programRet.setLine(line);
    }
    (v = varDecStatement NEWLINE+
    {
        for (VariableDeclaration varDec: $v.varDecRet)
            $programRet.addGlobalVariable(varDec);
    })*
    (c = classDeclaration NEWLINE+ {$programRet.addClass($c.ClassDecRet);})*
    ;

//todo ok
constructor returns [ConstructorDeclaration constructorRet]:
     PUBLIC init = INITIALIZE
     {
        $constructorRet = new ConstructorDeclaration();
        $constructorRet.setLine($init.getLine());
     }
     args = methodArgsDec NEWLINE*
     { $constructorRet.setArgs($args.ArgsDecRet); }
     b = methodBody
     {
        $constructorRet.setLocalVars($b.varDecmethodRet);
        $constructorRet.setBody($b.methodBodyRet);
     }
     ;

//todo ok
classDeclaration returns[ClassDeclaration ClassDecRet]
    locals[ArrayList<FieldDeclaration> fa, ArrayList<MethodDeclaration> ma]:
    {$fa = new ArrayList<>();}
    cn = CLASS
    ci = class_identifier
    {
        $ClassDecRet = new ClassDeclaration($ci.classIdentifierRet);
        $ClassDecRet.setLine($cn.getLine());
    }
    (LESS_THAN cip = class_identifier
    {
       $ClassDecRet.setParentClassName($cip.classIdentifierRet);
    })?
    NEWLINE*
    ((LBRACE NEWLINE+
    (fd1 = field_decleration NEWLINE+
    {
        if($fd1.fieldDecRet != null) {
            $ClassDecRet.addField($fd1.fieldDecRet);
        }
        if($fd1.methodDecRet != null) {
            $ClassDecRet.addMethod($fd1.methodDecRet);
        }
    })+
    RBRACE) |
    (fd2 = field_decleration
    {
        if($fd1.fieldDecRet != null) {
             $ClassDecRet.addField($fd1.fieldDecRet);
        }
        if($fd1.methodDecRet != null) {
             $ClassDecRet.addMethod($fd1.methodDecRet);
        }
    }
    ));

//todo ok
field_decleration returns [FieldDeclaration fieldDecRet, MethodDeclaration methodDecRet, MethodDeclaration constructorRet ]
    locals [boolean isPrivate, int line, ArrayList<VariableDeclaration> varDec]
    :
    ((( p = (PUBLIC | PRIVATE)
    {
        $isPrivate = false;
        if($p.getText().equals("private")) $isPrivate = true;
        $line = $p.getLine();
    }
    (v = varDecStatement
     {
        $varDec = $v.varDecRet;
        $fieldDecRet = new FieldDeclaration($varDec.get(0), $isPrivate);
        $fieldDecRet.setLine($line);
     }
     | m = method
     { $methodDecRet = $m.methodRet; }
     ))
     | c = constructor
     { $constructorRet = $c.constructorRet; }
     ))
    ;

//todo ok
method returns[MethodDeclaration methodRet]
    :
    { $methodRet = new MethodDeclaration(); }
    (t = type
    {
        $methodRet.setReturnType($t.typeRet);
    }
    | VOID)
    {
        $methodRet.setReturnType(new VoidType());
    }
    i = identifier
    {
        $methodRet.setMethodName($i.identifierRet);
        $methodRet.setLine($i.identifierRet.getLine());
    }
    ma = methodArgsDec
    {
        $methodRet.setArgs($ma.ArgsDecRet);
    }
    NEWLINE*
    mb = methodBody
    {
        $methodRet.setBody($mb.methodBodyRet);
        $methodRet.setLocalVars($mb.varDecmethodRet);
    }
    ;

//todo ok
methodBody returns [ArrayList<Statement> methodBodyRet, ArrayList<VariableDeclaration> varDecmethodRet]
    :
    {
        $methodBodyRet = new ArrayList<>();
        $varDecmethodRet = new ArrayList<>();
    }
    (LBRACE NEWLINE+
    (v = varDecStatement
    { $varDecmethodRet.addAll($v.varDecRet);}
    NEWLINE+)*
    (s = singleStatement
    {$methodBodyRet.add($s.statementRet);}
    NEWLINE+)* RBRACE)
    |
    ( v = varDecStatement
    {
        $varDecmethodRet = new ArrayList<>();
        $varDecmethodRet.addAll($v.varDecRet);})
    |
    (s=singleStatement
    {
        $methodBodyRet = new ArrayList<>();
        $methodBodyRet.add($s.statementRet);}
    )
    ;

//todo ok
methodArgsDec returns[ArrayList<VariableDeclaration> ArgsDecRet]
    :
    {$ArgsDecRet = new ArrayList<>();}
    LPAR (a1 = argDec
    { $ArgsDecRet.add($a1.argdecRet); }
    ((ASSIGN orExpression) | (COMMA a2 = argDec
    {$ArgsDecRet.add($a2.argdecRet);}
    )*) (COMMA arg=argDec
    {$ArgsDecRet.add($arg.argdecRet);}
    ASSIGN orExpression)*)? RPAR ;

//todo
argDec returns[VariableDeclaration argdecRet]
    : t = type i = identifier
    {
        $argdecRet =  new VariableDeclaration($i.identifierRet, $t.typeRet);
        $argdecRet.setLine($i.identifierRet.getLine());
    }
    ;

//todo
methodArgs returns[ArrayList<Expression> methodArgDrc]
    :
    {$methodArgDrc = new ArrayList<>();}
    (e1 = expression
    { $methodArgDrc.add($e1.expressionRet);}
    (COMMA e2=expression
    { $methodArgDrc.add($e2.expressionRet);}
    )*)?;

//todo ok
body returns[Statement bodyRet]
    :
     (b = blockStatement
      { $bodyRet = $b.blockStatementRet;}
      | (NEWLINE+ s = singleStatement {$bodyRet = $s.statementRet;}));

//todo ok
blockStatement returns[BlockStmt blockStatementRet]
    :
    {$blockStatementRet = new BlockStmt();}
    l = LBRACE {$blockStatementRet.setLine($l.getLine());} NEWLINE+ (s = singleStatement {$blockStatementRet.addStatement($s.statementRet);} NEWLINE+)* RBRACE;

//todo ok
singleStatement returns [Statement statementRet]
    :
    i = ifStatement
    { $statementRet = $i.conditionRet;}
    | p = printStatement
    { $statementRet = $p.printRet; }
    | m = methodCallStmt
    { $statementRet = $m.MethodcallRet; }
    | r = returnStatement
    { $statementRet = $r.returnRet; }
    | as = assignmentStatement
    { $statementRet = $as.assignRet; }
    | ls = loopStatement
    { $statementRet = $ls.eachRet; }
    | ads = addStatement
    { $statementRet = $ads.setAddRet;}
    | ms = mergeStatement
    { $statementRet = $ms.setMergeRet; }
    | ds = deleteStatement
    { $statementRet = $ds.setDelRet; }
    ;

//todo ok
addStatement returns [SetAdd setAddRet]
    :
    e1 = expression DOT ad = ADD LPAR e2 =orExpression RPAR
    {
        $setAddRet = new SetAdd($e1.expressionRet, $e2.orExprRet);
        $setAddRet.setLine($ad.getLine());
    }
    ;

//todo ok
mergeStatement returns [SetMerge setMergeRet]
    locals [ArrayList<Expression> eArgs]
    :
    {$eArgs = new ArrayList<>();}
    e1 = expression DOT m = MERGE LPAR
    e2 = orExpression
    {$eArgs.add($e2.orExprRet);}
    (COMMA orExpression
    {$eArgs.add($e2.orExprRet);} )*
    {
        $setMergeRet = new SetMerge($e1.expressionRet, $eArgs);
        $setMergeRet.setLine($m.getLine());
    }
    RPAR;

//todo ok
deleteStatement returns [SetDelete setDelRet]
    :
    e1 = expression DOT d = DELETE LPAR e2 = orExpression RPAR
    {
        $setDelRet = new SetDelete($e1.expressionRet, $e2.orExprRet);
        $setDelRet.setLine($d.getLine());
    }
    ;

//todo
varDecStatement returns[ArrayList<VariableDeclaration> varDecRet]
    locals [Type tt]:
    {$varDecRet = new ArrayList<>();}
    t = type
    i = identifier
    {
       $tt = $t.typeRet;
       VariableDeclaration v = new VariableDeclaration($i.identifierRet,$t.typeRet);
       v.setLine($i.identifierRet.getLine());
       $varDecRet.add(v);
    }
    (COMMA i2 = identifier
    {
        VariableDeclaration v1 = new VariableDeclaration($i2.identifierRet,$tt);
        v1.setLine($i2.identifierRet.getLine());
        $varDecRet.add(v1);
    }
    )*;

//todo ok
ifStatement returns [ConditionalStmt conditionRet]
    :
    i = IF c = condition b = body
    {
       $conditionRet = new ConditionalStmt($c.condRet, $b.bodyRet);
       $conditionRet.setLine($i.getLine());
    }
    (e1 = elsifStatement
        {$conditionRet.addElsif($e1.ElsifStmtRet);}
    )*
    (e2 = elseStatement
        {$conditionRet.setElseBody($e2.elseRet);}
    )?;

//todo ok
elsifStatement returns [ElsifStmt ElsifStmtRet]
    :
     NEWLINE* ef = ELSIF c = condition b = body
     {
        $ElsifStmtRet = new ElsifStmt($c.condRet, $b.bodyRet);
        $ElsifStmtRet.setLine($ef.getLine());
     }
     ;

//todo ok
condition returns[Expression condRet]
    :
    (LPAR e1 = expression RPAR)
     { $condRet = $e1.expressionRet;}
     | (e2 = expression
     { $condRet = $e2.expressionRet;}
     );

//todo ok
elseStatement returns[Statement elseRet]
    :
    NEWLINE* ELSE b = body
    { $elseRet = $b.bodyRet;}
    ;

//todo ok
printStatement returns [PrintStmt printRet]
    :
    p = PRINT LPAR e = expression RPAR
    {
        $printRet = new PrintStmt($e.expressionRet);
        $printRet.setLine($p.getLine());
    }
    ;
//MethodCall(Expression instance)
methodCallStmt returns [MethodCallStmt MethodcallRet]
    :
    ae = accessExpression (DOT (INITIALIZE | identifier))* (lp = LPAR m = methodArgs
    {
       MethodCall mc = new MethodCall($ae.accessExprRet, $m.methodArgDrc);
       mc.setLine($lp.getLine());
       $MethodcallRet = new MethodCallStmt(mc);
       $MethodcallRet.setLine($lp.getLine());
    }
     RPAR);

//todo ok
returnStatement returns [ReturnStmt returnRet]
    :
    r = RETURN
    {
        $returnRet = new ReturnStmt();
        $returnRet.setLine($r.getLine());
    }
    (e = expression
    {$returnRet.setReturnedExpr($e.expressionRet); }
    )?;

//todo ok
assignmentStatement returns [AssignmentStmt assignRet]
    :
    le = orExpression as = ASSIGN re = expression
    {
        $assignRet = new AssignmentStmt($le.orExprRet, $re.expressionRet);
        $assignRet.setLine($as.getLine());
    }
    ;

//todo ok hast vali list ro shak daram
loopStatement returns [EachStmt eachRet]
    locals [Expression List]
    :
    ((ae = accessExpression
    {
        $List = $ae.accessExprRet;
    }
    ) |
    (LPAR e = expression DOT DOT expression RPAR)
    {
        $List = $e.expressionRet; //???
    }
    ) DOT each1 = EACH DO BAR id = identifier BAR b = body
    {
        $eachRet = new EachStmt($id.identifierRet, $List);
        $eachRet.setLine($each1.getLine());
        $eachRet.setBody($b.bodyRet);
    }
    ;

//todo ok
expression returns [Expression expressionRet]
    :
    te = ternaryExpression
    { $expressionRet = $te.terExprRet; }
    (ae = ASSIGN e = expression
    {
        $expressionRet = new BinaryExpression($oe.orExprRet, $e.expressionRet, BinaryOperator.assign);
        $expressionRet.setLine($ae.getLine());
    }
    )?
    (DOT inc=INCLUDE LPAR oe=orExpression RPAR
    {
        $expressionRet = new SetInclude($te.terExprRet, $oe.orExprRet);
        $expressionRet.setLine($inc.getLine());
    }
    )?;


//todo ok
ternaryExpression returns [Expression terExprRet]
locals[Expression e]:
    oe = orExpression
    {$terExprRet = $oe.orExprRet;}
    (t = TIF t1 = ternaryExpression TELSE t2 = ternaryExpression
    {
        $terExprRet = new TernaryExpression($terExprRet, $t1.terExprRet, $t2.terExprRet);
        $terExprRet.setLine($t.getLine());
    })?
    ;

//todo ok
orExpression returns [Expression orExprRet]
    :
    ae1 = andExpression
    { $orExprRet = $ae1.andExprRet; }
     (or = OR ae2 = andExpression
     {
        $orExprRet = new BinaryExpression($orExprRet, $ae2.andExprRet, BinaryOperator.or);
        $orExprRet.setLine($or.getLine());
     }
     )*
    ;

//todo ok
andExpression returns [Expression andExprRet]
    :
    e1 = equalityExpression
    {$andExprRet = $e1.equalExprRet; }
    (an = AND e2 = equalityExpression
    {
       $andExprRet = new BinaryExpression($andExprRet, $e2.equalExprRet, BinaryOperator.and);
       $andExprRet.setLine($an.getLine());
    }
     )*;

//todo ok
equalityExpression returns [Expression equalExprRet]
    :
    r1 = relationalExpression
    { $equalExprRet = $r1.relationExprRet; }
    ( e = EQUAL r2 = relationalExpression
    {
        $equalExprRet = new BinaryExpression($equalExprRet, $r2.relationExprRet, BinaryOperator.eq);
        $equalExprRet.setLine($e.getLine());
    }
    )*;

//todo ok
relationalExpression returns [Expression relationExprRet]
    locals[BinaryOperator op, int line]
    :
    a1 = additiveExpression
    { $relationExprRet = $a1.addExprRet; }
     ((g = GREATER_THAN
     {
         $op = BinaryOperator.gt;
         $line = $g.getLine();
     }
     | l = LESS_THAN
     {
         $op = BinaryOperator.lt;
         $line = $l.getLine();
     }
     )
     a2 = additiveExpression
     {
        $relationExprRet = new BinaryExpression($relationExprRet, $a2.addExprRet, $op);
        $relationExprRet.setLine($line);
     }
     )*;

//todo ok
additiveExpression returns [Expression addExprRet]
    locals[BinaryOperator op, int line]
    :
    m1 = multiplicativeExpression
    {$addExprRet = $m1.multExprRet;}
    ((p = PLUS
    {
       $op = BinaryOperator.add;
       $line = $p.getLine();
    }
    | m = MINUS
    {
        $op = BinaryOperator.sub;
        $line = $m.getLine();
    }
    )
     m2 = multiplicativeExpression
     {
         $addExprRet = new BinaryExpression($addExprRet, $m2.multExprRet, $op);
         $addExprRet.setLine($line);
     }
     )*;

//todo ok
multiplicativeExpression returns[Expression multExprRet]
    locals[BinaryOperator op, int line]:
    p1=preUnaryExpression
    { $multExprRet = $p1.preUnaryExprRet; }
    ((m=MULT
    {
        $op = BinaryOperator.mult;
        $line = $m.getLine();
    }
    | d=DIVIDE
    {
        $op = BinaryOperator.div;
        $line = $d.getLine();
    }
    ) p2=preUnaryExpression
    {
        $multExprRet = new BinaryExpression($multExprRet, $p2.preUnaryExprRet, $op);
        $multExprRet.setLine($line);
    }
    )*
    ;

//todo ok
preUnaryExpression returns[Expression preUnaryExprRet]
    locals[UnaryOperator op, int line]:
    (n = NOT
    {
        $op = UnaryOperator.not;
        $line = $n.getLine();
    }
    | m = MINUS
    {
        $op = UnaryOperator.minus;
        $line = $m.getLine();
    }
     p1 = preUnaryExpression
     {
         $preUnaryExprRet = new UnaryExpression($p1.preUnaryExprRet, $op);
         $preUnaryExprRet.setLine($line);
     }
     ) | p2 = postUnaryExpression
     { $preUnaryExprRet = $p2.postUnaryExprRet; }
    ;

//todo ok
postUnaryExpression returns[Expression postUnaryExprRet]
    locals[UnaryOperator op, int line]:
    ac = accessExpression
    { $postUnaryExprRet = $ac.accessExprRet; }
     ((i = INC
     {
        $op = UnaryOperator.postinc;
        $line = $i.getLine();
     }
     | d = DEC
     {
        $op = UnaryOperator.postdec;
        $line = $d.getLine();
     })
     {
        $postUnaryExprRet = new UnaryExpression($postUnaryExprRet, $op);
        $postUnaryExprRet.setLine($line);
     }
     )?;

//todo
accessExpression returns[Expression accessExprRet]
    :
    oe = otherExpression
    {$accessExprRet = $oe.otherExprRet;}
    (( l = LPAR ma = methodArgs RPAR)
    {
        $accessExprRet = new MethodCall($accessExprRet, $ma.methodArgDrc);
        $accessExprRet.setLine($l.getLine());
    }
    | (d = DOT (i1 = identifier
    {
       $accessExprRet = new ObjectMemberAccess($accessExprRet, $i1.identifierRet);
       $accessExprRet.setLine($d.getLine());
    }
    | i2 = INITIALIZE

    | n = NEW ( l = LPAR ma = methodArgs RPAR )
    {
       $accessExprRet = new NewClassInstance(new ClassType($oe.identifierRet1), $ma.methodArgDrc);
       $accessExprRet.setLine($n.getLine());
    }


    )))*

    (d = DOT (i = identifier)
    | (l = LBRACK e = expression RBRACK
    {
        $accessExprRet = new ArrayAccessByIndex($accessExprRet, $e.expressionRet);
        $accessExprRet.setLine($l.getLine());
    }
    ))*;

//todo ok
otherExpression returns[Expression otherExprRet, Identifier identifierRet1]
    :
    se = SELF {$otherExprRet = new SelfClass(); $otherExprRet.setLine($se.getLine()); }
    | c = class_identifier  {
                                $otherExprRet = $c.classIdentifierRet;
                                $identifierRet1 = $c.classIdentifierRet;
                            }
    | v = value           {$otherExprRet = $v.valRet;}
    | i = identifier      {$otherExprRet = $i.identifierRet;}
    | s = setNew          {$otherExprRet = $s.setNewRet;}
    | LPAR e = expression {$otherExprRet = $e.expressionRet;} RPAR
    ;

//todo ok
setNew returns[SetNew setNewRet]
    locals [ArrayList<Expression> exArray, int line]
    :
    {$exArray = new ArrayList<>();}
    s = SET
    {$line = $s.getLine();}
    DOT NEW LPAR (LPAR
    ore1 = orExpression
    {$exArray.add($ore1.orExprRet);}
    (COMMA ore2 = orExpression
    {$exArray.add($ore2.orExprRet);})* RPAR)?
    RPAR
    {
            $setNewRet = new SetNew($exArray);
            $setNewRet.setLine($line);
    };

//todo ok
value returns [Value valRet]:
    bv = boolValue
    {$valRet = $bv.boolvalRet;}
    | iv = INT_VALUE {$valRet = new IntValue(Integer.parseInt($iv.text)); $valRet.setLine($iv.getLine());}
    ;

//todo ok
boolValue returns [BoolValue boolvalRet] :
    t = TRUE {$boolvalRet = new BoolValue(true); $boolvalRet.setLine($t.getLine());}
    |
    f = FALSE{$boolvalRet = new BoolValue(false); $boolvalRet.setLine($f.getLine());}
    ;

//todo ok
class_identifier returns [Identifier classIdentifierRet]:
    i = CLASS_IDENTIFIER
    {
        $classIdentifierRet = new Identifier($i.getText());
        $classIdentifierRet.setLine($i.getLine());
    };

//todo ok
identifier returns [Identifier identifierRet]:
    i = IDENTIFIER
    {
        $identifierRet = new Identifier($i.getText());
        $identifierRet.setLine($i.getLine());
    }
    ;

//todo ok
type returns [Type typeRet]:
     (INT {$typeRet = new IntType();}
    | BOOL {$typeRet = new BoolType();}
    | a = array_type {$typeRet = $a.ArrRet;}
    | f = fptr_type  {$typeRet = $f.fptrRet;}
    | s = set_type   {$typeRet = $s.setRet;}
    | ic = class_identifier {$typeRet = new ClassType($ic.classIdentifierRet);})

    ;

//todo ok
array_type returns [ArrayType ArrRet]
    locals[Type atRet, ArrayList<Expression> at]
    :
    {$at = new ArrayList<>();}
    (INT {$atRet = new IntType();}
    | BOOL {$atRet = new BoolType();}
    | i = class_identifier {$atRet = new ClassType($i.classIdentifierRet);})
    (l = LBRACK e = expression RBRACK
    {
        $at.add($e.expressionRet);
    })+
    {
        $ArrRet = new ArrayType($atRet, $at);
    }

    ;

//todo ok
fptr_type returns [FptrType fptrRet]
    locals[Type ftRet, ArrayList<Type> ft]
    :
    {$ft = new ArrayList<>();}
    f = FPTR
    LESS_THAN (VOID {$ft.add(new VoidType());}
    | (t = type {$ft.add($t.typeRet);}
    (COMMA t1 = type {$ft.add($t1.typeRet);} )*))
    ARROW (
    t2 = type {$ftRet = $t2.typeRet;}|
    VOID {$ftRet = new VoidType();} ) GREATER_THAN
    {$fptrRet = new FptrType($ft, $ftRet);
    }
    ;

//todo ok
set_type returns [SetType setRet]:
    s = SET
     LESS_THAN (INT) GREATER_THAN
    { $setRet = new SetType(); };


LINE_BREAK: ('//\n') -> skip;

CLASS: 'class';
PUBLIC: 'public';
PRIVATE: 'private';
INITIALIZE: 'initialize';
NEW: 'new';
SELF: 'self';


RETURN: 'return';
VOID: 'void';


DELETE: 'delete';
INCLUDE: 'include';
ADD: 'add';
MERGE: 'merge';
PRINT: 'print';


IF: 'if';
ELSE: 'else';
ELSIF: 'elsif';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIVIDE: '/';
INC: '++';
DEC: '--';

EQUAL: '==';
GREATER_THAN: '>';
LESS_THAN: '<';

ARROW: '->';
BAR: '|';

AND: '&&';
OR: '||';
NOT: '!';

TIF: '?';
TELSE: ':';

TRUE: 'true';
FALSE: 'false';
NULL: 'null';

BEGIN: '=begin';
END: '=end';

INT: 'int';
BOOL: 'bool';
FPTR: 'fptr';
SET: 'Set';
EACH: 'each';
DO: 'do';

ASSIGN: '=';
SHARP: '#';
LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';

COMMA: ',';
DOT: '.';
SEMICOLON: ';' -> skip;
NEWLINE: '\n';

INT_VALUE: '0' | [1-9][0-9]*;
IDENTIFIER: [a-z_][A-Za-z0-9_]*;
CLASS_IDENTIFIER: [A-Z][A-Za-z0-9_]*;

COMMENT: '#' .*? '\n' -> skip;
MLCOMMENT: ('=begin' .*? '=end') -> skip;
WS: ([ \t\r]) -> skip;
