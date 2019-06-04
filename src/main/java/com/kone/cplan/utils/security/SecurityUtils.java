package com.kone.cplan.utils.security;

import java.util.Set;
import java.util.TreeSet;

import com.kone.cplan.jpa.entity.User;

/**
 * This class provides utilities for the application security.
 * 
 * @author Gennadiy Pervukhin
 * @created 04-06-2019
 */
public class SecurityUtils {

	//
	//Constants
	//
	private static final Set<String> ADMIN_PROFILES_IDs = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	static {
		ADMIN_PROFILES_IDs.add("00ew0000001V7qqAAC"); //KONE: KC3 Agent
		ADMIN_PROFILES_IDs.add("00e1r000001mw9oAAA"); //KONE: External KC3 Agent
		ADMIN_PROFILES_IDs.add("00ew0000001V7q9AAC"); //KONE: Field Service Administrator
	}
	//
	
	//
	//Public static methods
	//
	public static boolean isAdminUser(User user) {
		return (user != null ? ADMIN_PROFILES_IDs.contains(user.getProfileId()) : false);
	}
	//
}