package me.hardcoded.arucas.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import me.hardcoded.arucas.language.color.ArucasHighlightingColors;
import me.hardcoded.arucas.psi.ArucasTypes;
import org.jetbrains.annotations.NotNull;

public class ArucasSyntaxHighlighter extends SyntaxHighlighterBase {
	private static final TokenSet KEYWORDS = TokenSet.create(
		ArucasTypes.KW_IF,
		ArucasTypes.KW_ELSE,
		ArucasTypes.KW_FOR,
		ArucasTypes.KW_FOREACH,
		ArucasTypes.KW_WHILE,
		ArucasTypes.KW_TRY,
		ArucasTypes.KW_CATCH,
		ArucasTypes.KW_FUN,
		ArucasTypes.KW_CLASS,
		ArucasTypes.KW_OPERATOR,
		ArucasTypes.KW_NEW,
		ArucasTypes.KW_STATIC,
		ArucasTypes.KW_VAR,
		ArucasTypes.KW_SWITCH,
		ArucasTypes.KW_CASE,
		ArucasTypes.KW_DEFAULT,
		ArucasTypes.KW_RETURN,
		ArucasTypes.KW_BREAK,
		ArucasTypes.KW_CONTINUE
	);
	
	private static final TokenSet VALUE_KEYWORDS = TokenSet.create(
		ArucasTypes.KW_TRUE,
		ArucasTypes.KW_FALSE,
		ArucasTypes.KW_NULL,
		ArucasTypes.KW_THIS
	);
	
	private static final TokenSet DELIMITERS = TokenSet.create(
		ArucasTypes.SEMICOLON,
		ArucasTypes.COMMA
	);
	
	private static final TextAttributesKey[] IDENTIFIER_KEYS = { ArucasHighlightingColors.IDENTIFIER };
	private static final TextAttributesKey[] BAD_CHAR_KEYS = { ArucasHighlightingColors.BAD_CHARACTER };
	private static final TextAttributesKey[] DELIMITER_KEYS = { ArucasHighlightingColors.DELIMITER };
	private static final TextAttributesKey[] NUMBER_KEYS = { ArucasHighlightingColors.NUMBER };
	private static final TextAttributesKey[] STRING_KEYS = { ArucasHighlightingColors.STRING };
	private static final TextAttributesKey[] COMMENT_KEYS = { ArucasHighlightingColors.COMMENT };
	private static final TextAttributesKey[] KEYWORD_KEYS = { ArucasHighlightingColors.KEYWORD };
	private static final TextAttributesKey[] EMPTY_KEYS = {};
	
	// private static final TextAttributesKey[] CLASS_NAME_KEYS = { ArucasHighlightingColors.CLASS_NAME };
	// private static final TextAttributesKey[] FUNCTION_NAME_KEYS = { ArucasHighlightingColors.FUNCTION_NAME };
	// private static final TextAttributesKey[] VARIABLE_NAME_KEYS = { ArucasHighlightingColors.VARIABLE_NAME };
	
	@NotNull
	@Override
	public Lexer getHighlightingLexer() {
		return new ArucasLexerAdapter();
	}
	
	@Override
	public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
		if (tokenType.equals(ArucasTypes.IDENTIFIER)) {
			return IDENTIFIER_KEYS;
		}
		if (tokenType.equals(ArucasTypes.COMMENT)) {
			return COMMENT_KEYS;
		}
		if (tokenType.equals(ArucasTypes.STRING)) {
			return STRING_KEYS;
		}
		if (tokenType.equals(ArucasTypes.NUMBER)) {
			return NUMBER_KEYS;
		}
		if (tokenType.equals(TokenType.BAD_CHARACTER)) {
			return BAD_CHAR_KEYS;
		}
		if (DELIMITERS.contains(tokenType)) {
			return DELIMITER_KEYS;
		}
		if (KEYWORDS.contains(tokenType)) {
			return KEYWORD_KEYS;
		}
		if (VALUE_KEYWORDS.contains(tokenType)) {
			return KEYWORD_KEYS;
		}
		return EMPTY_KEYS;
	}
}
