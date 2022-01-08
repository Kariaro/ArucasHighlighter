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

public class ArucasForEachStatementImpl extends ASTWrapperPsiElement implements ArucasForEachStatement {

  public ArucasForEachStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ArucasVisitor visitor) {
    visitor.visitForEachStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ArucasVisitor) accept((ArucasVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ArucasAtomExpression getAtomExpression() {
    return findNotNullChildByClass(ArucasAtomExpression.class);
  }

  @Override
  @NotNull
  public List<ArucasExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ArucasExpression.class);
  }

  @Override
  @NotNull
  public ArucasStatements getStatements() {
    return findNotNullChildByClass(ArucasStatements.class);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

}
