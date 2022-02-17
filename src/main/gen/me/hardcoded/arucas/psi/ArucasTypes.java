// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import me.hardcoded.arucas.psi.impl.*;

public interface ArucasTypes {

  IElementType ARGUMENT = new ArucasElementType("ARGUMENT");
  IElementType ARGUMENTS = new ArucasElementType("ARGUMENTS");
  IElementType ARITHMETIC_EXPRESSION = new ArucasElementType("ARITHMETIC_EXPRESSION");
  IElementType ASSIGN_EXPRESSION = new ArucasElementType("ASSIGN_EXPRESSION");
  IElementType ATOM_EXPRESSION = new ArucasElementType("ATOM_EXPRESSION");
  IElementType BREAK_STATEMENT = new ArucasElementType("BREAK_STATEMENT");
  IElementType CALL_ARGUMENTS = new ArucasElementType("CALL_ARGUMENTS");
  IElementType CALL_EXPRESSION = new ArucasElementType("CALL_EXPRESSION");
  IElementType CASE_STATEMENT = new ArucasElementType("CASE_STATEMENT");
  IElementType CASE_VALUE = new ArucasElementType("CASE_VALUE");
  IElementType CASE_VALUES = new ArucasElementType("CASE_VALUES");
  IElementType CLASS_CODE_BLOCK = new ArucasElementType("CLASS_CODE_BLOCK");
  IElementType CLASS_CONSTRUCTOR = new ArucasElementType("CLASS_CONSTRUCTOR");
  IElementType CLASS_DECLARATION = new ArucasElementType("CLASS_DECLARATION");
  IElementType CLASS_MEMBER = new ArucasElementType("CLASS_MEMBER");
  IElementType CLASS_METHOD = new ArucasElementType("CLASS_METHOD");
  IElementType CLASS_OPERATOR = new ArucasElementType("CLASS_OPERATOR");
  IElementType CODE_BLOCK = new ArucasElementType("CODE_BLOCK");
  IElementType CONDITIONAL_AND_EXPRESSION = new ArucasElementType("CONDITIONAL_AND_EXPRESSION");
  IElementType CONDITIONAL_OR_EXPRESSION = new ArucasElementType("CONDITIONAL_OR_EXPRESSION");
  IElementType CONTINUE_STATEMENT = new ArucasElementType("CONTINUE_STATEMENT");
  IElementType ELSE_STATEMENT = new ArucasElementType("ELSE_STATEMENT");
  IElementType EXPRESSION = new ArucasElementType("EXPRESSION");
  IElementType EXPRESSION_STATEMENT = new ArucasElementType("EXPRESSION_STATEMENT");
  IElementType FACTOR_EXPRESSION = new ArucasElementType("FACTOR_EXPRESSION");
  IElementType FOR_EACH_STATEMENT = new ArucasElementType("FOR_EACH_STATEMENT");
  IElementType FOR_STATEMENT = new ArucasElementType("FOR_STATEMENT");
  IElementType FUNCTION_MODIFIERS = new ArucasElementType("FUNCTION_MODIFIERS");
  IElementType FUNCTION_STATEMENT = new ArucasElementType("FUNCTION_STATEMENT");
  IElementType IDENTIFIER_NAME = new ArucasElementType("IDENTIFIER_NAME");
  IElementType IF_STATEMENT = new ArucasElementType("IF_STATEMENT");
  IElementType LAMBDA_EXPRESSION = new ArucasElementType("LAMBDA_EXPRESSION");
  IElementType LIST_EXPRESSION = new ArucasElementType("LIST_EXPRESSION");
  IElementType MAP_ENTRY = new ArucasElementType("MAP_ENTRY");
  IElementType MAP_EXPRESSION = new ArucasElementType("MAP_EXPRESSION");
  IElementType MEMBER_EXPRESSION = new ArucasElementType("MEMBER_EXPRESSION");
  IElementType NEW_EXPRESSION = new ArucasElementType("NEW_EXPRESSION");
  IElementType OPERATOR = new ArucasElementType("OPERATOR");
  IElementType OPERATOR_ARGUMENTS = new ArucasElementType("OPERATOR_ARGUMENTS");
  IElementType PARENTHESES_EXPRESSION = new ArucasElementType("PARENTHESES_EXPRESSION");
  IElementType POWER_EXPRESSION = new ArucasElementType("POWER_EXPRESSION");
  IElementType RELATIONAL_EXPRESSION = new ArucasElementType("RELATIONAL_EXPRESSION");
  IElementType RETURN_STATEMENT = new ArucasElementType("RETURN_STATEMENT");
  IElementType STATEMENT = new ArucasElementType("STATEMENT");
  IElementType SWITCH_CODE_BLOCK = new ArucasElementType("SWITCH_CODE_BLOCK");
  IElementType SWITCH_STATEMENT = new ArucasElementType("SWITCH_STATEMENT");
  IElementType TRY_STATEMENT = new ArucasElementType("TRY_STATEMENT");
  IElementType UNARY_EXPRESSION = new ArucasElementType("UNARY_EXPRESSION");
  IElementType UNARY_NOT_EXPRESSION = new ArucasElementType("UNARY_NOT_EXPRESSION");
  IElementType WHILE_STATEMENT = new ArucasElementType("WHILE_STATEMENT");

