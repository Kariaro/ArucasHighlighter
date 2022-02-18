package me.hardcoded.arucas.language;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import me.hardcoded.arucas.psi.ArucasClassDeclaration;
import me.hardcoded.arucas.psi.ArucasFile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArucasUtil {
	public static List<ArucasClassDeclaration> findClasses(Project project, String key) {
		List<ArucasClassDeclaration> result = new ArrayList<>();
		Collection<VirtualFile> virtualFiles =
			FileTypeIndex.getFiles(ArucasFileType.INSTANCE, GlobalSearchScope.allScope(project));
		for (VirtualFile virtualFile : virtualFiles) {
			ArucasFile simpleFile = (ArucasFile) PsiManager.getInstance(project).findFile(virtualFile);
			if (simpleFile != null) {
				ArucasClassDeclaration[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, ArucasClassDeclaration.class);
				if (properties != null) {
					for (ArucasClassDeclaration property : properties) {
						if (key.equals(property.getClassName().getIdentifier().getText())) {
							result.add(property);
						}
					}
				}
			}
		}
		return result;
	}
	
	public static List<ArucasClassDeclaration> findClasses(Project project) {
		List<ArucasClassDeclaration> result = new ArrayList<>();
		Collection<VirtualFile> virtualFiles =
			FileTypeIndex.getFiles(ArucasFileType.INSTANCE, GlobalSearchScope.allScope(project));
		for (VirtualFile virtualFile : virtualFiles) {
			ArucasFile simpleFile = (ArucasFile) PsiManager.getInstance(project).findFile(virtualFile);
			if (simpleFile != null) {
				ArucasClassDeclaration[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, ArucasClassDeclaration.class);
				if (properties != null) {
					Collections.addAll(result, properties);
				}
			}
		}
		return result;
	}
}
