package me.hardcoded.arucas.language;

import com.intellij.lang.Language;

public class ArucasLanguage extends Language {
	public static final ArucasLanguage INSTANCE = new ArucasLanguage();
	
	private ArucasLanguage() {
		super("Arucas");
	}
}
