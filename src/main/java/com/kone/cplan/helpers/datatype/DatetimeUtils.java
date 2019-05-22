package com.kone.cplan.helpers.datatype;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * This class provides utilities for date and datetime values.
 * 
 * @author Gennadiy Pervukhin
 */
public class DatetimeUtils {

	//
	//Constants
	//
	/*
	X means ISO 8601 time zone. It supports simple 'Z' letter, '+0000' and other formats. See this
	for more details: https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html#iso8601timezone
	*/
	public static final String ISO_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
	public static final String ISO_DATE_FORMAT = "yyyy-MM-dd";
	
	public static final int MILLISECONDS_IN_SEC = 1000;
	
	private static final String DATETIME_LABEL_FORMAT = "yyyy-MM-dd HH:mm:ss z";
	//
	
	//
	//Private methods
	//
	private static SimpleDateFormat newGmtDateFormatter(String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		return formatter;
	}
	//
	
	//
	//Public static methods
	//
	public static long getCurrentEpochTime() {
		return (new Date()).getTime();
	}
	
	public static String getCurrentGmtDateTimeLabel() {
		SimpleDateFormat formatter = newGmtDateFormatter(DATETIME_LABEL_FORMAT);
		return formatter.format(new Date());
	}
	
	public static Date parseIsoDateTime(String dateTimeIsoString) throws ParseException	{
		SimpleDateFormat formatter = new SimpleDateFormat(ISO_DATETIME_FORMAT);
		return formatter.parse(dateTimeIsoString);
	}
	
	public static Date parseIsoDate(String dateIsoString) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(ISO_DATE_FORMAT);
		return formatter.parse(dateIsoString);
	}
	
	
	public static String formatGmtDateAsIso(Date sourceDate) {
		SimpleDateFormat formatter = newGmtDateFormatter(ISO_DATE_FORMAT);
		return formatter.format(sourceDate);
	}
	
	public static String formatGmtDateTimeAsIso(Date sourceDateTime) {
		SimpleDateFormat formatter = newGmtDateFormatter(ISO_DATETIME_FORMAT);
		return formatter.format(sourceDateTime);
	}
	//
}