package me.hardcoded.arucas.language.formatting;

import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable.SpacingOption;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import me.hardcoded.arucas.language.ArucasLanguage;
import org.jetbrains.annotations.NotNull;

public class ArucasLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {
	@NotNull
	@Override
	public Language getLanguage() {
		return ArucasLanguage.INSTANCE;
	}
	
	@Override
	public void customizeSettings(@NotNull CodeStyleSettingsCustomizable consumer, @NotNull SettingsType settingsType) {
		if (settingsType == SettingsType.SPACING_SETTINGS) {
			showSpacingOptionOption(consumer, SpacingOption.SPACE_AROUND_ASSIGNMENT_OPERATORS, "Assignment");
		} else if (settingsType == SettingsType.BLANK_LINES_SETTINGS) {
			consumer.showStandardOptions("KEEP_BLANK_LINES_IN_CODE");
		}
	}
	
	private void showSpacingOptionOption(@NotNull CodeStyleSettingsCustomizable consumer, SpacingOption option, String rename) {
		String id = option.name();
		consumer.showStandardOptions(id);
		if (rename != null) {
			consumer.renameStandardOption(id, rename);
		}
	}
	
	@Override
	public String getCodeSample(@NotNull SettingsType settingsType) {
		return "/* This is an example class */\n" +
			"class Example {\n" +
			"    static var staticVariable = 'string';\n" +
			"    var memberVariable = 321;\n" +
			"\n" +
			"    Example() {\n" +
			"        fun(){\nfun(){\nfun(){\nfun(){\nfun(){\nfun(){\n\n};\n};\n};\n};\n};\n};\n" +
			"        this.memberVariable = true;\n" +
			"        localVariable = [ 'a', 1, { 1: '321' }];\n" +
			"    }\n" +
			"\n" +
			"    static fun staticMethod(obj) {\n" +
			"        return obj == null;\n" +
			"    }\n" +
			"}\n" +
			"\n" +
			"// Create a delegate\n" +
			"delegate = fun() {\n" +
			"    return new Example();\n" +
			"}();";
	}
}
