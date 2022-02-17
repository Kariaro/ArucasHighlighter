package me.hardcoded.arucas.language;

import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.jetbrains.annotations.NotNull;

public abstract class ArucasPlatformTestBase extends BasePlatformTestCase {
	
	public ArucasPlatformTestBase() {
		try {
			this.setUp();
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}
	
	@NotNull
	@Override
	protected String getTestDataPath() {
		return "src/test/testData/";
	}
}
