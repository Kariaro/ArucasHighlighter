// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class ArucasVisitor extends PsiElementVisitor {

  public void visitArgument(@NotNull ArucasArgument o) {
    visitPsiElement(o);
  }

  public void visitArguments(@NotNull ArucasArguments o) {
    visitPsiElement(o);
  }

  public void visitArithmeticExpression(@NotNull ArucasArithmeticExpression o) {
    visitPsiElement(o);
  }

  public void visitAtom(@NotNull ArucasAtom o) {
    visitExpression(o);
  }

  public void visitBreakStatement(@NotNull ArucasBreakStatement o) {
    visitStatement(o);
  }

  public void visitCaseStatement(@NotNull ArucasCaseStatement o) {
    visitPsiElement(o);
  }

  public void visitCaseValue(@NotNull ArucasCaseValue o) {
    visitPsiElement(o);
  }

  public void visitCaseValues(@NotNull ArucasCaseValues o) {
    visitPsiElement(o);
  }

  public void visitClassCodeBlock(@NotNull ArucasClassCodeBlock o) {
    visitStatement(o);
  }

  public void visitClassConstructor(@NotNull ArucasClassConstructor o) {
    visitPsiElement(o);
  }

  public void visitClassDeclaration(@NotNull ArucasClassDeclaration o) {
    visitStatement(o);
  }

  public void visitClassMember(@NotNull ArucasClassMember o) {
    visitPsiElement(o);
  }

  public void visitClassMethod(@NotNull ArucasClassMethod o) {
    visitPsiElement(o);
  }

  public void visitClassOperator(@NotNull ArucasClassOperator o) {
    visitPsiElement(o);
  }

  public void visitCodeBlock(@NotNull ArucasCodeBlock o) {
    visitPsiElement(o);
  }

  public void visitContinueStatement(@NotNull ArucasContinueStatement o) {
    visitStatement(o);
  }

  public void visitElseStatement(@NotNull ArucasElseStatement o) {
    visitStatement(o);
  }

  public void visitExpression(@NotNull ArucasExpression o) {
    visitPsiElement(o);
  }

  public void visitExpressionStatement(@NotNull ArucasExpressionStatement o) {
    visitStatement(o);
  }

  public void visitForEachStatement(@NotNull ArucasForEachStatement o) {
    visitStatement(o);
  }

  public void visitForStatement(@NotNull ArucasForStatement o) {
    visitStatement(o);
  }

  public void visitFunctionLambda(@NotNull ArucasFunctionLambda o) {
    visitExpression(o);
  }

  public void visitFunctionStatement(@NotNull ArucasFunctionStatement o) {
    visitStatement(o);
  }

  public void visitIfStatement(@NotNull ArucasIfStatement o) {
    visitStatement(o);
  }

  public void visitListExpression(@NotNull ArucasListExpression o) {
    visitExpression(o);
  }

  public void visitMapEntry(@NotNull ArucasMapEntry o) {
    visitPsiElement(o);
  }

  public void visitMapExpression(@NotNull ArucasMapExpression o) {
    visitExpression(o);
  }

  public void visitNewExpression(@NotNull ArucasNewExpression o) {
    visitExpression(o);
  }

  public void visitReturnStatement(@NotNull ArucasReturnStatement o) {
    visitStatement(o);
  }

  public void visitStatement(@NotNull ArucasStatement o) {
    visitPsiElement(o);
  }

  public void visitStaticModifier(@NotNull ArucasStaticModifier o) {
    visitPsiElement(o);
  }

  public void visitSwitchCodeBlock(@NotNull ArucasSwitchCodeBlock o) {
    visitStatement(o);
  }

  public void visitSwitchStatement(@NotNull ArucasSwitchStatement o) {
    visitStatement(o);
  }

  public void visitTryStatement(@NotNull ArucasTryStatement o) {
    visitStatement(o);
  }

  public void visitUnaryFactorExpression(@NotNull ArucasUnaryFactorExpression o) {
    visitPsiElement(o);
  }

  public void visitWhileStatement(@NotNull ArucasWhileStatement o) {
    visitStatement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
