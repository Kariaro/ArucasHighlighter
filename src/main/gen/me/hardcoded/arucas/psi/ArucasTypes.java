// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import me.hardcoded.arucas.psi.impl.*;

public interface ArucasTypes {

  IElementType ATOM_EXPRESSION = new ArucasElementType("ATOM_EXPRESSION");
  IElementType CLASS_BODY_STATEMENT = new ArucasElementType("CLASS_BODY_STATEMENT");
  IElementType CLASS_STATEMENT = new ArucasElementType("CLASS_STATEMENT");
  IElementType EXPRESSION = new ArucasElementType("EXPRESSION");
  IElementType FOR_EACH_STATEMENT = new ArucasElementType("FOR_EACH_STATEMENT");
  IElementType FOR_STATEMENT = new ArucasElementType("FOR_STATEMENT");
  IElementType FUNCTION_STATEMENT = new ArucasElementType("FUNCTION_STATEMENT");
  IElementType IF_STATEMENT = new ArucasElementType("IF_STATEMENT");
  IElementType STATEMENT = new ArucasElementType("STATEMENT");
  IElementType STATEMENTS = new ArucasElementType("STATEMENTS");
  IElementType SWITCH_STATEMENT = new ArucasElementType("SWITCH_STATEMENT");
  IElementType TRY_STATEMENT = new ArucasElementType("TRY_STATEMENT");
  IElementType WHILE_STATEMENT = new ArucasElementType("WHILE_STATEMENT");

  IElementType COMMENT = new ArucasTokenType("COMMENT");
  IElementType IDENTIFIER = new ArucasTokenType("IDENTIFIER");
  IElementType KEYWORD = new ArucasTokenType("KEYWORD");
  IElementType NUMBER = new ArucasTokenType("NUMBER");
  IElementType OPERATOR = new ArucasTokenType("OPERATOR");
  IElementType STRING = new ArucasTokenType("STRING");
  IElementType SYNTAX = new ArucasTokenType("SYNTAX");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ATOM_EXPRESSION) {
        return new ArucasAtomExpressionImpl(node);
      }
      else if (type == CLASS_BODY_STATEMENT) {
        return new ArucasClassBodyStatementImpl(node);
      }
      else if (type == CLASS_STATEMENT) {
        return new ArucasClassStatementImpl(node);
      }
      else if (type == EXPRESSION) {
        return new ArucasExpressionImpl(node);
      }
      else if (type == FOR_EACH_STATEMENT) {
        return new ArucasForEachStatementImpl(node);
      }
      else if (type == FOR_STATEMENT) {
        return new ArucasForStatementImpl(node);
      }
      else if (type == FUNCTION_STATEMENT) {
        return new ArucasFunctionStatementImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new ArucasIfStatementImpl(node);
      }
      else if (type == STATEMENT) {
        return new ArucasStatementImpl(node);
      }
      else if (type == STATEMENTS) {
        return new ArucasStatementsImpl(node);
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
