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

public class ArucasSwitchStatementImpl extends ASTWrapperPsiElement implements ArucasSwitchStatement {

  public ArucasSwitchStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ArucasVisitor visitor) {
    visitor.visitSwitchStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ArucasVisitor) accept((ArucasVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ArucasCaseStatement> getCaseStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ArucasCaseStatement.class);
  }

  @Override
  @NotNull
  public ArucasExpression getExpression() {
    return findNotNullChildByClass(ArucasExpression.class);
  }

}
