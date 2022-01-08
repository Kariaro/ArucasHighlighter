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
  | "fun" | "class" | "operator" | "new" | "static" | "var" | "switch"
  | "case" | "return" | "break" | "continue"

ValueKeyword = "true" | "false" | "this" | "null"

LineTerminator = \r|\n|\r\n
WhiteSpace = [ \t\r\n\f]+

/* literals */
Identifier = [a-zA-Z_][a-zA-Z0-9_]*
Number = -?[0-9]+(\.[0-9]+)?

Operator = "--" | "++" | "+" | "-" | "*" | "/" | "^" | "!"
Syntax = ":" | "." | "==" | "!=" | "(" | ")" | "[" | "]" | "{"
  | "}" | ">=" | "<=" | "=" | ">" | "<" | "||" | "&&" | "->"

Delimiter = ";" | ","

/* comments */
Comment = {LineComment} | {TraditionalComment} | {EndOfLineComment}
LineComment          = "//" [^\r\n]* {LineTerminator}
TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" [^\r\n]* {LineTerminator}?

%state STRING_DOUBLE
%state STRING_SINGLE

%%
<YYINITIAL> {
  /* spaces */
  \"                               { yybegin(STRING_DOUBLE); }
  \'                               { yybegin(STRING_SINGLE); }

/*
  "if"                             { return ArucasTypes.KEYWORD; }
  "else"                           { return ArucasTypes.KEYWORD; }
  "foreach"                        { return ArucasTypes.KEYWORD; }
  "for"                            { return ArucasTypes.KEYWORD; }
  "while"                          { return ArucasTypes.KEYWORD; }
  "try"                            { return ArucasTypes.KEYWORD; }
  "catch"                          { return ArucasTypes.KEYWORD; }
  "fun"                            { return ArucasTypes.KEYWORD; }
  "class"                          { return ArucasTypes.KEYWORD; }
  "new"                            { return ArucasTypes.KEYWORD; }
  "static"                         { return ArucasTypes.KEYWORD; }
  "var"                            { return ArucasTypes.KEYWORD; }
  "switch"                         { return ArucasTypes.KEYWORD; }
  "case"                           { return ArucasTypes.KEYWORD; }
  "return"                         { return ArucasTypes.KEYWORD; }
  "break"                          { return ArucasTypes.KEYWORD; }
  "continue"                       { return ArucasTypes.KEYWORD; }
  "operator"                       { return ArucasTypes.KEYWORD; }
*/

  /* keywords */
  {Keyword}                        { return ArucasTypes.KEYWORD; }
  {ValueKeyword}                   { return ArucasTypes.VALUE_KEYWORD; }
  {Syntax}                         { return ArucasTypes.SYNTAX; }
  {Delimiter}                      { return ArucasTypes.DELIMITER; }
  {Operator}                       { return ArucasTypes.OPERATOR; }

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