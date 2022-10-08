grammar SimpleLOOP;

@members{
    void print(String str, Boolean... params){
        assert params.length <= 1;
        boolean inline = params.length > 0 ? params[0].booleanValue() : false;
        if (inline) {
            System.out.print(str);
        } else
            System.out.println(str);
    }
}

simpleLoop: program;

program: (NL* (var_dec_statement NL*  | (class1 NL*) | comment NL*))*;

class1:
    CLASS_STRING (cn = CLASS_NAME {print("ClassDec : " + $cn.getText());} NL* (LCURLYB NL*)? class_scope NL* RCURLYB?) |
    CLASS_STRING (cn1 = CLASS_NAME LESS_THAN (cn2 = CLASS_NAME {print("ClassDec : " + $cn1.getText()); print("Inheritance : " + $cn1.getText() + " < " + $cn2.getText());} NL* LCURLYB NL* class_scope NL* RCURLYB) );
class_scope: (class_variable NL* | class_method NL* | comment NL*)* ;

class_variable: (PRIVATE | PUBLIC)? var_dec_statement;
class_method: ((PRIVATE | PUBLIC)?(VOID | type | set | function_pointer_type | array_type)? in = IDENTIFIER {if(!$in.getText().equals("initialize")) print("MethodDec : " + $in.getText());} input NL* method_scope NL*);
input: LPAR( (type ((LBRACK expression RBRACK)+)? |
    function_pointer_type) (in1 = IDENTIFIER  {print("ArgumentDec : "+$in1.getText());})(ASSIGN (INT_VALUE|bool|IDENTIFIER))? COMMA)* ((type ((LBRACK expression RBRACK)+)? | function_pointer_type) in2 = IDENTIFIER (ASSIGN (INT_VALUE|bool|IDENTIFIER))?{print("ArgumentDec : " + $in2.getText());} )? RPAR;

method_scope:  return_statement | statement
    | LCURLYB NL* (statement NL*)* RCURLYB | (LCURLYB NL* (statement NL* | return_statement)* RCURLYB )?;
return_statement: RETURN {print("Return");} expression NL*;

statement: (assign_statement | set_functions_statement | set_dec_statement | each_statement | func_call_statement | comment | return_statement |
        if_statement | function_pointer_statment | array_dec_statement  | var_dec_statement | print_statement | right_unary_statement) SEMICOLON? NL* ;

//set
set_dec_statement: SET LESS_THAN INT GREATER_THAN IDENTIFIER;
set_functions_statement: singular_input_statement | merge_statement | new_statement;
singular_input_statement: (IDENTIFIER DOT)+ (in = (ADD | DELETE | INCLUDE) LPAR expression RPAR {print($in.getText().toUpperCase());});
merge_statement: (IDENTIFIER DOT)+ MERGE LPAR (new_statement | IDENTIFIER | expression(COMMA expression)*) RPAR {print("MERGE");};
new_statement: SET DOT NEW LPAR ((INT_VALUE)(COMMA INT_VALUE)*)? RPAR {print("NEW");};

//pointer to function
function_pointer_type: FPTR LESS_THAN type (COMMA type)* ARROW type GREATER_THAN;
function_pointer_statment: function_pointer_type  id = IDENTIFIER {print("VarDec : " + $id.getText());};

right_unary_statement: terminal_expr (op = (PLUS_PLUS | MINUS_MINUS){print("Operator : " + $op.getText());})*;
print_statement: PRINT LPAR {print("Built-in : print");} expression RPAR ;
assign_statement: dot_identifier ASSIGN (expression | new_statement) {print("Operator : =");} ;
dot_identifier: ((NEW | array_element |IDENTIFIER) DOT)* (IDENTIFIER | array_element | NEW);
each_statement: (IDENTIFIER| range) DOT EACH DO OR IDENTIFIER OR NL* {print("Loop : each");} (statement | LCURLYB NL* (statement)* NL* RCURLYB);

range: LPAR expression DOT DOT expression RPAR;

if_statement: IF({print("Conditional : if");}) expression NL*( statement |  LCURLYB  (NL)* (statement NL*)* RCURLYB) (NL)*
    (ELSIF({print("Conditional : elsif");}) expression NL*(statement | LCURLYB  (NL)* (statement  (NL)*)* RCURLYB)(NL)+)*
    (ELSE ({print("Conditional : else");}) NL*(statement |  LCURLYB NL* (statement NL*)* RCURLYB))?;

