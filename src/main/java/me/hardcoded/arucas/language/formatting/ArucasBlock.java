package me.hardcoded.arucas.language.formatting;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.*;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import me.hardcoded.arucas.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ArucasBlock extends AbstractBlock {
	private final SpacingBuilder spacingBuilder;
	private final Indent indent;
	
	protected ArucasBlock(@NotNull ASTNode node,
						  Indent indent,
						  SpacingBuilder spacingBuilder) {
		super(node, null, null);
		this.spacingBuilder = spacingBuilder;
		this.indent = indent;
	}
	
	protected ArucasBlock(@NotNull ASTNode node,
						  SpacingBuilder spacingBuilder) {
		this(node, null, spacingBuilder);
	}
	
	private boolean hasErrors() {
		return PsiTreeUtil.findChildOfType(myNode.getPsi(), PsiErrorElement.class) != null;
	}
	
	@Override
	protected List<Block> buildChildren() {
		if (hasErrors()) {
			return AbstractBlock.EMPTY;
		}
		
		List<Block> blocks = new ArrayList<>();
		
		for (ASTNode child = myNode.getFirstChildNode(); child != null; child = child.getTreeNext()) {
			if (child.getTextRange().getLength() == 0
				|| child.getElementType() == TokenType.WHITE_SPACE) continue;
			
			Indent indent = calcIndent(child);
			blocks.add(new ArucasBlock(
				child,
				indent,
				spacingBuilder
			));
		}
		
		return blocks;
	}
	
	@Override
	public Indent getIndent() {
		return indent;
	}
	
	private Indent calcIndent(ASTNode child) {
		PsiElement parent = myNode.getPsi();
		IElementType type = child.getElementType();
		
		boolean isCodeBlock = (parent instanceof ArucasCodeBlock
							|| parent instanceof ArucasClassCodeBlock
							|| parent instanceof ArucasSwitchCodeBlock
							|| parent instanceof ArucasMapExpression
							|| parent instanceof ArucasListExpression);
		
		// Make sure that the parent is a code block and that the child
		// is not one of '{', '}', '[', ']'
		if (isCodeBlock && type != ArucasTypes.RBRACE && type != ArucasTypes.LBRACE
			&& type != ArucasTypes.RBRACK && type != ArucasTypes.LBRACK) {
			return Indent.getNormalIndent();
		}
		
		return Indent.getNoneIndent();
	}
	
	@Nullable
	@Override
	protected Indent getChildIndent() {
		if (hasErrors()) {
			return null;
		}
		
		PsiElement parent = myNode.getPsi();
		
		boolean isCodeBlock = (parent instanceof ArucasCodeBlock
			|| parent instanceof ArucasClassCodeBlock
			|| parent instanceof ArucasSwitchCodeBlock
			|| parent instanceof ArucasMapExpression
			|| parent instanceof ArucasListExpression);
		
		// Make sure that the parent is a code block and that the child
		// is not one of '{', '}'
		if (isCodeBlock) {
			return Indent.getNormalIndent();
		}
		
		return Indent.getNoneIndent();
	}
	
	@Nullable
	@Override
	public Alignment getAlignment() {
		return null;
	}
	
	@Nullable
	@Override
	public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
		return spacingBuilder.getSpacing(this, child1, child2);
	}

	@Override
	public boolean isLeaf() {
		return myNode.getFirstChildNode() == null;
	}
}
