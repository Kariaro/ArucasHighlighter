// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ArucasExpression extends PsiElement {

  @NotNull
  List<ArucasAtomExpression> getAtomExpressionList();

  @Nullable
  ArucasExpression getExpression();

  @Nullable
  PsiElement getIdentifier();

}