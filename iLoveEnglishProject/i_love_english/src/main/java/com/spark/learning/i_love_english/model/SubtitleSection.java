package com.spark.learning.i_love_english.model;

import java.sql.Time;

public class SubtitleSection {
	public int getOrginalLineNo() {
		return orginalLineNo;
	}
	public void setOrginalLineNo(int orginalLineNo) {
		this.orginalLineNo = orginalLineNo;
	}
	public Time getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Time beginTime) {
		this.beginTime = beginTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	public String getEnglishLine() {
		return englishLine;
	}
	public void setEnglishLine(String englishLine) {
		this.englishLine = englishLine;
	}
	public String getChineseLine() {
		return chineseLine;
	}
	public void setChineseLine(String chineseLine) {
		this.chineseLine = chineseLine;
	}
	
	private int orginalLineNo;
	private Time beginTime;
	private Time endTime;
	private String englishLine;
	private String chineseLine;
}
