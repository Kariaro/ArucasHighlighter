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

public class ArucasLambdaExpressionImpl extends ArucasExpressionImpl implements ArucasLambdaExpression {

  public ArucasLambdaExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull ArucasVisitor visitor) {
    visitor.visitLambdaExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ArucasVisitor) accept((ArucasVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ArucasArguments getArguments() {
    return findNotNullChildByClass(ArucasArguments.class);
  }

  @Override
  @Nullable
  public ArucasCodeBlock getCodeBlock() {
    return findChildByClass(ArucasCodeBlock.class);
  }

  @Override
  @Nullable
  public ArucasExpression getExpression() {
    return findChildByClass(ArucasExpression.class);
  }

  @Override
  @Nullable
  public ArucasNamedTypeHint getNamedTypeHint() {
    return findChildByClass(ArucasNamedTypeHint.class);
  }

}
