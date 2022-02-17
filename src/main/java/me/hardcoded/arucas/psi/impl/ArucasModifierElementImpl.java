package me.hardcoded.arucas.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import me.hardcoded.arucas.psi.ArucasModifierElement;
import me.hardcoded.arucas.psi.ArucasTypes;
import org.jetbrains.annotations.NotNull;

public class ArucasModifierElementImpl extends ASTWrapperPsiElement implements ArucasModifierElement {
	public ArucasModifierElementImpl(@NotNull ASTNode node) {
		super(node);
	}
	
	public boolean isStatic() {
		return findChildrenByType(ArucasTypes.KW_STATIC) != null;
	}
}
