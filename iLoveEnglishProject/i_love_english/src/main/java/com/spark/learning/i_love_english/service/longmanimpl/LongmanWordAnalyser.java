package com.spark.learning.i_love_english.service.longmanimpl;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.spark.learning.i_love_english.model.AdjWordForm;
import com.spark.learning.i_love_english.model.NounWordForm;
import com.spark.learning.i_love_english.model.NounWordForm.Countable;
import com.spark.learning.i_love_english.model.VerbWordForm;
import com.spark.learning.i_love_english.model.VerbWordForm.Transitive;
import com.spark.learning.i_love_english.model.WordForm;
import com.spark.learning.i_love_english.service.WordAnalyser;

public class LongmanWordAnalyser implements WordAnalyser {

	public List<WordForm> analyseWordForms(List<String> textContent) {
		if (textContent == null || textContent.size() == 0) {
			throw new IllegalArgumentException(String.format("%s cannot be null", "textContent"));
		}
		List<WordForm> wordForms = new LinkedList<WordForm>();
		Pattern pattern = Pattern.compile("[a-zA-Z·]+\\d");

		int i = 0;
		for (int lineNo = 0; lineNo < textContent.size(); lineNo++) {
			String line = textContent.get(lineNo);

			Matcher matcher = pattern.matcher(line);
			if (matcher.find()) {
				System.out.println(line);
				WordForm wordForm = null;
				if (line.indexOf(" n ") != -1) {
					NounWordForm nounWordForm = new NounWordForm();
					wordForm = nounWordForm;
					if (line.indexOf("[C]") != -1) {
						nounWordForm.setCountable(Countable.NC);
					} else if (line.indexOf("[U]") != -1) {
						nounWordForm.setCountable(Countable.NU);
					} else if (line.indexOf("[U and C]") != -1) {
						nounWordForm.setCountable(Countable.NV);
					} else {
						nounWordForm.setCountable(Countable.N_UN_UNIFIED);
					}
				} else if (line.indexOf(" adj") != -1) {
					wordForm = new AdjWordForm();
					AdjWordForm adjWordForm = (AdjWordForm) wordForm;
				} else if (line.indexOf(" v ") != -1) {
					wordForm = new VerbWordForm();
					VerbWordForm verbWordForm = (VerbWordForm) wordForm;
					if (line.indexOf("[T]") != -1) {
						verbWordForm.setTransitive(Transitive.VT);
					} else if (line.indexOf("[I]") != -1) {
						verbWordForm.setTransitive(Transitive.VI);
					} else if (line.indexOf("[I and T]") != -1 || line.indexOf("[T and I]") != -1) {
						verbWordForm.setTransitive(Transitive.VTI);
					} else {
						verbWordForm.setTransitive(Transitive.N_UN_UNIFIED);
					}
				}
				if (wordForm != null) {
					wordForms.add(wordForm);
					wordForm.setEntryNo(++i);
					//the lineNo is 1-based
					wordForm.setLineNo(lineNo + 1);
					wordForm.setHeadLine(line);
				}
			}

		}
		return wordForms;
	}

}
