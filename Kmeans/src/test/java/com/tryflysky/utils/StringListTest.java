package com.tryflysky.utils;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class StringListTest {


	/**
	 * 普通に生成
	 */
	@Test
	public void construct_normal() {

		StringList words = new StringList();
		words.add("standing")
		.add("by");

		assertEquals("standing by", words.toLine(" "));
	}



	/**
	 * コンストラクタに文字列を渡して生成
	 */
	@Test
	public void construct_with_string() {

		StringList words = new StringList("Rider");
		words.add("sting");

		assertEquals("Rider, sting", words.toLine(", "));
	}



	/**
	 * コンストラクタにListを渡して生成
	 *
	 */
	@Test
	public void construct_with_list() {

		List<String> wordList = new LinkedList<String>();
		wordList.add("one");
		wordList.add("two");
		wordList.add("three");
		wordList.add("Rider kick!");

		StringList words = new StringList(wordList);

		assertEquals("one, two, three, Rider kick!", words.toLine(", "));
	}



	/**
	 * コンストラクタに配列を渡して生成
	 *
	 */
	@Test
	public void construct_wit_array() {

		String[] wordArray = {"hyper", "cast", "off"};
		StringList words = new StringList(wordArray);

		assertEquals("hyper cast off", words.toLine(" "));
	}


	/**
	 * 空要素は出力時に無視される
	 */
	@Test
	public void toLineIgnoreBlankTest() {

		List<String> wordList = new LinkedList<String>();
		wordList.add("one");
		wordList.add("");
		wordList.add("two");
		wordList.add(" ");
		wordList.add("three");
		wordList.add("　");
		wordList.add("	");
		wordList.add("Rider kick!");

		StringList words = new StringList(wordList);

		assertEquals("one, two, three, Rider kick!", words.toLineIgnoreBlankElements(", "));
		assertEquals("one, , two,  , three, 　, 	, Rider kick!", words.toLine(", "));
	}



	/**
	 * CSV出力
	 */
	@Test
	public void toCsvTest() {

		StringList words = new StringList();

		words.add("cast")
		.add("off")
		.add("change")
		.add("beatle");

		assertEquals("cast,off,change,beatle", words.toCsv());
	}




	/**
	 * CSV出力（カンマの後に空白あり）
	 */
	@Test
	public void toCsvWithBlankTest() {

		StringList words = new StringList();

		words.add("cast")
		.add("off")
		.add("change")
		.add("beatle");

		assertEquals("cast, off, change, beatle", words.toCsvWithBlank());
	}




	/**
	 * 重複の削除
	 * 戻るのは新しいオブジェクト
	 */
	@Test
	public void removeOverlapTest() {

		StringList words = new StringList("a")
		.add("b")
		.add("c")
		.add("a")
		.add("d");

		StringList words_unique = words.removeOverlap();

		assertEquals("a, b, c, d", words_unique.toCsvWithBlank());
	}




	/**
	 * 格納されているのが空文字または空白文字だけなら真
	 */
	@Test
	public void isBlankStringOnlyTest() {

		StringList words = new StringList()
		.add("")
		.add(" ")
		.add("	")
		.add("　");

		assertTrue(words.isBlankStringOnly());
	}




	/**
	 * 配列化
	 */
	@Test
	public void toArrayTest() {

		StringList words = new StringList();

		words.add("a")
		.add("b")
		.add("c")
		.add("d");

		String[] array = words.toArray();

		assertTrue(array.length == 4);
		assertEquals("a", array[0]);
		assertEquals("b", array[1]);
		assertEquals("c", array[2]);
		assertEquals("d", array[3]);
	}



	@Test
	public void removeBlankElementsTest() {

		StringList words = new StringList("")
		.add("lightning")
		.add(" ")
		.add("	")
		.add("volt")
		.add("　")
		.add("!");

		StringList words_noBlank = words.removeBlankElements();

		String[] array = words_noBlank.toArray();

		assertEquals("lightning", array[0]);
		assertEquals("volt", array[1]);
		assertEquals("!", array[2]);

	}





	@Test
	public void coundWordTest() {

		StringList words = new StringList("a")
		.add("b")
		.add("b")
		.add("d")
		.add("d")
		.add("d");

		assertTrue(words.countWord("a") == 1);
		assertTrue(words.countWord("b") == 2);
		assertTrue(words.countWord("d") == 3);


	}
}
