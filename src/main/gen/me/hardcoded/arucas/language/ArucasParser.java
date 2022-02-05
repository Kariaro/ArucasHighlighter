// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.language;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static me.hardcoded.arucas.psi.ArucasTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ArucasParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return arucas(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ARITHMETIC_EXPRESSION, ATOM, EXPRESSION, FUNCTION_LAMBDA,
      LIST_EXPRESSION, MAP_EXPRESSION, NEW_EXPRESSION, UNARY_FACTOR_EXPRESSION),
    create_token_set_(BREAK_STATEMENT, CLASS_CODE_BLOCK, CLASS_DECLARATION, CONTINUE_STATEMENT,
      ELSE_STATEMENT, EXPRESSION_STATEMENT, FOR_EACH_STATEMENT, FOR_STATEMENT,
      FUNCTION_STATEMENT, IF_STATEMENT, RETURN_STATEMENT, STATEMENT,
      SWITCH_CODE_BLOCK, SWITCH_STATEMENT, TRY_STATEMENT, WHILE_STATEMENT),
  };

  /* ********************************************************** */
  // IdentifierName
  public static boolean Argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Argument")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IdentifierName(b, l + 1);
    exit_section_(b, m, ARGUMENT, r);
    return r;
  }

  /* ********************************************************** */
  // '(' [ Argument (',' Argument)* ] ')'
  public static boolean Arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && Arguments_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, ARGUMENTS, r);
    return r;
  }

  // [ Argument (',' Argument)* ]
  private static boolean Arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1")) return false;
    Arguments_1_0(b, l + 1);
    return true;
  }

  // Argument (',' Argument)*
  private static boolean Arguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Argument(b, l + 1);
    r = r && Arguments_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' Argument)*
  private static boolean Arguments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Arguments_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Arguments_1_0_1", c)) break;
    }
    return true;
  }

  // ',' Argument
  private static boolean Arguments_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Argument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TermExpression [ArithmeticOp ArithmeticExpression]
  public static boolean ArithmeticExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArithmeticExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, ARITHMETIC_EXPRESSION, "<arithmetic expression>");
    r = TermExpression(b, l + 1);
    r = r && ArithmeticExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [ArithmeticOp ArithmeticExpression]
  private static boolean ArithmeticExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArithmeticExpression_1")) return false;
    ArithmeticExpression_1_0(b, l + 1);
    return true;
  }

  // ArithmeticOp ArithmeticExpression
  private static boolean ArithmeticExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArithmeticExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ArithmeticOp(b, l + 1);
    r = r && ArithmeticExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '+' | '-'
  static boolean ArithmeticOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArithmeticOp")) return false;
    if (!nextTokenIs(b, "", OP_MINUS, OP_PLUS)) return false;
    boolean r;
    r = consumeToken(b, OP_PLUS);
    if (!r) r = consumeToken(b, OP_MINUS);
    return r;
  }

  /* ********************************************************** */
  // IdentifierName
  //   | VALUE_KEYWORD
  //   | STRING
  //   | NUMBER
  public static boolean Atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM, "<atom>");
    r = IdentifierName(b, l + 1);
    if (!r) r = consumeToken(b, VALUE_KEYWORD);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Atom
  //   | ListExpression
  //   | MapExpression
  //   | FunctionLambda
  //   | NewExpression
  //   | '(' Expression ')'
  static boolean AtomExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AtomExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Atom(b, l + 1);
    if (!r) r = ListExpression(b, l + 1);
    if (!r) r = MapExpression(b, l + 1);
    if (!r) r = FunctionLambda(b, l + 1);
    if (!r) r = NewExpression(b, l + 1);
    if (!r) r = AtomExpression_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' Expression ')'
  private static boolean AtomExpression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AtomExpression_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'break' ';'
  public static boolean BreakStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BreakStatement")) return false;
    if (!nextTokenIs(b, KW_BREAK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_BREAK, SEMICOLON);
    exit_section_(b, m, BREAK_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // '(' [ Expression (',' Expression)* ] ')'
  public static boolean CallArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallArguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && CallArguments_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, CALL_ARGUMENTS, r);
    return r;
  }

  // [ Expression (',' Expression)* ]
  private static boolean CallArguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallArguments_1")) return false;
    CallArguments_1_0(b, l + 1);
    return true;
  }

  // Expression (',' Expression)*
  private static boolean CallArguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallArguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && CallArguments_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' Expression)*
  private static boolean CallArguments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallArguments_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!CallArguments_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CallArguments_1_0_1", c)) break;
    }
    return true;
  }

  // ',' Expression
  private static boolean CallArguments_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallArguments_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MemberExpression [CallArguments]
  static boolean CallExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MemberExpression(b, l + 1);
    r = r && CallExpression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [CallArguments]
  private static boolean CallExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallExpression_1")) return false;
    CallArguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ['-'] NUMBER
  static boolean CaseNumber(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseNumber")) return false;
    if (!nextTokenIs(b, "", NUMBER, OP_MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CaseNumber_0(b, l + 1);
    r = r && consumeToken(b, NUMBER);
    exit_section_(b, m, null, r);
    return r;
  }

  // ['-']
  private static boolean CaseNumber_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseNumber_0")) return false;
    consumeToken(b, OP_MINUS);
    return true;
  }

  /* ********************************************************** */
  // ('default' | 'case' CaseValues) '->' Statement
  public static boolean CaseStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseStatement")) return false;
    if (!nextTokenIs(b, "<case statement>", KW_CASE, KW_DEFAULT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_STATEMENT, "<case statement>");
    r = CaseStatement_0(b, l + 1);
    r = r && consumeToken(b, POINTER);
    r = r && Statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'default' | 'case' CaseValues
  private static boolean CaseStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseStatement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_DEFAULT);
    if (!r) r = CaseStatement_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'case' CaseValues
  private static boolean CaseStatement_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseStatement_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_CASE);
    r = r && CaseValues(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING
  static boolean CaseString(PsiBuilder b, int l) {
    return consumeToken(b, STRING);
  }

  /* ********************************************************** */
  // CaseString | CaseNumber
  public static boolean CaseValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_VALUE, "<case value>");
    r = CaseString(b, l + 1);
    if (!r) r = CaseNumber(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CaseValue (',' CaseValue)*
  public static boolean CaseValues(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseValues")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_VALUES, "<case values>");
    r = CaseValue(b, l + 1);
    r = r && CaseValues_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' CaseValue)*
  private static boolean CaseValues_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseValues_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!CaseValues_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CaseValues_1", c)) break;
    }
    return true;
  }

  // ',' CaseValue
  private static boolean CaseValues_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseValues_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && CaseValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ClassMember
  //   | ClassConstructor
  //   | ClassMethod
  //   | ClassOperator
  static boolean ClassBodyStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassBodyStatement")) return false;
    boolean r;
    r = ClassMember(b, l + 1);
    if (!r) r = ClassConstructor(b, l + 1);
    if (!r) r = ClassMethod(b, l + 1);
    if (!r) r = ClassOperator(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // '{' ClassBodyStatement* '}'
  public static boolean ClassCodeBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassCodeBlock")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && ClassCodeBlock_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, CLASS_CODE_BLOCK, r);
    return r;
  }

  // ClassBodyStatement*
  private static boolean ClassCodeBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassCodeBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ClassBodyStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ClassCodeBlock_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IdentifierName Arguments CodeBlock
  public static boolean ClassConstructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassConstructor")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IdentifierName(b, l + 1);
    r = r && Arguments(b, l + 1);
    r = r && CodeBlock(b, l + 1);
    exit_section_(b, m, CLASS_CONSTRUCTOR, r);
    return r;
  }

  /* ********************************************************** */
  // 'class' IdentifierName ClassCodeBlock
  public static boolean ClassDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration")) return false;
    if (!nextTokenIs(b, KW_CLASS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_CLASS);
    r = r && IdentifierName(b, l + 1);
    r = r && ClassCodeBlock(b, l + 1);
    exit_section_(b, m, CLASS_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // FunctionModifiers 'var' IdentifierName ['=' Expression] ';'
  public static boolean ClassMember(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassMember")) return false;
    if (!nextTokenIs(b, "<class member>", KW_STATIC, KW_VAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_MEMBER, "<class member>");
    r = FunctionModifiers(b, l + 1);
    r = r && consumeToken(b, KW_VAR);
    r = r && IdentifierName(b, l + 1);
    r = r && ClassMember_3(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ['=' Expression]
  private static boolean ClassMember_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassMember_3")) return false;
    ClassMember_3_0(b, l + 1);
    return true;
  }

  // '=' Expression
  private static boolean ClassMember_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassMember_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGNMENT);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FunctionModifiers 'fun' IdentifierName Arguments CodeBlock
  public static boolean ClassMethod(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassMethod")) return false;
    if (!nextTokenIs(b, "<class method>", KW_FUN, KW_STATIC)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_METHOD, "<class method>");
    r = FunctionModifiers(b, l + 1);
    r = r && consumeToken(b, KW_FUN);
    r = r && IdentifierName(b, l + 1);
    r = r && Arguments(b, l + 1);
    r = r && CodeBlock(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'operator' Operator OperatorArguments CodeBlock
  public static boolean ClassOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassOperator")) return false;
    if (!nextTokenIs(b, KW_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_OPERATOR);
    r = r && Operator(b, l + 1);
    r = r && OperatorArguments(b, l + 1);
    r = r && CodeBlock(b, l + 1);
    exit_section_(b, m, CLASS_OPERATOR, r);
    return r;
  }

  /* ********************************************************** */
  // '{' ( '}' | Statement+ '}' )
  public static boolean CodeBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CodeBlock")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && CodeBlock_1(b, l + 1);
    exit_section_(b, m, CODE_BLOCK, r);
    return r;
  }

  // '}' | Statement+ '}'
  private static boolean CodeBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CodeBlock_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RBRACE);
    if (!r) r = CodeBlock_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Statement+ '}'
  private static boolean CodeBlock_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CodeBlock_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CodeBlock_1_1_0(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // Statement+
  private static boolean CodeBlock_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CodeBlock_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Statement(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CodeBlock_1_1_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '!' ComparisonExpression
  //   | ArithmeticExpression [ComparisonOp ArithmeticExpression]
  static boolean ComparisonExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComparisonExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ComparisonExpression_0(b, l + 1);
    if (!r) r = ComparisonExpression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '!' ComparisonExpression
  private static boolean ComparisonExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComparisonExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_NOT);
    r = r && ComparisonExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ArithmeticExpression [ComparisonOp ArithmeticExpression]
  private static boolean ComparisonExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComparisonExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ArithmeticExpression(b, l + 1);
    r = r && ComparisonExpression_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ComparisonOp ArithmeticExpression]
  private static boolean ComparisonExpression_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComparisonExpression_1_1")) return false;
    ComparisonExpression_1_1_0(b, l + 1);
    return true;
  }

  // ComparisonOp ArithmeticExpression
  private static boolean ComparisonExpression_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComparisonExpression_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ComparisonOp(b, l + 1);
    r = r && ArithmeticExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '==' | '!=' | '<' | '>' | '<=' | '>='
  static boolean ComparisonOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComparisonOp")) return false;
    boolean r;
    r = consumeToken(b, OP_EQUALS);
    if (!r) r = consumeToken(b, OP_NOTEQUALS);
    if (!r) r = consumeToken(b, OP_LESSTHAN);
    if (!r) r = consumeToken(b, OP_MORETHAN);
    if (!r) r = consumeToken(b, OP_LESSTHANEQ);
    if (!r) r = consumeToken(b, OP_MORETHANEQ);
    return r;
  }

  /* ********************************************************** */
  // 'continue' ';'
  public static boolean ContinueStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContinueStatement")) return false;
    if (!nextTokenIs(b, KW_CONTINUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_CONTINUE, SEMICOLON);
    exit_section_(b, m, CONTINUE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // 'else' Statement
  public static boolean ElseStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ElseStatement")) return false;
    if (!nextTokenIs(b, KW_ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_ELSE);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, ELSE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ModifyVariable
  //   | SizeExpression
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION, "<expression>");
    r = ModifyVariable(b, l + 1);
    if (!r) r = SizeExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression ';'
  public static boolean ExpressionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_STATEMENT, "<expression statement>");
    r = Expression(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // UnaryFactorExpression
  //   | PowerExpression
  static boolean FactorExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FactorExpression")) return false;
    boolean r;
    r = UnaryFactorExpression(b, l + 1);
    if (!r) r = PowerExpression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // '+' | '-'
  static boolean FactorOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FactorOp")) return false;
    if (!nextTokenIs(b, "", OP_MINUS, OP_PLUS)) return false;
    boolean r;
    r = consumeToken(b, OP_PLUS);
    if (!r) r = consumeToken(b, OP_MINUS);
    return r;
  }

  /* ********************************************************** */
  // 'foreach' '(' IdentifierName ':' MemberExpression ')' Statement
  public static boolean ForEachStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForEachStatement")) return false;
    if (!nextTokenIs(b, KW_FOREACH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_FOREACH, LPAREN);
    r = r && IdentifierName(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && MemberExpression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, FOR_EACH_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // 'for' '(' Expression? ';' Expression? ';' Expression? ')' Statement
  public static boolean ForStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement")) return false;
    if (!nextTokenIs(b, KW_FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_FOR, LPAREN);
    r = r && ForStatement_2(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && ForStatement_4(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && ForStatement_6(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, FOR_STATEMENT, r);
    return r;
  }

  // Expression?
  private static boolean ForStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_2")) return false;
    Expression(b, l + 1);
    return true;
  }

  // Expression?
  private static boolean ForStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_4")) return false;
    Expression(b, l + 1);
    return true;
  }

  // Expression?
  private static boolean ForStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_6")) return false;
    Expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'fun' Arguments CodeBlock
  public static boolean FunctionLambda(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionLambda")) return false;
    if (!nextTokenIs(b, KW_FUN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_FUN);
    r = r && Arguments(b, l + 1);
    r = r && CodeBlock(b, l + 1);
    exit_section_(b, m, FUNCTION_LAMBDA, r);
    return r;
  }

  /* ********************************************************** */
  // 'static'?
  public static boolean FunctionModifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionModifiers")) return false;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_MODIFIERS, "<function modifiers>");
    consumeToken(b, KW_STATIC);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // 'fun' IdentifierName Arguments CodeBlock
  public static boolean FunctionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionStatement")) return false;
    if (!nextTokenIs(b, KW_FUN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_FUN);
    r = r && IdentifierName(b, l + 1);
    r = r && Arguments(b, l + 1);
    r = r && CodeBlock(b, l + 1);
    exit_section_(b, m, FUNCTION_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean IdentifierName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IdentifierName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, IDENTIFIER_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // 'if' '(' Expression ')' Statement ElseStatement?
  public static boolean IfStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement")) return false;
    if (!nextTokenIs(b, KW_IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_IF, LPAREN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && Statement(b, l + 1);
    r = r && IfStatement_5(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // ElseStatement?
  private static boolean IfStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_5")) return false;
    ElseStatement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Expression (',' Expression)*
  static boolean ListElements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ListElements")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && ListElements_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' Expression)*
  private static boolean ListElements_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ListElements_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ListElements_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ListElements_1", c)) break;
    }
    return true;
  }

  // ',' Expression
  private static boolean ListElements_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ListElements_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '[' [ListElements] ']'
  public static boolean ListExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ListExpression")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && ListExpression_1(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, LIST_EXPRESSION, r);
    return r;
  }

  // [ListElements]
  private static boolean ListExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ListExpression_1")) return false;
    ListElements(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // MapEntry (',' MapEntry)*
  static boolean MapElements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapElements")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MapEntry(b, l + 1);
    r = r && MapElements_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' MapEntry)*
  private static boolean MapElements_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapElements_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!MapElements_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MapElements_1", c)) break;
    }
    return true;
  }

  // ',' MapEntry
  private static boolean MapElements_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapElements_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && MapEntry(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression ':' Expression
  public static boolean MapEntry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapEntry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAP_ENTRY, "<map entry>");
    r = Expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' [MapElements] '}'
  public static boolean MapExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapExpression")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && MapExpression_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, MAP_EXPRESSION, r);
    return r;
  }

  // [MapElements]
  private static boolean MapExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapExpression_1")) return false;
    MapElements(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // AtomExpression [MemberLoop]
  static boolean MemberExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AtomExpression(b, l + 1);
    r = r && MemberExpression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [MemberLoop]
  private static boolean MemberExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberExpression_1")) return false;
    MemberLoop(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '.' AtomExpression MemberOp
  static boolean MemberLoop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberLoop")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && AtomExpression(b, l + 1);
    r = r && MemberOp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CallArguments [MemberLoop]
  //   | '=' Expression
  //   | '++'
  //   | '--'
  //   | [MemberLoop]
  static boolean MemberOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberOp")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MemberOp_0(b, l + 1);
    if (!r) r = MemberOp_1(b, l + 1);
    if (!r) r = consumeToken(b, OP_PP);
    if (!r) r = consumeToken(b, OP_MM);
    if (!r) r = MemberOp_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CallArguments [MemberLoop]
  private static boolean MemberOp_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberOp_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CallArguments(b, l + 1);
    r = r && MemberOp_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [MemberLoop]
  private static boolean MemberOp_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberOp_0_1")) return false;
    MemberLoop(b, l + 1);
    return true;
  }

  // '=' Expression
  private static boolean MemberOp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberOp_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGNMENT);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [MemberLoop]
  private static boolean MemberOp_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberOp_4")) return false;
    MemberLoop(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '++' | '--' | '=' Expression
  static boolean ModifyOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModifyOp")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_PP);
    if (!r) r = consumeToken(b, OP_MM);
    if (!r) r = ModifyOp_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '=' Expression
  private static boolean ModifyOp_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModifyOp_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGNMENT);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IdentifierName ModifyOp
  static boolean ModifyVariable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModifyVariable")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IdentifierName(b, l + 1);
    r = r && ModifyOp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'new' IdentifierName CallArguments
  public static boolean NewExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NewExpression")) return false;
    if (!nextTokenIs(b, KW_NEW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_NEW);
    r = r && IdentifierName(b, l + 1);
    r = r && CallArguments(b, l + 1);
    exit_section_(b, m, NEW_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // '+' | '-' | '*' | '/' | '^' | '!' | '==' | '!='
  //   | '++' | '--' | '&&' | '||' | '>=' | '<=' | '>' | '<'
  public static boolean Operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERATOR, "<operator>");
    r = consumeToken(b, OP_PLUS);
    if (!r) r = consumeToken(b, OP_MINUS);
    if (!r) r = consumeToken(b, OP_MUL);
    if (!r) r = consumeToken(b, OP_DIV);
    if (!r) r = consumeToken(b, OP_POW);
    if (!r) r = consumeToken(b, OP_NOT);
    if (!r) r = consumeToken(b, OP_EQUALS);
    if (!r) r = consumeToken(b, OP_NOTEQUALS);
    if (!r) r = consumeToken(b, OP_PP);
    if (!r) r = consumeToken(b, OP_MM);
    if (!r) r = consumeToken(b, OP_LOGICAL_AND);
    if (!r) r = consumeToken(b, OP_LOGICAL_OR);
    if (!r) r = consumeToken(b, OP_MORETHANEQ);
    if (!r) r = consumeToken(b, OP_LESSTHANEQ);
    if (!r) r = consumeToken(b, OP_MORETHAN);
    if (!r) r = consumeToken(b, OP_LESSTHAN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Arguments
  public static boolean OperatorArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperatorArguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Arguments(b, l + 1);
    exit_section_(b, m, OPERATOR_ARGUMENTS, r);
    return r;
  }

  /* ********************************************************** */
  // CallExpression ['^' FactorExpression]
  static boolean PowerExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PowerExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CallExpression(b, l + 1);
    r = r && PowerExpression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ['^' FactorExpression]
  private static boolean PowerExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PowerExpression_1")) return false;
    PowerExpression_1_0(b, l + 1);
    return true;
  }

  // '^' FactorExpression
  private static boolean PowerExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PowerExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_POW);
    r = r && FactorExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'return' SizeExpression? ';'
  public static boolean ReturnStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement")) return false;
    if (!nextTokenIs(b, KW_RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_RETURN);
    r = r && ReturnStatement_1(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, RETURN_STATEMENT, r);
    return r;
  }

  // SizeExpression?
  private static boolean ReturnStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement_1")) return false;
    SizeExpression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ComparisonExpression [SizeOp SizeExpression]
  static boolean SizeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SizeExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ComparisonExpression(b, l + 1);
    r = r && SizeExpression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [SizeOp SizeExpression]
  private static boolean SizeExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SizeExpression_1")) return false;
    SizeExpression_1_0(b, l + 1);
    return true;
  }

  // SizeOp SizeExpression
  private static boolean SizeExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SizeExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SizeOp(b, l + 1);
    r = r && SizeExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '&&' | '||'
  static boolean SizeOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SizeOp")) return false;
    if (!nextTokenIs(b, "", OP_LOGICAL_AND, OP_LOGICAL_OR)) return false;
    boolean r;
    r = consumeToken(b, OP_LOGICAL_AND);
    if (!r) r = consumeToken(b, OP_LOGICAL_OR);
    return r;
  }

  /* ********************************************************** */
  // CodeBlock
  //   | ';'
  //   | IfStatement
  //   | WhileStatement
  //   | ClassDeclaration
  //   | FunctionStatement
  //   | TryStatement
  //   | ForEachStatement
  //   | ForStatement
  //   | SwitchStatement
  //   | ReturnStatement
  //   | ContinueStatement
  //   | BreakStatement
  //   | ExpressionStatement
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, STATEMENT, "<statement>");
    r = CodeBlock(b, l + 1);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = IfStatement(b, l + 1);
    if (!r) r = WhileStatement(b, l + 1);
    if (!r) r = ClassDeclaration(b, l + 1);
    if (!r) r = FunctionStatement(b, l + 1);
    if (!r) r = TryStatement(b, l + 1);
    if (!r) r = ForEachStatement(b, l + 1);
    if (!r) r = ForStatement(b, l + 1);
    if (!r) r = SwitchStatement(b, l + 1);
    if (!r) r = ReturnStatement(b, l + 1);
    if (!r) r = ContinueStatement(b, l + 1);
    if (!r) r = BreakStatement(b, l + 1);
    if (!r) r = ExpressionStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' CaseStatement* '}'
  public static boolean SwitchCodeBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchCodeBlock")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && SwitchCodeBlock_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, SWITCH_CODE_BLOCK, r);
    return r;
  }

  // CaseStatement*
  private static boolean SwitchCodeBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchCodeBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!CaseStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SwitchCodeBlock_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'switch' '(' Expression ')' SwitchCodeBlock
  public static boolean SwitchStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchStatement")) return false;
    if (!nextTokenIs(b, KW_SWITCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_SWITCH, LPAREN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && SwitchCodeBlock(b, l + 1);
    exit_section_(b, m, SWITCH_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // FactorExpression [TermOp TermExpression]
  static boolean TermExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TermExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FactorExpression(b, l + 1);
    r = r && TermExpression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [TermOp TermExpression]
  private static boolean TermExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TermExpression_1")) return false;
    TermExpression_1_0(b, l + 1);
    return true;
  }

  // TermOp TermExpression
  private static boolean TermExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TermExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TermOp(b, l + 1);
    r = r && TermExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '*' | '/'
  static boolean TermOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TermOp")) return false;
    if (!nextTokenIs(b, "", OP_DIV, OP_MUL)) return false;
    boolean r;
    r = consumeToken(b, OP_MUL);
    if (!r) r = consumeToken(b, OP_DIV);
    return r;
  }

  /* ********************************************************** */
  // 'try' Statement 'catch' '(' IdentifierName ')' Statement
  public static boolean TryStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStatement")) return false;
    if (!nextTokenIs(b, KW_TRY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_TRY);
    r = r && Statement(b, l + 1);
    r = r && consumeTokens(b, 0, KW_CATCH, LPAREN);
    r = r && IdentifierName(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, TRY_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // FactorOp FactorExpression
  public static boolean UnaryFactorExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryFactorExpression")) return false;
    if (!nextTokenIs(b, "<unary factor expression>", OP_MINUS, OP_PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, UNARY_FACTOR_EXPRESSION, "<unary factor expression>");
    r = FactorOp(b, l + 1);
    r = r && FactorExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'while' '(' Expression ')' Statement
  public static boolean WhileStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement")) return false;
    if (!nextTokenIs(b, KW_WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_WHILE, LPAREN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // Statement *
  static boolean arucas(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arucas")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arucas", c)) break;
    }
    return true;
  }

}
