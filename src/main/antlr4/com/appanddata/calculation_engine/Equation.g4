grammar Equation;

parse:	equation; //(equation NEWLINE)+ ;

equation: outputVariable EQUALS_SIGN expr;

expr:   MINUS_SIGN expr                             # unaryMinusExpr
	|   expr op=(MULTIPLY_SIGN|DIVIDE_SIGN) expr    # multiDivideExpr
    |	expr op=(PLUS_SIGN|MINUS_SIGN) expr         # plusMinusExpr
    |	INT_CONSTANT                                # intConstExpr
    |   FLOAT_CONSTANT                              # floatExpr
    |	'(' expr ')'                                # bracketsExpr
    |   function                                    # functionExpr
    |   variable                                    # variableExpr
    ;
function : IDENTIFIER '(' (expr (',' expr)*)? ')';
variable : IDENTIFIER ;
outputVariable : IDENTIFIER ;
IDENTIFIER : [a-zA-Z] (DIGIT | [a-zA-Z])*;
NEWLINE : [\n]+ -> channel(HIDDEN);
INT_CONSTANT : (DIGIT)+ ;
FLOAT_CONSTANT: (DIGIT)+ '.' (DIGIT)+;
PLUS_SIGN : '+';
MINUS_SIGN : '-';
DIVIDE_SIGN : '/';
MULTIPLY_SIGN : '*';
EQUALS_SIGN : '=';
WS : (' ' | '\t')+ -> channel(HIDDEN);

fragment DIGIT : [0-9]+ ;