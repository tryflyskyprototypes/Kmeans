package com.tryflysky.expression.helper;
import static org.junit.Assert.*;

import java.util.Deque;

import org.junit.Test;

import com.tryflysky.expression.helper.ExpressionDequeGenerator;
import com.tryflysky.expression.model.ExpressionDeque;


public class ExpressionDequeGeneratorTest {

	ExpressionDequeGenerator generator = new ExpressionDequeGenerator();

	@Test
	public void test() {

		String formula = "(12*(7+1+3))+(3+4)*(4/2)";

		ExpressionDeque expressionDeque = generator.execute(formula);

		Deque<String> actual_n = expressionDeque.getOperands();
		Deque<String> actual_o = expressionDeque.getOperators();


		String[] expects_n = {
				"12","7","1","3","3","4","4","2",
		};

		String[] expects_o = {
				"(","*","(","+","+",")",")","+","(","+",")","*","(","/",")",
		};


		assertTrue(actual_n.size() == expects_n.length);
		assertTrue(actual_o.size() == expects_o.length);

		valueTest(expects_n, actual_n);
		valueTest(expects_o, actual_o);
	}






	//TODO コピペ廃止
	//TODO テスト名変更
	@Test
	public void test2() {

		String formula = "2*2+4/2-1";

		ExpressionDeque expressionDeque = generator.execute(formula);

		Deque<String> actual_n = expressionDeque.getOperands();
		Deque<String> actual_o = expressionDeque.getOperators();


		String[] expects_n = {
				"2","2","4","2","1"
		};

		String[] expects_o = {
				"*","+", "/", "-"
		};


		assertTrue(actual_n.size() == expects_n.length);
		assertTrue(actual_o.size() == expects_o.length);

		valueTest(expects_n, actual_n);
		valueTest(expects_o, actual_o);
	}








	private void valueTest(String[] expects, Deque<String> actual_n) {

		for(int i = 0; i <  expects.length; i++) {

			assertEquals(expects[i], actual_n.removeFirst());
		}


	}




}
