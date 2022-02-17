package me.hardcoded.arucas.language;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import me.hardcoded.arucas.psi.ArucasNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArucasRefactoringSupportProvider extends RefactoringSupportProvider {
	@Override
	public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, @Nullable PsiElement context) {
		// And not part of a binary expression
		return false;
		// return element instanceof ArucasNamedElement;
	}
}
