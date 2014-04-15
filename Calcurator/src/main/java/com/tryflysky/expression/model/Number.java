package com.tryflysky.expression.model;

public enum Number implements Simbole {
	ZERO("0", new String[]{"０", "零", "〇", "○", "zero"}),
	ONE("1", new String[]{"１", "一", "壱", "one"}),
	TWO("2", new String[]{"２", "二", "弐", "two"}),
	THREE("3", new String[]{"３", "三", "参", "three"}),
	FOUR("4", new String[]{"４", "四", "肆", "four"}),
	FIVE("5", new String[]{"５", "五", "伍", "five"}),
	SIX("6", new String[]{"６", "六", "陸", "six"}),
	SEVEN("7", new String[]{"７", "七", "漆", "seven"}),
	EIGHT("8", new String[]{"８", "八", "捌", "eight"}),
	NINE("9", new String[]{"９", "九", "玖", "nine"}),
	;


	private final String simbole;
	private final String[] candidates;

	private Number(String simbole, String[] candidates) {
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
