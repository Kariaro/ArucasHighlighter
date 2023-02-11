package me.hardcoded.arucas.language.formatting;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class ArucasCodeStyleSettings extends CustomCodeStyleSettings {
	public ArucasCodeStyleSettings(CodeStyleSettings settings) {
		super("ArucasCodeStyleSettings", settings);
	}
	
	// Before left brace
	public boolean SPACE_BEFORE_LEFT_BRACE = true;
	public boolean SPACE_BEFORE_CLASS_BODY = true;
	public boolean SPACE_BEFORE_METHOD_BODY = true;
	
	// Before parentheses
	public boolean SPACE_BEFORE_METHOD_PARENTHESES = false;
	public boolean SPACE_BEFORE_OPERATOR_PARENTHESES = true;
	public boolean SPACE_BEFORE_NEW_PARENTHESES = false;
	public boolean SPACE_BEFORE_FOR_PARENTHESES = true;
	public boolean SPACE_BEFORE_FOREACH_PARENTHESES = true;
	public boolean SPACE_BEFORE_SWITCH_PARENTHESES = true;
	public boolean SPACE_BEFORE_IF_PARENTHESES = true;
	public boolean SPACE_BEFORE_WHILE_PARENTHESES = true;
	public boolean SPACE_BEFORE_CATCH_PARENTHESES = true;
	public boolean SPACE_BEFORE_CALL_PARENTHESES = false;
	
	/** {@code +, -, !} */
	public boolean SPACE_AROUND_UNARY_OPERATORS = false;
	
	/** {@code ++, --} */
	public boolean SPACE_AROUND_UNARY_MODIFY_OPERATORS = false;
	
	/** {@code +, -, *, /, ^} */
	public boolean SPACE_AROUND_BINARY_OPERATORS = true;
	
	/** {@code >=, >, <=, <} */
	public boolean SPACE_AROUND_RELATIONAL_OPERATORS = true;
	
	/** {@code &&, ||} */
	public boolean SPACE_AROUND_LOGICAL_OPERATORS = true;
	
	/** {@code ==, !=} */
	public boolean SPACE_AROUND_EQUALITY_OPERATORS = true;
	
	/** {@code =} */
	public boolean SPACE_AROUND_ASSIGNMENT_OPERATORS = true;
	
	// List
	public boolean SPACE_INSIDE_EMPTY_LIST = false;
	public boolean SPACE_AROUND_INSIDE_LIST = true;
	public boolean SPACE_BEFORE_LIST_COMMA = false;
	public boolean SPACE_AFTER_LIST_COMMA = true;
	
	// Map
	public boolean SPACE_INSIDE_EMPTY_MAP = false;
	public boolean SPACE_AROUND_INSIDE_MAP = true;
	public boolean SPACE_BEFORE_MAP_COLON = false;
	public boolean SPACE_AFTER_MAP_COLON = true;
	public boolean SPACE_BEFORE_MAP_COMMA = false;
	public boolean SPACE_AFTER_MAP_COMMA = true;
	
	// Method parameters
	public boolean SPACE_INSIDE_EMPTY_PARAMETERS = false;
	public boolean SPACE_AROUND_INSIDE_PARAMETERS = false;
	public boolean SPACE_BEFORE_PARAMETER_COMMA = false;
	public boolean SPACE_AFTER_PARAMETER_COMMA = true;
	
	// Call parameters
	public boolean SPACE_INSIDE_EMPTY_CALL_PARAMETERS = false;
	public boolean SPACE_AROUND_INSIDE_CALL_PARAMETERS = false;
	public boolean SPACE_BEFORE_PARAMETER_CALL_COMMA = false;
	public boolean SPACE_AFTER_PARAMETER_CALL_COMMA = true;
}
