package me.hardcoded.arucas.language.refactor;

import com.intellij.formatting.Indent;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.TokenType;
import me.hardcoded.arucas.language.ArucasReference;
import me.hardcoded.arucas.language.formatting.ArucasBlock;
import me.hardcoded.arucas.psi.*;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.ast.IfStatement;

import java.beans.Expression;
import java.util.List;

public class ArucasReferenceResolver {
	public static void resolve(String name, List<PsiReference> references, PsiElement element) {
		// Calculate the local root scope
		PsiElement scopeRoot = getScopeRoot(element);
		System.out.println(name + ", " + element);
		System.out.println("root: " + scopeRoot);
		// TODO: We will solve this differently if the element is inside the root scope
		
		// TODO: Traverse upwards from this element and get all the references
		// Look for the reference in the root scope and if it's not defined we stop at the furthest we can reach.
		
		boolean isRoot = scopeRoot instanceof ArucasFile;
		resolveElement(name, isRoot, scopeRoot, references);
		
		System.out.println("------------------------");
	}
	
	private static PsiElement getScopeRoot(PsiElement element) {
		if (element instanceof ArucasFile
		|| element instanceof ArucasFunctionStatement
		|| element instanceof ArucasFunctionLambda
		|| element instanceof ArucasClassDeclaration
		|| element instanceof ArucasClassMethod
		|| element instanceof ArucasClassOperator
		|| element instanceof ArucasClassConstructor) {
			return element;
		}
		
		PsiElement parent = element.getParent();
		return parent == null ? element : getScopeRoot(parent);
	}
	
//	public static void resolveAllElements(String name, boolean isRoot, PsiElement element, List<PsiReference> references) {
//		for (PsiElement child = element.getFirstChild(); child != null; child = child.getNextSibling()) {
//			resolveElement(name, isRoot, element, references);
//		}
//	}
	
	public static void resolveElement(String name, boolean isRoot, PsiElement element, List<PsiReference> references) {
		if (element == null) {
			return;
		}
		
		if (element instanceof ArucasIdentifierName) {
			ArucasIdentifierName ident = (ArucasIdentifierName)element;
			String identName = ident.getText();
			
			System.out.println(element + ", " + identName + ", " + name);
			if (name.equals(identName)) {
				System.out.println("Match!");
				references.add(new ArucasReference(ident.getIdentifier(), ident.getTextRange()));
			}
			
			return;
		}
		
		if (element instanceof ArucasExpression) {
//			if (element instanceof ArucasMemberExpression) {
//				// TODO: Allow this only for the first item
//				// TODO: Allow member expressions
//				return;
//			}
			
			ArucasExpression expr = (ArucasExpression)element;
			for (ArucasExpression e : expr.getExpressionList()) {
				resolveElement(name, isRoot, e, references);
			}
			
			if (expr instanceof ArucasFunctionLambda) {
				// TODO: IsRoot
			}
			
			return;
		}
		
		{
			if (element instanceof ArucasClassConstructor) {
				ArucasClassConstructor stat = (ArucasClassConstructor)element;
				for (ArucasArgument argument : stat.getArguments().getArgumentList()) {
					resolveElement(name, isRoot, argument.getIdentifierName(), references);
				}
				
				resolveElement(name, isRoot, stat.getCodeBlock(), references);
				return;
			}
			
			if (element instanceof ArucasClassMethod) {
				// TODO: If the method is static we should not be able to modify it
				ArucasClassMethod stat = (ArucasClassMethod)element;
				for (ArucasArgument argument : stat.getArguments().getArgumentList()) {
					resolveElement(name, isRoot, argument.getIdentifierName(), references);
				}
				
				resolveElement(name, isRoot, stat.getCodeBlock(), references);
				return;
			}
			
			if (element instanceof ArucasClassOperator) {
				// TODO: If the method is static we should not be able to modify it
				ArucasClassOperator stat = (ArucasClassOperator)element;
				for (ArucasArgument argument : stat.getOperatorArguments().getArguments().getArgumentList()) {
					resolveElement(name, isRoot, argument.getIdentifierName(), references);
				}
				
				resolveElement(name, isRoot, stat.getCodeBlock(), references);
				return;
			}
			
			if (element instanceof ArucasClassDeclaration) {
			
			}
		}
		
		if (element instanceof ArucasCodeBlock) {
			ArucasCodeBlock codeBlock = (ArucasCodeBlock)element;
			for (ArucasStatement stat : codeBlock.getStatementList()) {
				resolveElement(name, isRoot, stat, references);
			}
			
			return;
		}
		
		if (element instanceof ArucasStatement) {
			if (element instanceof ArucasForEachStatement) {
				ArucasForEachStatement stat = (ArucasForEachStatement)element;
				resolveElement(name, isRoot, stat.getIdentifierName(), references);
//				resolveElement(name, isRoot, stat.getExpressionList(), references);
				resolveElement(name, isRoot, stat.getStatement(), references);
			}
			
			if (element instanceof ArucasForStatement) {
				ArucasForStatement stat = (ArucasForStatement)element;
				for (ArucasExpression e : stat.getExpressionList()) {
					resolveElement(name, isRoot, e, references);
				}
				resolveElement(name, isRoot, stat.getStatement(), references);
			}
			
			if (element instanceof ArucasWhileStatement) {
				ArucasWhileStatement stat = (ArucasWhileStatement)element;
				resolveElement(name, isRoot, stat.getExpression(), references);
				resolveElement(name, isRoot, stat.getStatement(), references);
			}
			
			if (element instanceof ArucasIfStatement) {
				ArucasIfStatement stat = (ArucasIfStatement)element;
				resolveElement(name, isRoot, stat.getExpression(), references);
				for (ArucasStatement s : stat.getStatementList()) {
					resolveElement(name, isRoot, s, references);
				}
			}
			
			if (element instanceof ArucasTryStatement) {
				ArucasTryStatement stat = (ArucasTryStatement)element;
				resolveElement(name, isRoot, stat.getIdentifierName(), references);
				for(ArucasStatement s : stat.getStatementList()) {
					resolveElement(name, isRoot, s, references);
				}
			}
			
			return;
		}
	}
}
