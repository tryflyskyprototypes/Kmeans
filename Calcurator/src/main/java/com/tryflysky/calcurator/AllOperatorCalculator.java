package com.tryflysky.calcurator;

import com.tryflysky.expression.model.Expression;
import com.tryflysky.expression.model.ExpressionDeque;
import com.tryflysky.expression.model.Operator;



/**
 * 加減乗除の演算子全てを計算した答えを返す
 * 括弧を含む式には未対応（ParenthesesRemoverで外してある前提）
 *
 * @author admin
 *
 */
public class AllOperatorCalculator {

	//計算の優先順
	Operator[] calculateOrder = {
			Operator.MULTIPLE,
			Operator.DIVIDE,
			Operator.PLUS,
			Operator.MINUS,
	};




	public  String execute(String expression) {

		return execute(new Expression(expression));
	}





	public String execute(Expression expression) {

		ExpressionDeque result = expression.getDeque();

		for(Operator target : calculateOrder) {

			result = new OneOeratorCalculator(target).execute(result);
		}

		return result.getOperands().removeFirst();
	}
}
