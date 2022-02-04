// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ArucasArithmeticExpression extends PsiElement {

  @Nullable
  ArucasArithmeticExpression getArithmeticExpression();

  @NotNull
  List<ArucasCallArguments> getCallArgumentsList();

  @NotNull
  List<ArucasExpression> getExpressionList();

  @NotNull
  List<ArucasUnaryFactorExpression> getUnaryFactorExpressionList();

}
