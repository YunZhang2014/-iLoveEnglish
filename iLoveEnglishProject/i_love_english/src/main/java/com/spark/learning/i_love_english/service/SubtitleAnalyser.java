package com.spark.learning.i_love_english.service;

import java.util.List;

import com.spark.learning.i_love_english.model.Subtitle;

public interface SubtitleAnalyser {
	Subtitle analyseSubtitle(List<String> contents);
}
