//package me.hardcoded.arucas.language.refactor;
//
//import com.intellij.psi.PsiElement;
//import com.intellij.psi.PsiReference;
//import me.hardcoded.arucas.language.ArucasReference;
//import me.hardcoded.arucas.psi.*;
//import java.util.List;
//
//public class ArucasReferenceResolver {
//	public static void resolve(String name, List<PsiReference> references, PsiElement element) {
//		// Calculate the local root scope
////		PsiElement scopeRoot = getScopeRoot(element);
//
//		// TODO: We will solve this differently if the element is inside the root scope
//		// TODO: Traverse upwards from this element and get all the references
//		// Look for the reference in the root scope and if it's not defined we stop at the furthest we can reach
//
////		boolean isRoot = scopeRoot instanceof ArucasFile;
////		resolveElement(name, isRoot, scopeRoot, references);
////
////		System.out.println(name + ", " + element);
////		System.out.println("root: " + scopeRoot);
////		System.out.println("------------------------");
//	}
//
//	private static PsiElement getScopeRoot(PsiElement element) {
//		if (element instanceof ArucasFile
//		|| element instanceof ArucasFunctionStatement
//		|| element instanceof ArucasLambdaExpression
//		|| element instanceof ArucasClassDeclaration
//		|| element instanceof ArucasClassMethod
//		|| element instanceof ArucasClassOperator
//		|| element instanceof ArucasClassConstructor) {
//			return element;
//		}
//
//		PsiElement parent = element.getParent();
//		return parent == null ? element : getScopeRoot(parent);
//	}
//
//	private static void resolveIdentifier(String name, boolean isRoot, ArucasIdentifierName id, List<PsiReference> references) {
//		if (id != null && name.equals(id.getText())) {
//			System.out.println(id + ", " + name);
//			references.add(new ArucasReference(id.getIdentifier(), id.getTextRange()));
//		}
//	}
//
//	private static void resolveExpression(String name, boolean isRoot, ArucasExpression expr, List<PsiReference> references) {
//		if (expr instanceof ArucasAssignExpression) {
//			ArucasAssignExpression e = (ArucasAssignExpression)expr;
//			resolveIdentifier(name, isRoot, e.getIdentifierName(), references);
//			resolveExpression(name, isRoot, e.getExpression(), references);
//		} else if (expr instanceof ArucasConditionalOrExpression) {
//			for (ArucasExpression e : ((ArucasConditionalOrExpression)expr).getExpressionList()) {
//				resolveExpression(name, isRoot, e, references);
//			}
//		} else if (expr instanceof ArucasConditionalAndExpression) {
//			for (ArucasExpression e : ((ArucasConditionalAndExpression)expr).getExpressionList()) {
//				resolveExpression(name, isRoot, e, references);
//			}
//		} else if (expr instanceof ArucasUnaryNotExpression) {
//			resolveExpression(name, isRoot, ((ArucasUnaryNotExpression)expr).getExpression(), references);
//		} else if (expr instanceof ArucasRelationalExpression) {
//			for (ArucasExpression e : ((ArucasRelationalExpression)expr).getExpressionList()) {
//				resolveExpression(name, isRoot, e, references);
//			}
//		} else if (expr instanceof ArucasArithmeticExpression) {
//			for (ArucasExpression e : ((ArucasArithmeticExpression)expr).getExpressionList()) {
//				resolveExpression(name, isRoot, e, references);
//			}
//		} else if (expr instanceof ArucasFactorExpression) {
//			for (ArucasExpression e : ((ArucasFactorExpression)expr).getExpressionList()) {
//				resolveExpression(name, isRoot, e, references);
//			}
//		} else if (expr instanceof ArucasUnaryExpression) {
//			resolveExpression(name, isRoot, ((ArucasUnaryExpression)expr).getExpression(), references);
//		} else if (expr instanceof ArucasPowerExpression) {
//			for (ArucasExpression e : ((ArucasPowerExpression)expr).getExpressionList()) {
//				resolveExpression(name, isRoot, e, references);
//			}
//		} else if (expr instanceof ArucasCallExpression) {
//			ArucasCallExpression e = (ArucasCallExpression)expr;
//			resolveExpression(name, isRoot, e.getExpression(), references);
//			for (ArucasExpression arg : e.getCallArguments().getExpressionList()) {
//				resolveExpression(name, isRoot, arg, references);
//			}
//		} else if (expr instanceof ArucasMemberExpression) {
//			// TODO: Allow this only for the first item
//			// TODO: Allow member expressions
//			for (ArucasExpression e : ((ArucasMemberExpression)expr).getExpressionList()) {
//				resolveExpression(name, isRoot, e, references);
//			}
//		} else if (expr instanceof ArucasLambdaExpression) {
//			// TODO: Is root
////			ArucasLambdaExpression e = (ArucasLambdaExpression)expr;
////			resolveExpression(name, isRoot, e.getExpression(), references);
////			for (ArucasExpression arg : e.getCallArguments().getExpressionList()) {
////				resolveExpression(name, isRoot, arg, references);
////			}
//		} else if (expr instanceof ArucasNewExpression) {
//			ArucasNewExpression e = (ArucasNewExpression)expr;
//			resolveIdentifier(name, isRoot, e.getIdentifierName(), references);
//			for (ArucasExpression arg : e.getCallArguments().getExpressionList()) {
//				resolveExpression(name, isRoot, arg, references);
//			}
//		} else if (expr instanceof ArucasListExpression) {
//			for (ArucasExpression e : ((ArucasListExpression)expr).getExpressionList()) {
//				resolveExpression(name, isRoot, e, references);
//			}
//		} else if (expr instanceof ArucasMapExpression) {
//			for (ArucasMapEntry e : ((ArucasMapExpression)expr).getMapEntryList()) {
//				resolveExpression(name, isRoot, e.getKey(), references);
//				resolveExpression(name, isRoot, e.getValue(), references);
//			}
//		} else if (expr instanceof ArucasParenthesesExpression) {
//			resolveExpression(name, isRoot, ((ArucasParenthesesExpression)expr).getExpression(), references);
//		} else if (expr instanceof ArucasAtomExpression) {
//			ArucasAtomExpression e = (ArucasAtomExpression)expr;
//			resolveIdentifier(name, isRoot, e.getIdentifierName(), references);
//		}
//	}
//
//	public static void resolveElement(String name, boolean isRoot, PsiElement element, List<PsiReference> references) {
//		if (element == null) {
//			return;
//		}
//
////		{
////			String elmText = element.getText().replaceAll("[\r\n][\t ]*", " ");
////			if (elmText.length() > 200) {
////				elmText = elmText.substring(0, 200);
////			}
////			System.out.printf("%-60s%s\n", element, elmText);
////		}
//
//		if (element instanceof ArucasIdentifierName) {
//			resolveIdentifier(name, isRoot, (ArucasIdentifierName)element, references);
//			return;
//		}
//
//		if (element instanceof ArucasExpression) {
//			resolveExpression(name, isRoot, (ArucasExpression)element, references);
//			return;
//		} else if (element instanceof ArucasExpressionStatement) {
//			resolveExpression(name, isRoot, ((ArucasExpressionStatement)element).getExpression(), references);
//		} else if (element instanceof ArucasCodeBlock) {
//			for (ArucasStatement stat : ((ArucasCodeBlock)element).getStatementList()) {
//				resolveElement(name, isRoot, stat, references);
//			}
//			return;
//		} else {
//			if (element instanceof ArucasClassConstructor) {
//				ArucasClassConstructor stat = (ArucasClassConstructor)element;
//				for (ArucasArgument argument : stat.getArguments().getArgumentList()) {
//					resolveElement(name, isRoot, argument.getIdentifierName(), references);
//				}
//
//				resolveElement(name, isRoot, stat.getCodeBlock(), references);
//				return;
//			}
//
//			if (element instanceof ArucasClassMethod) {
//				// TODO: If the method is static we should not be able to modify it
//				ArucasClassMethod stat = (ArucasClassMethod)element;
//				for (ArucasArgument argument : stat.getArguments().getArgumentList()) {
//					resolveElement(name, isRoot, argument.getIdentifierName(), references);
//				}
//
//				resolveElement(name, isRoot, stat.getCodeBlock(), references);
//				return;
//			}
//
//			if (element instanceof ArucasClassOperator) {
//				// TODO: If the method is static we should not be able to modify it
//				ArucasClassOperator stat = (ArucasClassOperator)element;
//				for (ArucasArgument argument : stat.getOperatorArguments().getArguments().getArgumentList()) {
//					resolveElement(name, isRoot, argument.getIdentifierName(), references);
//				}
//
//				resolveElement(name, isRoot, stat.getCodeBlock(), references);
//				return;
//			}
//
//			if (element instanceof ArucasClassDeclaration) {
//
//			}
//		}
//
//		if (element instanceof ArucasStatement) {
//			if (element instanceof ArucasForEachStatement) {
//				ArucasForEachStatement stat = (ArucasForEachStatement)element;
//				resolveElement(name, isRoot, stat.getIdentifierName(), references);
////				resolveElement(name, isRoot, stat.getExpressionList(), references);
//				resolveElement(name, isRoot, stat.getStatement(), references);
//			}
//
//			if (element instanceof ArucasForStatement) {
//				ArucasForStatement stat = (ArucasForStatement)element;
//				for (ArucasExpression e : stat.getExpressionList()) {
//					resolveElement(name, isRoot, e, references);
//				}
//				resolveElement(name, isRoot, stat.getStatement(), references);
//			}
//
//			if (element instanceof ArucasWhileStatement) {
//				ArucasWhileStatement stat = (ArucasWhileStatement)element;
//				resolveElement(name, isRoot, stat.getExpression(), references);
//				resolveElement(name, isRoot, stat.getStatement(), references);
//			}
//
//			if (element instanceof ArucasIfStatement) {
//				ArucasIfStatement stat = (ArucasIfStatement)element;
//				resolveElement(name, isRoot, stat.getExpression(), references);
//				resolveElement(name, isRoot, stat.getStatement(), references);
//				resolveElement(name, isRoot, stat.getElseStatement(), references);
//			}
//
//			if (element instanceof ArucasTryStatement) {
//				ArucasTryStatement stat = (ArucasTryStatement)element;
//				resolveElement(name, isRoot, stat.getIdentifierName(), references);
//				for(ArucasStatement s : stat.getStatementList()) {
//					resolveElement(name, isRoot, s, references);
//				}
//			}
//		}
//	}
//}
