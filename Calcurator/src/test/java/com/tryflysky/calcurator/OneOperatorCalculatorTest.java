package com.tryflysky.calcurator;

import static org.junit.Assert.*;

import java.util.Deque;

import org.junit.Test;

import com.tryflysky.calcurator.helper.ExpressionDequeGenerator;
import com.tryflysky.expression.ExpressionDeque;
import com.tryflysky.expression.Operator;


public class OneOperatorCalculatorTest {


		@Test
		public void unique_operator() {

			final int EXPRESSION = 0;
			final int ANSWER = 1;
			final int OPERATOR = 2;

			String[][] formats = {
					{"7+1+3", "11", "PLUS"},
//					{"2+10" , "12", "PLUS"},
//					{"7-5"  , "2" , "MINUS"},
//					{"2*2"  , "4" , "MULTIPLE"},
//					{"2*2*3", "12", "MULTIPLE"},
//					{"4/2"  , "2" , "DIVIDE"},
//					{"8/4/2", "1" , "DIVIDE"},
			};


			for(String[] format : formats) {

				ExpressionDeque deque = new ExpressionDequeGenerator().execute(format[EXPRESSION]);

				OneOeratorCalculator calculator = new OneOeratorCalculator(Operator.valueOf(format[OPERATOR]));

				ExpressionDeque calculated = calculator.execute(deque);

				assertEquals(format[ANSWER], calculated.removeFirstOperand());
				assertTrue(calculated.getOperands().size() == 0);
				assertTrue(calculated.getOperators().size() == 0);
			}
		}







		@Test
		public void multi_operators() {

			String expression = "7+1-3";

			ExpressionDeque deque = new ExpressionDequeGenerator().execute(expression);

			OneOeratorCalculator calculator = new OneOeratorCalculator(Operator.PLUS);

			ExpressionDeque calculated = calculator.execute(deque);

			String[] expect_operand = {"8", "3"};
			String[] expect_operator = {"-"};

			sizeTest(expect_operand, calculated.getOperands());
			sizeTest(expect_operator, calculated.getOperators());

			valueTest(expect_operand, calculated.getOperands());
			valueTest(expect_operator, calculated.getOperators());
		}




		private void valueTest(String[] expect, Deque<String> actual) {

			for(int i = 0; i < expect.length; i++) {

				assertEquals(expect[i], actual.removeFirst());
			}
		}




		private void sizeTest(String[] expect, Deque<String> actual) {

			assertTrue(expect.length == actual.size());
		}
}
