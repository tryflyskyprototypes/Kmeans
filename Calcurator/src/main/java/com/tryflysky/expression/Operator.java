package com.tryflysky.expression;




public enum Operator implements Simbole{

	MULTIPLE("*", new String[]{"×","x","X", "multiple"}) {
		@Override
		public int calculate(int value1, int value2) {

			return value1 * value2;
		}
	},


	DIVIDE("/", new String[]{"÷", "divide"}) {
		@Override
		public int calculate(int value1, int value2) {

			return value1 / value2;
		}
	},


	PLUS("+", new String[]{"＋", "plus"}) {
		@Override
		public int calculate(int value1, int value2) {

			return value1 + value2;
		}
	},


	MINUS("-", new String[]{"－", "minus"}) {
		@Override
		public int calculate(int value1, int value2) {

			return value1 - value2;
		}
	},
	;

	private final String simbole;
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
