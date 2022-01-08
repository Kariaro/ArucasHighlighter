// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ArucasStatement extends PsiElement {

  @NotNull
  List<ArucasAtomExpression> getAtomExpressionList();

  @Nullable
  ArucasClassStatement getClassStatement();

  @NotNull
  List<ArucasExpression> getExpressionList();

  @Nullable
  ArucasForEachStatement getForEachStatement();

  @Nullable
  ArucasForStatement getForStatement();

  @Nullable
  ArucasFunctionStatement getFunctionStatement();

  @Nullable
  ArucasIfStatement getIfStatement();

  @Nullable
  ArucasStatements getStatements();

  @Nullable
  ArucasSwitchStatement getSwitchStatement();

  @Nullable
  ArucasTryStatement getTryStatement();

  @Nullable
  ArucasWhileStatement getWhileStatement();

}
