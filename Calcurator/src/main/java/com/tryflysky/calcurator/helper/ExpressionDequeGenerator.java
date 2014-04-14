package com.tryflysky.calcurator.helper;
import org.apache.commons.lang3.StringUtils;

import com.tryflysky.expression.ExpressionDeque;


public class ExpressionDequeGenerator {



	public ExpressionDeque execute(String expression) {

		ExpressionDeque result = new ExpressionDeque();

		StringBuilder operand = new StringBuilder();

		for(int i = 0; i < expression.length(); i++) {

			String c = String.valueOf(expression.charAt(i));

			if(isOperand(c)) {

				operand.append(c);
			}else {

				result.addLastOperator(c);
				result.addLastOperand(operand.toString());

				operand = new StringBuilder();
			}
		}

		//最後の1つ対策
		result.addLastOperand(operand.toString());

		return result;
	}






	private boolean isOperand(String c) {

		return StringUtils.isNumeric(c);
	}

}
