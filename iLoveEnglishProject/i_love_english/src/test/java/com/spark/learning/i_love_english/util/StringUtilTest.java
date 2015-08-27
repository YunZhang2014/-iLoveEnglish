package com.spark.learning.i_love_english.util;

import static org.junit.Assert.*;

import java.sql.Time;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testIsEmptyOrNumOnly() {
		assertTrue(StringUtil.isEmptyOrNumOnly(""));
		assertTrue(StringUtil.isEmptyOrNumOnly(" "));
		assertTrue(StringUtil.isEmptyOrNumOnly("9"));
		assertTrue(StringUtil.isEmptyOrNumOnly("10"));
		assertFalse(StringUtil.isEmptyOrNumOnly("00:02:00,520 --> 00:02:01,509"));
		assertFalse(StringUtil.isEmptyOrNumOnly("是啊"));
	}
	
	@Test 
	public void testStrToTime(){
		String str = "00:02:00,520";
		Time time = StringUtil.strToTime(str);
		assertEquals(Time.valueOf("00:02:00"), time);
	}
	
	@Test
	public void testContainChinese(){
		assertTrue(StringUtil.containChinese("I am 张云"));
		assertFalse(StringUtil.containChinese("I am yun zhang"));
	}

}
