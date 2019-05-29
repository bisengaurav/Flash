package com.kone.cplan.utils.i18n;

import java.util.Locale;
import com.kone.cplan.helpers.datatype.StringUtils;

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
	private L10nInfo(String countryKey) {
		this.countryKey = countryKey;
	}
	//
	
	//
	//Variables
	//
	//examples: RU, US
	private String countryKey;
	
	private String dateTimePattern;
	private String datePattern;
	private String timePattern;
	
	private LanguageData languageData;
	//
	
	//
	//Properties
	//
	public String getCountryKey() {
		return countryKey;
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
	
	public LanguageData getLanguageData() {
		return languageData;
	}
	//
	
	//
	//Public static methods
	//
	public static L10nInfo buildNew(String languageKey, String countryKey) {
		
		languageKey = StringUtils.emptyIfNull(languageKey);
		countryKey = StringUtils.emptyIfNull(countryKey);
		
		//- initialize a new L10nInfo and Locale
		L10nInfo l10nInfo = new L10nInfo(countryKey);
		Locale locale = new Locale(languageKey, countryKey);
		
		//- set patterns
		l10nInfo.dateTimePattern = FormatUtils.getDateTimePattern(locale);
		l10nInfo.datePattern = FormatUtils.getDatePattern(locale);
		l10nInfo.timePattern = FormatUtils.getTimePattern(locale);
		
		//- initialize and set language data
		l10nInfo.languageData = LanguageData.buildNew(languageKey);
		
		return l10nInfo;
	}
	//
}