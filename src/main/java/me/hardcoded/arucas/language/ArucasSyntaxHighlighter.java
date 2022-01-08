package me.hardcoded.arucas.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import me.hardcoded.arucas.psi.ArucasTypes;
import org.jetbrains.annotations.NotNull;

public class ArucasSyntaxHighlighter extends SyntaxHighlighterBase {
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
	
	private static final TextAttributesKey[] BAD_CHAR_KEYS = { BAD_CHARACTER };
	private static final TextAttributesKey[] DELIMITER_KEYS = { DELIMITER };
	private static final TextAttributesKey[] NUMBER_KEYS = { NUMBER };
	private static final TextAttributesKey[] STRING_KEYS = { STRING };
	private static final TextAttributesKey[] COMMENT_KEYS = { COMMENT };
	private static final TextAttributesKey[] KEYWORD_KEYS = { KEYWORD };
	private static final TextAttributesKey[] EMPTY_KEYS = {};
	
	@NotNull
	@Override
	public Lexer getHighlightingLexer() {
		return new ArucasLexerAdapter();
	}
	
	@Override
	public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
		if (tokenType.equals(ArucasTypes.COMMENT)) {
			return COMMENT_KEYS;
		}
		if (tokenType.equals(ArucasTypes.DELIMITER)) {
			return DELIMITER_KEYS;
		}
		if (tokenType.equals(ArucasTypes.STRING)) {
			return STRING_KEYS;
		}
		if (tokenType.equals(ArucasTypes.NUMBER)) {
			return NUMBER_KEYS;
		}
		if (tokenType.equals(ArucasTypes.KEYWORD)) {
			return KEYWORD_KEYS;
		}
		if (tokenType.equals(ArucasTypes.VALUE_KEYWORD)) {
			return KEYWORD_KEYS;
		}
		if (tokenType.equals(TokenType.BAD_CHARACTER)) {
			return BAD_CHAR_KEYS;
		}
		return EMPTY_KEYS;
	}
}
