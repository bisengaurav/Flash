package com.kone.cplan.helpers.datatype;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringUtils {
	
	//
	//Constants
	//
	public static final String EMPTY = "";
	
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	//
	
	//
	//Public static methods
	//
	public static Boolean isEmpty(String sourceString) {
		return (sourceString == null || sourceString.isEmpty());
	}
	
	public static Boolean isNotEmpty(String sourceString) {
		return (!isEmpty(sourceString));
	}
	
	public static String emptyIfNull(String value)
	{
		return (value != null ? value : EMPTY);
	}
	
	public static String toLowerCase(String sourceString) {
		return (sourceString != null ? sourceString.toLowerCase() : null);
	}
	
	public static List<String> toLowerCase(Collection<String> sourceStrings) {
		List<String> formattedStrings = new ArrayList<>();
		for (String sourceString : sourceStrings) {
			formattedStrings.add(toLowerCase(sourceString));
		}
		return formattedStrings;
	}
	
	public static String truncate(String sourceString, int limit) {
		if (sourceString != null && limit > -1 && sourceString.length() > limit) {
			return sourceString.substring(0, limit);
		}
		return sourceString;
	}
	
	public static byte[] getBytes(String content) {
		return (content != null ? content.getBytes(DEFAULT_CHARSET) : new byte[0]);
	}
	
	public static String[] split(String sourceString, String separator) {
		return (sourceString != null ? sourceString.split(separator) : new String[0]);
	}
	
	/*public static String decodeBase64(String base64String) {
		return (base64String != null ? new String(java.util.Base64.getDecoder().decode(base64String)) : null);
	}*/
	//
}
