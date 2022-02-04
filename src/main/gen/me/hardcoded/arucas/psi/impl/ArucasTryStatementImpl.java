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

public class ArucasTryStatementImpl extends ArucasStatementImpl implements ArucasTryStatement {

  public ArucasTryStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull ArucasVisitor visitor) {
    visitor.visitTryStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ArucasVisitor) accept((ArucasVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ArucasIdentifierName getIdentifierName() {
    return findNotNullChildByClass(ArucasIdentifierName.class);
  }

  @Override
  @NotNull
  public List<ArucasStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ArucasStatement.class);
  }

  @Override
  @NotNull
  public ArucasStatement getTryBody() {
    List<ArucasStatement> p1 = getStatementList();
    return p1.get(0);
  }

  @Override
  @Nullable
  public ArucasStatement getCatchBody() {
    List<ArucasStatement> p1 = getStatementList();
    return p1.size() < 2 ? null : p1.get(1);
  }

}
