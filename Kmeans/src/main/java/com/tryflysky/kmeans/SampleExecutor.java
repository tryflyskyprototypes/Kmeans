package com.tryflysky.kmeans;

import java.io.IOException;

import com.tryflysky.kmeans.reader.ConsolePrompt;
import com.tryflysky.kmeans.reader.MockTextReader;
import com.tryflysky.kmeans.viewer.ConsoleOutput;



/**
 * 動作確認用
 *
 * @author admin
 *
 */
public class SampleExecutor {

	public static void main(String[] args) {

//		KmeanExecutor executor = new KmeanExecutor(new ConsolePrompt(), new ConsoleOutput());
//		KmeanExecutor executor = new KmeanExecutor(new MockTextReader(), new ConsoleOutput());

		try {
			final int maxDivideNum = 3;

			for(int i = 1; i <= maxDivideNum; i++) {

				System.out.println("### clustering : " + i);

				KmeanExecutor executor = new KmeanExecutor(new MockTextReader(i), new ConsoleOutput());
				executor.execute();

				System.out.println();
				System.out.println();
				System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
