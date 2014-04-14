package com.tryflysky.calcurator.helper;

import static com.tryflysky.expression.Operator.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.tryflysky.expression.ExpressionDeque;
import com.tryflysky.expression.Operator;
import com.tryflysky.expression.Simbole;

public class TranslatorTest {

//	private Translator translator = Translator.getInstance();



	@Test
	public void translateTest() {
		
		Map<String, Simbole> formats = new HashMap<String, Simbole>(); 
		formats.put("+", PLUS);
		formats.put("＋", PLUS);
		formats.put("-", MINUS);
		formats.put("－", MINUS);
		formats.put("*", MULTIPLE);
		formats.put("x", MULTIPLE);
		formats.put("X", MULTIPLE);
		formats.put("×", MULTIPLE);
		formats.put("/", DIVIDE);
		formats.put("÷", DIVIDE);
		
		for(Entry<String, Simbole> e : formats.entrySet()) {
			
			assertEquals(e.getValue(), Translator.translate(e.getKey()));
		}
		
		
	}




	@Test
	public void toTranslatedDequeTest() {

		String formula = "1/2*3-4+5";

		ExpressionDeque original = new ExpressionDequeGenerator().execute(formula);

		ExpressionDeque translated = Translator.toTranslatedDeque(original);

		assertTrue(original.getOperands().size() == translated.getOperands().size());
		assertTrue(original.getOperators().size() == translated.getOperators().size());

		while(original.hasOperand()) {

			assertEquals(original.removeFirstOperand(), translated.removeFirstOperand());
		}

		String[] expected_operators = {
				Operator.DIVIDE.getSimbole(),
				Operator.MULTIPLE.getSimbole(),
				Operator.MINUS.getSimbole(),
				Operator.PLUS.getSimbole(),
		};


		for(String expected : expected_operators) {

			assertEquals(expected, translated.removeFirstOperator());
		}
	}
}
