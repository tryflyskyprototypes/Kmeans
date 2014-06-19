package com.tryflysky.kmeans.clustering;

import java.util.LinkedList;
import java.util.List;

import com.tryflysky.kmeans.bean.input.DivideNumber;
import com.tryflysky.kmeans.bean.output.Block;
import com.tryflysky.kmeans.bean.output.Coordinate;

public class BlockDivider {


	public List<Block> execute(Block block, DivideNumber divideNumber) {

		List<Block> dividedBlocks = new LinkedList<Block>();

		final int dividedBlockSize = block.readCoordinates().size() / divideNumber.intValue();


		List<Coordinate> coordinates = block.readCoordinates();

		Block divided = new Block();

		for(int i = 0; i < coordinates.size(); i++) {

			divided.add(coordinates.get(i));

			if(divided.size() == dividedBlockSize) {

				dividedBlocks.add(divided);
				divided = new Block();
			}
		}


		return dividedBlocks;
	}

}
