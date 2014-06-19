package com.tryflysky.kmeans.bean.input;

import com.tryflysky.kmeans.config.ValidateStatus;

abstract public class Validatable {



	public abstract ValidateStatus validate();



	public final boolean valid() {

		return validate() == ValidateStatus.VALID;
	}



	public final boolean invalid() {

		return ! valid();
	}

}
