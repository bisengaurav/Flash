package com.kone.cplan.utils.i18n;

import java.util.Locale;
import com.kone.cplan.helpers.datatype.StringUtils;

/**
 * This class encapsulates information for localization.
 * 
 * @author Gennadiy Pervukhin
 * @created 29-05-2019
 */
public class L10nData {

	//
	//Constructors
	//
	private L10nData(String countryCode) {
		this.countryCode = countryCode;
	}
	//
	
	//
	//Variables
	//
	//examples: RU, US
	private String countryCode;
	
	private String dateTimePattern;
	private String datePattern;
	private String timePattern;
	
	private LanguageData languageData;
	//
	
	//
	//Properties
	//
	public String getCountryCode() {
		return countryCode;
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
	public static L10nData buildNew(String languageCode, String countryCode) {
		
		languageCode = StringUtils.emptyIfNull(languageCode);
		countryCode = StringUtils.emptyIfNull(countryCode);
		
		//- initialize a new L10nData and Locale
		L10nData l10nData = new L10nData(countryCode);
		Locale locale = new Locale(languageCode, countryCode);
		
		//- set patterns
		//TODO: Talk to Alex and decide whether we need this.
		Formatters formatters = new Formatters(locale);
		l10nData.dateTimePattern = formatters.forDateTime().toPattern();
		l10nData.datePattern = formatters.forDate().toPattern();
		l10nData.timePattern = formatters.forTime().toPattern();
		
		//- initialize and set language data
		l10nData.languageData = LanguageData.buildNew(languageCode);
		
		return l10nData;
	}
	//
}