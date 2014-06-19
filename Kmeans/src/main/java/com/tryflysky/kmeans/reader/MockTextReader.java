package com.tryflysky.kmeans.reader;

import java.io.IOException;
import java.util.Arrays;

import com.tryflysky.kmeans.bean.input.Sheet;

public class MockTextReader implements DataReader {



	public Sheet read() throws IOException {

		final String divideNum = "2";


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
