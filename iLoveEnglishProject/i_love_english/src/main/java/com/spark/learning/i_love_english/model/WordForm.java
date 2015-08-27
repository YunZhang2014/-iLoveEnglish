/**
 * 
 */
package com.spark.learning.i_love_english.model;

/**
 * @author Yun
 *
 */
public class WordForm {		
	/**
	 * The number of the entry in the dict.
	 */
	private int EntryNo;
	
	/**
	 * is 1-based instead of 0-based
	 */
	private int lineNo;
	
	private String headLine;
	
	/**
	 * The text every word form has
	 */
	private String textContent;
	
	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}
	
	public String getHeadLine() {
		return headLine;
	}

	/**
	 * trim the empty space
	 * @param headLine
	 */
	public void setHeadLine(String headLine) {
		this.headLine = headLine.trim();
	}
	

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public int getEntryNo() {
		return EntryNo;
	}

	public void setEntryNo(int entryNo) {
		EntryNo = entryNo;
	}
}
