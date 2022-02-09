package me.hardcoded.arucas.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import me.hardcoded.arucas.language.ArucasReference;
import me.hardcoded.arucas.language.refactor.ArucasReferenceResolver;
import me.hardcoded.arucas.psi.ArucasNamedElement;
import me.hardcoded.arucas.psi.ArucasTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

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
		
		return getNode().getPsi();
	}
	
	@Override
	public PsiReference getReference() {
		PsiReference[] references = getReferences();
		return references.length == 0 ? null : references[0];
	}
	
	@Override
	public PsiReference @NotNull [] getReferences() {
		return PsiReference.EMPTY_ARRAY;
		/*
		PsiElement nameIdentifier = getNameIdentifier();
		if (nameIdentifier != null) {
			String name = nameIdentifier.getText();
			
			List<PsiReference> list = new ArrayList<>();
			ArucasReferenceResolver.resolve(name, list, getNode().getPsi());
			if (list.isEmpty()) {
				return PsiReference.EMPTY_ARRAY;
			}
			
			System.out.println(list);
			
			return list.toArray(PsiReference.EMPTY_ARRAY);
		}
		
		return PsiReference.EMPTY_ARRAY;
		*/
	}
}
