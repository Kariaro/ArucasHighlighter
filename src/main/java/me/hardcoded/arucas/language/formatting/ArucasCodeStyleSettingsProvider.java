package me.hardcoded.arucas.language.formatting;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.psi.codeStyle.CodeStyleConfigurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import me.hardcoded.arucas.language.ArucasLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArucasCodeStyleSettingsProvider extends CodeStyleSettingsProvider {
	
	@Override
	public CustomCodeStyleSettings createCustomSettings(CodeStyleSettings settings) {
		return new ArucasCodeStyleSettings(settings);
	}
	
	@Nullable
	@Override
	public String getConfigurableDisplayName() {
		return "Arucas";
	}
	
	@NotNull
	public CodeStyleConfigurable createConfigurable(@NotNull CodeStyleSettings settings, @NotNull CodeStyleSettings modelSettings) {
		return new CodeStyleAbstractConfigurable(settings, modelSettings, this.getConfigurableDisplayName()) {
			@Override
			protected CodeStyleAbstractPanel createPanel(CodeStyleSettings settings) {
				return new SimpleCodeStyleMainPanel(getCurrentSettings(), settings);
			}
		};
	}
	
	private static class SimpleCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {
		public SimpleCodeStyleMainPanel(CodeStyleSettings currentSettings, CodeStyleSettings settings) {
			super(ArucasLanguage.INSTANCE, currentSettings, settings);
		}
	}
}