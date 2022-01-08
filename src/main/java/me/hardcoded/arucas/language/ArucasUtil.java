package me.hardcoded.arucas.language;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import me.hardcoded.arucas.psi.ArucasClassStatement;
import me.hardcoded.arucas.psi.ArucasFile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArucasUtil {
	public static List<ArucasClassStatement> findClasses(Project project, String key) {
		List<ArucasClassStatement> result = new ArrayList<>();
		Collection<VirtualFile> virtualFiles =
			FileTypeIndex.getFiles(ArucasFileType.INSTANCE, GlobalSearchScope.allScope(project));
		for(VirtualFile virtualFile : virtualFiles) {
			ArucasFile simpleFile = (ArucasFile) PsiManager.getInstance(project).findFile(virtualFile);
			if(simpleFile != null) {
				ArucasClassStatement[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, ArucasClassStatement.class);
				if(properties != null) {
					for(ArucasClassStatement property : properties) {
						if(key.equals(property.getIdentifier().getText())) {
							result.add(property);
						}
					}
				}
			}
		}
		return result;
	}
	
	public static List<ArucasClassStatement> findClasses(Project project) {
		List<ArucasClassStatement> result = new ArrayList<>();
		Collection<VirtualFile> virtualFiles =
			FileTypeIndex.getFiles(ArucasFileType.INSTANCE, GlobalSearchScope.allScope(project));
		for(VirtualFile virtualFile : virtualFiles) {
			ArucasFile simpleFile = (ArucasFile) PsiManager.getInstance(project).findFile(virtualFile);
			if(simpleFile != null) {
				ArucasClassStatement[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, ArucasClassStatement.class);
				if(properties != null) {
					Collections.addAll(result, properties);
				}
			}
		}
		return result;
	}
}
