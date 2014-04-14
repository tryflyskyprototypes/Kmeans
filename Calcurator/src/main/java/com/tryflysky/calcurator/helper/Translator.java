package com.tryflysky.calcurator.helper;

import java.util.HashMap;
import java.util.Map;

import com.tryflysky.expression.ExpressionDeque;
import com.tryflysky.expression.Operator;
import com.tryflysky.expression.Parentheses;
import com.tryflysky.expression.Simbole;
import com.tryflysky.utils.DequeUtils;

public class Translator {

	private static Map<String, Simbole> dictionaly = new HashMap<String, Simbole>();



	private Translator() {
		//singleton
	};


	static {
		init();
	}



	public static Simbole translate(String operator) {

		return dictionaly.get(operator.toUpperCase());
	}




	private static void init() {

		writeIn(Operator.values());
		writeIn(Parentheses.values());
	}




	private static void writeIn(Simbole[] simboles) {

		for(Simbole simbole : simboles) {

			dictionaly.put(simbole.getSimbole(), simbole);

			for(String candidate : simbole.getCandidates()) {

				dictionaly.put(candidate.toUpperCase(), simbole);
			}
		}
	}




	public static ExpressionDeque toTranslatedDeque(ExpressionDeque original) {

		ExpressionDeque translated = new  ExpressionDeque();

		DequeUtils.copyLastAll(translated.getOperands(), original.getOperands());

		for(String operator : original.getOperators()) {

			translated.addLastOperator(translate(operator).getSimbole());
		}

		return translated;
	}

}
