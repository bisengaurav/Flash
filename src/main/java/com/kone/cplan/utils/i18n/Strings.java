package com.kone.cplan.utils.i18n;

import org.springframework.context.MessageSource;
import com.kone.cplan.utils.spring.AppContextHolder;

/**
 * This class provides static utilities to work with localized messages. But it must be parameterized
 * by instance of a MessageSource on application startup.
 * 
 * @author Gennadiy Pervukhin
 * @created 27-05-2019
 */
public class Strings {
	
	//
	//Static initialization
	//
	private static MessageSource messageSource;
	
	public static void setMessageSource(MessageSource messageSource) {
		Strings.messageSource = messageSource;
	}
	//
	
	//
	//Public static utility methods
	//
	public static String get(String code) {
		return messageSource.getMessage(code, null, AppContextHolder.currentLocale());
	}
	
	public static String getAndFormat(String code, Object... params) {
		return String.format(get(code), params);
	}
	//
}