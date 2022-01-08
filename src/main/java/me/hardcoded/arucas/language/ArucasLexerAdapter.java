package me.hardcoded.arucas.language;

import com.intellij.lexer.FlexAdapter;

public class ArucasLexerAdapter extends FlexAdapter {
	public ArucasLexerAdapter() {
		super(new ArucasLexer(null));
	}
}
