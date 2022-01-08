// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ArucasClassMethod extends PsiElement {

  @Nullable
  ArucasArguments getArguments();

  @NotNull
  ArucasCodeBlock getCodeBlock();

  @Nullable
  ArucasStaticModifier getStaticModifier();

  @NotNull
  PsiElement getIdentifier();

}
