/**
 * 
 */
package com.spark.learning.i_love_english.model;

/**
 * @author Yun
 *
 */
public class VerbWordForm extends WordForm {
	public enum Transitive{VT,VI,VTI, N_UN_UNIFIED};
	
	private Transitive transitive;

	public Transitive getTransitive() {
		return transitive;
	}

	public void setTransitive(Transitive transitive) {
		this.transitive = transitive;
	}	
}
