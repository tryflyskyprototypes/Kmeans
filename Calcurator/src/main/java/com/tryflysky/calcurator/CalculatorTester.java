package com.tryflysky.calcurator;



public class CalculatorTester {

	public static void main(String[] args) {

		String sample = "((1+2))*((4/2)+(6-5))";

		try {

			System.out.println(new Calculator().execute(sample));

		} catch (Exception e) {


			System.out.println("error occuer. review your expression ->" + sample);
			System.out.println("if expression is correct, please tell us.");
			System.out.println("LEVEL FIVE Search & Develop Division (L.S.D.)");
		}
	}

}
