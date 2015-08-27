/**
 * 
 */
package com.spark.learning.i_love_english.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yun
 *
 */
public class SingleWord {
	private List<WordForm> wordForms = new ArrayList<WordForm>();
    private TokenType tokenType;
    
    private String content;
    
	public TokenType getTokenType() {
		return tokenType;
	}
	public void setTokenType(TokenType tokenType) {
		this.tokenType = tokenType;
	}
	public String getContent() {
		return content;
	}	
	public void setContent(String token) {
		content = token.trim();
	}

}
