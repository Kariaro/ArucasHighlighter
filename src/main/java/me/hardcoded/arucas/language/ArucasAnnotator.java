package me.hardcoded.arucas.language;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import me.hardcoded.arucas.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ArucasAnnotator implements Annotator {
	
	@Override
	public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
		if (element instanceof ArucasClassDeclaration) {
			validateClass((ArucasClassDeclaration)element, holder);
		}
		
		if (element instanceof ArucasFunctionStatement) {
			validateFunction((ArucasFunctionStatement)element, holder);
		}
		
		if (element instanceof ArucasAtom) {
			validateAtom((ArucasAtom)element, holder);
		}
		
		if (element instanceof ArucasSwitchStatement) {
			validateSwitch((ArucasSwitchStatement)element, holder);
		}
		
		if (element instanceof ArucasBreakStatement) {
			validateBreak((ArucasBreakStatement)element, holder);
		}
		
		if (element instanceof ArucasContinueStatement) {
			validateContinue((ArucasContinueStatement)element, holder);
		}
	}
	
	private void validateContinue(ArucasContinueStatement continueStatement, AnnotationHolder holder) {
		if (!canUseContinue(continueStatement)) {
			holder.newAnnotation(HighlightSeverity.ERROR, "'continue' is not allowed outside loops")
				.range(continueStatement.getTextRange())
				.create();
		}
	}
	
	private void validateBreak(ArucasBreakStatement breakStatement, AnnotationHolder holder) {
		if (!canUseBreak(breakStatement)) {
			holder.newAnnotation(HighlightSeverity.ERROR, "'break' is not allowed outside loops and switch cases")
				.range(breakStatement.getTextRange())
				.create();
		}
	}
	
	private void validateSwitch(ArucasSwitchStatement switchStatement, AnnotationHolder holder) {
		List<ArucasCaseStatement> cases = switchStatement.getSwitchCodeBlock().getCaseStatementList();
		boolean hasDefault = false;
		int valueType = 0;
		
		Set<String> values = new HashSet<>();
		
		for (ArucasCaseStatement caseStatement : cases) {
			ArucasCaseValues caseValues = caseStatement.getCaseValues();
			if (caseValues == null) {
				if (hasDefault) {
					holder.newAnnotation(HighlightSeverity.ERROR, "A switch statement cannot contain multiple default cases")
						.range(caseStatement.getFirstChild().getTextRange())
						.create();
				}
				
				hasDefault = true;
			} else {
				List<ArucasCaseValue> listValues = caseValues.getCaseValueList();
				if (valueType == 0) {
					ArucasCaseValue first = listValues.get(0);
					valueType = ((first.getNumber() != null) ? 2 : 0) +
							    ((first.getString() != null) ? 1 : 0);
				}
				
				for (ArucasCaseValue value : listValues) {
					int caseType = ((value.getNumber() != null) ? 2 : 0) +
								   ((value.getString() != null) ? 1 : 0);
					
					PsiElement element = value.getNumber() == null
						? value.getString()
						: value.getNumber();
					
					if (valueType != caseType) {
						holder.newAnnotation(HighlightSeverity.ERROR, "A switch cannot mix value types")
							.range(element.getTextRange())
							.create();
					} else {
						String text = element.getText();
						if (valueType == 1) {
							text = text.substring(1, text.length() - 1);
						}
						
						if (!values.add(text)) {
							holder.newAnnotation(HighlightSeverity.ERROR, "Duplicate case value")
								.range(element.getTextRange())
								.create();
						}
					}
				}
			}
		}
	}
	
	/**
	 * Used to validate when 'this' is allowed to be used
	 */
	private void validateAtom(ArucasAtom atom, AnnotationHolder holder) {
		PsiElement valueKeyword = atom.getValueKeyword();
		
		if (valueKeyword != null && "this".equals(valueKeyword.getText())) {
			if (!canUseThis(atom)) {
				holder.newAnnotation(HighlightSeverity.ERROR, "'this' is not allowed in a non class context")
					.range(atom.getTextRange())
					.create();
			}
		}
	}
	
	private void validateFunction(ArucasFunctionStatement function, AnnotationHolder holder) {
		ArucasArguments arguments = function.getArguments();
		validateArguments(arguments, holder);
		
		// TODO: Make sure no function with this name has already been created
	}
	
	private void validateClass(ArucasClassDeclaration arucasClass, AnnotationHolder holder) {
		ArucasClassCodeBlock codeBlock = arucasClass.getClassCodeBlock();
		
		/* Constructors */ {
			String className = arucasClass.getIdentifier().getText();
			Set<Integer> argumentCount = new HashSet<>();
			
			for (ArucasClassConstructor constructor : codeBlock.getClassConstructorList()) {
				ArucasArguments arguments = constructor.getArguments();
				int parameters = getNumberOfArguments(arguments);
				
				if (!className.equals(constructor.getIdentifier().getText())) {
					holder.newAnnotation(HighlightSeverity.ERROR, "Constructor name is different from class name")
						.range(constructor.getIdentifier().getTextRange())
						.create();
				}
				
				if (!argumentCount.add(parameters)) {
					holder.newAnnotation(HighlightSeverity.ERROR, "A constructor with " + getParameterString(parameters) + " has already been defined")
						.range(constructor.getIdentifier().getTextRange())
						.create();
				}
				
				validateArguments(arguments, holder);
			}
		}
		
		/* Methods */ {
			Map<String, Set<Integer>> staticMethods = new HashMap<>();
			Map<String, Set<Integer>> methods = new HashMap<>();
			
			for (ArucasClassMethod method : codeBlock.getClassMethodList()) {
				boolean isStatic = method.getStaticModifier() != null;
				
				String name = method.getIdentifier().getText();
				Set<Integer> argumentCount = (isStatic ? staticMethods : methods)
					.computeIfAbsent(name, v -> new HashSet<>());
				
				ArucasArguments arguments = method.getArguments();
				int parameters = getNumberOfArguments(arguments);
				
				if (!argumentCount.add(parameters)) {
					holder.newAnnotation(HighlightSeverity.ERROR, "A " + (isStatic ? "static" : "") + " method with " + getParameterString(parameters) + " has already been defined")
						.range(method.getIdentifier().getTextRange())
						.create();
				}
				
				validateArguments(arguments, holder);
			}
		}
		
		/* Members */ {
			Set<String> members = new HashSet<>();
			
			for (ArucasClassMember member : codeBlock.getClassMemberList()) {
				String name = member.getIdentifier().getText();
				
				if (!members.add(name)) {
					holder.newAnnotation(HighlightSeverity.ERROR, "A member the name '" + name + "' has already been defined")
						.range(member.getIdentifier().getTextRange())
						.create();
				}
			}
		}
		
		/* Operators */ {
			// TODO: Implement operator overload checking and size checking
			//       some operators only have a set amount of parameters
		}
	}
	
	private void validateArguments(@Nullable ArucasArguments arguments, AnnotationHolder holder) {
		if (arguments != null) {
			Set<String> names = new HashSet<>();
			for (ArucasArgument argument : arguments.getArgumentList()) {
				String name = argument.getIdentifier().getText();
				if (!names.add(name)) {
					holder.newAnnotation(HighlightSeverity.ERROR, "A parameter with the name '" + name + "' already exists")
						.range(argument.getIdentifier().getTextRange())
						.create();
				}
			}
		}
	}
	
	private static int getNumberOfArguments(@Nullable ArucasArguments arguments) {
		return arguments == null ? 0 : arguments.getArgumentList().size();
	}
	
	private static String getParameterString(int count) {
		return count == 1 ? "1 parameter" : (count + " parameters");
	}
	
	private static boolean canUseContinue(PsiElement element) {
		while (element != null) {
			PsiElement parent = element.getParent();
			
			// Functions and lambdas cannot use 'continue'
			if (parent instanceof ArucasFunctionLambda
			|| parent instanceof ArucasFunctionStatement
			|| parent instanceof ArucasClassOperator
			|| parent instanceof ArucasClassConstructor) {
				return false;
			}
			
			// Loops can use 'continue'
			if (parent instanceof ArucasForEachStatement
			|| parent instanceof ArucasForStatement
			|| parent instanceof ArucasWhileStatement) {
				return true;
			}
			
			element = parent;
		}
		
		return false;
	}
	
	private static boolean canUseBreak(PsiElement element) {
		while (element != null) {
			PsiElement parent = element.getParent();
			
			// Functions and lambdas cannot use 'break'
			if (parent instanceof ArucasFunctionLambda
			|| parent instanceof ArucasFunctionStatement
			|| parent instanceof ArucasClassOperator
			|| parent instanceof ArucasClassConstructor) {
				return false;
			}
			
			// Loops and switch cases can use 'break'
			if (parent instanceof ArucasSwitchStatement
			|| parent instanceof ArucasForEachStatement
			|| parent instanceof ArucasForStatement
			|| parent instanceof ArucasWhileStatement) {
				return true;
			}
			
			element = parent;
		}
		
		return false;
	}
	
	private static boolean canUseThis(PsiElement element) {
		while (element != null) {
			PsiElement parent = element.getParent();
			
			// Functions and lambdas cannot access 'this'
			if (parent instanceof ArucasFunctionLambda
			|| parent instanceof ArucasFunctionStatement) {
				return false;
			}
			
			// Constructors and operators can always access 'this'
			if (parent instanceof ArucasClassOperator
			|| parent instanceof ArucasClassConstructor) {
				return true;
			}
			
			// Static methods cannot access 'this'
			if (parent instanceof ArucasClassMethod) {
				return ((ArucasClassMethod)parent).getStaticModifier() == null;
			}
			
			element = parent;
		}
		
		return false;
	}
}
