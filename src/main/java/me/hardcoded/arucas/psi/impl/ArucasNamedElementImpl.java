package me.hardcoded.arucas.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import me.hardcoded.arucas.language.ArucasReference;
import me.hardcoded.arucas.psi.ArucasNamedElement;
import me.hardcoded.arucas.psi.ArucasTypes;
import org.jetbrains.annotations.NotNull;

public class ArucasNamedElementImpl extends ASTWrapperPsiElement implements ArucasNamedElement {
	public ArucasNamedElementImpl(@NotNull ASTNode node) {
		super(node);
	}
	
	@NotNull
	@Override
	public PsiElement getNameIdentifier() {
		return findNotNullChildByType(ArucasTypes.IDENTIFIER);
	}
	
	@Override
	public PsiElement setName(@NotNull String name) {
		return null;
	}
	
	@NotNull
	@Override
	public String getName() {
		return getText();
	}
	
	@Override
	public PsiReference getReference() {
		String name = getName();
		return new ArucasReference(this, TextRange.from(0, name.length()));
	}
}
