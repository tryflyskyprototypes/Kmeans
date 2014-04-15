package com.tryflysky.calcurator;

import static org.junit.Assert.*;

import org.junit.Test;


public class AllOperatorCalcuratorTest {

	AllOperatorCalculator calcurator = new AllOperatorCalculator();



	@Test
	public void test() {

		final int EXPRESSION = 0;
		final int ANSWER = 1;

		String[][] formats = {
				{"1+2*3", "7"},
				{"3*3", "9"},
				{"2*2+4/2-1", "5"},
				{"2*2*3/4", "3"},
				{"8/2*2", "2"},
				{"3-1+4/2", "0"},
				{"壱足す二", "3"},
				{"一〇÷２ひく3", "2"},
		};


		for(String[] format : formats) {

			assertEquals(format[ANSWER], calcurator.execute(format[EXPRESSION]));
		}
	}






}
