package me.hardcoded.arucas.language.formatting;

import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.tree.TokenSet;
import me.hardcoded.arucas.language.ArucasLanguage;
import me.hardcoded.arucas.psi.ArucasTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArucasFormattingModelBuilder implements FormattingModelBuilder {
	private static final TokenSet EQUALITY_OP = TokenSet.create(ArucasTypes.OP_EQUALS, ArucasTypes.OP_NOTEQUALS);
	private static final TokenSet LOGICAL_OP = TokenSet.create(ArucasTypes.OP_LOGICAL_AND, ArucasTypes.OP_LOGICAL_OR);
	private static final TokenSet RELATIONAL_OP = TokenSet.create(ArucasTypes.OP_MORETHANEQ, ArucasTypes.OP_MORETHAN, ArucasTypes.OP_LESSTHANEQ, ArucasTypes.OP_LESSTHAN);
	
	private static final TokenSet BINARY_FACTOR_OP = TokenSet.create(ArucasTypes.OP_PLUS, ArucasTypes.OP_MINUS);
	private static final TokenSet BINARY_OP = TokenSet.create(ArucasTypes.OP_MUL, ArucasTypes.OP_DIV, ArucasTypes.OP_POW);
	private static final TokenSet UNARY_FACTOR_OP = TokenSet.create(ArucasTypes.OP_PLUS, ArucasTypes.OP_MINUS);
	private static final TokenSet UNARY_MEMBER_OP = TokenSet.create(ArucasTypes.OP_PP, ArucasTypes.OP_MM);
	
	private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
		ArucasCodeStyleSettings data = settings.getCustomSettings(ArucasCodeStyleSettings.class);
		CommonCodeStyleSettings commonSettings = settings.getCommonSettings(ArucasLanguage.INSTANCE);
		
		return new SpacingBuilder(settings, ArucasLanguage.INSTANCE) {
			@Override
			public @Nullable Spacing getSpacing(@Nullable Block parent, @Nullable Block child1, @Nullable Block child2) {
				if (child1 instanceof ArucasBlock && child2 instanceof ArucasBlock) {
					String c1s = ((ArucasBlock)child1).getNode().getText();
					String c2s = ((ArucasBlock)child2).getNode().getText();
					
					if (c1s.endsWith("+") && c2s.startsWith("+") || c1s.endsWith("-") && c2s.startsWith("-")) {
						return Spacing.createSpacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, commonSettings.KEEP_BLANK_LINES_IN_CODE);
					}
				}
				
				return super.getSpacing(parent, child1, child2);
			}
		}
			// After statement
			.beforeInside(ArucasTypes.STATEMENT, ArucasTypes.IF_STATEMENT)
			.spaceIf(data.SPACE_BEFORE_LEFT_BRACE)
			.beforeInside(ArucasTypes.STATEMENT, ArucasTypes.FOR_EACH_STATEMENT)
			.spaceIf(data.SPACE_BEFORE_LEFT_BRACE)
			.beforeInside(ArucasTypes.STATEMENT, ArucasTypes.FOR_STATEMENT)
			.spaceIf(data.SPACE_BEFORE_LEFT_BRACE)
			.beforeInside(ArucasTypes.STATEMENT, ArucasTypes.WHILE_STATEMENT)
			.spaceIf(data.SPACE_BEFORE_LEFT_BRACE)
			.beforeInside(ArucasTypes.STATEMENT, ArucasTypes.CASE_STATEMENT)
			.spaceIf(data.SPACE_BEFORE_LEFT_BRACE)
			.beforeInside(ArucasTypes.SWITCH_CODE_BLOCK, ArucasTypes.SWITCH_STATEMENT)
			.spaceIf(data.SPACE_BEFORE_LEFT_BRACE)
			.beforeInside(ArucasTypes.STATEMENT, ArucasTypes.TRY_STATEMENT)
			.spaceIf(data.SPACE_BEFORE_LEFT_BRACE)
			.beforeInside(ArucasTypes.STATEMENT, ArucasTypes.ELSE_STATEMENT)
			.spaceIf(data.SPACE_BEFORE_LEFT_BRACE)
			
			// Before parentheses
			.before(ArucasTypes.ARGUMENTS)
			.spaceIf(data.SPACE_BEFORE_METHOD_PARENTHESES)
			.before(ArucasTypes.OPERATOR_ARGUMENTS)
			.spaceIf(data.SPACE_BEFORE_OPERATOR_PARENTHESES)
			.beforeInside(ArucasTypes.CALL_ARGUMENTS, ArucasTypes.NEW_EXPRESSION)
			.spaceIf(data.SPACE_BEFORE_NEW_PARENTHESES)
			.before(ArucasTypes.CALL_ARGUMENTS)
			.spaceIf(data.SPACE_BEFORE_CALL_PARENTHESES)
			.after(ArucasTypes.KW_FOR)
			.spaceIf(data.SPACE_BEFORE_FOR_PARENTHESES)
			.after(ArucasTypes.KW_FOREACH)
			.spaceIf(data.SPACE_BEFORE_FOREACH_PARENTHESES)
			.after(ArucasTypes.KW_SWITCH)
			.spaceIf(data.SPACE_BEFORE_SWITCH_PARENTHESES)
			.after(ArucasTypes.KW_IF)
			.spaceIf(data.SPACE_BEFORE_IF_PARENTHESES)
			.after(ArucasTypes.KW_WHILE)
			.spaceIf(data.SPACE_BEFORE_WHILE_PARENTHESES)
			.after(ArucasTypes.KW_CATCH)
			.spaceIf(data.SPACE_BEFORE_CATCH_PARENTHESES)
			
			// Binary spaces
			.aroundInside(BINARY_FACTOR_OP, ArucasTypes.ARITHMETIC_EXPRESSION)
			.spaceIf(data.SPACE_AROUND_BINARY_OPERATORS)
			.around(BINARY_OP)
			.spaceIf(data.SPACE_AROUND_BINARY_OPERATORS)
			.around(RELATIONAL_OP)
			.spaceIf(data.SPACE_AROUND_RELATIONAL_OPERATORS)
			.around(LOGICAL_OP)
			.spaceIf(data.SPACE_AROUND_LOGICAL_OPERATORS)
			.around(EQUALITY_OP)
			.spaceIf(data.SPACE_AROUND_EQUALITY_OPERATORS)
			.around(ArucasTypes.ASSIGNMENT)
			.spaceIf(data.SPACE_AROUND_ASSIGNMENT_OPERATORS)
			
			// Unary spaces
			.before(UNARY_MEMBER_OP)
			.spaceIf(data.SPACE_AROUND_UNARY_MODIFY_OPERATORS)
			.after(ArucasTypes.OP_NOT)
			.spaceIf(data.SPACE_AROUND_UNARY_OPERATORS)
			.aroundInside(UNARY_FACTOR_OP, ArucasTypes.UNARY_EXPRESSION)
			.spaceIf(data.SPACE_AROUND_UNARY_OPERATORS)
			
			// Code block spaces
			.before(ArucasTypes.CLASS_CODE_BLOCK)
			.spaceIf(data.SPACE_BEFORE_CLASS_BODY)
			.before(ArucasTypes.CODE_BLOCK)
			.spaceIf(data.SPACE_BEFORE_METHOD_BODY)
			
			// List expression
			.betweenInside(ArucasTypes.LBRACK, ArucasTypes.RBRACK, ArucasTypes.LIST_EXPRESSION)
			.spaceIf(data.SPACE_INSIDE_EMPTY_LIST)
			.afterInside(ArucasTypes.LBRACK, ArucasTypes.LIST_EXPRESSION)
			.spaceIf(data.SPACE_AROUND_INSIDE_LIST)
			.beforeInside(ArucasTypes.RBRACK, ArucasTypes.LIST_EXPRESSION)
			.spaceIf(data.SPACE_AROUND_INSIDE_LIST)
			.afterInside(ArucasTypes.COMMA, ArucasTypes.LIST_EXPRESSION)
			.spaceIf(data.SPACE_AFTER_LIST_COMMA)
			.beforeInside(ArucasTypes.COMMA, ArucasTypes.LIST_EXPRESSION)
			.spaceIf(data.SPACE_BEFORE_LIST_COMMA)
			
			// Map expression
			.betweenInside(ArucasTypes.LBRACE, ArucasTypes.RBRACE, ArucasTypes.MAP_EXPRESSION)
			.spaceIf(data.SPACE_INSIDE_EMPTY_MAP)
			.afterInside(ArucasTypes.LBRACE, ArucasTypes.MAP_EXPRESSION)
			.spaceIf(data.SPACE_AROUND_INSIDE_MAP)
			.beforeInside(ArucasTypes.RBRACE, ArucasTypes.MAP_EXPRESSION)
			.spaceIf(data.SPACE_AROUND_INSIDE_MAP)
			.afterInside(ArucasTypes.COLON, ArucasTypes.MAP_ENTRY)
			.spaceIf(data.SPACE_AFTER_MAP_COLON)
			.beforeInside(ArucasTypes.COLON, ArucasTypes.MAP_ENTRY)
			.spaceIf(data.SPACE_BEFORE_MAP_COLON)
			.afterInside(ArucasTypes.COMMA, ArucasTypes.MAP_EXPRESSION)
			.spaceIf(data.SPACE_AFTER_MAP_COMMA)
			.beforeInside(ArucasTypes.COMMA, ArucasTypes.MAP_EXPRESSION)
			.spaceIf(data.SPACE_BEFORE_MAP_COMMA)
			
			// Method parameters
			.betweenInside(ArucasTypes.LPAREN, ArucasTypes.RPAREN, ArucasTypes.ARGUMENTS)
			.spaceIf(data.SPACE_INSIDE_EMPTY_PARAMETERS)
			.afterInside(ArucasTypes.LPAREN, ArucasTypes.ARGUMENTS)
			.spaceIf(data.SPACE_AROUND_INSIDE_PARAMETERS)
			.beforeInside(ArucasTypes.RPAREN, ArucasTypes.ARGUMENTS)
			.spaceIf(data.SPACE_AROUND_INSIDE_PARAMETERS)
			.afterInside(ArucasTypes.COMMA, ArucasTypes.ARGUMENTS)
			.spaceIf(data.SPACE_AFTER_PARAMETER_COMMA)
			.beforeInside(ArucasTypes.COMMA, ArucasTypes.ARGUMENTS)
			.spaceIf(data.SPACE_BEFORE_PARAMETER_COMMA)
			
			// Call parameters
			.betweenInside(ArucasTypes.LPAREN, ArucasTypes.RPAREN, ArucasTypes.CALL_ARGUMENTS)
			.spaceIf(data.SPACE_INSIDE_EMPTY_CALL_PARAMETERS)
			.afterInside(ArucasTypes.LPAREN, ArucasTypes.CALL_ARGUMENTS)
			.spaceIf(data.SPACE_AROUND_INSIDE_CALL_PARAMETERS)
			.beforeInside(ArucasTypes.RPAREN, ArucasTypes.CALL_ARGUMENTS)
			.spaceIf(data.SPACE_AROUND_INSIDE_CALL_PARAMETERS)
			.afterInside(ArucasTypes.COMMA, ArucasTypes.CALL_ARGUMENTS)
			.spaceIf(data.SPACE_AFTER_PARAMETER_CALL_COMMA)
			.beforeInside(ArucasTypes.COMMA, ArucasTypes.CALL_ARGUMENTS)
			.spaceIf(data.SPACE_BEFORE_PARAMETER_CALL_COMMA)
			;
	}
	
	@NotNull
	@Override
	public FormattingModel createModel(@NotNull FormattingContext formattingContext) {
		final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
		return FormattingModelProvider
			.createFormattingModelForPsiFile(formattingContext.getContainingFile(),
				new ArucasBlock(formattingContext.getNode(),
					createSpaceBuilder(codeStyleSettings)
				),
				codeStyleSettings
			);
	}
}
