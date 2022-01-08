// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ArucasAtomExpression extends PsiElement {

  @Nullable
  ArucasExpression getExpression();

  @NotNull
  List<ArucasStatement> getStatementList();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiElement getNumber();

  @Nullable
  PsiElement getString();

  @Nullable
  PsiElement getValueKeyword();

}
