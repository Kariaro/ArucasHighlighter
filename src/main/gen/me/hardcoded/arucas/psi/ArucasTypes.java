// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import me.hardcoded.arucas.psi.impl.*;

public interface ArucasTypes {

  IElementType ARGUMENT = new ArucasElementType("ARGUMENT");
  IElementType ARGUMENTS = new ArucasElementType("ARGUMENTS");
  IElementType ATOM = new ArucasElementType("ATOM");
  IElementType BREAK_STATEMENT = new ArucasElementType("BREAK_STATEMENT");
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
  IElementType CONTINUE_STATEMENT = new ArucasElementType("CONTINUE_STATEMENT");
  IElementType ELSE_STATEMENT = new ArucasElementType("ELSE_STATEMENT");
  IElementType EXPRESSION = new ArucasElementType("EXPRESSION");
  IElementType EXPRESSION_STATEMENT = new ArucasElementType("EXPRESSION_STATEMENT");
  IElementType FOR_EACH_STATEMENT = new ArucasElementType("FOR_EACH_STATEMENT");
  IElementType FOR_STATEMENT = new ArucasElementType("FOR_STATEMENT");
  IElementType FUNCTION_LAMBDA = new ArucasElementType("FUNCTION_LAMBDA");
  IElementType FUNCTION_STATEMENT = new ArucasElementType("FUNCTION_STATEMENT");
  IElementType IF_STATEMENT = new ArucasElementType("IF_STATEMENT");
  IElementType LIST_EXPRESSION = new ArucasElementType("LIST_EXPRESSION");
  IElementType MAP_ENTRY = new ArucasElementType("MAP_ENTRY");
  IElementType MAP_EXPRESSION = new ArucasElementType("MAP_EXPRESSION");
  IElementType NEW_EXPRESSION = new ArucasElementType("NEW_EXPRESSION");
  IElementType RETURN_STATEMENT = new ArucasElementType("RETURN_STATEMENT");
  IElementType STATEMENT = new ArucasElementType("STATEMENT");
  IElementType STATIC_MODIFIER = new ArucasElementType("STATIC_MODIFIER");
  IElementType SWITCH_CODE_BLOCK = new ArucasElementType("SWITCH_CODE_BLOCK");
  IElementType SWITCH_STATEMENT = new ArucasElementType("SWITCH_STATEMENT");
  IElementType TRY_STATEMENT = new ArucasElementType("TRY_STATEMENT");
  IElementType WHILE_STATEMENT = new ArucasElementType("WHILE_STATEMENT");

  IElementType ASSIGNMENT = new ArucasTokenType("=");
  IElementType COLON = new ArucasTokenType(":");
  IElementType COMMA = new ArucasTokenType(",");
  IElementType COMMENT = new ArucasTokenType("COMMENT");
  IElementType DOT = new ArucasTokenType(".");
  IElementType IDENTIFIER = new ArucasTokenType("IDENTIFIER");
  IElementType KEYWORD = new ArucasTokenType("KEYWORD");
  IElementType LBRACE = new ArucasTokenType("{");
  IElementType LBRACK = new ArucasTokenType("[");
  IElementType LPAREN = new ArucasTokenType("(");
  IElementType NUMBER = new ArucasTokenType("NUMBER");
  IElementType OPERATOR = new ArucasTokenType("OPERATOR");
  IElementType POINTER = new ArucasTokenType("->");
  IElementType RBRACE = new ArucasTokenType("}");
  IElementType RBRACK = new ArucasTokenType("]");
  IElementType RPAREN = new ArucasTokenType(")");
  IElementType SEMICOLON = new ArucasTokenType(";");
  IElementType STRING = new ArucasTokenType("STRING");
  IElementType SYNTAX = new ArucasTokenType("SYNTAX");
  IElementType VALUE_KEYWORD = new ArucasTokenType("VALUE_KEYWORD");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENT) {
        return new ArucasArgumentImpl(node);
      }
      else if (type == ARGUMENTS) {
        return new ArucasArgumentsImpl(node);
      }
      else if (type == ATOM) {
        return new ArucasAtomImpl(node);
      }
      else if (type == BREAK_STATEMENT) {
        return new ArucasBreakStatementImpl(node);
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
      else if (type == CONTINUE_STATEMENT) {
        return new ArucasContinueStatementImpl(node);
      }
      else if (type == ELSE_STATEMENT) {
        return new ArucasElseStatementImpl(node);
      }
      else if (type == EXPRESSION) {
        return new ArucasExpressionImpl(node);
      }
      else if (type == EXPRESSION_STATEMENT) {
        return new ArucasExpressionStatementImpl(node);
      }
      else if (type == FOR_EACH_STATEMENT) {
        return new ArucasForEachStatementImpl(node);
      }
      else if (type == FOR_STATEMENT) {
        return new ArucasForStatementImpl(node);
      }
      else if (type == FUNCTION_LAMBDA) {
        return new ArucasFunctionLambdaImpl(node);
      }
      else if (type == FUNCTION_STATEMENT) {
        return new ArucasFunctionStatementImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new ArucasIfStatementImpl(node);
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
      else if (type == NEW_EXPRESSION) {
        return new ArucasNewExpressionImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new ArucasReturnStatementImpl(node);
      }
      else if (type == STATEMENT) {
        return new ArucasStatementImpl(node);
      }
      else if (type == STATIC_MODIFIER) {
        return new ArucasStaticModifierImpl(node);
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
      else if (type == WHILE_STATEMENT) {
        return new ArucasWhileStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
