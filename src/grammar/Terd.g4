grammar Terd;

command
  : executable (SPACES arguments)? EOF
  ;

executable
  : PATTERN
  ;

arguments
  : argument (SPACES argument)*
  ;

argument
  : (option | optionWithArgument | PATTERN)
  ;

option
  : '-' PATTERN
  ;

optionWithArgument
  : '--' PATTERN SPACES PATTERN
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