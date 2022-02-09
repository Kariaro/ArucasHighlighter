package me.hardcoded.arucas.language;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.util.PsiUtilCore;
import me.hardcoded.arucas.psi.ArucasNamedElement;
import me.hardcoded.arucas.psi.impl.ArucasNamedElementImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArucasReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
	private final String key;
	private final String name;
	
	public ArucasReference(@NotNull PsiElement element, TextRange textRange) {
		super(element, textRange);
		// System.out.println("Create reference: " + element);
		this.key = element.getText();
		
		if (element instanceof ArucasNamedElement) {
			ArucasNamedElement elm = (ArucasNamedElement)element;
			this.name = elm.getName();
		} else {
			this.name = null;
		}
	}
	
	@Override
	public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
		System.out.println("MultiResolve: " + myElement);
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
	
//	@Override
//	public boolean isReferenceTo(@NotNull PsiElement element) {
//		if (element instanceof ArucasNamedElement) {
//			ArucasNamedElement elm = (ArucasNamedElement)element;
//			if (elm.getName() != null && elm.getName().equals(name)) {
//				return true;
//			}
//		}
//
//		return super.isReferenceTo(element);
//	}
}
