package com.tryflysky.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;



/**
 * ApacheのStringUtilsの不足を埋めるための独自Utils
 *
 * @author kawakami(tmp06557)
 * @since 2013/12/26
 *
 */
public class MyStringUtils {




	/**
	 * キーに変換前の文字列、値に変換後の文字列を持つMapと
	 * StringUtils.replaceEach(text, searchList[], replacementList[])をつなぐ
	 *
	 * @param value
	 * @param replaceMap
	 * @return
	 */
	public static String replaceEach(String value, Map<String, String> replaceMap) {

		List<String> searchStrs = new LinkedList<String>();
		List<String> replaceStrs = new LinkedList<String>();

		for(Entry<String, String> e : replaceMap.entrySet()) {

			searchStrs.add(e.getKey());
			replaceStrs.add(e.getValue());
		}

		return StringUtils.replaceEach(value, toArray(searchStrs), toArray(replaceStrs));
	}




	/**
	 * 文字列のリストを配列に変換する際、毎回引数に配列を渡す手間を軽減
	 *
	 * @param strList
	 * @return
	 */
	//TODO CollectionのUtilとしたほうがいい？
	public static String[] toArray(List<String> strList) {

		return strList.toArray(new String[strList.size()]);
	}




	public static boolean matchAny(String value, String[] searchStrs) {

		for(String seach : searchStrs) {

			if(value.equals(seach)) {

				return true;
			}
		}

		return false;
	}
}
