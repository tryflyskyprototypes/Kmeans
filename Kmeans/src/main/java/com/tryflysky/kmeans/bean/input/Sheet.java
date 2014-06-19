package com.tryflysky.kmeans.bean.input;
import java.util.LinkedList;
import java.util.List;

import com.tryflysky.kmeans.validation.ValidateStatus;


public class Sheet extends Validatable {


	private final DivideNumber divideNumber;
	private final List<Row> rows;





	public Sheet(String splitSize, List<String> lines) {

		this.divideNumber = new DivideNumber(splitSize);
		this.rows = convertToRows(lines);
	}






	private List<Row> convertToRows(List<String> lines) {

		List<Row> rows = new LinkedList<Row>();
		for(String line : lines) {
			rows.add(new Row(line));
		}

		return rows;
	}






	public ValidateStatus validate() {

		ValidateStatus state_split = divideNumber.validate();

		ValidateStatus state_rows = ValidateStatus.VALID;

		for(Row row : rows) {

			if(row.invalid()) {

				state_rows = ValidateStatus.INVALID;
				break;
			}
		}

		return ((state_split == ValidateStatus.VALID) && (state_rows == ValidateStatus.VALID)) ? ValidateStatus.VALID : ValidateStatus.INVALID;
	}






	/**
	 * divideNumberを取得します。
	 * @return divideNumber
	 */
	public DivideNumber getDivideNumber() {
	    return divideNumber;
	}






	/**
	 * rowsを取得します。
	 * @return rows
	 */
	public List<Row> getRows() {
	    return rows;
	}




}
