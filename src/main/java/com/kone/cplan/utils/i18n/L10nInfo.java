package com.kone.cplan.utils.i18n;

import java.util.Locale;
import java.util.Map;

/**
 * This class encapsulates information for localization.
 * 
 * @author Gennadiy Pervukhin
 * @created 29-05-2019
 */
public class L10nInfo {

	//
	//Constructors
	//
	private L10nInfo(String localeCode) {
		this.languageTag = localeCode;
	}
	//
	
	//
	//Variables
	//
	//e.g., ru-RU, en-US
	private String languageTag;
	private String dateTimePattern;
	private String datePattern;
	private String timePattern;
	
	private String stringsHashCode;
	private Map<String, String> stringsMap;
	//
	
	//
	//Properties
	//
	public String getLanguageTag() {
		return languageTag;
	}
	
	public String getDateTimePattern() {
		return dateTimePattern;
	}
	public String getDatePattern() {
		return datePattern;
	}
	public String getTimePattern() {
		return timePattern;
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
	public static L10nInfo buildNew(String languageTag) {
		//- initialize a new I18nInfo and Locale
		L10nInfo i18nInfo = new L10nInfo(languageTag);
		Locale locale = Locale.forLanguageTag(languageTag);
		
		//- set string resources
		i18nInfo.stringsHashCode = ResourceBundleUtils.getStringsHashCode(locale);
		i18nInfo.stringsMap = ResourceBundleUtils.getStringsMap(locale);
		
		//- set patterns
		i18nInfo.dateTimePattern = FormatUtils.getDateTimePattern(locale);
		i18nInfo.datePattern = FormatUtils.getDatePattern(locale);
		i18nInfo.timePattern = FormatUtils.getTimePattern(locale);
		
		return i18nInfo;
	}
	//
}