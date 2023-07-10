grammar Terd;

command
  : SPACES? executable SPACES arguments SPACES? EOF
  ;

executable
  : PATTERN
  ;

arguments
  : argument (SPACES argument)*
  ;

argument
  : (option | PATTERN)
  ;

option
  : ('-' | '--') PATTERN
  ;

PATTERN
  : WORD ('-' | WORD)*
  ;

STRING
  : QUOTED_STRING
  | DQUOTED_STRING
  ;

QUOTED_STRING: '\'' QUOTED_STRING_CH* '\'';

DQUOTED_STRING: '"' DQUOTED_STRING_CH* '"';

SPACES: [ \t]+;

fragment WORD: ~[ '"-];

fragment QUOTED_STRING_CH:  ~['];

fragment DQUOTED_STRING_CH:  ~["];

WS
  : [ \t\r] + -> skip
  ;
