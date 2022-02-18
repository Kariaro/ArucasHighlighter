// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ArucasClassMethod extends PsiElement {

  @NotNull
  ArucasArguments getArguments();

  @NotNull
  ArucasCodeBlock getCodeBlock();

  @NotNull
  ArucasFunctionModifiers getFunctionModifiers();

  @NotNull
  ArucasFunctionName getFunctionName();

}
