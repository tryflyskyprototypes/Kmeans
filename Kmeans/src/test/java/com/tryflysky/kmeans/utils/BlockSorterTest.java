package com.tryflysky.kmeans.utils;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.tryflysky.kmeans.bean.input.Row;
import com.tryflysky.kmeans.bean.output.Block;
import com.tryflysky.kmeans.bean.output.Coordinate;
import com.tryflysky.kmeans.clustering.BlockSorter;
import com.tryflysky.kmeans.clustering.SheetTranslator;

public class BlockSorterTest {

	
	
	@Test
	public void test() {
		
		String[] lines = {
				"0 0 0 0 0 0 1 0 0 0 0",
				"1 0 0 0 0 0 0 0 0 0 0",
				"0 0 0 0 0 0 1 0 0 0 0",
		};


		List<Row> rows = new LinkedList<Row>();
		for(String line : lines) {

			rows.add(new Row(line));
		}


		String[] expects = {
				"0, 1",
				"6, 0",
				"6, 2",
		};
		
		
		Block translated = new SheetTranslator().toBlock(rows);

		Block sorted = new BlockSorter().execute(translated);
		
		List<Coordinate> actual = sorted.readCoordinates();
		
		for(int i = 0; i < sorted.size(); i++) {
			
			System.out.println(actual.get(i).toString());
			
			assertEquals(expects[i], actual.get(i).toString());
		}
		
		
		
	}

}
