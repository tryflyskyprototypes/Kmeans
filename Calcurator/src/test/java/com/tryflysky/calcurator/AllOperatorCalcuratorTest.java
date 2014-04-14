package com.tryflysky.calcurator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tryflysky.calcurator.helper.ExpressionDequeGenerator;
import com.tryflysky.expression.ExpressionDeque;


public class AllOperatorCalcuratorTest {

	AllOperatorCalculator calcurator = new AllOperatorCalculator();



	@Test
	public void test() {

		final int EXPRESSION = 0;
		final int ANSWER = 1;

		String[][] formats = {
				{"2*2+4/2-1", "5"},
				{"2*2*3/4", "3"},
				{"8/2*2", "2"},
				{"3-1+4/2", "0"},
		};


		for(String[] format : formats) {

			ExpressionDeque deque = new ExpressionDequeGenerator().execute(format[EXPRESSION]);

			assertEquals(format[ANSWER], calcurator.execute(deque));
		}




	}






}
