package com.spark.learning.i_love_english.service.impl;

import java.util.List;

import com.spark.learning.i_love_english.model.Subtitle;
import com.spark.learning.i_love_english.model.SubtitleSection;
import com.spark.learning.i_love_english.service.SubtitleAnalyser;
import com.spark.learning.i_love_english.util.StringUtil;

public class DefaulSubtitleAnalyser implements SubtitleAnalyser {

	public Subtitle analyseSubtitle(List<String> contents) {
		Subtitle subtitle = new Subtitle();
		for (int i = 0; i < contents.size(); i++) {
			String line = contents.get(i);
			if (!StringUtil.isEmptyOrNumOnly(line)){
				if (line.contains("-->")){
					String[] strs = line.split("-->");
					if (strs.length != 2){
						throw new RuntimeException("Incorrect timeline format");
					}else{
						SubtitleSection section = new SubtitleSection();
						
						section.setBeginTime(StringUtil.strToTime(strs[0]));
						section.setEndTime(StringUtil.strToTime(strs[1]));
						section.setOrginalLineNo(i+1);
						if (i + 1 < contents.size()){
							String nextLine = contents.get(i+1);
							if (StringUtil.containChinese(nextLine)){
								section.setChineseLine(nextLine);
								if (i + 2 < contents.size()){
									section.setEnglishLine(contents.get(i+2));
								}
							}else{
								section.setEnglishLine(nextLine);
							}
							section.setOrginalLineNo(i+1);
						}
						subtitle.getSections().add(section);
					}
				}
			}
		}
		return subtitle;
	}


}
