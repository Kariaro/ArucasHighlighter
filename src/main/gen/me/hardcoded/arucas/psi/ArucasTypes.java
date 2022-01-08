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
  IElementType CLASS_CONSTRUCTOR = new ArucasElementType("CLASS_CONSTRUCTOR");
  IElementType CLASS_MEMBER = new ArucasElementType("CLASS_MEMBER");
  IElementType CLASS_METHOD = new ArucasElementType("CLASS_METHOD");
  IElementType CLASS_OPERATOR = new ArucasElementType("CLASS_OPERATOR");
  IElementType CLASS_STATEMENT = new ArucasElementType("CLASS_STATEMENT");
  IElementType EXPRESSION = new ArucasElementType("EXPRESSION");
  IElementType FOR_EACH_STATEMENT = new ArucasElementType("FOR_EACH_STATEMENT");
  IElementType FOR_STATEMENT = new ArucasElementType("FOR_STATEMENT");
  IElementType FUNCTION_LAMBDA = new ArucasElementType("FUNCTION_LAMBDA");
  IElementType FUNCTION_STATEMENT = new ArucasElementType("FUNCTION_STATEMENT");
  IElementType IF_STATEMENT = new ArucasElementType("IF_STATEMENT");
  IElementType STATEMENT = new ArucasElementType("STATEMENT");
  IElementType STATIC_MODIFIER = new ArucasElementType("STATIC_MODIFIER");
  IElementType SWITCH_STATEMENT = new ArucasElementType("SWITCH_STATEMENT");
  IElementType TRY_STATEMENT = new ArucasElementType("TRY_STATEMENT");
  IElementType WHILE_STATEMENT = new ArucasElementType("WHILE_STATEMENT");

  IElementType COMMENT = new ArucasTokenType("COMMENT");
  IElementType DELIMITER = new ArucasTokenType("DELIMITER");
  IElementType IDENTIFIER = new ArucasTokenType("IDENTIFIER");
  IElementType KEYWORD = new ArucasTokenType("KEYWORD");
  IElementType MEMBEROP_4_0 = new ArucasTokenType("MemberOp_4_0");
  IElementType NUMBER = new ArucasTokenType("NUMBER");
  IElementType OPERATOR = new ArucasTokenType("OPERATOR");
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
      else if (type == CLASS_CONSTRUCTOR) {
        return new ArucasClassConstructorImpl(node);
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
      else if (type == FUNCTION_LAMBDA) {
        return new ArucasFunctionLambdaImpl(node);
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
      else if (type == STATIC_MODIFIER) {
        return new ArucasStaticModifierImpl(node);
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
