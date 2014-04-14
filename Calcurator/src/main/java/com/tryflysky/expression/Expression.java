package com.tryflysky.expression;

import org.apache.commons.lang3.StringUtils;

import com.tryflysky.calcurator.helper.ExpressionDequeGenerator;

public class Expression {

	private ExpressionDequeGenerator expressionDequeGenerator = new ExpressionDequeGenerator();


	private final String expression;


	public Expression(String expression) {

		this.expression = StringUtils.deleteWhitespace(expression);
	}


	@Override
	public String toString() {

		return expression;
	}




	public ExpressionDeque getDeque() {

		return expressionDequeGenerator.execute(expression);	//状態変化するので、毎回生成して返す
	}



	public boolean containsParentheses() {

		return StringUtils.contains(expression, Parentheses.LEFT.getSimbole());
	}



}
