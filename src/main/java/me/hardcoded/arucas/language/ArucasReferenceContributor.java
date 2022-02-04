package me.hardcoded.arucas.language;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import me.hardcoded.arucas.psi.ArucasNamedElement;
import me.hardcoded.arucas.psi.ArucasTypes;
import org.jetbrains.annotations.NotNull;

public class ArucasReferenceContributor extends PsiReferenceContributor {
	@Override
	public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
		registrar.registerReferenceProvider(PlatformPatterns.psiElement(ArucasTypes.IDENTIFIER_NAME),
			new PsiReferenceProvider() {
				@Override
				public PsiReference @NotNull [] getReferencesByElement(
					@NotNull PsiElement element,
					@NotNull ProcessingContext context
				) {
					if (element instanceof ArucasNamedElement) {
						return new PsiReference[] {
							new ArucasReference(element, element.getTextRange())
						};
					}
					
					return PsiReference.EMPTY_ARRAY;
				}
			}
		);
	}
}
