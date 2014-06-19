package com.tryflysky.kmeans.bean.output;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;




public class Block {

	private List<Coordinate> coordinates;



	public Block() {

		this(new LinkedList<Coordinate>());
	}


	public Block(List<Coordinate> coordinates) {

		this.coordinates = coordinates;
	}




	public void add(Coordinate c) {

		coordinates.add(c);
	}



	public List<Coordinate> readCoordinates() {

		return Collections.unmodifiableList(coordinates);
	}





	public void addAll(List<Coordinate> c) {

		coordinates.addAll(c);
	}



	public int size() {

		return coordinates.size();
	}





}
