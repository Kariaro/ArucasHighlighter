package me.hardcoded.arucas.language;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import me.hardcoded.arucas.psi.ArucasNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArucasReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
	private final String name;
	
	public ArucasReference(@NotNull PsiElement element, TextRange textRange) {
		super(element, textRange);
		
		if (element instanceof ArucasNamedElement) {
			ArucasNamedElement elm = (ArucasNamedElement)element;
			this.name = elm.getName();
		} else {
			this.name = null;
		}
	}
	
	@Override
	public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
		if (myElement instanceof ArucasNamedElement) {
			return new ResolveResult[] {
				new PsiElementResolveResult(myElement)
			};
		}
		
		return ResolveResult.EMPTY_ARRAY;
	}
	
	@Nullable
	@Override
	public PsiElement resolve() {
		ResolveResult[] resolveResults = multiResolve(false);
		return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
	}
	
	@Override
	public boolean isReferenceTo(@NotNull PsiElement element) {
		if (element instanceof ArucasNamedElement) {
			ArucasNamedElement elm = (ArucasNamedElement)element;
			if (elm.getName() != null && elm.getName().equals(name)) {
				return true;
			}
		}

		return super.isReferenceTo(element);
	}
}
