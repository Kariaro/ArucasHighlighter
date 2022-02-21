package me.hardcoded.arucas.language.annotator;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.psi.PsiElement;
import me.hardcoded.arucas.language.color.ArucasHighlightingColors;
import me.hardcoded.arucas.psi.*;
import org.jetbrains.annotations.NotNull;

public class ArucasSemanticAnnotator implements Annotator {
	@Override
	public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
		if (element instanceof ArucasClassDeclaration) {
			annotateClassName(((ArucasClassDeclaration)element).getClassName(), holder);
		}
		
		if (element instanceof ArucasNewExpression) {
			annotateClassName(((ArucasNewExpression)element).getClassName(), holder);
		}

		if (element instanceof ArucasClassConstructor) {
			annotateFunctionName(((ArucasClassConstructor)element).getFunctionName(), holder);
		}

		if (element instanceof ArucasClassMethod) {
			annotateFunctionName(((ArucasClassMethod)element).getFunctionName(), holder);
		}

		if (element instanceof ArucasFunctionStatement) {
			annotateFunctionName(((ArucasFunctionStatement)element).getFunctionName(), holder);
		}
		
		if (element instanceof ArucasClassMember) {
			annotateVariableName(((ArucasClassMember)element).getVariableName(), holder);
		}

		if (element instanceof ArucasCallExpression) {
			annotateCallExpression((ArucasCallExpression)element, holder);
		}
	}
	
	private ArucasIdentifierName getCallIdentifier(ArucasExpression parent) {
		if (parent instanceof ArucasMemberExpression) {
			ArucasMemberExpression expr = (ArucasMemberExpression)parent;
			return getCallIdentifier(expr.getRight());
		}
		
		if (parent instanceof ArucasAtomExpression) {
			ArucasAtomExpression expr = (ArucasAtomExpression)parent;
			return expr.getIdentifierName();
		}
		
		return null;
	}
	
	private void annotateCallExpression(ArucasCallExpression expr, AnnotationHolder holder) {
		ArucasIdentifierName identifier = getCallIdentifier(expr.getExpression());
		
		if (identifier != null) {
			holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(identifier)
				.enforcedTextAttributes(TextAttributes.ERASE_MARKER)
				.create();
			
			holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(identifier)
				.textAttributes(ArucasHighlightingColors.FUNCTION_CALL)
				.create();
		}
	}
	
//	private void annotateClassDeclaration(ArucasClassDeclaration element, AnnotationHolder holder) {
//		ArucasIdentifierName identifier = element.getIdentifierName();
//		holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(identifier)
//			.textAttributes(ArucasHighlightingColors.METHOD_NAME)
//			.create();
//	}
	
	private void annotateClassName(ArucasClassName name, AnnotationHolder holder) {
		holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(name)
			.enforcedTextAttributes(TextAttributes.ERASE_MARKER)
			.create();
		holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(name)
			.textAttributes(ArucasHighlightingColors.CLASS_NAME)
			.create();
	}
	
	private void annotateFunctionName(ArucasFunctionName name, AnnotationHolder holder) {
		holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(name)
			.enforcedTextAttributes(TextAttributes.ERASE_MARKER)
			.create();
		holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(name)
			.textAttributes(ArucasHighlightingColors.FUNCTION_NAME)
			.create();
	}
	
	private void annotateVariableName(ArucasVariableName name, AnnotationHolder holder) {
		holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(name)
			.enforcedTextAttributes(TextAttributes.ERASE_MARKER)
			.create();
		holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(name)
			.textAttributes(ArucasHighlightingColors.VARIABLE_NAME)
			.create();
	}
	
	private void annotateName(ArucasName name, AnnotationHolder holder) {
		holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(name)
			.enforcedTextAttributes(TextAttributes.ERASE_MARKER)
			.create();
		holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(name)
			.textAttributes(ArucasHighlightingColors.FUNCTION_NAME)
			.create();
	}
}
