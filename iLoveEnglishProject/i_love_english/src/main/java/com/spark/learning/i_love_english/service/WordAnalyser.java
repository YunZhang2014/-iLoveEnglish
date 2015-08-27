/**
 * 
 */
package com.spark.learning.i_love_english.service;

import java.util.List;

import com.spark.learning.i_love_english.model.WordForm;

/**
 * @author Yun
 *
 */
public interface WordAnalyser {
	List<WordForm> analyseWordForms(List<String> textContent);
}
