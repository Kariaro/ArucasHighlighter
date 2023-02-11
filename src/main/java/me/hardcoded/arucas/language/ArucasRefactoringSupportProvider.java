package me.hardcoded.arucas.language;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArucasRefactoringSupportProvider extends RefactoringSupportProvider {
	@Override
	public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, @Nullable PsiElement context) {
		// return element instanceof ArucasNamedElement;
		return false;
	}
}
