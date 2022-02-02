package me.hardcoded.arucas.language.formatting;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class ArucasCodeStyleSettings extends CustomCodeStyleSettings {
	public ArucasCodeStyleSettings(CodeStyleSettings settings) {
		super("ArucasCodeStyleSettings", settings);
	}
	
	// Custom settings
	public boolean SPACE_BEFORE_CLASS_BODY = true;
	public boolean SPACE_BEFORE_METHOD_BODY = true;
	
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
	public boolean SPACE_AFTER_METHOD_NAME = false;
	public boolean SPACE_AROUND_INSIDE_PARAMETERS = false;
	public boolean SPACE_BEFORE_PARAMETER_COMMA = false;
	public boolean SPACE_AFTER_PARAMETER_COMMA = true;
}
