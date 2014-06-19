package com.tryflysky.utils;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * List<String>をラップするクラス
 *
 * チェーンで値を追加できる
 *
 * ※StringUtilsに依存
 *
 * 今は出力（toLine()）で空文字を含む空要素は無視する
 *
 * @author kawakami 20130701
 *
 */
public class StringList {

	private List<String> elements = new LinkedList<String>();


	/**
	 * コンストラクタ
	 */
	public StringList() {
	}
	public StringList(String word) {
		elements.add(word);
	}
	public StringList(List<String> wordList) {
		this.elements = wordList;
	}
	public StringList(String[] wordArray) {
		add(wordArray);
	}






	/**
	 * 一語追加
	 * @param str
	 * @return
	 */
	public StringList add(String str) {
		elements.add(str);

		return this;
	}


	/**
	 * まとめて追加
	 *
	 * @param wordArray
	 */
	public void add(String[] wordArray) {

		if(ArrayUtils.isNotEmpty(wordArray)) {
			for(String word : wordArray) {
				elements.add(word);
			}
		}
	}


	/**
	 * まとめて追加
	 *
	 * @param strList
	 * @return
	 */
	public StringList addAll(List<String> strList) {
		elements.addAll(strList);

		return this;
	}



	/**
	 * 第一引数を区切り文字として文字列を生成
	 *
	 * @param delimiter
	 * @return
	 */
	public String toLine(String delimiter) {

		StringBuilder oneLine = new StringBuilder();

		for(String word : elements) {

			oneLine.append(StringUtils.chomp(word));
			oneLine.append(delimiter);
		}

		return StringUtils.removeEnd(oneLine.toString(), delimiter);
	}



	/**
	 * 第一引数を区切り文字として文字列を生成
	 * 空文字を含む空要素は無視して出力
	 *
	 * @param delimiter
	 * @return
	 */
	public String toLineIgnoreBlankElements(String delimiter) {

		return removeBlankElements().toLine(delimiter);
	}



	/**
	 * CSV出力
	 *
	 * @return
	 */
	public String toCsv() {

		return toLine(",");
	}


	/**
	 * CSV出力（カンマの後に空白あり)
	 * @return
	 */
	public String toCsvWithBlank() {

		return toLine(", ");
	}


	/**
	 * wordListを取得します。
	 * @return wordList
	 */
	public List<String> toList() {
	    return elements;
	}



	/**
	 * 重複を削除した新しいオブジェクトを返す
	 *
	 * @return
	 */
	public StringList removeOverlap() {

		List<String> uniqueList = new LinkedList<String>(new LinkedHashSet<String>(elements));

		return new StringList(uniqueList);
	}




	/**
	 * 空であれば真
	 * 空白文字は空扱い
	 *
	 * @return
	 */
	public boolean isBlankStringOnly() {

		return StringUtils.isBlank(toLine(""));
	}



	/**
	 * 配列にして返す
	 *
	 * @return
	 */
	public String[] toArray() {

		return elements.toArray(new String[elements.size()]);
	}




	/**
	 * 空白の要素は削除して返す
	 * 空文字は空白扱い
	 *
	 * @return
	 */
	public StringList removeBlankElements() {

		List<String> no_blank_elements = new LinkedList<String>();
		for(String element : elements) {

			if(StringUtils.isNotBlank(element)) {
				no_blank_elements.add(element);
			}
		}

		return new StringList(no_blank_elements);
	}




	/**
	 * Wordsに含まれる第2引数の数を返す
	 *
	 * ※現状は以下のように動く
	 *
	 * words.add("cast off").add("cast") とした場合に[cast]を検索すると結果は1件
	 * Wordsの要素単位で文字列比較しているだけなので
	 *
	 * @param stringList
	 * @param searchStr
	 * @return
	 */
	//TODO 名前がcountMatchElementとかのほうがいいかも
	public int countWord(String searchStr) {

		int found = 0;

		for(String one_of_many : elements) {

			if(StringUtils.equals(searchStr, one_of_many)) {
				found++;
			}
		}

		return found;
	}


}
