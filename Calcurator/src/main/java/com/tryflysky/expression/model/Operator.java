package com.tryflysky.expression.model;




public enum Operator implements Simbole{

	MULTIPLE("*", new String[]{"×","x","X", "multiple", "multiplication", "掛ける", "かける"}) {
		@Override
		public int calculate(int value1, int value2) {

			return value1 * value2;
		}
	},


	DIVIDE("/", new String[]{"÷", "divide", "division", "割る", "わる"}) {
		@Override
		public int calculate(int value1, int value2) {

			return value1 / value2;
		}
	},


	PLUS("+", new String[]{"＋", "plus", "addition", "足す", "たす"}) {
		@Override
		public int calculate(int value1, int value2) {

			return value1 + value2;
		}
	},


	MINUS("-", new String[]{"－", "minus", "subtraction", "引く", "ひく"}) {
		@Override
		public int calculate(int value1, int value2) {

			return value1 - value2;
		}
	},
	;

	public final String simbole;
	private final String[] candidates;

	private Operator(String simbole, String[] candidates) {
		this.simbole = simbole;
		this.candidates = candidates;
	}


	public String getSimbole() {

		return simbole;
	}

	public String[] getCandidates() {

		return candidates;
	}

	abstract public int calculate(int value1, int value2);
}
