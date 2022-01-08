package me.hardcoded.arucas.language.formatting;

import com.intellij.formatting.*;
import com.intellij.psi.TokenType;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import me.hardcoded.arucas.language.ArucasLanguage;
import me.hardcoded.arucas.psi.ArucasTypes;
import org.jetbrains.annotations.NotNull;

public class ArucasFormattingModelBuilder implements FormattingModelBuilder {
	private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
		return new SpacingBuilder(settings, ArucasLanguage.INSTANCE)
			.around(ArucasTypes.ASSIGNMENT)
			.spaceIf(settings.getCommonSettings(ArucasLanguage.INSTANCE.getID()).SPACE_AROUND_ASSIGNMENT_OPERATORS)
			.around(ArucasTypes.ASSIGNMENT)
			.none();
	}
	
	@NotNull
	@Override
	public FormattingModel createModel(@NotNull FormattingContext formattingContext) {
		final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
		return FormattingModelProvider
			.createFormattingModelForPsiFile(formattingContext.getContainingFile(),
				new ArucasBlock(formattingContext.getNode(),
					createSpaceBuilder(codeStyleSettings)
				),
				codeStyleSettings
			);
	}
}
