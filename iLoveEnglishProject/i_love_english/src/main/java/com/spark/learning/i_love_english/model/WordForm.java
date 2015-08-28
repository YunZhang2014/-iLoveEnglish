/**
 * 
 */
package com.spark.learning.i_love_english.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Yun
 *
 */
@Entity
@Table(name="word_form")
public class WordForm {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	/**
	 * The number of the entry in the dict.
	 */
	private int EntryNo;
	
	/**
	 * is 1-based instead of 0-based
	 */
	@Column(name="line_no")
	private int lineNo;
	
	private String headLine;
	
	/**
	 * The text every word form has
	 */
	@Column(name="text_content",length=4000)
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
