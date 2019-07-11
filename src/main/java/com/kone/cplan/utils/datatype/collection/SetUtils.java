package com.kone.cplan.utils.datatype.collection;

import java.util.Set;

import com.kone.cplan.utils.datatype.StringUtils;

/**
 * This class provides utilities for sets.
 * 
 * @author Gennadiy Pervukhin
 * @created 14-12-2017
 */
public class SetUtils {
	
	//
	//Public static methods
	//
	public static void removeBlankValues(Set<String> set) {
		if (set != null) {
			set.remove(null);
			set.remove(StringUtils.EMPTY);
		}
	}
	
	public static boolean contains(Set<String> set, String value) {
		if (set == null || value == null) { return false; }
		
		return set.contains(value);
	}
	//
}
