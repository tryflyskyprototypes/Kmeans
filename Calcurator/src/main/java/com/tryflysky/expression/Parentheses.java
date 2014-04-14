package com.tryflysky.expression;



public enum Parentheses implements Simbole{

	LEFT("(" , new String[]{"（", "[", "{", "「"}),
	RIGHT(")", new String[]{"）", "]", "}", "」"}),
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
