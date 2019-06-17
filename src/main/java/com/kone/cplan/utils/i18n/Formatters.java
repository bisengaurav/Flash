package com.kone.cplan.utils.i18n;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import com.kone.cplan.utils.spring.AppContextHolder;

/**
 * This class provides utilities for formatting values in different locales.
 * 
 * @author Gennadiy Pervukhin
 * @created 29-05-2019
 */
public class Formatters {
	
	//
	//Constructors
	//
	public Formatters(Locale locale) {
		this.locale = locale;
	}
	
	public Formatters(Locale locale, TimeZone timeZone) {
		this.locale = locale;
		this.timeZone = timeZone;
	}
	
	public Formatters(Locale locale, String timeZoneId) {
		this(locale, TimeZone.getTimeZone(timeZoneId));
	}
	//

	//
	//Variables
	//
	private Locale locale;
	private TimeZone timeZone;
	//
	
	//
	//Private methods
	//
	private void setTimeZoneToFormatter(SimpleDateFormat formatter) {
		if (this.timeZone != null) {
			formatter.setTimeZone(this.timeZone);
		}
	}
	//

	//
	//Public methods
	//
	/**
	 * @param dateStyle - use these constants from the DateFormat class: DEFAULT, SHORT, MEDIUM,
	 *  LONG, FULL. See the 1st parameter in {@link DateFormat#getDateTimeInstance(int, int, Locale)}
	 * @param timeStyle - use these constants from the DateFormat class: DEFAULT, SHORT, MEDIUM,
	 *  LONG, FULL. See the 2nd parameter in {@link DateFormat#getDateTimeInstance(int, int, Locale)}
	 * @return {@link SimpleDateFormat} for DateTime values that respects the specified locale and
	 *  time zone.
	 */
	public SimpleDateFormat forDateTime(int dateStyle, int timeStyle) {
		SimpleDateFormat formatter = (SimpleDateFormat)DateFormat.getDateTimeInstance(
			dateStyle, timeStyle, this.locale);
		this.setTimeZoneToFormatter(formatter);
		return formatter;
	}
	
	/**
	 * See {@link Formatters#forDateTime(int, int)}. This method uses the DEFAULT date and SHORT
	 * time styles.
	 */
	public SimpleDateFormat forDateTime() {
		return forDateTime(DateFormat.DEFAULT, DateFormat.SHORT);
	}
	
	
	/**
	 * @param dateStyle - use these constants from the DateFormat class: DEFAULT, SHORT, MEDIUM,
	 *  LONG, FULL. See the 1st parameter in {@link DateFormat#getDateInstance(int, Locale)}
	 * @return {@link SimpleDateFormat} for Date values that respects the specified locale and time
	 *  zone.
	 */
	public SimpleDateFormat forDate(int dateStyle) {
		SimpleDateFormat formatter =
			(SimpleDateFormat)DateFormat.getDateInstance(dateStyle, this.locale);
		this.setTimeZoneToFormatter(formatter);
		return formatter;
	}
	
	/**
	 * See {@link Formatters#forDate(int)}. This method uses the DEFAULT date style.
	 */
	public SimpleDateFormat forDate() {
		return this.forDate(DateFormat.DEFAULT);
	}
	
	
	/**
	 * @param timeStyle - use these constants from the DateFormat class: DEFAULT, SHORT, MEDIUM,
	 *  LONG, FULL. See the 1st parameter in {@link DateFormat#getTimeInstance(int, Locale)}
	 * @return {@link SimpleDateFormat} for Time values that respects the specified locale and
	 *  time zone.
	 */
	public SimpleDateFormat forTime(int timeStyle) {
		SimpleDateFormat formatter =
			(SimpleDateFormat)DateFormat.getTimeInstance(timeStyle, this.locale);
		this.setTimeZoneToFormatter(formatter);
		return formatter;
	}
	
	/**
	 * See {@link Formatters#forTime(int)}. This method uses the SHORT time style.
	 */
	public SimpleDateFormat forTime() {
		return forTime(DateFormat.SHORT);
	}
	//
	
	
	//
	//Public static methods
	//
	/**
	 * The methods initializes a new {@link Formatters} for the Current User (CU).
	 */
	public static Formatters forCurrentUser() {
		L10nParams l10nParams = AppContextHolder.getAppSessionContext().getCurrentL10nParams();
		return (new Formatters(l10nParams.buildLocale(), l10nParams.getTimeZoneId()));
	}
	//
}