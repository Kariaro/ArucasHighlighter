package me.hardcoded.arucas.language.color;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import me.hardcoded.arucas.language.ArucasIcons;
import me.hardcoded.arucas.language.ArucasSyntaxHighlighter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class ArucasColorSettingsPage implements ColorSettingsPage {
	private static final AttributesDescriptor[] DESCRIPTORS = {
		new AttributesDescriptor("String", ArucasSyntaxHighlighter.STRING),
		new AttributesDescriptor("Delimiter", ArucasSyntaxHighlighter.DELIMITER),
		new AttributesDescriptor("Number", ArucasSyntaxHighlighter.NUMBER),
		new AttributesDescriptor("Keyword", ArucasSyntaxHighlighter.KEYWORD),
		new AttributesDescriptor("Comment", ArucasSyntaxHighlighter.COMMENT),
		new AttributesDescriptor("Bad value", ArucasSyntaxHighlighter.BAD_CHARACTER),
	};
	
	@Nullable
	@Override
	public Icon getIcon() {
		return ArucasIcons.FILE;
	}
	
	@NotNull
	@Override
	public SyntaxHighlighter getHighlighter() {
		return new ArucasSyntaxHighlighter();
	}
	
	@NotNull
	@Override
	public String getDemoText() {
		return "/* This is an example class */\n" +
			"class Example {\n" +
			"    static var staticVariable = 'string';\n" +
			"    var memberVariable = 321;\n" +
			"\n" +
			"    Example() {\n" +
			"        this.memberVariable = true;\n" +
			"        localVariable = [ 'a', 1, { 1: '321' }];\n" +
			"    }\n" +
			"\n" +
			"    static fun staticMethod(obj) {\n" +
			"        return obj == null;\n" +
			"    }\n" +
			"}\n" +
			"\n" +
			"// Create a function lambda\n" +
			"lambda = fun() {\n" +
			"    return new Example();\n" +
			"}();\n" +
			"\n" +
			"// Invalid character\n" +
			"test = invalid^;";
	}
	
	@Nullable
	@Override
	public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
		return null;
	}
	
	@Override
	public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
		return DESCRIPTORS;
	}
	
	@Override
	public ColorDescriptor @NotNull [] getColorDescriptors() {
		return ColorDescriptor.EMPTY_ARRAY;
	}
	
	@NotNull
	@Override
	public String getDisplayName() {
		return "Arucas";
	}
}
