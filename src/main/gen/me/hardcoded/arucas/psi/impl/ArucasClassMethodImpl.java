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

public class ArucasClassMethodImpl extends ASTWrapperPsiElement implements ArucasClassMethod {

  public ArucasClassMethodImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ArucasVisitor visitor) {
    visitor.visitClassMethod(this);
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
  @NotNull
  public ArucasCodeBlock getCodeBlock() {
    return findNotNullChildByClass(ArucasCodeBlock.class);
  }

  @Override
  @NotNull
  public ArucasIdentifierName getIdentifierName() {
    return findNotNullChildByClass(ArucasIdentifierName.class);
  }

  @Override
  @Nullable
  public ArucasStaticModifier getStaticModifier() {
    return findChildByClass(ArucasStaticModifier.class);
  }

}
