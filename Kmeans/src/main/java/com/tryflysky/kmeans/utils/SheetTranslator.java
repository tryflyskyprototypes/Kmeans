package com.tryflysky.kmeans.utils;

import java.util.LinkedList;
import java.util.List;

import com.tryflysky.kmeans.bean.input.Flag;
import com.tryflysky.kmeans.bean.input.Row;
import com.tryflysky.kmeans.bean.input.Sheet;
import com.tryflysky.kmeans.bean.output.Block;
import com.tryflysky.kmeans.bean.output.Coordinate;

public class SheetTranslator {


	public Block toBlock(Sheet sheet) {

		return toBlock(sheet.getRows());
	}




	public Block toBlock(List<Row> rows) {

		Block translated = new Block();

		for(int i = 0; i < rows.size(); i++) {

			translated.addAll(toSameRowCoordinates(toVerticalCoordinateList(rows.get(i)), i));
		}

		return translated;
	}




	private List<Integer> toVerticalCoordinateList(Row row) {

		List<Integer> verticalCoordinates = new LinkedList<Integer>();

		for(int i = 0; i < row.size(); i++) {

			Flag flag = row.readAt(i);

			if(flag.on()) {

				verticalCoordinates.add(i);
			}
		}

		return verticalCoordinates;
	}




	private List<Coordinate> toSameRowCoordinates(List<Integer> verticalCoordinates, int horizontalCoordinate) {

		List<Coordinate> result = new LinkedList<Coordinate>();

		for(Integer vertical : verticalCoordinates) {

			result.add(new Coordinate(vertical, horizontalCoordinate));
		}

		return result;
	}


}
