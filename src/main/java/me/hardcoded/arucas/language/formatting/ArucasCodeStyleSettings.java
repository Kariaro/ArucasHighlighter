package me.hardcoded.arucas.language.formatting;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class ArucasCodeStyleSettings extends CustomCodeStyleSettings {
	public ArucasCodeStyleSettings(CodeStyleSettings settings) {
		super("ArucasCodeStyleSettings", settings);
	}
}
