package com.tryflysky.calcurator;

import com.tryflysky.calcurator.helper.ExpressionDequeGenerator;
import com.tryflysky.calcurator.helper.ExpressionDequeViewer;
import com.tryflysky.calcurator.helper.Translator;
import com.tryflysky.expression.ExpressionDeque;
import com.tryflysky.expression.Operator;



/**
 * 加減乗除の演算子全てを計算した答えを返す
 * 括弧を含む式には未対応（ParenthesesRemoverで外してある前提）
 *
 * @author admin
 *
 */
public class AllOperatorCalculator {

	ExpressionDequeGenerator dequeGenerator = new ExpressionDequeGenerator();

	//計算の優先順
	Operator[] calculateOrder = {
			Operator.MULTIPLE,
			Operator.DIVIDE,
			Operator.PLUS,
			Operator.MINUS,
	};



	ExpressionDequeViewer viewer = new ExpressionDequeViewer();


	public  String execute(String expression) {

		return execute(dequeGenerator.execute(expression));
	}



	public String execute(ExpressionDeque expressionDeque) {

		ExpressionDeque result = Translator.toTranslatedDeque(expressionDeque);

		for(Operator target : calculateOrder) {

			result = new OneOeratorCalculator(target).execute(result);
		}

		return result.getOperands().removeFirst();
	}
}
