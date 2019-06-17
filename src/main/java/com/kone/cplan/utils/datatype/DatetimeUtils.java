package com.kone.cplan.utils.datatype;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.kone.cplan.utils.i18n.L10nParams;
import com.kone.cplan.utils.spring.AppContextHolder;

/**
 * This class provides utilities for date and datetime values.
 * 
 * @author Gennadiy Pervukhin
 * @created 17-06-2019
 */
public class DatetimeUtils {
	
	//
	//Public static methods
	//
	public static Calendar getCalendarForCU(Date sourceDateTime) {
		L10nParams l10nParams = AppContextHolder.getAppSessionContext().getCurrentL10nParams();
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(l10nParams.getTimeZoneId()),
			l10nParams.buildLocale());
		
		return calendar;
	}
	
	public static void clearTimePart(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}
	//
}