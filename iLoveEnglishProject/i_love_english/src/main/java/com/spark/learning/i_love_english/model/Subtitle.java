package com.spark.learning.i_love_english.model;

import java.util.LinkedList;
import java.util.List;

public class Subtitle {
	public List<String> getOriginalLines() {
		return originalLines;
	}
	public void setOriginalLines(List<String> originalLines) {
		this.originalLines = originalLines;
	}
	public List<SubtitleSection> getSections() {
		return sections;
	}
	public void setSections(List<SubtitleSection> sections) {
		this.sections = sections;
	}
	private List<String> originalLines = new LinkedList<String>();
	private List<SubtitleSection> sections = new LinkedList<SubtitleSection>();
}
