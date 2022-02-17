// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import me.hardcoded.arucas.psi.ArucasAtomElement.AtomType;

public interface ArucasAtomExpression extends ArucasExpression, ArucasAtomElement {

  @Nullable
  ArucasIdentifierName getIdentifierName();

  @Nullable
  PsiElement getNumber();

  @Nullable
  PsiElement getString();

  @NotNull AtomType getAtomType();

}
