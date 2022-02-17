package me.hardcoded.arucas.psi;

import org.jetbrains.annotations.NotNull;

public interface ArucasAtomElement {
	enum AtomType {
		TRUE, FALSE, NULL, THIS, NUMBER, STRING, IDENTIFIER, INVALID
	}
	
	@NotNull
	AtomType getAtomType();
}
