package com.tryflysky.kmeans.utils;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.tryflysky.kmeans.bean.input.Row;
import com.tryflysky.kmeans.bean.output.Block;
import com.tryflysky.kmeans.bean.output.Coordinate;
import com.tryflysky.kmeans.clustering.SheetTranslator;

public class SheetTranslatorTest {


	SheetTranslator sheetTranslator = new SheetTranslator();


	@Test
	public void test() {

		String[] lines = {
				"0 0 0 0 0 0 0 0 0 0 0",
				"1 0 0 0 0 0 0 0 0 0 0",
				"0 0 0 0 0 0 1 0 0 0 1",
		};


		List<Row> rows = new LinkedList<Row>();
		for(String line : lines) {

			rows.add(new Row(line));
		}


		String[] expects = {
				"0, 1",
				"6, 2",
				"10, 2"
		};


		Block translated = sheetTranslator.toBlock(rows);


		assertTrue(expects.length == translated.size());

		List<Coordinate> actual = translated.readCoordinates();

		for(int i = 0; i < actual.size(); i++) {

			assertEquals(expects[i], actual.get(i).toString());
		}
	}

}
