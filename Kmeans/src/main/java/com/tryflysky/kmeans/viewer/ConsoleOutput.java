package com.tryflysky.kmeans.viewer;

import java.util.List;

import com.tryflysky.kmeans.bean.output.Block;
import com.tryflysky.kmeans.bean.output.Coordinate;



public class ConsoleOutput implements ResultViewer {



	public void view(List<Block> blocks) {

		System.out.println();

		System.out.println("-- clustering results --");
		System.out.println();

		for(Block block : blocks) {

			view(block);
			System.out.println();
		}

//		System.out.println();
		System.out.println("------------------------");

	}




	private void view(Block block) {

		List<Coordinate> coordinates = block.readCoordinates();

		for(Coordinate c : coordinates) {

			System.out.println(c.toString());
		}
	}

}
