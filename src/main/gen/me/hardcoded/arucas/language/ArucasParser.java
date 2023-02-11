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
    create_token_set_(CLASS_NAME, FUNCTION_NAME, IDENTIFIER_NAME, IMPORT_CLASS_NAME,
      VARIABLE_NAME),
    create_token_set_(ARITHMETIC_EXPRESSION, ARRAY_EXPRESSION, ASSIGN_EXPRESSION, ATOM_EXPRESSION,
      BIT_EXPRESSION, CALL_EXPRESSION, CONDITIONAL_AND_EXPRESSION, CONDITIONAL_OR_EXPRESSION,
      EXPRESSION, FACTOR_EXPRESSION, LAMBDA_EXPRESSION, LIST_EXPRESSION,
      MAP_EXPRESSION, MEMBER_EXPRESSION, NEW_EXPRESSION, PARENTHESES_EXPRESSION,
      POWER_EXPRESSION, RELATIONAL_EXPRESSION, UNARY_EXPRESSION, UNARY_NOT_EXPRESSION),
    create_token_set_(BREAK_STATEMENT, CLASS_CODE_BLOCK, CLASS_DECLARATION, CONTINUE_STATEMENT,
      ELSE_STATEMENT, ENUM_CODE_BLOCK, ENUM_DECLARATION, EXPRESSION_STATEMENT,
      FOR_EACH_STATEMENT, FOR_STATEMENT, FUNCTION_STATEMENT, IF_STATEMENT,
      IMPORT_STATEMENT, INTERFACE_CODE_BLOCK, INTERFACE_DECLARATION, LOCAL_STATEMENT,
      RETURN_STATEMENT, STATEMENT, SWITCH_CODE_BLOCK, SWITCH_STATEMENT,
      THROW_STATEMENT, TRY_STATEMENT, WHILE_STATEMENT),
  };

  /* ********************************************************** */
  // IdentifierName NamedTypeHint?
  public static boolean Argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Argument")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IdentifierName(b, l + 1);
    r = r && Argument_1(b, l + 1);
    exit_section_(b, m, ARGUMENT, r);
    return r;
  }

  // NamedTypeHint?
  private static boolean Argument_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Argument_1")) return false;
    NamedTypeHint(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '...'
  public static boolean ArgumentArbitrary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentArbitrary")) return false;
    if (!nextTokenIs(b, ARBITRARY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARBITRARY);
    exit_section_(b, m, ARGUMENT_ARBITRARY, r);
    return r;
  }

  /* ********************************************************** */
  // '(' IDENTIFIER ArgumentArbitrary ')' 
  //     | '(' [ Argument (',' Argument)* ] ')'
  public static boolean Arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Arguments_0(b, l + 1);
    if (!r) r = Arguments_1(b, l + 1);
    exit_section_(b, m, ARGUMENTS, r);
    return r;
  }

  // '(' IDENTIFIER ArgumentArbitrary ')'
  private static boolean Arguments_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LPAREN, IDENTIFIER);
    r = r && ArgumentArbitrary(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' [ Argument (',' Argument)* ] ')'
  private static boolean Arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && Arguments_1_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ Argument (',' Argument)* ]
  private static boolean Arguments_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1_1")) return false;
    Arguments_1_1_0(b, l + 1);
    return true;
  }

  // Argument (',' Argument)*
  private static boolean Arguments_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Argument(b, l + 1);
    r = r && Arguments_1_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' Argument)*
  private static boolean Arguments_1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Arguments_1_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Arguments_1_1_0_1", c)) break;
    }
    return true;
  }

  // ',' Argument
  private static boolean Arguments_1_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1_1_0_1_0")) return false;
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
  // FunctionName Arguments ConstructorArguments? CodeBlock
  public static boolean ClassConstructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassConstructor")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FunctionName(b, l + 1);
    r = r && Arguments(b, l + 1);
    r = r && ClassConstructor_2(b, l + 1);
    r = r && CodeBlock(b, l + 1);
    exit_section_(b, m, CLASS_CONSTRUCTOR, r);
    return r;
  }

  // ConstructorArguments?
  private static boolean ClassConstructor_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassConstructor_2")) return false;
    ConstructorArguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'class' ClassName ClassInheritance? ClassCodeBlock
  public static boolean ClassDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration")) return false;
    if (!nextTokenIs(b, KW_CLASS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_CLASS);
    r = r && ClassName(b, l + 1);
    r = r && ClassDeclaration_2(b, l + 1);
    r = r && ClassCodeBlock(b, l + 1);
    exit_section_(b, m, CLASS_DECLARATION, r);
    return r;
  }

  // ClassInheritance?
  private static boolean ClassDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration_2")) return false;
    ClassInheritance(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ':' ClassName (',' ClassName)*
  public static boolean ClassInheritance(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassInheritance")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && ClassName(b, l + 1);
    r = r && ClassInheritance_2(b, l + 1);
    exit_section_(b, m, CLASS_INHERITANCE, r);
    return r;
  }

  // (',' ClassName)*
  private static boolean ClassInheritance_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassInheritance_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ClassInheritance_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ClassInheritance_2", c)) break;
    }
    return true;
  }

  // ',' ClassName
  private static boolean ClassInheritance_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassInheritance_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ClassName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FunctionModifiers 'var' VariableName NamedTypeHint? ['=' Expression] ';'
  public static boolean ClassMember(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassMember")) return false;
    if (!nextTokenIs(b, "<class member>", KW_STATIC, KW_VAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_MEMBER, "<class member>");
    r = FunctionModifiers(b, l + 1);
    r = r && consumeToken(b, KW_VAR);
    r = r && VariableName(b, l + 1);
    r = r && ClassMember_3(b, l + 1);
    r = r && ClassMember_4(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NamedTypeHint?
  private static boolean ClassMember_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassMember_3")) return false;
    NamedTypeHint(b, l + 1);
    return true;
  }

  // ['=' Expression]
  private static boolean ClassMember_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassMember_4")) return false;
    ClassMember_4_0(b, l + 1);
    return true;
  }

  // '=' Expression
  private static boolean ClassMember_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassMember_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGNMENT);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FunctionModifiers 'fun' FunctionName Arguments NamedTypeHint? CodeBlock
  public static boolean ClassMethod(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassMethod")) return false;
    if (!nextTokenIs(b, "<class method>", KW_FUN, KW_STATIC)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_METHOD, "<class method>");
    r = FunctionModifiers(b, l + 1);
    r = r && consumeToken(b, KW_FUN);
    r = r && FunctionName(b, l + 1);
    r = r && Arguments(b, l + 1);
    r = r && ClassMethod_4(b, l + 1);
    r = r && CodeBlock(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NamedTypeHint?
  private static boolean ClassMethod_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassMethod_4")) return false;
    NamedTypeHint(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean ClassName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CLASS_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // 'operator' Operator OperatorArguments NamedTypeHint? CodeBlock
  public static boolean ClassOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassOperator")) return false;
    if (!nextTokenIs(b, KW_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_OPERATOR);
    r = r && Operator(b, l + 1);
    r = r && OperatorArguments(b, l + 1);
    r = r && ClassOperator_3(b, l + 1);
    r = r && CodeBlock(b, l + 1);
    exit_section_(b, m, CLASS_OPERATOR, r);
    return r;
  }

  // NamedTypeHint?
  private static boolean ClassOperator_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassOperator_3")) return false;
    NamedTypeHint(b, l + 1);
    return true;
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
  // ':' ('super' | 'this') CallArguments
  public static boolean ConstructorArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructorArguments")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && ConstructorArguments_1(b, l + 1);
    r = r && CallArguments(b, l + 1);
    exit_section_(b, m, CONSTRUCTOR_ARGUMENTS, r);
    return r;
  }

  // 'super' | 'this'
  private static boolean ConstructorArguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructorArguments_1")) return false;
    boolean r;
    r = consumeToken(b, KW_SUPER);
    if (!r) r = consumeToken(b, KW_THIS);
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
  // '{' EnumCodeValues? (';' ClassBodyStatement*)? '}'
  public static boolean EnumCodeBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumCodeBlock")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && EnumCodeBlock_1(b, l + 1);
    r = r && EnumCodeBlock_2(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, ENUM_CODE_BLOCK, r);
    return r;
  }

  // EnumCodeValues?
  private static boolean EnumCodeBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumCodeBlock_1")) return false;
    EnumCodeValues(b, l + 1);
    return true;
  }

  // (';' ClassBodyStatement*)?
  private static boolean EnumCodeBlock_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumCodeBlock_2")) return false;
    EnumCodeBlock_2_0(b, l + 1);
    return true;
  }

  // ';' ClassBodyStatement*
  private static boolean EnumCodeBlock_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumCodeBlock_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON);
    r = r && EnumCodeBlock_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ClassBodyStatement*
  private static boolean EnumCodeBlock_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumCodeBlock_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ClassBodyStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EnumCodeBlock_2_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // EnumValue (',' EnumValue )* ','?
  public static boolean EnumCodeValues(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumCodeValues")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EnumValue(b, l + 1);
    r = r && EnumCodeValues_1(b, l + 1);
    r = r && EnumCodeValues_2(b, l + 1);
    exit_section_(b, m, ENUM_CODE_VALUES, r);
    return r;
  }

  // (',' EnumValue )*
  private static boolean EnumCodeValues_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumCodeValues_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!EnumCodeValues_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EnumCodeValues_1", c)) break;
    }
    return true;
  }

  // ',' EnumValue
  private static boolean EnumCodeValues_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumCodeValues_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && EnumValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean EnumCodeValues_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumCodeValues_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // 'enum' ClassName ClassInheritance? EnumCodeBlock
  public static boolean EnumDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDeclaration")) return false;
    if (!nextTokenIs(b, KW_ENUM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_ENUM);
    r = r && ClassName(b, l + 1);
    r = r && EnumDeclaration_2(b, l + 1);
    r = r && EnumCodeBlock(b, l + 1);
    exit_section_(b, m, ENUM_DECLARATION, r);
    return r;
  }

  // ClassInheritance?
  private static boolean EnumDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDeclaration_2")) return false;
    ClassInheritance(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER CallArguments?
  public static boolean EnumValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumValue")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && EnumValue_1(b, l + 1);
    exit_section_(b, m, ENUM_VALUE, r);
    return r;
  }

  // CallArguments?
  private static boolean EnumValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumValue_1")) return false;
    CallArguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Expression (&',' UnpackExtension)? ';'
  public static boolean ExpressionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionStatement")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_STATEMENT, "<expression statement>");
    r = Expression(b, l + 1, -1);
    p = r; // pin = 1
    r = r && report_error_(b, ExpressionStatement_1(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (&',' UnpackExtension)?
  private static boolean ExpressionStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionStatement_1")) return false;
    ExpressionStatement_1_0(b, l + 1);
    return true;
  }

  // &',' UnpackExtension
  private static boolean ExpressionStatement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionStatement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionStatement_1_0_0(b, l + 1);
    r = r && UnpackExtension(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &','
  private static boolean ExpressionStatement_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionStatement_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, COMMA);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'foreach' '(' IdentifierName ':' Expression ')' Statement
  public static boolean ForEachStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForEachStatement")) return false;
    if (!nextTokenIs(b, KW_FOREACH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_FOREACH, LPAREN);
    r = r && IdentifierName(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1, -1);
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
  // IDENTIFIER
  public static boolean FunctionName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, FUNCTION_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // 'fun' FunctionName Arguments NamedTypeHint? CodeBlock
  public static boolean FunctionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionStatement")) return false;
    if (!nextTokenIs(b, KW_FUN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_FUN);
    r = r && FunctionName(b, l + 1);
    r = r && Arguments(b, l + 1);
    r = r && FunctionStatement_3(b, l + 1);
    r = r && CodeBlock(b, l + 1);
    exit_section_(b, m, FUNCTION_STATEMENT, r);
    return r;
  }

  // NamedTypeHint?
  private static boolean FunctionStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionStatement_3")) return false;
    NamedTypeHint(b, l + 1);
    return true;
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
  // IDENTIFIER
  public static boolean ImportClassName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportClassName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, IMPORT_CLASS_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // '*'
  //   | ImportClassName ( ',' ImportClassName)*
  public static boolean ImportElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportElement")) return false;
    if (!nextTokenIs(b, "<import element>", IDENTIFIER, OP_MUL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_ELEMENT, "<import element>");
    r = consumeToken(b, OP_MUL);
    if (!r) r = ImportElement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ImportClassName ( ',' ImportClassName)*
  private static boolean ImportElement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportElement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ImportClassName(b, l + 1);
    r = r && ImportElement_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ',' ImportClassName)*
  private static boolean ImportElement_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportElement_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ImportElement_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ImportElement_1_1", c)) break;
    }
    return true;
  }

  // ',' ImportClassName
  private static boolean ImportElement_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportElement_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ImportClassName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ( '.' IDENTIFIER )*
  public static boolean ImportPath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportPath")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && ImportPath_1(b, l + 1);
    exit_section_(b, m, IMPORT_PATH, r);
    return r;
  }

  // ( '.' IDENTIFIER )*
  private static boolean ImportPath_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportPath_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ImportPath_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ImportPath_1", c)) break;
    }
    return true;
  }

  // '.' IDENTIFIER
  private static boolean ImportPath_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportPath_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'import' ImportElement 'from' ImportPath ';'
  public static boolean ImportStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStatement")) return false;
    if (!nextTokenIs(b, KW_IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_IMPORT);
    r = r && ImportElement(b, l + 1);
    r = r && consumeToken(b, KW_FROM);
    r = r && ImportPath(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, IMPORT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // InterfaceMethod
  static boolean InterfaceBodyStatement(PsiBuilder b, int l) {
    return InterfaceMethod(b, l + 1);
  }

  /* ********************************************************** */
  // '{' InterfaceBodyStatement* '}'
  public static boolean InterfaceCodeBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceCodeBlock")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && InterfaceCodeBlock_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, INTERFACE_CODE_BLOCK, r);
    return r;
  }

  // InterfaceBodyStatement*
  private static boolean InterfaceCodeBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceCodeBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!InterfaceBodyStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "InterfaceCodeBlock_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'interface' ClassName InterfaceCodeBlock
  public static boolean InterfaceDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDeclaration")) return false;
    if (!nextTokenIs(b, KW_INTERFACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_INTERFACE);
    r = r && ClassName(b, l + 1);
    r = r && InterfaceCodeBlock(b, l + 1);
    exit_section_(b, m, INTERFACE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // 'fun' FunctionName Arguments NamedTypeHint? ';'
  public static boolean InterfaceMethod(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceMethod")) return false;
    if (!nextTokenIs(b, KW_FUN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_FUN);
    r = r && FunctionName(b, l + 1);
    r = r && Arguments(b, l + 1);
    r = r && InterfaceMethod_3(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, INTERFACE_METHOD, r);
    return r;
  }

  // NamedTypeHint?
  private static boolean InterfaceMethod_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceMethod_3")) return false;
    NamedTypeHint(b, l + 1);
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
  // 'local' IDENTIFIER NamedTypeHint? '=' Expression ';'
  public static boolean LocalStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LocalStatement")) return false;
    if (!nextTokenIs(b, KW_LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_LOCAL, IDENTIFIER);
    r = r && LocalStatement_2(b, l + 1);
    r = r && consumeToken(b, ASSIGNMENT);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, LOCAL_STATEMENT, r);
    return r;
  }

  // NamedTypeHint?
  private static boolean LocalStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LocalStatement_2")) return false;
    NamedTypeHint(b, l + 1);
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
    r = Expression(b, l + 1, -1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ':' NamedTypeHintName ( '|' NamedTypeHintName )*
  public static boolean NamedTypeHint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedTypeHint")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && NamedTypeHintName(b, l + 1);
    r = r && NamedTypeHint_2(b, l + 1);
    exit_section_(b, m, NAMED_TYPE_HINT, r);
    return r;
  }

  // ( '|' NamedTypeHintName )*
  private static boolean NamedTypeHint_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedTypeHint_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!NamedTypeHint_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "NamedTypeHint_2", c)) break;
    }
    return true;
  }

  // '|' NamedTypeHintName
  private static boolean NamedTypeHint_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedTypeHint_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_BOR);
    r = r && NamedTypeHintName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ClassName
  public static boolean NamedTypeHintName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedTypeHintName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ClassName(b, l + 1);
    exit_section_(b, m, NAMED_TYPE_HINT_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // '+' | '-' | '*' | '/' | '^' | '!' | '==' | '!='
  //   | '++' | '--' | '&&' | '||' | '>=' | '<=' | '>' | '<'
  //   | '&' | '|' | '~' | '>>' | '<<' | '[' ']'
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
    if (!r) r = consumeToken(b, OP_BAND);
    if (!r) r = consumeToken(b, OP_BOR);
    if (!r) r = consumeToken(b, OP_BXOR);
    if (!r) r = consumeToken(b, OP_BSHR);
    if (!r) r = consumeToken(b, OP_BSHL);
    if (!r) r = parseTokens(b, 0, LBRACK, RBRACK);
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
  //   | EnumDeclaration
  //   | InterfaceDeclaration
  //   | ImportStatement
  //   | ThrowStatement
  //   | FunctionStatement
  //   | TryStatement
  //   | ForEachStatement
  //   | ForStatement
  //   | SwitchStatement
  //   | ReturnStatement
  //   | LocalStatement
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
    if (!r) r = EnumDeclaration(b, l + 1);
    if (!r) r = InterfaceDeclaration(b, l + 1);
    if (!r) r = ImportStatement(b, l + 1);
    if (!r) r = ThrowStatement(b, l + 1);
    if (!r) r = FunctionStatement(b, l + 1);
    if (!r) r = TryStatement(b, l + 1);
    if (!r) r = ForEachStatement(b, l + 1);
    if (!r) r = ForStatement(b, l + 1);
    if (!r) r = SwitchStatement(b, l + 1);
    if (!r) r = ReturnStatement(b, l + 1);
    if (!r) r = LocalStatement(b, l + 1);
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
  // 'throw' Expression ';'
  public static boolean ThrowStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ThrowStatement")) return false;
    if (!nextTokenIs(b, KW_THROW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_THROW);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, THROW_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // 'try' Statement 'catch' '(' IdentifierName NamedTypeHint? ')' Statement TryStatementFinally?
  public static boolean TryStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStatement")) return false;
    if (!nextTokenIs(b, KW_TRY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_TRY);
    r = r && Statement(b, l + 1);
    r = r && consumeTokens(b, 0, KW_CATCH, LPAREN);
    r = r && IdentifierName(b, l + 1);
    r = r && TryStatement_5(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && Statement(b, l + 1);
    r = r && TryStatement_8(b, l + 1);
    exit_section_(b, m, TRY_STATEMENT, r);
    return r;
  }

  // NamedTypeHint?
  private static boolean TryStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStatement_5")) return false;
    NamedTypeHint(b, l + 1);
    return true;
  }

  // TryStatementFinally?
  private static boolean TryStatement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStatement_8")) return false;
    TryStatementFinally(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'finally' Statement
  public static boolean TryStatementFinally(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStatementFinally")) return false;
    if (!nextTokenIs(b, KW_FINALLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_FINALLY);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, TRY_STATEMENT_FINALLY, r);
    return r;
  }

  /* ********************************************************** */
  // (',' Expression)+
  public static boolean UnpackExtension(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnpackExtension")) return false;
    if (!nextTokenIs(b, COMMA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = UnpackExtension_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!UnpackExtension_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "UnpackExtension", c)) break;
    }
    exit_section_(b, m, UNPACK_EXTENSION, r);
    return r;
  }

  // ',' Expression
  private static boolean UnpackExtension_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnpackExtension_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
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
  // IDENTIFIER
  public static boolean VariableName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VARIABLE_NAME, r);
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
  // 4: BINARY(ArrayExpression)
  // 5: BINARY(RelationalExpression)
  // 6: BINARY(ArithmeticExpression)
  // 7: BINARY(BitExpression)
  // 8: BINARY(FactorExpression)
  // 9: PREFIX(UnaryExpression)
  // 10: BINARY(PowerExpression)
  // 11: POSTFIX(CallExpression)
  // 12: BINARY(MemberExpression)
  // 13: ATOM(AtomExpression) ATOM(ListExpression) ATOM(MapExpression) ATOM(LambdaExpression)
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
      else if (g < 4 && consumeTokenSmart(b, LBRACK)) {
        r = report_error_(b, Expression(b, l, 4));
        r = ArrayExpression_1(b, l + 1) && r;
        exit_section_(b, l, m, ARRAY_EXPRESSION, r, true, null);
      }
      else if (g < 5 && RelationalExpression_0(b, l + 1)) {
        r = Expression(b, l, 5);
        exit_section_(b, l, m, RELATIONAL_EXPRESSION, r, true, null);
      }
      else if (g < 6 && ArithmeticExpression_0(b, l + 1)) {
        r = Expression(b, l, 6);
        exit_section_(b, l, m, ARITHMETIC_EXPRESSION, r, true, null);
      }
      else if (g < 7 && BitExpression_0(b, l + 1)) {
        r = Expression(b, l, 7);
        exit_section_(b, l, m, BIT_EXPRESSION, r, true, null);
      }
      else if (g < 8 && FactorExpression_0(b, l + 1)) {
        r = Expression(b, l, 8);
        exit_section_(b, l, m, FACTOR_EXPRESSION, r, true, null);
      }
      else if (g < 10 && consumeTokenSmart(b, OP_POW)) {
        r = Expression(b, l, 10);
        exit_section_(b, l, m, POWER_EXPRESSION, r, true, null);
      }
      else if (g < 11 && CallExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, CALL_EXPRESSION, r, true, null);
      }
      else if (g < 12 && MemberExpression_0(b, l + 1)) {
        r = Expression(b, l, 12);
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

  // ']' ( '=' Expression )?
  private static boolean ArrayExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RBRACK);
    r = r && ArrayExpression_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( '=' Expression )?
  private static boolean ArrayExpression_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayExpression_1_1")) return false;
    ArrayExpression_1_1_0(b, l + 1);
    return true;
  }

  // '=' Expression
  private static boolean ArrayExpression_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayExpression_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGNMENT);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
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

  // '>>' | '<<' | '~' | '|' | '&'
  private static boolean BitExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BitExpression_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, OP_BSHR);
    if (!r) r = consumeTokenSmart(b, OP_BSHL);
    if (!r) r = consumeTokenSmart(b, OP_BXOR);
    if (!r) r = consumeTokenSmart(b, OP_BOR);
    if (!r) r = consumeTokenSmart(b, OP_BAND);
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
    r = p && Expression(b, l, 9);
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

  // 'fun' Arguments NamedTypeHint? ( CodeBlock | Expression )
  public static boolean LambdaExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaExpression")) return false;
    if (!nextTokenIsSmart(b, KW_FUN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, KW_FUN);
    r = r && Arguments(b, l + 1);
    r = r && LambdaExpression_2(b, l + 1);
    r = r && LambdaExpression_3(b, l + 1);
    exit_section_(b, m, LAMBDA_EXPRESSION, r);
    return r;
  }

  // NamedTypeHint?
  private static boolean LambdaExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaExpression_2")) return false;
    NamedTypeHint(b, l + 1);
    return true;
  }

  // CodeBlock | Expression
  private static boolean LambdaExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaExpression_3")) return false;
    boolean r;
    r = CodeBlock(b, l + 1);
    if (!r) r = Expression(b, l + 1, -1);
    return r;
  }

  // 'new' ClassName CallArguments
  public static boolean NewExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NewExpression")) return false;
    if (!nextTokenIsSmart(b, KW_NEW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, KW_NEW);
    r = r && ClassName(b, l + 1);
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
