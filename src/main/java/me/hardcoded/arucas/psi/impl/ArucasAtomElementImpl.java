package me.hardcoded.arucas.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import me.hardcoded.arucas.psi.ArucasAtomElement;
import me.hardcoded.arucas.psi.ArucasTypes;
import org.jetbrains.annotations.NotNull;

public class ArucasAtomElementImpl extends ASTWrapperPsiElement implements ArucasAtomElement {
	public ArucasAtomElementImpl(@NotNull ASTNode node) {
		super(node);
	}
	
	@NotNull
	@Override
	public AtomType getAtomType() {
		IElementType type = getNode().getFirstChildNode().getElementType();
		
		if (type == ArucasTypes.KW_TRUE) {
			return AtomType.TRUE;
		} else if (type == ArucasTypes.KW_FALSE) {
			return AtomType.FALSE;
		} else if (type == ArucasTypes.KW_NULL) {
			return AtomType.NULL;
		} else if (type == ArucasTypes.KW_THIS) {
			return AtomType.THIS;
		} else if (type == ArucasTypes.NUMBER) {
			return AtomType.NUMBER;
		} else if (type == ArucasTypes.STRING) {
			return AtomType.STRING;
		} else if (type == ArucasTypes.IDENTIFIER_NAME) {
			return AtomType.IDENTIFIER;
		}
		
		return AtomType.INVALID;
	}
}
