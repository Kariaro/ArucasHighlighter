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
import java.util.HashMap;
import java.util.Map;

public class ArucasColorSettingsPage implements ColorSettingsPage {
	private static final AttributesDescriptor[] DESCRIPTORS = {
		new AttributesDescriptor("Declarations//Class name", ArucasHighlightingColors.CLASS_NAME),
		new AttributesDescriptor("Declarations//Function name", ArucasHighlightingColors.FUNCTION_NAME),
		new AttributesDescriptor("Declarations//Variable name", ArucasHighlightingColors.VARIABLE_NAME),
		new AttributesDescriptor("Function call", ArucasHighlightingColors.FUNCTION_CALL),
		
		new AttributesDescriptor("Identifier", ArucasHighlightingColors.IDENTIFIER),
		new AttributesDescriptor("Comment", ArucasHighlightingColors.COMMENT),
		new AttributesDescriptor("String", ArucasHighlightingColors.STRING),
		new AttributesDescriptor("Number", ArucasHighlightingColors.NUMBER),
		new AttributesDescriptor("Operator", ArucasHighlightingColors.OPERATOR),
		new AttributesDescriptor("Delimiter", ArucasHighlightingColors.DELIMITER),
		new AttributesDescriptor("Value Keyword", ArucasHighlightingColors.VALUE_KEYWORD),
		new AttributesDescriptor("Keyword", ArucasHighlightingColors.KEYWORD),
		new AttributesDescriptor("Bad value", ArucasHighlightingColors.BAD_CHARACTER),
	};
	
	private static final Map<String, TextAttributesKey> customTags;
	
	static {
		customTags = new HashMap<>();
		customTags.put("className", ArucasHighlightingColors.CLASS_NAME);
		customTags.put("funName", ArucasHighlightingColors.FUNCTION_NAME);
		customTags.put("varName", ArucasHighlightingColors.VARIABLE_NAME);
		customTags.put("funCall", ArucasHighlightingColors.FUNCTION_CALL);
	}
	
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
			"class <className>Example</className> {\n" +
			"    static var <varName>staticVariable</varName> = 'string';\n" +
			"    var <varName>memberVariable</varName> = 321;\n" +
			"\n" +
			"    <funName>Example</funName>() {\n" +
			"        this.memberVariable = true;\n" +
			"        localVariable = [ 'a', 1, { 1: '321' }];\n" +
			"    }\n" +
			"\n" +
			"    fun <funName>method</funName>(value) {\n" +
			"         <funCall>print</funCall>(value);\n" +
			"    }\n" +
			"\n" +
			"    static fun <funName>staticMethod</funName>(obj) {\n" +
			"        return obj == null;\n" +
			"    }\n" +
			"}\n" +
			"\n" +
			"// Create a function lambda\n" +
			"lambda = fun() {\n" +
			"    return new <className>Example</className>();\n" +
			"}();\n" +
			"lambda.<funCall>method</funCall>('message')\n" +
			"\n" +
			"// Invalid character\n" +
			"test = invalid^;";
	}
	
	@Nullable
	@Override
	public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
		return customTags;
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
