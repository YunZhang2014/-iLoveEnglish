package com.spark.learning.i_love_english.util;

import java.sql.Time;

public class StringUtil {
	public static boolean isEmptyOrNumOnly(String line) {
		if (line.trim().length() == 0 || line.trim().matches("^\\d+$")){
			return true;
		}else{
			return false;
		}
	}

	public static Time strToTime(String str) {
		String newStr = str.trim();
		if (newStr.length() > 8){
			newStr = newStr.substring(0, 8);
		}
		return Time.valueOf(newStr);
	}

	public static boolean containChinese(String str) {
        char[] ch = str.toCharArray();  
        for (int i = 0; i < ch.length; i++) {  
            char c = ch[i];  
            if (isChinese(c)) {  
                return true;  
            }  
        }  
        return false;  
	}

	private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {  
            return true;  
        }  
        return false;  
	}
}
