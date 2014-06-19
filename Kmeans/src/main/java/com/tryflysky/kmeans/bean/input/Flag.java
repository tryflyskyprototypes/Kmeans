package com.tryflysky.kmeans.bean.input;

import org.apache.commons.lang3.StringUtils;

import com.tryflysky.kmeans.config.DataConfig;
import com.tryflysky.kmeans.validation.ValidateStatus;
import com.tryflysky.utils.MyStringUtils;


public class Flag extends Validatable {

	private final String value;


	public Flag(final String value) {

		this.value = value;
	}



	public ValidateStatus validate() {

		return MyStringUtils.matchAny(value, DataConfig.FLAG_VALUES) ? ValidateStatus.VALID : ValidateStatus.INVALID;
	}



	public boolean on() {

		return  StringUtils.equals(value, DataConfig.FLAG_ON);
	}




}
