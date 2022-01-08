package me.hardcoded.arucas.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ArucasFileType extends LanguageFileType {
	public static final ArucasFileType INSTANCE = new ArucasFileType();
	
	private ArucasFileType() {
		super(ArucasLanguage.INSTANCE);
	}
	
	@NotNull
	@Override
	public String getName() {
		return "Arucas File";
	}
	
	@NotNull
	@Override
	public String getDescription() {
		return "Arucas language file";
	}
	
	@NotNull
	@Override
	public String getDefaultExtension() {
		return "arucas";
	}
	
	@Nullable
	@Override
	public Icon getIcon() {
		return ArucasIcons.FILE;
	}
}
