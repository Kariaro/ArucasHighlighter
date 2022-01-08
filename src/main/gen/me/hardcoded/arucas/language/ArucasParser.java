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
    b = adapt_builder_(t, b, this, null);
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

  /* ********************************************************** */
  // TermExpression [ArithmeticOp ArithmeticExpression]
  static boolean ArithmeticExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArithmeticExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TermExpression(b, l + 1);
    r = r && ArithmeticExpression_1(b, l + 1);
    exit_section_(b, m, null, r);
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
    boolean r;
    r = consumeToken(b, "+");
    if (!r) r = consumeToken(b, "-");
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  //   | STRING
  //   | NUMBER
  //   | '[' [ListElements] ']'
  //   | '{' [MapElements] '}'
  //   | 'fun' '(' [FunctionArguments] ')' '{' Statement* '}'
  //   | 'new' IDENTIFIER '(' [FunctionArguments] ')'
  //   | '(' Expression ')'
  public static boolean AtomExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AtomExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM_EXPRESSION, "<atom expression>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = AtomExpression_3(b, l + 1);
    if (!r) r = AtomExpression_4(b, l + 1);
    if (!r) r = AtomExpression_5(b, l + 1);
    if (!r) r = AtomExpression_6(b, l + 1);
    if (!r) r = AtomExpression_7(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '[' [ListElements] ']'
  private static boolean AtomExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AtomExpression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    r = r && AtomExpression_3_1(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // [ListElements]
  private static boolean AtomExpression_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AtomExpression_3_1")) return false;
    ListElements(b, l + 1);
    return true;
  }

  // '{' [MapElements] '}'
  private static boolean AtomExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AtomExpression_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && AtomExpression_4_1(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // [MapElements]
  private static boolean AtomExpression_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AtomExpression_4_1")) return false;
    MapElements(b, l + 1);
    return true;
  }

  // 'fun' '(' [FunctionArguments] ')' '{' Statement* '}'
  private static boolean AtomExpression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AtomExpression_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "fun");
    r = r && consumeToken(b, "(");
    r = r && AtomExpression_5_2(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, "{");
    r = r && AtomExpression_5_5(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // [FunctionArguments]
  private static boolean AtomExpression_5_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AtomExpression_5_2")) return false;
    FunctionArguments(b, l + 1);
    return true;
  }

  // Statement*
  private static boolean AtomExpression_5_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AtomExpression_5_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AtomExpression_5_5", c)) break;
    }
    return true;
  }

  // 'new' IDENTIFIER '(' [FunctionArguments] ')'
  private static boolean AtomExpression_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AtomExpression_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "new");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "(");
    r = r && AtomExpression_6_3(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // [FunctionArguments]
  private static boolean AtomExpression_6_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AtomExpression_6_3")) return false;
    FunctionArguments(b, l + 1);
    return true;
  }

  // '(' Expression ')'
  private static boolean AtomExpression_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AtomExpression_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression [',' CallArguments]
  static boolean CallArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallArguments")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && CallArguments_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [',' CallArguments]
  private static boolean CallArguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallArguments_1")) return false;
    CallArguments_1_0(b, l + 1);
    return true;
  }

  // ',' CallArguments
  private static boolean CallArguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallArguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && CallArguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MemberExpression ['(' [CallArguments] ')']
  static boolean CallExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MemberExpression(b, l + 1);
    r = r && CallExpression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ['(' [CallArguments] ')']
  private static boolean CallExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallExpression_1")) return false;
    CallExpression_1_0(b, l + 1);
    return true;
  }

  // '(' [CallArguments] ')'
  private static boolean CallExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && CallExpression_1_0_1(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // [CallArguments]
  private static boolean CallExpression_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallExpression_1_0_1")) return false;
    CallArguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ('default' | 'case' CaseValue) '->' Statements
  static boolean CaseStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseStatement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CaseStatement_0(b, l + 1);
    r = r && consumeToken(b, "->");
    r = r && Statements(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'default' | 'case' CaseValue
  private static boolean CaseStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseStatement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "default");
    if (!r) r = CaseStatement_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'case' CaseValue
  private static boolean CaseStatement_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseStatement_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "case");
    r = r && CaseValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING | NUMBER
  static boolean CaseValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseValue")) return false;
    if (!nextTokenIs(b, "", NUMBER, STRING)) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    return r;
  }

  /* ********************************************************** */
  // ['static'] 'var' IDENTIFIER ['=' Expression] ';'
  //   | ['static'] ['fun'] IDENTIFIER '(' [FunctionArguments] ')' '{' Statement* '}'
  public static boolean ClassBodyStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassBodyStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_BODY_STATEMENT, "<class body statement>");
    r = ClassBodyStatement_0(b, l + 1);
    if (!r) r = ClassBodyStatement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ['static'] 'var' IDENTIFIER ['=' Expression] ';'
  private static boolean ClassBodyStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassBodyStatement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ClassBodyStatement_0_0(b, l + 1);
    r = r && consumeToken(b, "var");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && ClassBodyStatement_0_3(b, l + 1);
    r = r && consumeToken(b, ";");
    exit_section_(b, m, null, r);
    return r;
  }

  // ['static']
  private static boolean ClassBodyStatement_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassBodyStatement_0_0")) return false;
    consumeToken(b, "static");
    return true;
  }

  // ['=' Expression]
  private static boolean ClassBodyStatement_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassBodyStatement_0_3")) return false;
    ClassBodyStatement_0_3_0(b, l + 1);
    return true;
  }

  // '=' Expression
  private static boolean ClassBodyStatement_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassBodyStatement_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ['static'] ['fun'] IDENTIFIER '(' [FunctionArguments] ')' '{' Statement* '}'
  private static boolean ClassBodyStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassBodyStatement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ClassBodyStatement_1_0(b, l + 1);
    r = r && ClassBodyStatement_1_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "(");
    r = r && ClassBodyStatement_1_4(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, "{");
    r = r && ClassBodyStatement_1_7(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // ['static']
  private static boolean ClassBodyStatement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassBodyStatement_1_0")) return false;
    consumeToken(b, "static");
    return true;
  }

  // ['fun']
  private static boolean ClassBodyStatement_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassBodyStatement_1_1")) return false;
    consumeToken(b, "fun");
    return true;
  }

  // [FunctionArguments]
  private static boolean ClassBodyStatement_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassBodyStatement_1_4")) return false;
    FunctionArguments(b, l + 1);
    return true;
  }

  // Statement*
  private static boolean ClassBodyStatement_1_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassBodyStatement_1_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ClassBodyStatement_1_7", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER '{' ClassBodyStatement* '}'
  public static boolean ClassStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassStatement")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "{");
    r = r && ClassStatement_2(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, CLASS_STATEMENT, r);
    return r;
  }

  // ClassBodyStatement*
  private static boolean ClassStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassStatement_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ClassBodyStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ClassStatement_2", c)) break;
    }
    return true;
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
    r = consumeToken(b, "!");
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
    r = consumeToken(b, "==");
    if (!r) r = consumeToken(b, "!=");
    if (!r) r = consumeToken(b, "<");
    if (!r) r = consumeToken(b, ">");
    if (!r) r = consumeToken(b, "<=");
    if (!r) r = consumeToken(b, ">=");
    return r;
  }

  /* ********************************************************** */
  // SetVariable
  //   | ModifyVariable
  //   | SizeExpression
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION, "<expression>");
    r = SetVariable(b, l + 1);
    if (!r) r = ModifyVariable(b, l + 1);
    if (!r) r = SizeExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FactorOp FactorExpression
  //   | PowerExpression
  static boolean FactorExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FactorExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FactorExpression_0(b, l + 1);
    if (!r) r = PowerExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FactorOp FactorExpression
  private static boolean FactorExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FactorExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FactorOp(b, l + 1);
    r = r && FactorExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '+' | '-'
  static boolean FactorOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FactorOp")) return false;
    boolean r;
    r = consumeToken(b, "+");
    if (!r) r = consumeToken(b, "-");
    return r;
  }

  /* ********************************************************** */
  // '(' IDENTIFIER ':' MemberExpression ')' Statements
  public static boolean ForEachStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForEachStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_EACH_STATEMENT, "<for each statement>");
    r = consumeToken(b, "(");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, ":");
    r = r && MemberExpression(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && Statements(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' [Expression] ';' [Expression] ';' [Expression] ')' Statements
  public static boolean ForStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_STATEMENT, "<for statement>");
    r = consumeToken(b, "(");
    r = r && ForStatement_1(b, l + 1);
    r = r && consumeToken(b, ";");
    r = r && ForStatement_3(b, l + 1);
    r = r && consumeToken(b, ";");
    r = r && ForStatement_5(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && Statements(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [Expression]
  private static boolean ForStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_1")) return false;
    Expression(b, l + 1);
    return true;
  }

  // [Expression]
  private static boolean ForStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_3")) return false;
    Expression(b, l + 1);
    return true;
  }

  // [Expression]
  private static boolean ForStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_5")) return false;
    Expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER [',' FunctionArguments]
  static boolean FunctionArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionArguments")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && FunctionArguments_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [',' FunctionArguments]
  private static boolean FunctionArguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionArguments_1")) return false;
    FunctionArguments_1_0(b, l + 1);
    return true;
  }

  // ',' FunctionArguments
  private static boolean FunctionArguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionArguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && FunctionArguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER '(' [FunctionArguments] ')' '{' Statement* '}'
  public static boolean FunctionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionStatement")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "(");
    r = r && FunctionStatement_2(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, "{");
    r = r && FunctionStatement_5(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, FUNCTION_STATEMENT, r);
    return r;
  }

  // [FunctionArguments]
  private static boolean FunctionStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionStatement_2")) return false;
    FunctionArguments(b, l + 1);
    return true;
  }

  // Statement*
  private static boolean FunctionStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionStatement_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionStatement_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '(' Expression ')' Statements ['else' Statements]
  public static boolean IfStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IF_STATEMENT, "<if statement>");
    r = consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && Statements(b, l + 1);
    r = r && IfStatement_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ['else' Statements]
  private static boolean IfStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_4")) return false;
    IfStatement_4_0(b, l + 1);
    return true;
  }

  // 'else' Statements
  private static boolean IfStatement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && Statements(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression [',' ListElements]
  static boolean ListElements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ListElements")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && ListElements_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [',' ListElements]
  private static boolean ListElements_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ListElements_1")) return false;
    ListElements_1_0(b, l + 1);
    return true;
  }

  // ',' ListElements
  private static boolean ListElements_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ListElements_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && ListElements(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression ':' Expression [',' MapElements]
  static boolean MapElements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapElements")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && consumeToken(b, ":");
    r = r && Expression(b, l + 1);
    r = r && MapElements_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [',' MapElements]
  private static boolean MapElements_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapElements_3")) return false;
    MapElements_3_0(b, l + 1);
    return true;
  }

  // ',' MapElements
  private static boolean MapElements_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapElements_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && MapElements(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AtomExpression ['.' MemberExpression]
  static boolean MemberExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AtomExpression(b, l + 1);
    r = r && MemberExpression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ['.' MemberExpression]
  private static boolean MemberExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberExpression_1")) return false;
    MemberExpression_1_0(b, l + 1);
    return true;
  }

  // '.' MemberExpression
  private static boolean MemberExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ".");
    r = r && MemberExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '++' | '--'
  static boolean ModifyOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModifyOp")) return false;
    boolean r;
    r = consumeToken(b, "++");
    if (!r) r = consumeToken(b, "--");
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ModifyOp
  static boolean ModifyVariable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModifyVariable")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && ModifyOp(b, l + 1);
    exit_section_(b, m, null, r);
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
    r = consumeToken(b, "^");
    r = r && FactorExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ['var'] IDENTIFIER '=' Expression
  static boolean SetVariable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetVariable")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SetVariable_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "=");
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ['var']
  private static boolean SetVariable_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetVariable_0")) return false;
    consumeToken(b, "var");
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
    boolean r;
    r = consumeToken(b, "&&");
    if (!r) r = consumeToken(b, "||");
    return r;
  }

  /* ********************************************************** */
  // '{' Statements '}'
  //   | 'if' IfStatement
  //   | 'while' WhileStatement
  //   | 'class' ClassStatement
  //   | 'fun' FunctionStatement
  //   | 'try' TryStatement
  //   | 'foreach' ForEachStatement
  //   | 'for' ForStatement
  //   | 'switch' SwitchStatement
  //   | 'return' [SizeExpression] ';'
  //   | 'continue' ';'
  //   | 'break' ';'
  //   | [Expression] ';'
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = Statement_0(b, l + 1);
    if (!r) r = Statement_1(b, l + 1);
    if (!r) r = Statement_2(b, l + 1);
    if (!r) r = Statement_3(b, l + 1);
    if (!r) r = Statement_4(b, l + 1);
    if (!r) r = Statement_5(b, l + 1);
    if (!r) r = Statement_6(b, l + 1);
    if (!r) r = Statement_7(b, l + 1);
    if (!r) r = Statement_8(b, l + 1);
    if (!r) r = Statement_9(b, l + 1);
    if (!r) r = Statement_10(b, l + 1);
    if (!r) r = Statement_11(b, l + 1);
    if (!r) r = Statement_12(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '{' Statements '}'
  private static boolean Statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && Statements(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // 'if' IfStatement
  private static boolean Statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "if");
    r = r && IfStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'while' WhileStatement
  private static boolean Statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "while");
    r = r && WhileStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'class' ClassStatement
  private static boolean Statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "class");
    r = r && ClassStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'fun' FunctionStatement
  private static boolean Statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "fun");
    r = r && FunctionStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'try' TryStatement
  private static boolean Statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "try");
    r = r && TryStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'foreach' ForEachStatement
  private static boolean Statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "foreach");
    r = r && ForEachStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'for' ForStatement
  private static boolean Statement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "for");
    r = r && ForStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'switch' SwitchStatement
  private static boolean Statement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "switch");
    r = r && SwitchStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'return' [SizeExpression] ';'
  private static boolean Statement_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "return");
    r = r && Statement_9_1(b, l + 1);
    r = r && consumeToken(b, ";");
    exit_section_(b, m, null, r);
    return r;
  }

  // [SizeExpression]
  private static boolean Statement_9_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_9_1")) return false;
    SizeExpression(b, l + 1);
    return true;
  }

  // 'continue' ';'
  private static boolean Statement_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "continue");
    r = r && consumeToken(b, ";");
    exit_section_(b, m, null, r);
    return r;
  }

  // 'break' ';'
  private static boolean Statement_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "break");
    r = r && consumeToken(b, ";");
    exit_section_(b, m, null, r);
    return r;
  }

  // [Expression] ';'
  private static boolean Statement_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Statement_12_0(b, l + 1);
    r = r && consumeToken(b, ";");
    exit_section_(b, m, null, r);
    return r;
  }

  // [Expression]
  private static boolean Statement_12_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_12_0")) return false;
    Expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '{' '}' | '{' Statement* '}' | Statement
  public static boolean Statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statements")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENTS, "<statements>");
    r = Statements_0(b, l + 1);
    if (!r) r = Statements_1(b, l + 1);
    if (!r) r = Statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '{' '}'
  private static boolean Statements_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statements_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // '{' Statement* '}'
  private static boolean Statements_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statements_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && Statements_1_1(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // Statement*
  private static boolean Statements_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statements_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Statements_1_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '(' Expression ')' '{' CaseStatement* '}'
  public static boolean SwitchStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SWITCH_STATEMENT, "<switch statement>");
    r = consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, "{");
    r = r && SwitchStatement_4(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CaseStatement*
  private static boolean SwitchStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchStatement_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!CaseStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SwitchStatement_4", c)) break;
    }
    return true;
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
    boolean r;
    r = consumeToken(b, "*");
    if (!r) r = consumeToken(b, "/");
    return r;
  }

  /* ********************************************************** */
  // Statements 'catch' '(' IDENTIFIER ')' Statements
  public static boolean TryStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRY_STATEMENT, "<try statement>");
    r = Statements(b, l + 1);
    r = r && consumeToken(b, "catch");
    r = r && consumeToken(b, "(");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, ")");
    r = r && Statements(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' Expression ')' Statements
  public static boolean WhileStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WHILE_STATEMENT, "<while statement>");
    r = consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && Statements(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Statements *
  static boolean arucas(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arucas")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arucas", c)) break;
    }
    return true;
  }

}
