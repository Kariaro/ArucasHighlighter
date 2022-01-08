// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static me.hardcoded.arucas.psi.ArucasTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import me.hardcoded.arucas.psi.*;

public class ArucasStatementImpl extends ASTWrapperPsiElement implements ArucasStatement {

  public ArucasStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ArucasVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ArucasVisitor) accept((ArucasVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ArucasAtom> getAtomList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ArucasAtom.class);
  }

  @Override
  @Nullable
  public ArucasClassStatement getClassStatement() {
    return findChildByClass(ArucasClassStatement.class);
  }

  @Override
  @NotNull
  public List<ArucasExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ArucasExpression.class);
  }

  @Override
  @Nullable
  public ArucasForEachStatement getForEachStatement() {
    return findChildByClass(ArucasForEachStatement.class);
  }

  @Override
  @Nullable
  public ArucasForStatement getForStatement() {
    return findChildByClass(ArucasForStatement.class);
  }

  @Override
  @NotNull
  public List<ArucasFunctionLambda> getFunctionLambdaList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ArucasFunctionLambda.class);
  }

  @Override
  @Nullable
  public ArucasFunctionStatement getFunctionStatement() {
    return findChildByClass(ArucasFunctionStatement.class);
  }

  @Override
  @Nullable
  public ArucasIfStatement getIfStatement() {
    return findChildByClass(ArucasIfStatement.class);
  }

  @Override
  @NotNull
  public List<ArucasStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ArucasStatement.class);
  }

  @Override
  @Nullable
  public ArucasSwitchStatement getSwitchStatement() {
    return findChildByClass(ArucasSwitchStatement.class);
  }

  @Override
  @Nullable
  public ArucasTryStatement getTryStatement() {
    return findChildByClass(ArucasTryStatement.class);
  }

  @Override
  @Nullable
  public ArucasWhileStatement getWhileStatement() {
    return findChildByClass(ArucasWhileStatement.class);
  }

}
