package me.hardcoded.arucas.language;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import me.hardcoded.arucas.psi.ArucasTypes;
import org.jetbrains.annotations.NotNull;

public class ArucasCompletionContributor extends CompletionContributor {
	public ArucasCompletionContributor() {
		// TODO: Figure out how to add code completion
		
//		extend(CompletionType.BASIC, PlatformPatterns.psiElement(ArucasTypes.NUMBER),
//			new CompletionProvider<CompletionParameters>() {
//				public void addCompletions(@NotNull CompletionParameters parameters,
//										   @NotNull ProcessingContext context,
//										   @NotNull CompletionResultSet resultSet) {
//					resultSet.addElement(LookupElementBuilder.create("Hello"));
//				}
//			}
//		);
	}
}
