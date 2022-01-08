package me.hardcoded.arucas.language;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.psi.PsiElement;
import me.hardcoded.arucas.psi.ArucasAtom;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class ArucasLineMarkerProvider extends RelatedItemLineMarkerProvider {
	@Override
	protected void collectNavigationMarkers(@NotNull PsiElement element,
											@NotNull Collection<? super RelatedItemLineMarkerInfo<?>> result) {
		if (element instanceof ArucasAtom) {
			ArucasAtom atom = (ArucasAtom)element;
			
			if (atom.getIdentifier() != null) {
				// We found an identifier
				
				// If the parent is an atom we know that we
			}
		}
	}
}
