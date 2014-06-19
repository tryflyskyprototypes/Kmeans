package com.tryflysky.kmeans.reader;

import java.io.IOException;
import java.util.Arrays;

import com.tryflysky.kmeans.bean.input.Sheet;

public class MockTextReader implements DataReader {

	private final String divideNum;


	public MockTextReader(int divideNum) {

		this.divideNum = String.valueOf(divideNum);
	}

	public Sheet read() throws IOException {

		String[] lines = {
				"0 0 0 0 0 0 0 0 0 0 0",
				"0 0 0 0 0 0 1 0 0 0 0",
				"0 0 1 0 0 0 0 0 0 0 0",
				"0 0 0 0 0 0 0 0 0 0 0",
				"0 0 0 1 0 0 0 0 0 0 0",
				"0 0 0 0 0 0 0 0 0 0 0",
				"0 0 0 0 0 0 1 0 0 0 0",
				"0 0 0 0 0 0 0 0 0 0 0",
				"0 0 0 0 0 0 1 0 0 0 0",
				"0 0 0 0 0 0 0 0 0 0 0",
				"0 0 0 0 0 0 0 0 0 1 0",
		};


		return new Sheet(divideNum, Arrays.asList(lines));
	}

}
