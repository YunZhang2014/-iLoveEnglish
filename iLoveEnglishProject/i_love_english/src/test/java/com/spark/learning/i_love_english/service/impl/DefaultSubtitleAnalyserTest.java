package com.spark.learning.i_love_english.service.impl;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.spark.learning.i_love_english.model.Subtitle;
import com.spark.learning.i_love_english.model.SubtitleSection;
import com.spark.learning.i_love_english.service.SubtitleAnalyser;
import com.spark.learning.i_love_english.util.FileUtil;

public class DefaultSubtitleAnalyserTest {
	List<String> lines; 
	@Before
	public void setUp() throws Exception {
		lines = FileUtil.readResourceToLines("resources/subtitle/Wolf Creek Film Subtitle 2005.txt","GB2312");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		SubtitleAnalyser sa = new DefaulSubtitleAnalyser();
		Subtitle subtitle= sa.analyseSubtitle(lines);
		assertNotNull(subtitle);
		assertNotNull(subtitle.getSections());
		assertFalse(subtitle.getSections().isEmpty());
		SubtitleSection section = null;
		section = subtitle.getSections().get(0);
		assertEquals(2, section.getOrginalLineNo());
		assertEquals(Time.valueOf("00:01:49"), section.getBeginTime());
		assertEquals(Time.valueOf("00:01:57"),section.getEndTime());
		assertEquals("你和两个姑娘一起旅行 是吗，老兄？",section.getChineseLine());
		assertEquals("You traveling with two sheilas, are you, mate?",section.getEnglishLine());
		assertEquals(761,subtitle.getSections().size());
	}

}
