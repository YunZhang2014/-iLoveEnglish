package com.spark.learning.i_love_english.service.longmanimpl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.spark.learning.i_love_english.model.AdjWordForm;
import com.spark.learning.i_love_english.model.NounWordForm;
import com.spark.learning.i_love_english.model.VerbWordForm;
import com.spark.learning.i_love_english.model.VerbWordForm.Transitive;
import com.spark.learning.i_love_english.model.WordForm;
import com.spark.learning.i_love_english.service.WordAnalyser;

import static junit.framework.Assert.*;

public class LongmanWordAnalyserTest {
	
	List<String> text = new LinkedList<String>();
	InputStream inputStream;
	
	@Before
	public void setUp() throws Exception {
		inputStream = this.getClass().getClassLoader().getResourceAsStream("resources/sample_words/subject.txt");
		Reader reader = new InputStreamReader(inputStream,"UTF-8");
		BufferedReader br = new BufferedReader(reader);
		String line = null;
		while((line = br.readLine()) != null){
			text.add(line);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAnalyseWordForms() {
		WordAnalyser wordAnalyser = new LongmanWordAnalyser();
		List<WordForm> wordForms = wordAnalyser.analyseWordForms(text);
		assertNotNull(wordForms);
		
		assertEquals(wordForms.size(), 3);
		
		WordForm wordForm = wordForms.get(0);
		assertNotNull(wordForm);
		assertTrue(wordForm instanceof NounWordForm);
		assertEquals(wordForm.getEntryNo(), 1);
		assertEquals(2,wordForm.getLineNo());
		assertEquals("sub·ject1 W2S2 /ˈsʌbdʒɪkt/ n [C]",wordForm.getHeadLine());
		NounWordForm nounWordForm = (NounWordForm)wordForm;
		assertEquals(nounWordForm.getCountable(),NounWordForm.Countable.NC);
		
		wordForm = wordForms.get(1);
		assertNotNull(wordForm);
		assertTrue(wordForm instanceof AdjWordForm);
		AdjWordForm adjWordForm = (AdjWordForm)wordForm;
		assertEquals(2,adjWordForm.getEntryNo());
		assertEquals(61,wordForm.getLineNo());	
		assertEquals("subject2 adj",wordForm.getHeadLine());
		
		wordForm = wordForms.get(2);
		assertNotNull(wordForm);
		assertTrue(wordForm instanceof VerbWordForm);
		VerbWordForm verbWordForm = (VerbWordForm)wordForm;
		assertEquals(3,verbWordForm.getEntryNo());
		assertEquals(74,wordForm.getLineNo());
		assertEquals("sub·ject3 /səbˈdʒekt/ v [T]",wordForm.getHeadLine());
		assertEquals(verbWordForm.getTransitive(),VerbWordForm.Transitive.VT);
	}

}
