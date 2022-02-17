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
    create_token_set_(BREAK_STATEMENT, CLASS_CODE_BLOCK, CLASS_DECLARATION, CONTINUE_STATEMENT,
      ELSE_STATEMENT, EXPRESSION_STATEMENT, FOR_EACH_STATEMENT, FOR_STATEMENT,
      FUNCTION_STATEMENT, IF_STATEMENT, RETURN_STATEMENT, STATEMENT,
      SWITCH_CODE_BLOCK, SWITCH_STATEMENT, TRY_STATEMENT, WHILE_STATEMENT),
    create_token_set_(ARITHMETIC_EXPRESSION, ASSIGN_EXPRESSION, ATOM_EXPRESSION, CALL_EXPRESSION,
      CONDITIONAL_AND_EXPRESSION, CONDITIONAL_OR_EXPRESSION, EXPRESSION, FACTOR_EXPRESSION,
      LAMBDA_EXPRESSION, LIST_EXPRESSION, MAP_EXPRESSION, MEMBER_EXPRESSION,
      NEW_EXPRESSION, PARENTHESES_EXPRESSION, POWER_EXPRESSION, RELATIONAL_EXPRESSION,
      UNARY_EXPRESSION, UNARY_NOT_EXPRESSION),
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
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CALL_ARGUMENTS, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, CallArguments_1(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
    r = Expression(b, l + 1, -1);
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
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
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
    r = r && Expression(b, l + 1, -1);
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
  // Expression ';'
  public static boolean ExpressionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionStatement")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_STATEMENT, "<expression statement>");
    r = Expression(b, l + 1, -1);
    p = r; // pin = 1
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
    r = r && Expression(b, l + 1, 9);
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
    Expression(b, l + 1, -1);
    return true;
  }

  // Expression?
  private static boolean ForStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_4")) return false;
    Expression(b, l + 1, -1);
    return true;
  }

  // Expression?
  private static boolean ForStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_6")) return false;
    Expression(b, l + 1, -1);
    return true;
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
    r = r && Expression(b, l + 1, -1);
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
    r = Expression(b, l + 1, -1);
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
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
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
    r = Expression(b, l + 1, -1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
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
  // 'return' Expression? ';'
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

  // Expression?
  private static boolean ReturnStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement_1")) return false;
    Expression(b, l + 1, -1);
    return true;
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
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, RPAREN);
    r = r && SwitchCodeBlock(b, l + 1);
    exit_section_(b, m, SWITCH_STATEMENT, r);
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
  // KW_TRUE | KW_FALSE | KW_NULL | KW_THIS
  static boolean ValueKeyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ValueKeyword")) return false;
    boolean r;
    r = consumeToken(b, KW_TRUE);
    if (!r) r = consumeToken(b, KW_FALSE);
    if (!r) r = consumeToken(b, KW_NULL);
    if (!r) r = consumeToken(b, KW_THIS);
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
    r = r && Expression(b, l + 1, -1);
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

  /* ********************************************************** */
  // Expression root: Expression
  // Operator priority table:
  // 0: ATOM(AssignExpression)
  // 1: BINARY(ConditionalOrExpression)
  // 2: BINARY(ConditionalAndExpression)
  // 3: PREFIX(UnaryNotExpression)
  // 4: BINARY(RelationalExpression)
  // 5: BINARY(ArithmeticExpression)
  // 6: BINARY(FactorExpression)
  // 7: PREFIX(UnaryExpression)
  // 8: BINARY(PowerExpression)
  // 9: POSTFIX(CallExpression)
  // 10: BINARY(MemberExpression)
  // 11: ATOM(AtomExpression) ATOM(ListExpression) ATOM(MapExpression) ATOM(LambdaExpression)
  //    ATOM(NewExpression) PREFIX(ParenthesesExpression)
  public static boolean Expression(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    addVariant(b, "<expression>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expression>");
    r = AssignExpression(b, l + 1);
    if (!r) r = UnaryNotExpression(b, l + 1);
    if (!r) r = UnaryExpression(b, l + 1);
    if (!r) r = AtomExpression(b, l + 1);
    if (!r) r = ListExpression(b, l + 1);
    if (!r) r = MapExpression(b, l + 1);
    if (!r) r = LambdaExpression(b, l + 1);
    if (!r) r = NewExpression(b, l + 1);
    if (!r) r = ParenthesesExpression(b, l + 1);
    p = r;
    r = r && Expression_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean Expression_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Expression_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 1 && consumeTokenSmart(b, OP_LOGICAL_OR)) {
        r = Expression(b, l, 1);
        exit_section_(b, l, m, CONDITIONAL_OR_EXPRESSION, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, OP_LOGICAL_AND)) {
        r = Expression(b, l, 2);
        exit_section_(b, l, m, CONDITIONAL_AND_EXPRESSION, r, true, null);
      }
      else if (g < 4 && RelationalExpression_0(b, l + 1)) {
        r = Expression(b, l, 4);
        exit_section_(b, l, m, RELATIONAL_EXPRESSION, r, true, null);
      }
      else if (g < 5 && ArithmeticExpression_0(b, l + 1)) {
        r = Expression(b, l, 5);
        exit_section_(b, l, m, ARITHMETIC_EXPRESSION, r, true, null);
      }
      else if (g < 6 && FactorExpression_0(b, l + 1)) {
        r = Expression(b, l, 6);
        exit_section_(b, l, m, FACTOR_EXPRESSION, r, true, null);
      }
      else if (g < 8 && consumeTokenSmart(b, OP_POW)) {
        r = Expression(b, l, 8);
        exit_section_(b, l, m, POWER_EXPRESSION, r, true, null);
      }
      else if (g < 9 && CallExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, CALL_EXPRESSION, r, true, null);
      }
      else if (g < 10 && MemberExpression_0(b, l + 1)) {
        r = Expression(b, l, 10);
        exit_section_(b, l, m, MEMBER_EXPRESSION, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // IdentifierName ('++' | '--' | '=' Expression)
  public static boolean AssignExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignExpression")) return false;
    if (!nextTokenIsSmart(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IdentifierName(b, l + 1);
    r = r && AssignExpression_1(b, l + 1);
    exit_section_(b, m, ASSIGN_EXPRESSION, r);
    return r;
  }

  // '++' | '--' | '=' Expression
  private static boolean AssignExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, OP_PP);
    if (!r) r = consumeTokenSmart(b, OP_MM);
    if (!r) r = AssignExpression_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '=' Expression
  private static boolean AssignExpression_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignExpression_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, ASSIGNMENT);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  public static boolean UnaryNotExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryNotExpression")) return false;
    if (!nextTokenIsSmart(b, OP_NOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, OP_NOT);
    p = r;
    r = p && Expression(b, l, 3);
    exit_section_(b, l, m, UNARY_NOT_EXPRESSION, r, p, null);
    return r || p;
  }

  // '==' | '!=' | '<' | '>' | '<=' | '>='
  private static boolean RelationalExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, OP_EQUALS);
    if (!r) r = consumeTokenSmart(b, OP_NOTEQUALS);
    if (!r) r = consumeTokenSmart(b, OP_LESSTHAN);
    if (!r) r = consumeTokenSmart(b, OP_MORETHAN);
    if (!r) r = consumeTokenSmart(b, OP_LESSTHANEQ);
    if (!r) r = consumeTokenSmart(b, OP_MORETHANEQ);
    return r;
  }

  // '+' | '-'
  private static boolean ArithmeticExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArithmeticExpression_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, OP_PLUS);
    if (!r) r = consumeTokenSmart(b, OP_MINUS);
    return r;
  }

  // '*' | '/'
  private static boolean FactorExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FactorExpression_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, OP_MUL);
    if (!r) r = consumeTokenSmart(b, OP_DIV);
    return r;
  }

  public static boolean UnaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryExpression")) return false;
    if (!nextTokenIsSmart(b, OP_MINUS, OP_PLUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = UnaryExpression_0(b, l + 1);
    p = r;
    r = p && Expression(b, l, 7);
    exit_section_(b, l, m, UNARY_EXPRESSION, r, p, null);
    return r || p;
  }

  // '+' | '-'
  private static boolean UnaryExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryExpression_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, OP_PLUS);
    if (!r) r = consumeTokenSmart(b, OP_MINUS);
    return r;
  }

  // &'(' CallArguments
  private static boolean CallExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CallExpression_0_0(b, l + 1);
    r = r && CallArguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'('
  private static boolean CallExpression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallExpression_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeTokenSmart(b, LPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '.' ( &IDENTIFIER )
  private static boolean MemberExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, DOT);
    r = r && MemberExpression_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &IDENTIFIER
  private static boolean MemberExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberExpression_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeTokenSmart(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IdentifierName
  //   | ValueKeyword
  //   | STRING
  //   | NUMBER
  public static boolean AtomExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AtomExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM_EXPRESSION, "<atom expression>");
    r = IdentifierName(b, l + 1);
    if (!r) r = ValueKeyword(b, l + 1);
    if (!r) r = consumeTokenSmart(b, STRING);
    if (!r) r = consumeTokenSmart(b, NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '[' ListElements? ']'
  public static boolean ListExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ListExpression")) return false;
    if (!nextTokenIsSmart(b, LBRACK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LIST_EXPRESSION, null);
    r = consumeTokenSmart(b, LBRACK);
    p = r; // pin = 1
    r = r && report_error_(b, ListExpression_1(b, l + 1));
    r = p && consumeToken(b, RBRACK) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ListElements?
  private static boolean ListExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ListExpression_1")) return false;
    ListElements(b, l + 1);
    return true;
  }

  // '{' MapElements? '}'
  public static boolean MapExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapExpression")) return false;
    if (!nextTokenIsSmart(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAP_EXPRESSION, null);
    r = consumeTokenSmart(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, MapExpression_1(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // MapElements?
  private static boolean MapExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapExpression_1")) return false;
    MapElements(b, l + 1);
    return true;
  }

  // 'fun' Arguments CodeBlock
  public static boolean LambdaExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaExpression")) return false;
    if (!nextTokenIsSmart(b, KW_FUN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, KW_FUN);
    r = r && Arguments(b, l + 1);
    r = r && CodeBlock(b, l + 1);
    exit_section_(b, m, LAMBDA_EXPRESSION, r);
    return r;
  }

  // 'new' IdentifierName CallArguments
  public static boolean NewExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NewExpression")) return false;
    if (!nextTokenIsSmart(b, KW_NEW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, KW_NEW);
    r = r && IdentifierName(b, l + 1);
    r = r && CallArguments(b, l + 1);
    exit_section_(b, m, NEW_EXPRESSION, r);
    return r;
  }

  public static boolean ParenthesesExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParenthesesExpression")) return false;
    if (!nextTokenIsSmart(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, LPAREN);
    p = r;
    r = p && Expression(b, l, -1);
    r = p && report_error_(b, consumeToken(b, RPAREN)) && r;
    exit_section_(b, l, m, PARENTHESES_EXPRESSION, r, p, null);
    return r || p;
  }

}
