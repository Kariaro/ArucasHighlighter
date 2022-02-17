package me.hardcoded.arucas.language;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiRecursiveElementWalkingVisitor;
import com.intellij.util.ProcessingContext;
import me.hardcoded.arucas.psi.ArucasIdentifierName;
import me.hardcoded.arucas.psi.ArucasTypes;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ArucasCompletionContributor extends CompletionContributor {
	private static final String[] KEYWORDS = {
		"if", "else", "foreach", "for", "while", "try", "catch",
		"fun", "class", "operator", "new", "static", "var", "switch",
		"case", "default", "return", "break", "continue"
	};
	
	private static final String[] VALUE_KEYWORDS = {
		"true", "false", "this", "null"
	};
	
	public ArucasCompletionContributor() {
		extend(CompletionType.BASIC, PlatformPatterns.psiElement(ArucasTypes.IDENTIFIER),
			new CompletionProvider<CompletionParameters>() {
				public void addCompletions(@NotNull CompletionParameters parameters,
										   @NotNull ProcessingContext context,
										   @NotNull CompletionResultSet resultSet) {
					for (String keyword : KEYWORDS) {
						resultSet.addElement(LookupElementBuilder.create(keyword));
					}
					
					for (String keyword : VALUE_KEYWORDS) {
						resultSet.addElement(LookupElementBuilder.create(keyword));
					}
					
					final Set<String> uniqueStrings = new LinkedHashSet<>();
					parameters.getOriginalFile().accept(new PsiRecursiveElementWalkingVisitor() {
						@Override
						public void visitElement(@NotNull PsiElement element) {
							if (element instanceof ArucasIdentifierName) {
								ArucasIdentifierName name = (ArucasIdentifierName)element;
								uniqueStrings.add(name.getName());
							}
							super.visitElement(element);
						}
					});
					
					for (String name : uniqueStrings) {
						resultSet.addElement(LookupElementBuilder.create(name));
					}
				}
			}
		);
	}
}
