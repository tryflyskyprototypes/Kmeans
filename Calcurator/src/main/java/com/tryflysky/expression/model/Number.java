package com.tryflysky.expression.model;

public enum Number implements Simbole {
	ZERO("0", new String[]{"０", "零", "〇", "○"}),
	ONE("1", new String[]{"１", "一", "壱"}),
	TWO("2", new String[]{"２", "二", "弐"}),
	THREE("3", new String[]{"３", "三", "参"}),
	FOUR("4", new String[]{"４", "四", "肆"}),
	FIVE("5", new String[]{"５", "五", "伍"}),
	SIX("6", new String[]{"６", "六", "陸"}),
	SEVEN("7", new String[]{"７", "七", "漆"}),
	EIGHT("8", new String[]{"８", "八", "捌"}),
	NINE("9", new String[]{"９", "九", "玖"}),
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
