// This is a generated file. Not intended for manual editing.
package me.hardcoded.arucas.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ArucasTryStatement extends ArucasStatement {

  @NotNull
  ArucasIdentifierName getIdentifierName();

  @Nullable
  ArucasNamedTypeHint getNamedTypeHint();

  @NotNull
  List<ArucasStatement> getStatementList();

  @Nullable
  ArucasTryStatementFinally getTryStatementFinally();

  @NotNull
  ArucasStatement getTryBody();

  @Nullable
  ArucasStatement getCatchBody();

}
