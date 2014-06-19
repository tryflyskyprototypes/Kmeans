package com.tryflysky.kmeans;

import java.io.IOException;
import java.util.List;

import com.tryflysky.kmeans.bean.input.Sheet;
import com.tryflysky.kmeans.bean.output.Block;
import com.tryflysky.kmeans.reader.DataReader;
import com.tryflysky.kmeans.utils.BlockDivider;
import com.tryflysky.kmeans.utils.BlockSorter;
import com.tryflysky.kmeans.utils.SheetTranslator;
import com.tryflysky.kmeans.viewer.ResultViewer;

public class KmeanExecutor {


	private final DataReader dataReader;
	private final ResultViewer resultViewer;

	public KmeanExecutor(DataReader dataReader, ResultViewer resultViewer) {

		this.dataReader = dataReader;
		this.resultViewer = resultViewer;
	}






	public void execute() throws IOException {

		Sheet inputed = dataReader.read();

		//TODO validate

		//translate
		Block translated = new SheetTranslator().toBlock(inputed);

		//divide
		List<Block> blocks = new BlockDivider().execute(translated, inputed.getDivideNumber());

		//sort
		List<Block> blocks_sorted = new BlockSorter().execute(blocks);

		//export result
		resultViewer.view(blocks_sorted);
	}

}
