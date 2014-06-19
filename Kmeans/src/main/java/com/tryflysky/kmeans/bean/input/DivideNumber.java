package com.tryflysky.kmeans.bean.input;

import com.tryflysky.kmeans.config.ValidateStatus;

public class DivideNumber extends Validatable {

	private final String value;

	public DivideNumber(String value) {

		this.value = value;
	}



	public int intValue() {

		return Integer.parseInt(value);
	}



	@Override
	public ValidateStatus validate() {

		//TODO 真面目に実装すること
		try {
			Integer.parseInt(value);

			return ValidateStatus.VALID;

		}catch(Exception e) {

			return ValidateStatus.INVALID;
		}
	}

}
