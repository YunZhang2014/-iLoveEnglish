/**
 * 
 */
package com.spark.learning.i_love_english.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.spark.learning.i_love_english.model.Sentence;
import com.spark.learning.i_love_english.service.SentenceAnalyser;

/**
 * @author Yun
 *
 */
public class DefaultSentenceAnalyserTest {

	/**
	 * Test method for {@link com.spark.learning.i_love_english.service.impl.DefaultSentenceAnalyser#parseIntoTokens(java.lang.String)}.
	 */
	@Test
	public void testParseIntoWords() {
		SentenceAnalyser sentenceAnalyser = new DefaultSentenceAnalyser();
		Sentence sentence = sentenceAnalyser.parseIntoTokens("It's political and polarizing.");
		assertEquals("It's political and polarizing.", sentence.getOrginalContent());
		assertEquals(5, sentence.getWords().size());
		assertEquals("It's", sentence.getWords().get(0).getContent());
		assertEquals("political", sentence.getWords().get(1).getContent());
		assertEquals("and", sentence.getWords().get(2).getContent());
		assertEquals("polarizing", sentence.getWords().get(3).getContent());
		assertEquals(".", sentence.getWords().get(4).getContent());
		assertEquals("It's political and polarizing.", sentence.getSynthesisedContent());
		
	}

}
