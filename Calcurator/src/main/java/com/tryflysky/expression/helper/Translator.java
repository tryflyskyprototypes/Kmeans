package com.tryflysky.expression.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.tryflysky.expression.model.Number;
import com.tryflysky.expression.model.Operator;
import com.tryflysky.expression.model.Parentheses;
import com.tryflysky.expression.model.Simbole;

public class Translator {

	private static Map<String, Simbole> dictionaly = new HashMap<String, Simbole>();



	private Translator() {
		//util class
	};


	static {
		init();
	}



	public static String execute(String expression) {

		String translated = fix(expression);

		for(Entry<String, Simbole> e : dictionaly.entrySet()) {

			translated = StringUtils.replace(translated, e.getKey(), e.getValue().getSimbole());
		}

		return StringUtils.deleteWhitespace(translated);
	}







	private static void init() {

		writeIn(Operator.values());
		writeIn(Parentheses.values());
		writeIn(Number.values());
	}




	private static void writeIn(Simbole[] simboles) {

		for(Simbole simbole : simboles) {

			dictionaly.put(simbole.getSimbole(), simbole);

			for(String candidate : simbole.getCandidates()) {

				dictionaly.put(fix(candidate), simbole);
			}
		}
	}




	private static String fix(String str) {

		String fixed = str.toLowerCase();

		return StringUtils.remove(fixed, "by");		//TODO 定数化？
	}
}
