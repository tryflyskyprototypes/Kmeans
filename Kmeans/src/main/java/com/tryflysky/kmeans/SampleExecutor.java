package com.tryflysky.kmeans;

import java.io.IOException;

import com.tryflysky.kmeans.reader.ConsolePrompt;
import com.tryflysky.kmeans.reader.MockTextReader;
import com.tryflysky.kmeans.viewer.ConsoleOutput;

public class SampleExecutor {

	public static void main(String[] args) {

//		KmeanExecutor executor = new KmeanExecutor(new ConsolePrompt(), new ConsoleOutput());
		KmeanExecutor executor = new KmeanExecutor(new MockTextReader(), new ConsoleOutput());

		try {
			executor.execute();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
