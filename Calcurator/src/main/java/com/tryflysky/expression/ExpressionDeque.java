package com.tryflysky.expression;

import static com.tryflysky.expression.Structure.*;

import java.util.Deque;

import org.apache.commons.lang3.StringUtils;

import com.tryflysky.utils.DequeMap;



public class ExpressionDeque {

	private DequeMap<String> dequeMap;



	public ExpressionDeque() {

		dequeMap = new DequeMap<String>();

		dequeMap.addDeque(OPERAND);
		dequeMap.addDeque(OPERATOR);
	}


	public void addFirstOperand(String value) {

		dequeMap.addFirst(OPERAND, value);
	}


	public void addLastOperand(String value) {

		addIfNotBlank(OPERAND, value);

//		dequeMap.addLast(OPERAND, value);
	}






	public String removeFirstOperand() {

		return dequeMap.removeFirst(OPERAND);
	}



	public void addLastOperator(String value) {

		addIfNotBlank(OPERATOR, value);

//		dequeMap.addLast(OPERATOR, value);
	}



	public String removeFirstOperator() {

		return dequeMap.removeFirst(OPERATOR);
	}



	public String getFirstOperator() {

		return dequeMap.getFirst(OPERATOR);
	}



	public Deque<String> getOperands() {

		return dequeMap.getDeque(OPERAND);
	}



	public Deque<String> getOperators() {

		return dequeMap.getDeque(OPERATOR);
	}



	public boolean hasOperand() {

		return dequeMap.isNotEmpty(OPERAND);
	}



	public boolean hasOperator() {

		return dequeMap.isNotEmpty(OPERATOR);
	}


	private void addIfNotBlank(Structure key, String value) {

		if(StringUtils.isNotBlank(value)) {

			dequeMap.addLast(key, value);
		}
	}



}
