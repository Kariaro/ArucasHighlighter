// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ArucasStatement extends PsiElement {

  @NotNull
  List<ArucasAtom> getAtomList();

  @Nullable
  ArucasClassStatement getClassStatement();

  @NotNull
  List<ArucasExpression> getExpressionList();

  @Nullable
  ArucasForEachStatement getForEachStatement();

  @Nullable
  ArucasForStatement getForStatement();

  @NotNull
  List<ArucasFunctionLambda> getFunctionLambdaList();

  @Nullable
  ArucasFunctionStatement getFunctionStatement();

  @Nullable
  ArucasIfStatement getIfStatement();

  @NotNull
  List<ArucasStatement> getStatementList();

  @Nullable
  ArucasSwitchStatement getSwitchStatement();

  @Nullable
  ArucasTryStatement getTryStatement();

  @Nullable
  ArucasWhileStatement getWhileStatement();

}
