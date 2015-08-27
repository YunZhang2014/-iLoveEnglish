package com.spark.learning.i_love_english.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.spark.learning.i_love_english.model.Sentence;
import com.spark.learning.i_love_english.model.SingleWord;
import com.spark.learning.i_love_english.model.TokenType;
import com.spark.learning.i_love_english.service.SentenceAnalyser;

public class DefaultSentenceAnalyser implements SentenceAnalyser {

	public Sentence parseIntoTokens(String sentence) {
		Sentence result = new Sentence();
		result.setOrginalContent(sentence);
		String punc = sentence.substring(sentence.length() - 1, sentence.length());
		sentence = sentence.substring(0,sentence.length() - 1);
		String[] tokens = sentence.split("\\s+");
		for (int i = 0; i < tokens.length; i++) {
			SingleWord singleWord = new SingleWord();
			result.getWords().add(singleWord);
			String token = tokens[i];
			singleWord.setContent(token);
			if (isPunctuation(token)){
				singleWord.setTokenType(TokenType.PUNCTUATION);
			}else{
				singleWord.setTokenType(TokenType.WORD);
			}
		}
		SingleWord singleWord = new SingleWord();
		result.getWords().add(singleWord);
		singleWord.setTokenType(TokenType.PUNCTUATION);
		singleWord.setContent(punc);

		return result;
	}

	private boolean isPunctuation(String token) {
		String temp = token.trim();
		if (temp.matches("[,.?!]")){
			return true;
		}else{
			return false;		
		}
	}

}
