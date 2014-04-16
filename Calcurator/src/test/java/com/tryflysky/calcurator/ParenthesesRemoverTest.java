package com.tryflysky.calcurator;

import static org.junit.Assert.*;

import org.junit.Test;


public class ParenthesesRemoverTest {

	ParenthesesRemover calcurator = new ParenthesesRemover();



	@Test
	public void test() {

		final int EXPRESSION = 0;
		final int ANSWER = 1;

		String[][] formats = {

				{"(3+4)", "7"},
				{"1+(2-1)", "1+1"},

				{"((1+2))*((4/2)+(6-5))","3*3"},
				
				{"(12*(7+1+3))+(3+4)*(4/2)", "132+7*2"},

				{"((1+2))*((4/2)+(6-5))", "3*3"},
				
				{"(((1+2))*((4/2)+(6-5)))", "9"},
				
				{"3", "3"},
				{"(3)", "3"},
		};


		for(String[] format : formats) {

			String actual = calcurator.execute(format[EXPRESSION]).toString();

			assertEquals(format[ANSWER], actual);
		}



	}

}
