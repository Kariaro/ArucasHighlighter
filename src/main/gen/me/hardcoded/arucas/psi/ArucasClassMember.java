// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ArucasClassMember extends PsiElement {

  @Nullable
  ArucasExpression getExpression();

  @NotNull
  ArucasFunctionModifiers getFunctionModifiers();

  @Nullable
  ArucasNamedTypeHint getNamedTypeHint();

  @NotNull
  ArucasVariableName getVariableName();

}
