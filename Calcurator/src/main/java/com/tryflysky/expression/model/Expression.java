package com.tryflysky.expression.model;

import org.apache.commons.lang3.StringUtils;

import com.tryflysky.expression.helper.ExpressionDequeGenerator;
import com.tryflysky.expression.helper.Translator;

public class Expression {

	private ExpressionDequeGenerator expressionDequeGenerator = new ExpressionDequeGenerator();


	private final String expression;


	public Expression(String expression) {

		String translated = Translator.execute(StringUtils.deleteWhitespace(expression));

		this.expression = translated;
	}


	@Override
	public String toString() {

		return expression;
	}




	public ExpressionDeque getDeque() {

		return expressionDequeGenerator.execute(expression);	//状態変化するので、毎回生成して返す
	}




	/**
	 * 式に括弧があれば真
	 *
	 * @return
	 */
	public boolean containsParentheses() {

		return StringUtils.contains(expression, Parentheses.LEFT.getSimbole());
	}


	public boolean notContainsParentheses() {

		return ! containsParentheses();
	}



}
