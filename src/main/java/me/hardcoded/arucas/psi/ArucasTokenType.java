package me.hardcoded.arucas.psi;

import com.intellij.psi.tree.IElementType;
import me.hardcoded.arucas.language.ArucasLanguage;

public class ArucasTokenType extends IElementType {
	
	public ArucasTokenType(String debugName) {
		super(debugName, ArucasLanguage.INSTANCE);
	}
	
	@Override
	public String toString() {
		return "ArucasTokenType." + super.toString();
	}
}
