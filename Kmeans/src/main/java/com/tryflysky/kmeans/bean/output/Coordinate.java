package com.tryflysky.kmeans.bean.output;



public class Coordinate {

	private final int VERTICAL = 0;
	private final int HORIZONTAL = 1;
//	private final int Z = 2;
	private final int AXIS_SIZE = 2;

	private final int[] coordinate = new int[AXIS_SIZE];	//※Final宣言しても要素を変更出来ないわけではないことを忘れるな


	public Coordinate(int vertical, int horizontal) {

		coordinate[VERTICAL] = vertical;
		coordinate[HORIZONTAL] = horizontal;
	}



	public int vertical() {

		return coordinate[VERTICAL];
	}



	public int horizontal() {

		return coordinate[HORIZONTAL];
	}



	public int[] toArray() {

		return coordinate;
	}



	@Override
	public String toString() {

		return coordinate[VERTICAL] + ", " + coordinate[HORIZONTAL];
	}
}
