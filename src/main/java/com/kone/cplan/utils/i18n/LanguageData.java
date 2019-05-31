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
	private LanguageData(String languageCode) {
		this.languageCode = languageCode;
	}
	//
	
	//
	//Variables
	//
	//examples: ru, en-US
	private String languageCode;
	
	private String stringsHashCode;
	private Map<String, String> stringsMap;
	//
	
	//
	//Properties
	//
	public String getLanguageCode() {
		return languageCode;
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
	public static LanguageData buildNew(String languageCode) {
		
		languageCode = StringUtils.emptyIfNull(languageCode);
		
		//- initialize a new LanguageData and Locale
		LanguageData languageData = new LanguageData(languageCode);
		Locale locale = new Locale(languageCode);
		
		//- set string resources
		languageData.stringsHashCode = LanguageBundleUtils.getStringsHashCode(locale);
		languageData.stringsMap = LanguageBundleUtils.getStringsMap(locale);
		
		return languageData;
	}
	//
}