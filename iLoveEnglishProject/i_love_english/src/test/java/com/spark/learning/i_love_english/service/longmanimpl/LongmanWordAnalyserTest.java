package com.spark.learning.i_love_english.service.longmanimpl;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.spark.learning.i_love_english.model.AdjWordForm;
import com.spark.learning.i_love_english.model.NounWordForm;
import com.spark.learning.i_love_english.model.VerbWordForm;
import com.spark.learning.i_love_english.model.WordForm;
import com.spark.learning.i_love_english.service.WordAnalyser;
import com.spark.learning.i_love_english.util.FileUtil;

public class LongmanWordAnalyserTest {
	
	List<String> text;
	
	@Before
	public void setUp() throws Exception {
		text = FileUtil.readResourceToLines("resources/sample_words/subject.txt");
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
