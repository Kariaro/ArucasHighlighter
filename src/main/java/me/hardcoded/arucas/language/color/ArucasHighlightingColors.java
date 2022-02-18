package me.hardcoded.arucas.language.color;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

public class ArucasHighlightingColors {
	public static final TextAttributesKey IDENTIFIER
		= TextAttributesKey.createTextAttributesKey("ARUCAS_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
	public static final TextAttributesKey KEYWORD
		= TextAttributesKey.createTextAttributesKey("ARUCAS_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
	public static final TextAttributesKey NUMBER
		= TextAttributesKey.createTextAttributesKey("ARUCAS_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
	public static final TextAttributesKey DELIMITER
		= TextAttributesKey.createTextAttributesKey("ARUCAS_DELIMITER", DefaultLanguageHighlighterColors.SEMICOLON);
	public static final TextAttributesKey COMMENT
		= TextAttributesKey.createTextAttributesKey("ARUCAS_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
	public static final TextAttributesKey STRING
		= TextAttributesKey.createTextAttributesKey("ARUCAS_STRING", DefaultLanguageHighlighterColors.STRING);
	public static final TextAttributesKey BAD_CHARACTER
		= TextAttributesKey.createTextAttributesKey("ARUCAS_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
	
	public static final TextAttributesKey CLASS_NAME
		= TextAttributesKey.createTextAttributesKey("ARUCAS_CLASS_NAME", DefaultLanguageHighlighterColors.CLASS_NAME);
	public static final TextAttributesKey FUNCTION_NAME
		= TextAttributesKey.createTextAttributesKey("ARUCAS_FUNCTION_NAME", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
	public static final TextAttributesKey VARIABLE_NAME
		= TextAttributesKey.createTextAttributesKey("ARUCAS_VARIABLE_NAME", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
	
	public static final TextAttributesKey FUNCTION_CALL
		= TextAttributesKey.createTextAttributesKey("ARUCAS_FUNCTION_CALL", DefaultLanguageHighlighterColors.FUNCTION_CALL);
}
