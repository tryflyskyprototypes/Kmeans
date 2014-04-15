package com.tryflysky.calcurator;



/**
 * 計算機のデモンストレーション用クラス
 *
 * @author admin
 *
 */
public class CalculatorTester {





	public static void main(String[] args) {

		Calculator calculator = new Calculator();
		
		String[] samples = {
				"1+2*3",
				"((1+2))*((4/2)+(6-5))",
				"２×三足す6－10"
		};

		
		for(String expression : samples) {
			
			try {

				int answer = calculator.execute(expression);
				
				System.out.println(expression + " = " +  answer);
				System.out.println();

			} catch (Exception e) {


				System.out.println("error occuer. review your expression ->" + expression);
				System.out.println("if expression is correct, please tell us.");
				System.out.println("LEVEL FIVE Search & Develop Division (L.S.D.)");
				
				
				System.out.println();
				e.printStackTrace();
			}
		}
	}

}