  IElementType ASSIGNMENT = new ArucasTokenType("=");
  IElementType COLON = new ArucasTokenType(":");
  IElementType COMMA = new ArucasTokenType(",");
  IElementType COMMENT = new ArucasTokenType("COMMENT");
  IElementType DOT = new ArucasTokenType(".");
  IElementType IDENTIFIER = new ArucasTokenType("IDENTIFIER");
  IElementType KW_BREAK = new ArucasTokenType("break");
  IElementType KW_CASE = new ArucasTokenType("case");
  IElementType KW_CATCH = new ArucasTokenType("catch");
  IElementType KW_CLASS = new ArucasTokenType("class");
  IElementType KW_CONTINUE = new ArucasTokenType("continue");
  IElementType KW_DEFAULT = new ArucasTokenType("default");
  IElementType KW_ELSE = new ArucasTokenType("else");
  IElementType KW_FALSE = new ArucasTokenType("false");
  IElementType KW_FOR = new ArucasTokenType("for");
  IElementType KW_FOREACH = new ArucasTokenType("foreach");
  IElementType KW_FUN = new ArucasTokenType("fun");
  IElementType KW_IF = new ArucasTokenType("if");
  IElementType KW_NEW = new ArucasTokenType("new");
  IElementType KW_NULL = new ArucasTokenType("null");
  IElementType KW_OPERATOR = new ArucasTokenType("operator");
  IElementType KW_RETURN = new ArucasTokenType("return");
  IElementType KW_STATIC = new ArucasTokenType("static");
  IElementType KW_SWITCH = new ArucasTokenType("switch");
  IElementType KW_THIS = new ArucasTokenType("this");
  IElementType KW_TRUE = new ArucasTokenType("true");
  IElementType KW_TRY = new ArucasTokenType("try");
  IElementType KW_VAR = new ArucasTokenType("var");
  IElementType KW_WHILE = new ArucasTokenType("while");
  IElementType LBRACE = new ArucasTokenType("{");
  IElementType LBRACK = new ArucasTokenType("[");
  IElementType LPAREN = new ArucasTokenType("(");
  IElementType NUMBER = new ArucasTokenType("NUMBER");
  IElementType OP_DIV = new ArucasTokenType("/");
  IElementType OP_EQUALS = new ArucasTokenType("==");
  IElementType OP_LESSTHAN = new ArucasTokenType("<");
  IElementType OP_LESSTHANEQ = new ArucasTokenType("<=");
  IElementType OP_LOGICAL_AND = new ArucasTokenType("&&");
  IElementType OP_LOGICAL_OR = new ArucasTokenType("||");
  IElementType OP_MINUS = new ArucasTokenType("-");
  IElementType OP_MM = new ArucasTokenType("--");
  IElementType OP_MORETHAN = new ArucasTokenType(">");
  IElementType OP_MORETHANEQ = new ArucasTokenType(">=");
  IElementType OP_MUL = new ArucasTokenType("*");
  IElementType OP_NOT = new ArucasTokenType("!");
  IElementType OP_NOTEQUALS = new ArucasTokenType("!=");
  IElementType OP_PLUS = new ArucasTokenType("+");
  IElementType OP_POW = new ArucasTokenType("^");
  IElementType OP_PP = new ArucasTokenType("++");
  IElementType POINTER = new ArucasTokenType("->");
  IElementType RBRACE = new ArucasTokenType("}");
  IElementType RBRACK = new ArucasTokenType("]");
  IElementType RPAREN = new ArucasTokenType(")");
  IElementType SEMICOLON = new ArucasTokenType(";");
  IElementType STRING = new ArucasTokenType("STRING");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENT) {
        return new ArucasArgumentImpl(node);
      }
      else if (type == ARGUMENTS) {
        return new ArucasArgumentsImpl(node);
      }
      else if (type == ARITHMETIC_EXPRESSION) {
        return new ArucasArithmeticExpressionImpl(node);
      }
      else if (type == ASSIGN_EXPRESSION) {
        return new ArucasAssignExpressionImpl(node);
      }
      else if (type == ATOM_EXPRESSION) {
        return new ArucasAtomExpressionImpl(node);
      }
      else if (type == BREAK_STATEMENT) {
        return new ArucasBreakStatementImpl(node);
      }
      else if (type == CALL_ARGUMENTS) {
        return new ArucasCallArgumentsImpl(node);
      }
      else if (type == CALL_EXPRESSION) {
        return new ArucasCallExpressionImpl(node);
      }
      else if (type == CASE_STATEMENT) {
        return new ArucasCaseStatementImpl(node);
      }
      else if (type == CASE_VALUE) {
        return new ArucasCaseValueImpl(node);
      }
      else if (type == CASE_VALUES) {
        return new ArucasCaseValuesImpl(node);
      }
      else if (type == CLASS_CODE_BLOCK) {
        return new ArucasClassCodeBlockImpl(node);
      }
      else if (type == CLASS_CONSTRUCTOR) {
        return new ArucasClassConstructorImpl(node);
      }
      else if (type == CLASS_DECLARATION) {
        return new ArucasClassDeclarationImpl(node);
      }
      else if (type == CLASS_MEMBER) {
        return new ArucasClassMemberImpl(node);
      }
      else if (type == CLASS_METHOD) {
        return new ArucasClassMethodImpl(node);
      }
      else if (type == CLASS_OPERATOR) {
        return new ArucasClassOperatorImpl(node);
      }
      else if (type == CODE_BLOCK) {
        return new ArucasCodeBlockImpl(node);
      }
      else if (type == CONDITIONAL_AND_EXPRESSION) {
        return new ArucasConditionalAndExpressionImpl(node);
      }
      else if (type == CONDITIONAL_OR_EXPRESSION) {
        return new ArucasConditionalOrExpressionImpl(node);
      }
      else if (type == CONTINUE_STATEMENT) {
        return new ArucasContinueStatementImpl(node);
      }
      else if (type == ELSE_STATEMENT) {
        return new ArucasElseStatementImpl(node);
      }
      else if (type == EXPRESSION_STATEMENT) {
        return new ArucasExpressionStatementImpl(node);
      }
      else if (type == FACTOR_EXPRESSION) {
        return new ArucasFactorExpressionImpl(node);
      }
      else if (type == FOR_EACH_STATEMENT) {
        return new ArucasForEachStatementImpl(node);
      }
      else if (type == FOR_STATEMENT) {
        return new ArucasForStatementImpl(node);
      }
      else if (type == FUNCTION_MODIFIERS) {
        return new ArucasFunctionModifiersImpl(node);
      }
      else if (type == FUNCTION_STATEMENT) {
        return new ArucasFunctionStatementImpl(node);
      }
      else if (type == IDENTIFIER_NAME) {
        return new ArucasIdentifierNameImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new ArucasIfStatementImpl(node);
      }
      else if (type == LAMBDA_EXPRESSION) {
        return new ArucasLambdaExpressionImpl(node);
      }
      else if (type == LIST_EXPRESSION) {
        return new ArucasListExpressionImpl(node);
      }
      else if (type == MAP_ENTRY) {
        return new ArucasMapEntryImpl(node);
      }
      else if (type == MAP_EXPRESSION) {
        return new ArucasMapExpressionImpl(node);
      }
      else if (type == MEMBER_EXPRESSION) {
        return new ArucasMemberExpressionImpl(node);
      }
      else if (type == NEW_EXPRESSION) {
        return new ArucasNewExpressionImpl(node);
      }
      else if (type == OPERATOR) {
        return new ArucasOperatorImpl(node);
      }
      else if (type == OPERATOR_ARGUMENTS) {
        return new ArucasOperatorArgumentsImpl(node);
      }
      else if (type == PARENTHESES_EXPRESSION) {
        return new ArucasParenthesesExpressionImpl(node);
      }
      else if (type == POWER_EXPRESSION) {
        return new ArucasPowerExpressionImpl(node);
      }
      else if (type == RELATIONAL_EXPRESSION) {
        return new ArucasRelationalExpressionImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new ArucasReturnStatementImpl(node);
      }
      else if (type == STATEMENT) {
        return new ArucasStatementImpl(node);
      }
      else if (type == SWITCH_CODE_BLOCK) {
        return new ArucasSwitchCodeBlockImpl(node);
      }
      else if (type == SWITCH_STATEMENT) {
        return new ArucasSwitchStatementImpl(node);
      }
      else if (type == TRY_STATEMENT) {
        return new ArucasTryStatementImpl(node);
      }
      else if (type == UNARY_EXPRESSION) {
        return new ArucasUnaryExpressionImpl(node);
      }
      else if (type == UNARY_NOT_EXPRESSION) {
        return new ArucasUnaryNotExpressionImpl(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new ArucasWhileStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
