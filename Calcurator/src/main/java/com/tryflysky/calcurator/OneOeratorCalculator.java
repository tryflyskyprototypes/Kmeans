package com.tryflysky.calcurator;

import org.apache.commons.lang3.StringUtils;

import com.tryflysky.expression.model.Expression;
import com.tryflysky.expression.model.ExpressionDeque;
import com.tryflysky.expression.model.Operator;
import com.tryflysky.utils.DequeUtils;
import com.tryflysky.utils.MyCollectionUtils;




/**
 * 指定された演算子のみ計算した式を返す
 * （※現状はDequeのまま返してる）
 *
 * 括弧を含む式には未対応（ParenthesesRemoverで外してある前提）
 *
 * @author admin
 *
 */
public class OneOeratorCalculator {

	private final Operator targetOperator;	// +-/*いずれかの演算子


	public OneOeratorCalculator(Operator targetOperator) {

		this.targetOperator = targetOperator;
	}




	public ExpressionDeque execute(Expression expression) {

		return execute(expression.getDeque());
	}



	public ExpressionDeque execute(ExpressionDeque expressionDeque) {

		if(containsMyTarget(expressionDeque)) {

			return execute(calculateFirstHit(expressionDeque));
		}else {

			return expressionDeque;
		}
	}




	/**
	 * 担当の演算子かつ最初に見つかったもののみ計算して返す
	 * execute()の方で再帰してるので最終的には全て計算される
	 *
	 * @param expressionDeque
	 * @return
	 */
	private ExpressionDeque calculateFirstHit(ExpressionDeque expressionDeque) {

		ExpressionDeque result = new ExpressionDeque();

		while(expressionDeque.hasOperator()) {

			String operator = expressionDeque.removeFirstOperator();

			if(myTarget(operator)) {

				result.addLastOperand(calculate(expressionDeque));

				transferAll(result, expressionDeque);

			}else {

				result.addLastOperator(operator);
				result.addLastOperand(expressionDeque.removeFirstOperand());
			}
		}

		return result;
	}




	private String calculate(ExpressionDeque expressionDeque) {

		int v1 = Integer.parseInt(expressionDeque.removeFirstOperand());
		int v2 = Integer.parseInt(expressionDeque.removeFirstOperand());

		return String.valueOf(targetOperator.calculate(v1, v2));
	}




	private void transferAll(ExpressionDeque to, ExpressionDeque from) {

		DequeUtils.transferLastAll(to.getOperands(), from.getOperands());
		DequeUtils.transferLastAll(to.getOperators(), from.getOperators());
	}




	private boolean containsMyTarget(ExpressionDeque expressionDeque) {

		return MyCollectionUtils.contains(expressionDeque.getOperators(), targetOperator.getSimbole());
	}




	private boolean myTarget(String candidate) {

		return StringUtils.equals(candidate, targetOperator.getSimbole());
	}
}
