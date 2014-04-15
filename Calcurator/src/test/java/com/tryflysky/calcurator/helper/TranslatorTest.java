package com.tryflysky.calcurator.helper;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tryflysky.expression.Expression;
import com.tryflysky.expression.ExpressionDeque;
import com.tryflysky.expression.ExpressionFactory;
import com.tryflysky.expression.Operator;

public class TranslatorTest {




	@Test
	public void toTranslatedDequeTest() {

		String expStr = "1÷2×3引く4たす5";

		Expression expression = ExpressionFactory.generate(expStr);

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
