package com.tryflysky.kmeans.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import com.tryflysky.kmeans.bean.input.Sheet;
import com.tryflysky.kmeans.config.DataConfig;





public class ConsolePrompt implements DataReader {

	private String divideNum;
	private List<String> lines;





	public Sheet read() throws IOException {

		divideNum = inputDivideNumber();

		lines = inputLines();

		return new Sheet(divideNum, lines);
	}



	private List<String> inputLines() throws IOException {

		List<String> lines = new LinkedList<String>();

		for(int i = 0; i < DataConfig.ROW_SIZE; i++) {

			System.out.println("Input line [" + i + "]");
			lines.add(sysoutPrompt());
		}

		return lines;
	}



	private String inputDivideNumber() throws IOException {

		System.out.println("Input split size...");
		return sysoutPrompt();
	}



	private String sysoutPrompt() throws IOException {

		System.out.print("->  ");

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		return input.readLine();
	}



}