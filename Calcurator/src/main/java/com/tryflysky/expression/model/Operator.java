package com.tryflysky.expression.model;




public enum Operator implements Simbole{

	MULTIPLE("*", new String[]{"×","x", "multipled", "times", "掛ける", "かける"}) {
		@Override
		public int calculate(int value1, int value2) {

			return value1 * value2;
		}
	},


	DIVIDE("/", new String[]{"÷", "／", "divided", "割る", "わる"}) {
		@Override
		public int calculate(int value1, int value2) {

			return value1 / value2;
		}
	},


	PLUS("+", new String[]{"＋", "plus", "足す", "たす"}) {
		@Override
		public int calculate(int value1, int value2) {

			return value1 + value2;
		}
	},


	MINUS("-", new String[]{"－", "minus", "引く", "ひく"}) {
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


	public int calculate(ExpressionDeque deque) {

		int v1 = Integer.parseInt(deque.removeFirstOperand());
		int v2 = Integer.parseInt(deque.removeFirstOperand());

		return calculate(v1, v2);
	}
}
