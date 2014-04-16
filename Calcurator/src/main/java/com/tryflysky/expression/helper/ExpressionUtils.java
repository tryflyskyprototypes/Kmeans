package com.tryflysky.expression.helper;

import java.util.Deque;
import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;

import com.tryflysky.expression.model.ExpressionDeque;
import com.tryflysky.expression.model.Simbole;
import com.tryflysky.utils.DequeUtils;

public class ExpressionUtils {


	private ExpressionUtils() {
		//util class
	}





	public static boolean match(String candidate, Simbole simbole) {

		return StringUtils.equals(candidate, simbole.getSimbole());
	}





	public static boolean isOperand(String value) {

		return StringUtils.isNumeric(value);
	}





	public static void transferLastAll(ExpressionDeque to, ExpressionDeque from) {

		DequeUtils.transferLastAll(to.getOperands(), from.getOperands());
		DequeUtils.transferLastAll(to.getOperators(), from.getOperators());
	}




	/**
	 * 1要素1文字のDequeにする
	 * ※CharacterといいつつString型なのは、ま、後で考えましょう
	 *
	 * @param expression
	 * @return
	 */
	public static Deque<String> toCharacterDeque(String expression) {

		Deque<String> result = new LinkedList<String>();	//1文字ずつのDequeにするので、順番が保障されること必須

		for(int i = 0; i < expression.length(); i++) {
			result.add(String.valueOf(expression.charAt(i)));
		}

		return result;
	}
}
