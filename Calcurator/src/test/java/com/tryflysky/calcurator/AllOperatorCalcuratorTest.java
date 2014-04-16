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
				//課題の式
				{"1+2*3", "7"},
				{"一足す二×参", "7"},
				{"one + two * three", "7"},
				{"One plus TWO multipled by three", "7"},

				//その他
				{"3*3", "9"},
				{"2*2+4/2-1", "5"},
				{"2*2*3/4", "3"},
				{"8/2*2", "2"},
				{"3-1+4/2", "0"},
				{"壱足す二", "3"},
				{"一〇÷２ひく3", "2"},
				{"Four * two / EIGHT", "1"},
				{"nine times three", "27"},
				
				{"1", "1"},
				{"弐", "2"},
				{"three", "3"},
		};


		for(String[] format : formats) {

			assertEquals(format[ANSWER], calcurator.execute(format[EXPRESSION]));
		}
	}




}
