package me.hardcoded.arucas.language.formatting;

import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizableOptions;
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
			String groupName;
			
			// Before parentheses
			groupName = CodeStyleSettingsCustomizableOptions.getInstance().SPACES_BEFORE_PARENTHESES;
			showSpacingOption(consumer, Type.SPACE_BEFORE_METHOD_PARENTHESES, "Method declaration parentheses", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_OPERATOR_PARENTHESES, "Operator declaration parentheses", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_NEW_PARENTHESES, "New parentheses", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_CALL_PARENTHESES, "Method call parentheses", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_FOR_PARENTHESES, "'for' parentheses", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_FOREACH_PARENTHESES, "'foreach' parentheses", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_SWITCH_PARENTHESES, "'switch' parentheses", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_IF_PARENTHESES, "'if' parentheses", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_WHILE_PARENTHESES, "'while' parentheses", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_CATCH_PARENTHESES, "'catch' parentheses", groupName);
			
			// Basic operators
			groupName = CodeStyleSettingsCustomizableOptions.getInstance().SPACES_AROUND_OPERATORS;
			showSpacingOption(consumer, Type.SPACE_AROUND_ASSIGNMENT_OPERATORS, "Assignment", groupName);
			showSpacingOption(consumer, Type.SPACE_AROUND_UNARY_OPERATORS, "Unary operators", groupName);
			showSpacingOption(consumer, Type.SPACE_AROUND_UNARY_MODIFY_OPERATORS, "Unary modify operators", groupName);
			showSpacingOption(consumer, Type.SPACE_AROUND_BINARY_OPERATORS, "Binary operators", groupName);
			showSpacingOption(consumer, Type.SPACE_AROUND_LOGICAL_OPERATORS, "Logical operators", groupName);
			showSpacingOption(consumer, Type.SPACE_AROUND_RELATIONAL_OPERATORS, "Relational operators", groupName);
			showSpacingOption(consumer, Type.SPACE_AROUND_EQUALITY_OPERATORS, "Equality operators", groupName);
			
			// Code blocks
			groupName = CodeStyleSettingsCustomizableOptions.getInstance().SPACES_BEFORE_LEFT_BRACE;
			showSpacingOption(consumer, Type.SPACE_BEFORE_CLASS_BODY, "Class body", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_METHOD_BODY, "Method body", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_LEFT_BRACE, "Space before left brace", groupName);
			
			// List expression
			groupName = SPACE_LIST;
			showSpacingOption(consumer, Type.SPACE_INSIDE_EMPTY_LIST, "Empty space", groupName);
			showSpacingOption(consumer, Type.SPACE_AROUND_INSIDE_LIST, "Around walls", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_LIST_COMMA, "Before comma", groupName);
			showSpacingOption(consumer, Type.SPACE_AFTER_LIST_COMMA, "After comma", groupName);
			
			// Map expression
			groupName = SPACE_MAP;
			showSpacingOption(consumer, Type.SPACE_INSIDE_EMPTY_MAP, "Empty space", groupName);
			showSpacingOption(consumer, Type.SPACE_AROUND_INSIDE_MAP, "Around walls", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_MAP_COLON, "Before colon", groupName);
			showSpacingOption(consumer, Type.SPACE_AFTER_MAP_COLON, "After colon", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_MAP_COMMA, "Before comma", groupName);
			showSpacingOption(consumer, Type.SPACE_AFTER_MAP_COMMA, "After comma", groupName);
			
			// Method parameters
			groupName = SPACE_METHOD_PARAMETERS;
			showSpacingOption(consumer, Type.SPACE_INSIDE_EMPTY_PARAMETERS, "Empty space", groupName);
			showSpacingOption(consumer, Type.SPACE_AROUND_INSIDE_PARAMETERS, "Around walls", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_PARAMETER_COMMA, "Before comma", groupName);
			showSpacingOption(consumer, Type.SPACE_AFTER_PARAMETER_COMMA, "After comma", groupName);
			
			// Call parameters
			groupName = SPACE_CALL_PARAMETERS;
			showSpacingOption(consumer, Type.SPACE_INSIDE_EMPTY_CALL_PARAMETERS, "Empty space", groupName);
			showSpacingOption(consumer, Type.SPACE_AROUND_INSIDE_CALL_PARAMETERS, "Around walls", groupName);
			showSpacingOption(consumer, Type.SPACE_BEFORE_PARAMETER_CALL_COMMA, "Before comma", groupName);
			showSpacingOption(consumer, Type.SPACE_AFTER_PARAMETER_CALL_COMMA, "After comma", groupName);
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
			"    static var staticVariable = 'literal';\n" +
			"    var memberVariable;\n" +
			"\n" +
			"    Example(value) {\n" +
			"        a_local = ['a', { 1: 'b', 2: {} }, []];\n" +
			"        foreach (item : a_local) {\n" +
			"            len = length(item);\n" +
			"            if (!(len > 0 && len <= value) || value > 100) {\n" +
			"                for (i = 0; i < 10; i++) {\n" +
			"                    a_local.append('text' + (i * 3 / 2.0), 'a', null);\n" +
			"                }\n" +
			"            } else {\n" +
			"                i = 10;\n" +
			"                while (i >= len) {\n" +
			"                    switch (i--) {\n" +
			"                        case 1, 2, 3 -> {\n" +
			"                            {\n" +
			"                                a_local.append('text' + i);\n" +
			"                            }\n" +
			"                        }\n" +
			"                        default -> {}\n" +
			"                    }\n" +
			"                }\n" +
			"            }\n" +
			"        }\n" +
			"\n" +
			"        try {\n" +
			"            complex = (0.5 ^ (0 - -1) + +1);\n" +
			"        } catch (message) {\n" +
			"            // Single line comment\n" +
			"        }\n" +
			"    }\n" +
			"\n" +
			"    operator +(right) {\n" +
			"        return this.a_local + right;\n" +
			"    }\n" +
			"\n" +
			"    static fun testInequality(a, b, expected) {\n" +
			"        return (a != b) == expected;\n" +
			"    }\n" +
			"}\n" +
			"\n" +
			"obj = fun() {\n" +
			"    return new Example(50);\n" +
			"}();";
	}
}
