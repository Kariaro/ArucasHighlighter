package me.hardcoded.arucas.psi;

import com.intellij.psi.tree.IElementType;
import me.hardcoded.arucas.language.ArucasLanguage;

public class ArucasElementType extends IElementType {
	public ArucasElementType(String debugName) {
		super(debugName, ArucasLanguage.INSTANCE);
	}
}
