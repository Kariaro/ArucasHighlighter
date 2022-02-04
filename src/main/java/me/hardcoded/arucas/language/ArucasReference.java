package me.hardcoded.arucas.language;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArucasReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
	private final String key;
	
	public ArucasReference(@NotNull PsiElement element, TextRange textRange) {
		super(element, textRange);
		System.out.println("Create reference: " + element);
		this.key = element.getText();
	}
	
	@Override
	public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
		Project project = myElement.getProject();
		
		// Go backwards or forwards
		return new ResolveResult[0];
	}
	
	@Nullable
	@Override
	public PsiElement resolve() {
		ResolveResult[] resolveResults = multiResolve(false);
		return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
	}
}
