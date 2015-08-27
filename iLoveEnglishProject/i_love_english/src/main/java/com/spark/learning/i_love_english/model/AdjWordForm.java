/**
 * 
 */
package com.spark.learning.i_love_english.model;

/**
 * @author Yun
 *
 */
public class AdjWordForm extends WordForm {
	/**
	 * ALL all position  </br>
	 * NBN not before noun </br>
	 * OBN only before noun </br>
	 * UBN usually before noun </br>
	 * @author Yun
	 *
	 */
	public enum Position{ALL,NBN,OBN,UBN};
	
	private Position position;

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
