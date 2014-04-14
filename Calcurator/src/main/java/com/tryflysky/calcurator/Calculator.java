package com.tryflysky.calcurator;

import com.tryflysky.expression.Expression;


/**
 *
 * @author syowha
 *
 */
public class Calculator {



	/**
	 *
	 * 検証は省略
	 * エラーが出たら式を見直してもらう
	 *
	 * @param expression
	 * @return
	 */
	public int execute(String expression) {

		Expression exp = new Expression(expression);

		if(exp.containsParentheses()) {

			exp = new ParenthesesRemover().execute(exp);
		}

		String answer = new AllOperatorCalculator().execute(exp.getDeque());

		return Integer.parseInt(answer);
	}
}
