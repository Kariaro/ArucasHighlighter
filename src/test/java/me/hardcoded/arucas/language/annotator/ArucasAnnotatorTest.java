package me.hardcoded.arucas.language.annotator;

import me.hardcoded.arucas.language.ArucasPlatformTestBase;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

public class ArucasAnnotatorTest extends ArucasPlatformTestBase {
	@NotNull
	@Override
	public String getDirectory() {
		return "annotator";
	}
	
	@Test
	public void testAnnotator() {
		myFixture.configureByFiles(
			"test_class.arucas",
			"test_keywords.arucas"
		);
		myFixture.checkHighlighting();
	}
}
