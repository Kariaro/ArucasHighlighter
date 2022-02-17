package me.hardcoded.arucas.language.folding;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import me.hardcoded.arucas.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArucasFoldingBuilder extends FoldingBuilderEx implements DumbAware {
	
	@Override
	public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
		List<FoldingDescriptor> descriptors = new ArrayList<>();
		Collection<PsiElement> elements = PsiTreeUtil.findChildrenOfAnyType(root,
			ArucasClassDeclaration.class,
			ArucasClassCodeBlock.class,
			ArucasLambdaExpression.class,
			ArucasSwitchCodeBlock.class,
			ArucasCodeBlock.class
		);
		
		for (final PsiElement element : elements) {
			/*
			if (element instanceof ArucasCodeBlock) {
				PsiElement parent = element.getParent();
				
				if (!(parent instanceof ArucasClassOperator
				|| parent instanceof ArucasClassMethod
				|| parent instanceof ArucasClassConstructor
				|| parent instanceof ArucasFunctionStatement
				
				|| parent instanceof ArucasIfStatement
				|| parent instanceof ArucasElseStatement
				|| parent instanceof ArucasWhileStatement
				|| parent instanceof ArucasForEachStatement
				|| parent instanceof ArucasForStatement
				|| parent instanceof ArucasTryStatement
				
				|| parent instanceof ArucasLambdaExpression
				|| parent instanceof ArucasCaseStatement)) {
					continue;
				}
			}
			*/
			descriptors.add(new FoldingDescriptor(element.getNode(), element.getTextRange()));
		}
		
		return descriptors.toArray(FoldingDescriptor.EMPTY);
	}
	
	@Nullable
	@Override
	public String getPlaceholderText(@NotNull ASTNode node) {
		return "{...}";
	}
	
	@Override
	public boolean isCollapsedByDefault(@NotNull ASTNode node) {
		return false;
	}
}
