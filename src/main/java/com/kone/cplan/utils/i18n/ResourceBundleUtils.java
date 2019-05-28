package com.kone.cplan.utils.i18n;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.core.io.ClassPathResource;

import com.kone.cplan.config.AppSettings;

/**
 * This class provides utilities for the Resource Bundle.
 * 
 * @author Gennadiy Pervukhin
 * @created 28-05-2019
 */
public class ResourceBundleUtils {

	//
	//Private static methods
	//
	private static Map<String, String> readMapOfStrings(Locale locale) {
		
		//STEP #1: load the bundle of messages
		ResourceBundle bundle = MessageSourceResourceBundle.getBundle(
			AppSettings.getMessagesBaseName(), locale, new ResourceBundleControl_UTF8());
		
		//STEP #2: go through the keys and build a map of key-value pairs
		Map<String, String> map = new HashMap<>();
		Enumeration<String> keys = bundle.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			map.put(key, bundle.getString(key));
		}
		
		return map;
	}
	
	private static long getResourceFileSize(Locale locale) {
		
		//STEP #1: build name of the file
		String fileName = AppSettings.getMessagesBaseName();
		if (locale != null) {
			fileName += "_" + locale.toString();
		}
		fileName += ".properties";
		
		//STEP #2: try to find the file and get its length
		ClassPathResource resourseFile = new ClassPathResource(fileName);
		try {
			return resourseFile.contentLength();
		}
		catch (IOException e) {
			return 0;
		}
	}
	//
	
	//
	//Public static methods
	//
	public static Map<String, String> getStringsMap(Locale locale) {
		
		if (locale == null) { return (new HashMap<>()); }
		
		//STEP #1: get strings for the default locale
		Map<String, String> mapOfStrings = readMapOfStrings(AppSettings.DEFAULT_LOCALE);
		
		//STEP #2: get localized strings (if it's needed) and extend (override) the map by them
		Map<String, String> localizedStrings = (locale.equals(AppSettings.DEFAULT_LOCALE)
			? new HashMap<>() : readMapOfStrings(locale));
		mapOfStrings.putAll(localizedStrings);
		
		return mapOfStrings;
	}
	
	public static String getStringsHashCode(Locale locale) {
		//since the map of strings is based on 2 resource files (default one and localized one), we
		//should consider both of them, when we generate the hash code
		long defaultResourceSize = getResourceFileSize(null);
		long localizedResourceSize = getResourceFileSize(locale);
		return (defaultResourceSize + "_" + localizedResourceSize);
	}
	//
}