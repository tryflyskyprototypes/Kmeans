package com.tryflysky.expression.helper;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tryflysky.expression.model.Expression;
import com.tryflysky.expression.model.ExpressionDeque;
import com.tryflysky.expression.model.Operator;

public class TranslatorTest {




	@Test
	public void toTranslatedDequeTest() {

		String expStr = "1÷2×3引く4たす5";

		Expression expression = new Expression(expStr);

		ExpressionDeque deque = expression.getDeque();

		String[] expected_operators = {
				Operator.DIVIDE.getSimbole(),
				Operator.MULTIPLE.getSimbole(),
				Operator.MINUS.getSimbole(),
				Operator.PLUS.getSimbole(),
		};

		for(String expected : expected_operators) {

			assertEquals(expected, deque.removeFirstOperator());
		}
	}







}
