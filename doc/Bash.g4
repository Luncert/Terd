grammar Bash;

command
  : simpleCommand
  | shellCommand
  | shellCommand redirectionList
  ;

shellCommand
  : forCommand
  | caseCommand
  | 'while' compoundList 'do' compoundList 'done'
  | 'until' compoundList 'do' compoundList 'done'
  | selectCommand
  | ifCommand
  | subShell
  | groupCommand
  | functionDef
  ;

forCommand
  : 'for' WORD NEWLINES 'do' compoundList 'done'
  | 'for' WORD NEWLINES '{' compoundList '}'
  | 'for' WORD ';' NEWLINES 'do' compoundList 'done'
  | 'for' WORD ';' NEWLINES '{' compoundList '}'
  | 'for' WORD NEWLINES 'in' wordList listTerminator NEWLINES 'do' compoundList 'done'
  | 'for' WORD NEWLINES 'in' wordList listTerminator NEWLINES '{' compoundList '}'
  ;

selectCommand
  : 'select' WORD NEWLINES 'do' list 'done'
  | 'select' WORD NEWLINES '{' list '}'
  | 'select' WORD ';' NEWLINES 'do' list 'done'
  | 'select' WORD ';' NEWLINES '{' list '}'
  | 'select' WORD NEWLINES 'in' wordList listTerminator NEWLINES 'do' list 'done'
  | 'select' WORD NEWLINES 'in' wordList listTerminator NEWLINES '{' list '}'
  ;

caseCommand
  : 'case' WORD NEWLINES 'in' wordList 'esac'
  | 'case' WORD NEWLINES 'in' caseClauseSequence NEWLINES 'esac'
  | 'case' WORD NEWLINES 'in' caseClause 'esac'
  ;

functionDef
  : WORD '(' ')' NEWLINES groupCommand
  | 'function' WORD '(' ')' NEWLINES groupCommand
  | 'function' WORD NEWLINES groupCommand
  ;

subShell
  : '(' compoundList ')'
  ;

ifCommand
  : 'if' compoundList 'then' compoundList 'fi'
  | 'if' compoundList 'then' compoundList 'else' compoundList 'fi'
  | 'if' compoundList 'then' compoundList elifClause 'fi'
  ;

groupCommand
  : '{' list '}'
  ;

elifClause
  : 'elif' compoundList 'then' compoundList
  | 'elif' compoundList 'then' compoundList 'else' compoundList
  | 'elif' compoundList 'then' compoundList elifClause
  ;

caseClause
  : caseClauseSequence? patternList
  ;

patternList
  : NEWLINES pattern ')' compoundList
  | NEWLINES pattern ')' NEWLINES
  | NEWLINES '(' pattern ')' compoundList
  | NEWLINES '(' pattern ')' NEWLINES
  ;

caseClauseSequence
  : patternList ';;'
  | caseClauseSequence patternList ';;'
  ;

pattern
  : WORD ('|' WORD)*
  ;

list
  : NEWLINES list0
  ;

compoundList
  : list
  | NEWLINES list1
  ;

list0
  : list1 ('\n' | '&' | ';') NEWLINES
  ;

list1
  : list1 ('&&' | '||' | '&' | ';' | '\n') NEWLINES list1
  | pipelineCommand
  ;

listTerminator
  : '\n'
  | ';'
  ;

simpleList
  : simpleList1 ('&' | ';')?
  ;

simpleList1
  : pipelineCommand (('&&' NEWLINES | '||' NEWLINES | '&' | ';') pipelineCommand)*
  ;

pipelineCommand
  : pipeline
  | '!' pipeline
  | timeSpec pipeline
  | timeSpec '!' pipeline
  | '!' timeSpec pipeline
  ;

pipeline
  : command ('|' NEWLINES command)*
  ;

timeOpt
  : '-p'
  ;

timeSpec
  : 'time' timeOpt?
  ;

simpleCommand
  : simpleCommandElement simpleCommandElement*
  ;

redirectionList
  : redirection redirection*
  ;

simpleCommandElement
  : WORD
  | assignmentWord
  | redirection
  ;

redirection
  : '>' WORD
  | '<' WORD
  | NUMBER '>' WORD
  | NUMBER '<' WORD
  | '>>' WORD
  | NUMBER '>>' WORD
  | '<<' WORD
  | NUMBER '<<' WORD
  | '<&' NUMBER
  | NUMBER '<&' NUMBER
  | '>&' NUMBER
  | NUMBER '>&' NUMBER
  | '<&' WORD
  | NUMBER '<&' WORD
  | '>&' WORD
  | NUMBER '>&' WORD
  | '<<-' WORD
  | NUMBER '<<-' WORD
  | '>&' '-'
  | NUMBER '>&' '-'
  | '<&' '-'
  | NUMBER '<&' '-'
  | '&>' WORD
  | NUMBER '<>' WORD
  | '<>' WORD
  | '>|' WORD
  | NUMBER '>|' WORD
  ;

assignmentWord
  : WORD '=' WORD
  ;

wordList
  : WORD WORD*
  ;

WORD
  : ALPHA ('_' | ALPHA)*
  ;

NUMBER
  : DIGIT DIGIT*
  ;

NEWLINES
  : '\n' '\n'*
  ;

fragment DIGIT
  : [0-9]
  ;

fragment ALPHA
  : [a-zA-Z]
  ;

WS
  : [ \t\r] + -> skip
  ;