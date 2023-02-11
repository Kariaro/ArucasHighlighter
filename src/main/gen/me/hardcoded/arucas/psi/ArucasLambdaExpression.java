// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ArucasLambdaExpression extends ArucasExpression {

  @NotNull
  ArucasArguments getArguments();

  @Nullable
  ArucasCodeBlock getCodeBlock();

  @Nullable
  ArucasExpression getExpression();

  @Nullable
  ArucasNamedTypeHint getNamedTypeHint();

}
