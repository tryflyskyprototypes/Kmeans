package com.tryflysky.kmeans.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.tryflysky.kmeans.bean.output.Block;
import com.tryflysky.kmeans.bean.output.Coordinate;

public class BlockSorter {



	public List<Block> execute(List<Block> unsorteds) {

		List<Block> sorteds = new LinkedList<Block>();

		for(Block unsorted : unsorteds) {

			sorteds.add(execute(unsorted));
		}

		return sorteds;
	}




	public Block execute(Block unsorted) {

		List<Coordinate> c = unsorted.readCoordinates();

		Coordinate[] c_array = toArray(c);

		Arrays.sort(c_array, new Sorter(0));

		return new Block(Arrays.asList(c_array));
	}




	private Coordinate[] toArray(List<Coordinate> list) {

		Coordinate[] array = new Coordinate[list.size()];
		for(int i = 0; i < array.length; i++) {

			array[i] = list.get(i);
		}

		return array;
	}







	private class Sorter implements Comparator<Coordinate> {

		private final int sortIndex;


		Sorter(int sortIndex) {

			this.sortIndex = sortIndex;
		}



		public int compare(Coordinate o1, Coordinate o2) {

			int compareValue_1 = o1.toArray()[sortIndex];
			int compareValue_2 = o2.toArray()[sortIndex];

			if(compareValue_1 == compareValue_2) {

				return new Sorter(sortIndex + 1).compare(o1, o2);
			}

			return o1.vertical() - o2.vertical();
		}
	}





}
