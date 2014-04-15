package com.tryflysky.expression.model;



public enum Parentheses implements Simbole{

	LEFT("(" , new String[]{"（", "[", "{", "「", "左括弧"}),
	RIGHT(")", new String[]{"）", "]", "}", "」", "右括弧"}),
	;

	private final String simbole;
	private final String[] candidates;

	private Parentheses(String simbole, String[] candidates) {

		this.simbole = simbole;
		this.candidates = candidates;
	}



	public String getSimbole() {
		return simbole;
	}

	public String[] getCandidates() {
		return candidates;
	}
}
