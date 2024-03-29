package me.hardcoded.arucas.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import me.hardcoded.arucas.psi.ArucasTypes;
import com.intellij.psi.TokenType;

%%

%class ArucasLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}


Keyword = "if" | "else" | "foreach" | "for" | "while" | "try" | "catch"
  | "fun" | "class" | "new" | "static" | "var" | "switch"
  | "case" | "default" | "return" | "break" | "continue" | "operator"
  | "import" | "from" | "finally" | "local" | "enum" |"interface" | "super"
  
ValueKeyword = "true" | "false" | "this" | "null"

LineTerminator = \r|\n|\r\n
WhiteSpace = [ \t\r\n\f]+

/* literals */
Identifier = [a-zA-Z_][a-zA-Z0-9_]*
Number = [0-9]+(\.[0-9]+)?

Operator = "--" | "++" | "+" | "-" | "*" | "/" | "^" | "!" | ">>" | "<<" | "~" | "|" | "&"
Syntax = "==" | "!=" | ">=" | "<=" | ">" | "<" | "||" | "&&"

/* comments */
Comment = {LineComment} | {TraditionalComment}
LineComment          = "//" [^\r\n]*
TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"

%state STRING_DOUBLE
%state STRING_SINGLE

%%
<YYINITIAL> {
  /* spaces */
  \"                               { yybegin(STRING_DOUBLE); }
  \'                               { yybegin(STRING_SINGLE); }

  "true"                           { return ArucasTypes.KW_TRUE; }
  "false"                          { return ArucasTypes.KW_FALSE; }
  "null"                           { return ArucasTypes.KW_NULL; }
  "this"                           { return ArucasTypes.KW_THIS; }

  "if"                             { return ArucasTypes.KW_IF; }
  "else"                           { return ArucasTypes.KW_ELSE; }
  "foreach"                        { return ArucasTypes.KW_FOREACH; }
  "for"                            { return ArucasTypes.KW_FOR; }
  "while"                          { return ArucasTypes.KW_WHILE; }
  "try"                            { return ArucasTypes.KW_TRY; }
  "catch"                          { return ArucasTypes.KW_CATCH; }
  "fun"                            { return ArucasTypes.KW_FUN; }
  "class"                          { return ArucasTypes.KW_CLASS; }
  "new"                            { return ArucasTypes.KW_NEW; }
  "static"                         { return ArucasTypes.KW_STATIC; }
  "var"                            { return ArucasTypes.KW_VAR; }
  "switch"                         { return ArucasTypes.KW_SWITCH; }
  "case"                           { return ArucasTypes.KW_CASE; }
  "default"                        { return ArucasTypes.KW_DEFAULT; }
  "return"                         { return ArucasTypes.KW_RETURN; }
  "break"                          { return ArucasTypes.KW_BREAK; }
  "continue"                       { return ArucasTypes.KW_CONTINUE; }
  "operator"                       { return ArucasTypes.KW_OPERATOR; }
  "import"                         { return ArucasTypes.KW_IMPORT; }
  "from"                           { return ArucasTypes.KW_FROM; }
  "finally"                        { return ArucasTypes.KW_FINALLY; }
  "local"                          { return ArucasTypes.KW_LOCAL; }
  "enum"                           { return ArucasTypes.KW_ENUM; }
  "interface"                      { return ArucasTypes.KW_INTERFACE; }
  "super"                          { return ArucasTypes.KW_SUPER; }
  "throw"                          { return ArucasTypes.KW_THROW; }

  "+"                              { return ArucasTypes.OP_PLUS; }
  "-"                              { return ArucasTypes.OP_MINUS; }
  "*"                              { return ArucasTypes.OP_MUL; }
  "/"                              { return ArucasTypes.OP_DIV; }
  "^"                              { return ArucasTypes.OP_POW; }
  "!"                              { return ArucasTypes.OP_NOT; }
  "++"                             { return ArucasTypes.OP_PP; }
  "--"                             { return ArucasTypes.OP_MM; }

  "||"                             { return ArucasTypes.OP_LOGICAL_OR; }
  "&&"                             { return ArucasTypes.OP_LOGICAL_AND; }
  "=="                             { return ArucasTypes.OP_EQUALS; }
  "!="                             { return ArucasTypes.OP_NOTEQUALS; }
  ">="                             { return ArucasTypes.OP_MORETHANEQ; }
  ">"                              { return ArucasTypes.OP_MORETHAN; }
  "<="                             { return ArucasTypes.OP_LESSTHANEQ; }
  "<"                              { return ArucasTypes.OP_LESSTHAN; }

  "<<"                             { return ArucasTypes.OP_BSHL; }
  ">>"                             { return ArucasTypes.OP_BSHR; }
  "~"                              { return ArucasTypes.OP_BXOR; }
  "&"                              { return ArucasTypes.OP_BAND; }
  "|"                              { return ArucasTypes.OP_BOR; }

  "..."                            { return ArucasTypes.ARBITRARY; }
  "("                              { return ArucasTypes.LPAREN; }
  ")"                              { return ArucasTypes.RPAREN; }
  "["                              { return ArucasTypes.LBRACK; }
  "]"                              { return ArucasTypes.RBRACK; }
  "{"                              { return ArucasTypes.LBRACE; }
  "}"                              { return ArucasTypes.RBRACE; }
  "->"                             { return ArucasTypes.POINTER; }
  ":"                              { return ArucasTypes.COLON; }
  "."                              { return ArucasTypes.DOT; }
  "="                              { return ArucasTypes.ASSIGNMENT; }
  ";"                              { return ArucasTypes.SEMICOLON; }
  ","                              { return ArucasTypes.COMMA; }

  /* literals */
  {Number}                         { return ArucasTypes.NUMBER; }
  {Identifier}                     { return ArucasTypes.IDENTIFIER; }

  /* comments */
  {Comment}                        { return ArucasTypes.COMMENT; }

  /* whitespaces */
  {WhiteSpace}                     { return TokenType.WHITE_SPACE; }
}

<STRING_DOUBLE> {
  \"                             { yybegin(YYINITIAL); return ArucasTypes.STRING; }
  [^\n\r\"\\]+                   { }
  \\t                            { }
  \\n                            { }

  \\r                            { }
  \\\"                           { }
  \\\\                           { }
  \\                             { }
}

<STRING_SINGLE> {
  \'                             { yybegin(YYINITIAL); return ArucasTypes.STRING; }
  [^\n\r\'\\]+                   { }
  \\t                            { }
  \\n                            { }

  \\r                            { }
  \\\'                           { }
  \\\\                           { }
  \\                             { }
}

[^]                              { return TokenType.BAD_CHARACTER; }