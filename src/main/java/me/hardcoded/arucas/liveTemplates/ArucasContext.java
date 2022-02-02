package me.hardcoded.arucas.liveTemplates;

import com.intellij.codeInsight.template.TemplateActionContext;
import com.intellij.codeInsight.template.TemplateContextType;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import me.hardcoded.arucas.language.ArucasFileType;
import me.hardcoded.arucas.language.ArucasLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArucasContext extends TemplateContextType {
	protected ArucasContext() {
		super("ARUCAS", ArucasLanguage.INSTANCE.getDisplayName());
	}
	
	@Override
	public boolean isInContext(@NotNull TemplateActionContext templateActionContext) {
		return templateActionContext.getFile().getName().endsWith(".arucas");
	}
	
	@Nullable
	@Override
	public SyntaxHighlighter createHighlighter() {
		return SyntaxHighlighterFactory.getSyntaxHighlighter(ArucasFileType.INSTANCE, null, null);
	}
}
