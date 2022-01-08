package me.hardcoded.arucas.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import me.hardcoded.arucas.psi.ArucasTypes;
import me.hardcoded.arucas.psi.ArucasFile;
import org.jetbrains.annotations.NotNull;

public class ArucasParserDefinition implements ParserDefinition {
	public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
	public static final TokenSet COMMENTS = TokenSet.create(ArucasTypes.COMMENT);
	
	public static final IFileElementType FILE = new IFileElementType(ArucasLanguage.INSTANCE);
	
	@NotNull
	@Override
	public Lexer createLexer(Project project) {
		return new ArucasLexerAdapter();
	}
	
	@NotNull
	@Override
	public TokenSet getWhitespaceTokens() {
		return WHITE_SPACES;
	}
	
	@NotNull
	@Override
	public TokenSet getCommentTokens() {
		return COMMENTS;
	}
	
	@NotNull
	@Override
	public TokenSet getStringLiteralElements() {
		return TokenSet.EMPTY;
	}
	
	@NotNull
	@Override
	public PsiParser createParser(final Project project) {
		return new ArucasParser();
	}
	
	@Override
	public IFileElementType getFileNodeType() {
		return FILE;
	}
	
	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new ArucasFile(viewProvider);
	}
	
	@Override
	public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
		return SpaceRequirements.MAY;
	}
	
	@NotNull
	@Override
	public PsiElement createElement(ASTNode node) {
		return ArucasTypes.Factory.createElement(node);
	}
}
