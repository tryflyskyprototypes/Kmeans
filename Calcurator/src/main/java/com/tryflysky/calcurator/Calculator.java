package com.tryflysky.calcurator;

import com.tryflysky.expression.Expression;
import com.tryflysky.expression.ExpressionFactory;


/**
 * 計算機
 * 関連クラスは全てintで計算するので、小数点以下の出る計算には不向き
 *
 * 漢数字も計算できる
 * 漢数字の場合は漢数字で返すようなこ洒落た機能は無い
 *
 * @author syowha
 *
 */
public class Calculator {



	/**
	 * 単純に全て計算して答えを返す
	 *
	 * 検証は省略
	 * エラーが出たら式を見直してもらう
	 *
	 * @param expression
	 * @return
	 */
	public int execute(String expression) {

		Expression exp = ExpressionFactory.generate(expression);

		exp = new ParenthesesRemover().execute(exp);

		String answer = new AllOperatorCalculator().execute(exp);

		return Integer.parseInt(answer);
	}



	/*
	 * メモ
	 * ParenthesesRemoverとOneOperatorCalculatorを組み合わせれば
	 * 括弧のみ外す、指定した演算子のみ計算して返すなど可能
	 * Webにインターフェースを用意して作ってみてもよいかも
	 */
}
