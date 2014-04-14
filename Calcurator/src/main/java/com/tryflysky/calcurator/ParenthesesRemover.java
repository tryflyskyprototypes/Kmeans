package com.tryflysky.calcurator;

import java.util.Deque;
import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;

import com.tryflysky.expression.Expression;
import com.tryflysky.expression.Parentheses;



/**
 * 式に含まれる括弧を外す（括弧内のみ計算）した式を返す
 *
 * @author admin
 *
 */
public class ParenthesesRemover {



	private AllOperatorCalculator calcurator = new AllOperatorCalculator();




	public Expression execute(String expression) {

		return execute(new Expression(expression));
	}



	public Expression execute(Expression expression) {

		Deque<StringBuilder> partExpressions = new LinkedList<StringBuilder>();

		StringBuilder currentPart = new StringBuilder();

		for(int i = 0; i < expression.toString().length(); i++) {

			String c = String.valueOf(expression.toString().charAt(i));

			//雑だけどまあいいや
			if(leftParentheses(c)) {

				partExpressions.addLast(currentPart);
				currentPart = new  StringBuilder();

			}else if(rightParentheses(c)) {

				String calculated = calcurator.execute(currentPart.toString());

				currentPart = partExpressions.removeLast();

				currentPart.append(calculated);

			}else {

				currentPart.append(c);
			}
		}

		return new Expression(currentPart.toString());
	}




	private boolean leftParentheses(String c) {

		return isMatch(c, Parentheses.LEFT);
	}




	private boolean rightParentheses(String c) {

		return isMatch(c, Parentheses.RIGHT);
	}



	private boolean isMatch(String c, Parentheses p) {

		return StringUtils.equals(c, p.getSimbole());
	}












}
