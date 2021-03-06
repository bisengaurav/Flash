package com.kone.cplan.jpa.utils;

/**
 * This class provides JPA utilities.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 07-06-2019
 */
public class JpaUtils {

	//
	//Constants
	//
	private static final String CONTAINS_PATTERN = "%%%s%%";
	private static final String STARTS_WITH_PATTERN = "%s%%";
	private static final String ENDS_WITH_PATTERN = "%%%s";
	//

	//
	//Public static methods
	//
	public static String buildContainsPattern(String value, boolean isCaseSensitive) {
		return String.format(CONTAINS_PATTERN, isCaseSensitive ? value : value.toLowerCase());
	}

	public static String buildStartsWithPattern(String value, boolean isCaseSensitive) {
		return String.format(STARTS_WITH_PATTERN, isCaseSensitive ? value : value.toLowerCase());
	}

	public static String buildEndsWithPattern(String value, boolean isCaseSensitive) {
		return String.format(ENDS_WITH_PATTERN, isCaseSensitive ? value : value.toLowerCase());
	}
	//
}