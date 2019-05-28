package com.kone.cplan.utils.i18n;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * This class provides utilities for formatting values in different locales.
 * 
 * @author Gennadiy Pervukhin
 * @created 29-05-2019
 */
public class FormatUtils {

	//
	//Public static methods
	//
	public static String getDateTimePattern(Locale locale) {
		SimpleDateFormat formatter = (SimpleDateFormat)DateFormat.getDateTimeInstance(
			DateFormat.DEFAULT, DateFormat.SHORT, locale);
		return formatter.toPattern();
	}
	
	public static String getDatePattern(Locale locale) {
		SimpleDateFormat formatter = (SimpleDateFormat)DateFormat.getDateInstance(
			DateFormat.DEFAULT, locale);
		return formatter.toPattern();
	}
	
	public static String getTimePattern(Locale locale) {
		SimpleDateFormat formatter = (SimpleDateFormat)DateFormat.getTimeInstance(
			DateFormat.SHORT, locale);
		return formatter.toPattern();
	}
	//
}