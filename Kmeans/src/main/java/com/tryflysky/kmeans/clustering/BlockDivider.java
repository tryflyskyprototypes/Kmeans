package com.tryflysky.kmeans.clustering;

import java.util.LinkedList;
import java.util.List;

import com.tryflysky.kmeans.bean.input.DivideNumber;
import com.tryflysky.kmeans.bean.output.Block;
import com.tryflysky.kmeans.bean.output.Coordinate;

public class BlockDivider {



	//TODO 割り切れる数であること前提の実装なので、余りは最後のブロックとするようにしても良い
	public List<Block> execute(Block block, DivideNumber divideNumber) {

		final int dividedBlockSize = block.readCoordinates().size() / divideNumber.intValue();

		List<Coordinate> coordinates = block.readCoordinates();

		Block divided = new Block();

		List<Block> dividedBlocks = new LinkedList<Block>();

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
