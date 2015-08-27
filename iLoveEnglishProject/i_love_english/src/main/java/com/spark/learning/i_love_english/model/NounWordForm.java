package com.spark.learning.i_love_english.model;

public class NounWordForm extends WordForm {
	
	/**
	 * NC - countable noun
	 * NU - uncountable noun
	 * NV - countable or uncountable noun
	 * N_UN_UNIFIED - The word forms for each sense differ
	 * @author Yun
	 *
	 */
	public enum Countable{NC,NU,NV,N_UN_UNIFIED};
	
	private Countable countable;

	public Countable getCountable() {
		return countable;
	}

	public void setCountable(Countable countable) {
		this.countable = countable;
	}
}
