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

public class ArucasClassBodyStatementImpl extends ASTWrapperPsiElement implements ArucasClassBodyStatement {

  public ArucasClassBodyStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ArucasVisitor visitor) {
    visitor.visitClassBodyStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ArucasVisitor) accept((ArucasVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ArucasClassConstructor getClassConstructor() {
    return findChildByClass(ArucasClassConstructor.class);
  }

  @Override
  @Nullable
  public ArucasClassFunction getClassFunction() {
    return findChildByClass(ArucasClassFunction.class);
  }

  @Override
  @Nullable
  public ArucasClassOperator getClassOperator() {
    return findChildByClass(ArucasClassOperator.class);
  }

  @Override
  @Nullable
  public ArucasClassVariable getClassVariable() {
    return findChildByClass(ArucasClassVariable.class);
  }

}
