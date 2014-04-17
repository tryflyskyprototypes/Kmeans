package com.tryflysky.calcurator;

import com.tryflysky.expression.helper.ExpressionUtils;
import com.tryflysky.expression.model.Expression;
import com.tryflysky.expression.model.ExpressionDeque;
import com.tryflysky.expression.model.Operator;




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

	private final Operator target;	// +-/*いずれかの演算子


	public OneOeratorCalculator(Operator target) {

		this.target = target;
	}





	public ExpressionDeque execute(String expression) {

		return execute(new Expression(expression));
	}



	public ExpressionDeque execute(Expression expression) {

		return execute(expression.toDeque());
	}



	public ExpressionDeque execute(ExpressionDeque deque) {

		return calculate(deque);
	}





	/**
	 * 担当の演算子のみ計算した式を返す（今はDeque返してますが）
	 * 最初に見つかった担当の演算子のみ計算するメソッドを再帰しながら呼ぶことで最終的には全て計算される
	 *
	 * @param deque
	 * @return
	 */
	private ExpressionDeque calculate(ExpressionDeque deque) {

		if(deque.notContainsOperator(target)) {

			return deque;
		}

		return calculate(calculateFirstHit(deque));
	}





	/**
	 * 最初に見つかった担当の演算子のみ計算して返す
	 *
	 * @param deque
	 * @return
	 */
	private ExpressionDeque calculateFirstHit(ExpressionDeque deque) {

		ExpressionDeque calculated = new ExpressionDeque();

		while(deque.hasOperator()) {

			String operator = deque.removeFirstOperator();

			if(myTarget(operator)) {

				calculated.addLastOperand(String.valueOf(target.calculate(deque)));

				ExpressionUtils.transferLastAll(calculated, deque);
				break;
			}

			calculated.addLastOperator(operator);
			calculated.addLastOperand(deque.removeFirstOperand());
		}

		return calculated;
	}





	private boolean myTarget(String candidate) {

		return ExpressionUtils.match(candidate, target);
	}
}
