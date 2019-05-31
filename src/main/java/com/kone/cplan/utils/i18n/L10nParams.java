package com.kone.cplan.utils.i18n;

import java.util.Locale;

import com.kone.cplan.config.AppSettings;
import com.kone.cplan.jpa.entity.User;

/**
 * This class encapsulates parameters of localization.
 * 
 * @author Gennadiy Pervukhin
 * @created 30-05-2019
 */
public class L10nParams {
	
	//
	//Constructors
	//
	public L10nParams(User user) {
		if (user != null) {
			this.initialize(user);
		}
		else {
			this.initializeDefault();
		}
	}
	//
	
	//
	//Variables
	//
	private String languageCode;
	private String countryCode;
	private String timeZoneId;
	
	private String languageDataHashCode;
	//
	
	//
	//Properties
	//
	public String getLanguageCode() {
		return languageCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public String getTimeZoneId() {
		return timeZoneId;
	}
	
	public String getLanguageDataHashCode() {
		return languageDataHashCode;
	}
	//
	
	//
	//Private methods
	//
	private void initialize(User user) {
		//- set the language code
		this.languageCode = user.getLanguageLocaleKey();
		
		//- extract and set country code
		if (user.getLocaleSidkey().length() == 2) {
			//examples: "ru", "fr"
			this.countryCode = user.getLocaleSidkey();
		}
		else if (user.getLocaleSidkey().length() > 2 && user.getLocaleSidkey().contains("_")) {
			//examples: "en_US", "fr_FR_EURO"
			this.countryCode = user.getLocaleSidkey().split("_")[1];
		}
		else {
			//all other unknown cases
			this.countryCode = user.getLocaleSidkey();
		}
		
		//- set time zone key
		this.timeZoneId = user.getTimezoneSidKey();
		
		//- set hash code of language data
		this.languageDataHashCode = LanguageBundleUtils.getStringsHashCode(this.buildLocale());
	}
	
	private void initializeDefault() {
		this.languageCode = AppSettings.DEFAULT_LOCALE.getLanguage();
		this.countryCode = AppSettings.DEFAULT_LOCALE.getCountry();
		this.timeZoneId = AppSettings.DEFAULT_TIME_ZONE_ID;
		this.languageDataHashCode = LanguageBundleUtils.getStringsHashCode(
			AppSettings.DEFAULT_LOCALE);
	}
	//
	
	//
	//Public methods
	//
	public Locale buildLocale() {
		return new Locale(this.languageCode, this.countryCode);
	}
	//
}