var_dec_statement: (type | set | CLASS_NAME) id= IDENTIFIER {print("VarDec : " + $id.getText());} (COMMA id2 = IDENTIFIER {print("VarDec : " + $id2.getText());})* (SEMICOLON)?
                    | array_dec_statement (SEMICOLON)?;

func_call_statement: (dot_identifier (LPAR {print("MethodCall");} (expression)?(COMMA (expression))* RPAR DOT?)
                        | (LPAR (expression)?(COMMA (expression))* RPAR DOT?))+;
func_call_expr: LPAR (expression)?(COMMA (expression))* RPAR;

array_type: (INT | BOOL | CLASS_NAME) (LBRACK expression RBRACK)+;
array_dec_statement: type (LBRACK expression RBRACK)+ id = IDENTIFIER {print("VarDec : " + $id.getText());};
array_element: IDENTIFIER (LBRACK expression RBRACK)+;
comment: (CSHARP (~(CSHARP | NL))* | CBEGIN NL* (~(CBEGIN | CEND) NL*)* CEND);
//expression
expression: ternary_expr (ASSIGN expression {print("Operator : =");})?;
ternary_expr: or_expr (QUESTION_MARK ternary_expr COLON ternary_expr ({print("Operator : ?:");}))* ;
or_expr: and_expr (LOGIC_OR and_expr {print("Operator : ||");})*;
and_expr: equal_exp (LOGIC_AND equal_exp {print("Operator : &&");})*;
equal_exp: comparative_expr (op = EQUAL comparative_expr {print("Operator : ==");})*;
comparative_expr: plus_expr (op = (GREATER_THAN | LESS_THAN) plus_expr {print("Operator : " + $op.getText());})*;
plus_expr: mult_expr (op = (PLUS | MINUS) mult_expr {print("Operator : " + $op.getText());})*;
mult_expr: unary_expr (op = (MULT | DIVIDE) unary_expr {print("Operator : " + $op.getText());})*;
unary_expr: op = (NOT | MINUS) unary_expr {print("Operator : " + $op.getText());} | right_unary_expr;
right_unary_expr: dot_expr (op = (PLUS_PLUS | MINUS_MINUS){print("Operator : " + $op.getText());})*;
dot_expr: terminal_expr (func_call_expr | DOT terminal_expr)*;
terminal_expr: bool | INT_VALUE | dot_identifier | LPAR (expression) RPAR;



type: INT | BOOL | CLASS_NAME | VOID | array_type;
bool: TRUE | FALSE;
set: SET LESS_THAN INT GREATER_THAN;


RETURN: 'return';
VOID: 'void';
NL: '\r'?'\n';

CLASS_STRING: 'class';
PRIVATE: 'private';
PUBLIC: 'public';

PRINT: 'print';
EACH: 'each';
DO: 'do';
NEW: 'new';
NULL: 'null';

SET: 'Set';
DELETE: 'delete';
INCLUDE: 'include';
ADD: 'add';
MERGE: 'merge';

IF: 'if';
ELSIF: 'elsif';
ELSE: 'else';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIVIDE: '/';

PLUS_PLUS: '++';
MINUS_MINUS: '--';

EQUAL: '==';
ARROW: '->';
GREATER_THAN: '>';
LESS_THAN: '<';

AND: '&';
OR: '|';
NOT: '!';

LOGIC_AND: '&&';
LOGIC_OR: '||';

QUESTION_MARK: '?';
COLON: ':';

TRUE: 'true';
FALSE: 'false';

CBEGIN: '=begin';
CEND: '=end';
CSHARP: '#';

INT: 'int';
BOOL: 'bool';
FPTR: 'fptr';

ASSIGN: '=';
LCURLYB: '{';
RCURLYB: '}';
LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';

COMMA: ',';
DOT: '.';
SEMICOLON: ';';

INT_VALUE: '0' | [1-9][0-9]*;
IDENTIFIER: [a-z_][A-Za-z0-9_]*;
CLASS_NAME: [A-Z][A-Za-z0-9_]*;
STRING: '"' ~('"') '"';

WS: ([ \t\r]) -> skip;
IGNORED_ESCAPE
   : ([/][/][\r\n]) . -> skip
   ;