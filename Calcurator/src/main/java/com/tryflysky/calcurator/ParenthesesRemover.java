package com.tryflysky.calcurator;

import java.util.Deque;
import com.tryflysky.expression.helper.ExpressionUtils;
import com.tryflysky.expression.model.Expression;
import com.tryflysky.expression.model.Parentheses;



/**
 * 括弧内のみ計算して、括弧の無い式を返す
 *
 * @author admin
 *
 */
public class ParenthesesRemover {

	private AllOperatorCalculator calcurator = new AllOperatorCalculator();





	/*public Expression execute(String expression) {

		return execute(new Expression(expression));
	}*/
	public Expression execute(String expression) {

		return new Expression(toNoParenthesesExpression(ExpressionUtils.toCharacterDeque(expression)));
	}



	/**
	 * 式に含まれる全ての括弧内を計算して括弧のない式を返す
	 * 検証は省略
	 *
	 * @param expression
	 * @return
	 */
	/*public Expression execute(Expression expression) {

		if(expression.notContainsParentheses()) {	//ガード節
			return expression;
		}

		Deque<StringBuilder> partExpressions = new LinkedList<StringBuilder>();	//括弧で分割した式

		StringBuilder currentPart = new StringBuilder();	//括弧内の式

		for(int i = 0; i < expression.toString().length(); i++) {

			String c = String.valueOf(expression.toString().charAt(i));

			//雑だけどまあいいや
			if(leftParentheses(c)) {

				partExpressions.addLast(currentPart);
				currentPart = new  StringBuilder();

			}else if(rightParentheses(c)) {

				String calculated = calcurator.execute(currentPart.toString());

				currentPart = partExpressions.removeLast();

				currentPart.append(calculated);

			}else {

				currentPart.append(c);
			}
		}

		return new Expression(currentPart.toString());
	}*/
	private String toNoParenthesesExpression(Deque<String> charDeque) {

		StringBuilder noParentheses = new StringBuilder();

		while( ! charDeque.isEmpty()) {

			String c = charDeque.removeFirst();

			if(leftParentheses(c)) {

				c = toNoParenthesesExpression(charDeque);	//左括弧[(]が見つかったら再帰
			}

			if(rightParentheses(c)) {

				return calcurator.execute(noParentheses.toString());	//右括弧がでたらそこまでを計算
			}

			noParentheses.append(c);
		}

		return noParentheses.toString();
	}








	private boolean leftParentheses(String c) {

		return ExpressionUtils.match(c, Parentheses.LEFT);
	}





	private boolean rightParentheses(String c) {

		return ExpressionUtils.match(c, Parentheses.RIGHT);
	}
}
