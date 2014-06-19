package com.tryflysky.kmeans.bean.input;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.tryflysky.kmeans.config.DataConfig;
import com.tryflysky.kmeans.config.ValidateStatus;




public class Row extends Validatable {


	private final List<Flag> flags;




	public Row(String inputed) {

		this.flags = toFlags(inputed);
	}




	private List<Flag> toFlags(String inputed) {

		String[] splited = StringUtils.split(inputed, DataConfig.FLAG_DELIMITER);

		List<Flag> result = new LinkedList<Flag>();

		for(String value : splited) {

			result.add(new Flag(value));
		}

		return result;
	}




	public ValidateStatus validate() {

		if(flags.size() != DataConfig.COLUMN_SIZE) {

			return ValidateStatus.INVALID;
		}

		for(Flag flag : flags) {

			if(! flag.invalid()) {

				return ValidateStatus.INVALID;
			}
		}

		return ValidateStatus.VALID;
	}




	public Flag readAt(int index) {

		return flags.get(index);
	}



	public int size() {

		return flags.size();
	}

}
