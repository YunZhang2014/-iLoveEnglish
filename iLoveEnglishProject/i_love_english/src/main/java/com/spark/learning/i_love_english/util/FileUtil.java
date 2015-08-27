/**
 * 
 */
package com.spark.learning.i_love_english.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yun
 *
 */
public class FileUtil {
	public static List<String> readResourceToLines(String fileName) throws UnsupportedEncodingException, IOException {
		List<String> text = new LinkedList<String>();
		InputStream inputStream = FileUtil.class.getClassLoader().getResourceAsStream(fileName);
		try {
			Reader reader = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(reader);
			String line = null;
			while((line = br.readLine()) != null){
				text.add(line);
			}
			return text;
		} finally {
			if (inputStream != null){
				inputStream.close();
			}
		}

		
	}

	public static List<String> readResourceToLines(String resourceName, String encoding) {
		List<String> text = new LinkedList<String>();
		InputStream inputStream = FileUtil.class.getClassLoader().getResourceAsStream(resourceName);
		try {
			Reader reader = new InputStreamReader(inputStream,encoding);
			BufferedReader br = new BufferedReader(reader);
			String line = null;
			while((line = br.readLine()) != null){
				text.add(line);
			}
			return text;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UnsupportedEncodingException",e);
		} catch (IOException e) {
			throw new RuntimeException("UnsupportedEncodingException",e);
		} 
		finally {
			if (inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}	
}
