package com.tryflysky.kmeans.reader;

import java.io.IOException;

import com.tryflysky.kmeans.bean.input.Sheet;

public interface DataReader {


	public Sheet read() throws IOException;


//	public List<String> showValidateReport(ValidateReport report);
}
