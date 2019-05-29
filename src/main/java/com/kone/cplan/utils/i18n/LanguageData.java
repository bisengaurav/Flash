package com.kone.cplan.utils.i18n;

import java.util.Locale;
import java.util.Map;

import com.kone.cplan.helpers.datatype.StringUtils;

/**
 * This class encapsulates data for a particular language.
 * 
 * @author Gennadiy Pervukhin
 * @created 29-05-2019
 */
public class LanguageData {

	//
	//Constructors
	//
	private LanguageData(String languageKey) {
		this.languageKey = languageKey;
	}
	//
	
	//
	//Variables
	//
	//examples: ru, en-US
	private String languageKey;
	
	private String stringsHashCode;
	private Map<String, String> stringsMap;
	//
	
	//
	//Properties
	//
	public String getLanguageKey() {
		return languageKey;
	}
	
	public String getStringsHashCode() {
		return stringsHashCode;
	}
	public Map<String, String> getStringsMap() {
		return stringsMap;
	}
	//
	
	//
	//Public static methods
	//
	public static LanguageData buildNew(String languageKey) {
		
		languageKey = StringUtils.emptyIfNull(languageKey);
		
		//- initialize a new LanguageData and Locale
		LanguageData languageData = new LanguageData(languageKey);
		Locale locale = new Locale(languageKey);
		
		//- set string resources
		languageData.stringsHashCode = ResourceBundleUtils.getStringsHashCode(locale);
		languageData.stringsMap = ResourceBundleUtils.getStringsMap(locale);
		
		return languageData;
	}
	//
}