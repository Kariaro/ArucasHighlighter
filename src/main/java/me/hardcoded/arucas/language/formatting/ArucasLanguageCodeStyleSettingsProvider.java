package me.hardcoded.arucas.language.formatting;

import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import me.hardcoded.arucas.language.ArucasLanguage;
import org.jetbrains.annotations.NotNull;

import static me.hardcoded.arucas.language.formatting.ArucasStyleSettingsCustomizable.*;

public class ArucasLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {
	@NotNull
	@Override
	public Language getLanguage() {
		return ArucasLanguage.INSTANCE;
	}
	
	@Override
	public void customizeSettings(@NotNull CodeStyleSettingsCustomizable consumer, @NotNull SettingsType settingsType) {
		if (settingsType == SettingsType.SPACING_SETTINGS) {
			// Basic operators
			showSpacingOption(consumer, Type.SPACE_AROUND_ASSIGNMENT_OPERATORS, "Assignment", SPACE_AROUND_OPERATORS);
			showSpacingOption(consumer, Type.SPACE_AROUND_UNARY_OPERATORS, "Unary operators", SPACE_AROUND_OPERATORS);
			showSpacingOption(consumer, Type.SPACE_AROUND_UNARY_MODIFY_OPERATORS, "Unary modify operators", SPACE_AROUND_OPERATORS);
			showSpacingOption(consumer, Type.SPACE_AROUND_BINARY_OPERATORS, "Binary operators", SPACE_AROUND_OPERATORS);
			showSpacingOption(consumer, Type.SPACE_AROUND_LOGICAL_OPERATORS, "Logical operators", SPACE_AROUND_OPERATORS);
			showSpacingOption(consumer, Type.SPACE_AROUND_RELATIONAL_OPERATORS, "Relational operators", SPACE_AROUND_OPERATORS);
			showSpacingOption(consumer, Type.SPACE_AROUND_EQUALITY_OPERATORS, "Equality operators", SPACE_AROUND_OPERATORS);
			
			// Code blocks
			showSpacingOption(consumer, Type.SPACE_BEFORE_CLASS_BODY, "Class body", SPACE_BEFORE_LBRACE);
			showSpacingOption(consumer, Type.SPACE_BEFORE_METHOD_BODY, "Method body", SPACE_BEFORE_LBRACE);
			
			// List expression
			showSpacingOption(consumer, Type.SPACE_INSIDE_EMPTY_LIST, "Empty space", SPACE_LIST);
			showSpacingOption(consumer, Type.SPACE_AROUND_INSIDE_LIST, "Around walls", SPACE_LIST);
			showSpacingOption(consumer, Type.SPACE_BEFORE_LIST_COMMA, "Before comma", SPACE_LIST);
			showSpacingOption(consumer, Type.SPACE_AFTER_LIST_COMMA, "After comma", SPACE_LIST);
			
			// Map expression
			showSpacingOption(consumer, Type.SPACE_INSIDE_EMPTY_MAP, "Empty space", SPACE_MAP);
			showSpacingOption(consumer, Type.SPACE_AROUND_INSIDE_MAP, "Around walls", SPACE_MAP);
			showSpacingOption(consumer, Type.SPACE_BEFORE_MAP_COLON, "Before colon", SPACE_MAP);
			showSpacingOption(consumer, Type.SPACE_AFTER_MAP_COLON, "After colon", SPACE_MAP);
			showSpacingOption(consumer, Type.SPACE_BEFORE_MAP_COMMA, "Before comma", SPACE_MAP);
			showSpacingOption(consumer, Type.SPACE_AFTER_MAP_COMMA, "After comma", SPACE_MAP);
			
			// Method parameters
			showSpacingOption(consumer, Type.SPACE_INSIDE_EMPTY_PARAMETERS, "Empty space", SPACE_METHOD_PARAMETERS);
			showSpacingOption(consumer, Type.SPACE_AFTER_METHOD_NAME, "After method name", SPACE_METHOD_PARAMETERS);
			showSpacingOption(consumer, Type.SPACE_AROUND_INSIDE_PARAMETERS, "Around walls", SPACE_METHOD_PARAMETERS);
			showSpacingOption(consumer, Type.SPACE_BEFORE_PARAMETER_COMMA, "Before comma", SPACE_METHOD_PARAMETERS);
			showSpacingOption(consumer, Type.SPACE_AFTER_PARAMETER_COMMA, "After comma", SPACE_METHOD_PARAMETERS);
		} else if (settingsType == SettingsType.BLANK_LINES_SETTINGS) {
			consumer.showStandardOptions("KEEP_BLANK_LINES_IN_CODE");
		}
	}
	
	private void showSpacingOption(@NotNull CodeStyleSettingsCustomizable consumer, Type type, String name, String group) {
		consumer.showCustomOption(ArucasCodeStyleSettings.class, type.name(), name, group);
	}
	
	@Override
	public String getCodeSample(@NotNull SettingsType settingsType) {
		return "/* This is an example class */\n" +
			"class Example {\n" +
			"    static var staticVariable = 'string';\n" +
			"    var memberVariable = 321;\n" +
			"    var eq = (a == b) != c;\n" +
			"    var rl = (((a <= b) >= c) < d) > e;\n" +
			"    var lc = (a && b) || c;\n" +
			"    var as = (a = b);\n" +
			"    var bi = (a + b - c * d ^ e);\n" +
			"    var un = (-a + +b - (!c) + (d++) - (e--));\n" +
			"\n" +
			"    Example() {\n" +
			"        this.memberVariable = true;\n" +
			"        localVariable = [ 'a', 1, { 1: '321', 2: {} }, [] ];\n" +
			"    }\n" +
			"\n" +
			"    static fun staticMethod(obj, b, c) {\n" +
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
