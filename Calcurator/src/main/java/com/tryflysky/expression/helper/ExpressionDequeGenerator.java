package com.tryflysky.expression.helper;
import com.tryflysky.expression.model.ExpressionDeque;


public class ExpressionDequeGenerator {





	public ExpressionDeque execute(String expression) {

		ExpressionDeque result = new ExpressionDeque();

		StringBuilder operand = new StringBuilder();

		for(int i = 0; i < expression.length(); i++) {

			String c = String.valueOf(expression.charAt(i));

			if(ExpressionUtils.isOperand(c)) {

				operand.append(c);
			}else {

				result.addLastOperator(c);
				result.addLastOperand(operand.toString());

				operand = new StringBuilder();
			}
		}

		//最後の1文字対策
		result.addLastOperand(operand.toString());

		return result;
	}
}
