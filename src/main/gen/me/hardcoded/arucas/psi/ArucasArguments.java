// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ArucasArguments extends PsiElement {

  @NotNull
  List<ArucasArgument> getArgumentList();

  @Nullable
  ArucasArgumentArbitrary getArgumentArbitrary();

  @Nullable
  PsiElement getIdentifier();

}
