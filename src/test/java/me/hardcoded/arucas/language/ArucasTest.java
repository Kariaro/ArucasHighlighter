package me.hardcoded.arucas.language;

import org.junit.jupiter.api.Test;

public class ArucasTest extends ArucasPlatformTestBase {
	@Test
	public void testAnnotator() {
		myFixture.configureByFiles(
			"annotator/test_class.arucas",
			"annotator/test_keywords.arucas"
		);
		myFixture.checkHighlighting();
	}
	
//	@Test
//	public void testCommenter() {
//		myFixture.configureByText(ArucasFileType.INSTANCE, "<caret>a = 0;");
//		CommentByLineCommentAction commentAction = new CommentByLineCommentAction();
//		commentAction.actionPerformedImpl(getProject(), myFixture.getEditor());
//		myFixture.checkResult("//a = 0;");
//		commentAction.actionPerformedImpl(getProject(), myFixture.getEditor());
//		myFixture.checkResult("a = 0;");
//	}
}
