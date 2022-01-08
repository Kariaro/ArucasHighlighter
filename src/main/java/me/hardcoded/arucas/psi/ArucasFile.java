package me.hardcoded.arucas.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import me.hardcoded.arucas.language.ArucasFileType;
import me.hardcoded.arucas.language.ArucasLanguage;
import org.jetbrains.annotations.NotNull;

public class ArucasFile extends PsiFileBase  {
	public ArucasFile(FileViewProvider viewProvider) {
		super(viewProvider, ArucasLanguage.INSTANCE);
	}
	
	@NotNull
	@Override
	public FileType getFileType() {
		return ArucasFileType.INSTANCE;
	}
	
	@NotNull
	@Override
	public String toString() {
		return "Arucas File";
	}
}
