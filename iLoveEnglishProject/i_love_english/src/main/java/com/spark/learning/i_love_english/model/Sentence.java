package com.spark.learning.i_love_english.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @pdOid 41ed7526-40a3-45bc-a991-6adeefcadd39
 */

@Entity
@Table(name = "MESSAGES")
public class Sentence extends EntityObject {
	public List<SingleWord> getWords() {
		return words;
	}

	public void setWords(List<SingleWord> words) {
		this.words = words;
	}

	public String getSynthesisedContent() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < words.size(); i++) {
			SingleWord singleWord = words.get(i);
			sb.append(singleWord.getContent());
			//no space before and after the last punctuation.
			if (i != words.size() - 1 && i != words.size() - 2){
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	/**
	 * @pdOid 3faa6184-a2e8-40ff-b9c6-9d0741137eb2
	 */
	public java.lang.String getOrginalContent() {
		return orginalContent;
	}

	/**
	 * @param newContent
	 * @pdOid 853ee45c-bd52-42ac-b377-522184801706
	 */
	public void setOrginalContent(java.lang.String newContent) {
		orginalContent = newContent.trim();
	}

	// test spring support
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Sentence sentence = context.getBean(Sentence.class);
		//sentence.setContent("Hello,Spring");
		//System.out.println(sentence.getContent());

	}

	/**
	 * @pdOid fcb86c3a-4e64-4027-b2c5-39d97bfeef5e
	 */
	private java.lang.String orginalContent;
	
	private List<SingleWord> words = new LinkedList<SingleWord>();

}