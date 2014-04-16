package com.tryflysky.expression.model;

import static com.tryflysky.expression.model.Structure.*;

import java.util.Deque;

import org.apache.commons.lang3.StringUtils;

import com.tryflysky.utils.DequeMap;



/**
 * 式を被演算子と演算子にわけてそれぞれのDequeとして保持
 *
 * @author admin
 *
 */
public class ExpressionDeque {

	private DequeMap<String> deques;



	public ExpressionDeque() {

		deques = new DequeMap<String>();

		deques.addDeque(OPERAND);
		deques.addDeque(OPERATOR);
	}




	public void addLastOperand(String value) {

		addIfNotBlank(OPERAND, value);
	}



	public String removeFirstOperand() {

		return deques.removeFirst(OPERAND);
	}



	public void addLastOperator(String value) {

		addIfNotBlank(OPERATOR, value);
	}



	public String removeFirstOperator() {

		return deques.removeFirst(OPERATOR);
	}



	public Deque<String> getOperands() {

		return deques.getDeque(OPERAND);
	}



	public Deque<String> getOperators() {

		return deques.getDeque(OPERATOR);
	}



	public boolean hasOperand() {

		return deques.isNotEmpty(OPERAND);
	}



	public boolean hasOperator() {

		return deques.isNotEmpty(OPERATOR);
	}



	private void addIfNotBlank(Structure key, String value) {

		if(StringUtils.isNotBlank(value)) {

			deques.addLast(key, value);
		}
	}




	public boolean containsOperator(Operator operator) {

		return deques.contains(OPERATOR, operator.getSimbole());
	}
}
