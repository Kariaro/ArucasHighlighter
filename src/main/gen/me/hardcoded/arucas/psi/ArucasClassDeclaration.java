// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ArucasClassDeclaration extends ArucasStatement {

  @NotNull
  ArucasClassCodeBlock getClassCodeBlock();

  @Nullable
  ArucasClassInheritance getClassInheritance();

  @NotNull
  ArucasClassName getClassName();

}
