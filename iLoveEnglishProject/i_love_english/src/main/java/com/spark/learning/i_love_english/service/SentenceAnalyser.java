/**
 * 
 */
package com.spark.learning.i_love_english.service;

import com.spark.learning.i_love_english.model.Sentence;

/**
 * @author Yun
 *
 */
public interface SentenceAnalyser {
	Sentence parseIntoTokens(String sentence);
}
