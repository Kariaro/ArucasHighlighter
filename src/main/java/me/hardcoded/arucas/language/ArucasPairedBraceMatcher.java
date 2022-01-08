package me.hardcoded.arucas.language;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import me.hardcoded.arucas.psi.ArucasTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArucasPairedBraceMatcher implements PairedBraceMatcher {
	private static final BracePair[] PAIRS = {
		new BracePair(ArucasTypes.LBRACK, ArucasTypes.RBRACK, false),
		new BracePair(ArucasTypes.LPAREN, ArucasTypes.RPAREN, false),
		new BracePair(ArucasTypes.LBRACE, ArucasTypes.RBRACE, true),
	};
	
	@Override
	public BracePair @NotNull [] getPairs() {
		return PAIRS;
	}
	
	@Override
	public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
		return true;
	}
	
	@Override
	public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
		return openingBraceOffset;
	}
}
