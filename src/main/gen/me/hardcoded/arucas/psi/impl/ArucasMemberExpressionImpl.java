// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static me.hardcoded.arucas.psi.ArucasTypes.*;
import me.hardcoded.arucas.psi.*;

public class ArucasMemberExpressionImpl extends ArucasExpressionImpl implements ArucasMemberExpression {

  public ArucasMemberExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull ArucasVisitor visitor) {
    visitor.visitMemberExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ArucasVisitor) accept((ArucasVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ArucasExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ArucasExpression.class);
  }

  @Override
  @NotNull
  public ArucasExpression getLeft() {
    List<ArucasExpression> p1 = getExpressionList();
    return p1.get(0);
  }

  @Override
  @Nullable
  public ArucasExpression getRight() {
    List<ArucasExpression> p1 = getExpressionList();
    return p1.size() < 2 ? null : p1.get(1);
  }

}
