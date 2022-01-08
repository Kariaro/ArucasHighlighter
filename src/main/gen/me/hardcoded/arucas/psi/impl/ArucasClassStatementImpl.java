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

public class ArucasClassStatementImpl extends ASTWrapperPsiElement implements ArucasClassStatement {

  public ArucasClassStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ArucasVisitor visitor) {
    visitor.visitClassStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ArucasVisitor) accept((ArucasVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ArucasClassConstructor> getClassConstructorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ArucasClassConstructor.class);
  }

  @Override
  @NotNull
  public List<ArucasClassMember> getClassMemberList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ArucasClassMember.class);
  }

  @Override
  @NotNull
  public List<ArucasClassMethod> getClassMethodList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ArucasClassMethod.class);
  }

  @Override
  @NotNull
  public List<ArucasClassOperator> getClassOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ArucasClassOperator.class);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

}
