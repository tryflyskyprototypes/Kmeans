package com.tryflysky.expression.model;

import org.apache.commons.lang3.StringUtils;

import com.tryflysky.expression.helper.ExpressionDequeGenerator;
import com.tryflysky.expression.helper.Translator;



/**
 * 式を表す
 * 例：1+2*3
 *
 * @author admin
 *
 */
public class Expression {

	private final ExpressionDequeGenerator expressionDequeGenerator = new ExpressionDequeGenerator();

	private final String expression;


	public Expression(String expression) {

		this.expression = Translator.execute(expression);
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
