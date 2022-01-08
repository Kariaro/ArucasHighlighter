// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ArucasClassStatement extends PsiElement {

  @NotNull
  List<ArucasClassConstructor> getClassConstructorList();

  @NotNull
  List<ArucasClassMember> getClassMemberList();

  @NotNull
  List<ArucasClassMethod> getClassMethodList();

  @NotNull
  List<ArucasClassOperator> getClassOperatorList();

  @NotNull
  PsiElement getIdentifier();

}
