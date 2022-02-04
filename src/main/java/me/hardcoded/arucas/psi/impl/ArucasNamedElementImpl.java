package me.hardcoded.arucas.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.util.IncorrectOperationException;
import me.hardcoded.arucas.psi.ArucasNamedElement;
import me.hardcoded.arucas.psi.ArucasTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArucasNamedElementImpl extends ASTWrapperPsiElement implements ArucasNamedElement {
	public ArucasNamedElementImpl(@NotNull ASTNode node) {
		super(node);
	}
	
	@Nullable
	@Override
	public PsiElement getNameIdentifier() {
		return findChildByType(ArucasTypes.IDENTIFIER);
	}
	
	@Override
	public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
		System.out.println("Set name: " + name);
		System.out.println("    : " + this);
		System.out.println("    : " + this.getParent());
		System.out.println("    : " + this.getNode());
		ASTNode nameNode = findChildByType(ArucasTypes.IDENTIFIER);
		System.out.println("    : " + nameNode);
		if (nameNode != null) {
			// Change name
		}
		
		return getParent();
	}
	
	@Override
	public PsiReference getReference() {
		System.out.println("Get reference: " + this);
		PsiReference[] references = getReferences();
		return references.length == 0 ? null : references[0];
	}
	
	@Override
	public PsiReference @NotNull [] getReferences() {
		return ReferenceProvidersRegistry.getReferencesFromProviders(this);
	}
}
