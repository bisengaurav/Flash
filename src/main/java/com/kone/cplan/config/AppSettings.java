package com.kone.cplan.config;

import java.util.Locale;

import org.springframework.core.env.Environment;

/**
 * This class provides utilities for application settings.
 * 
 * @author Gennadiy Pervukhin
 * @created 20-06-2018
 */
public class AppSettings {
	
	//
	//Constants
	//
	private static final String DEFAULT_DB_URL = "postgres://ue2qq9efj6fnk5" +
		":p078e12fcd6e1b28d67371c974b7198bfbe78d104834619636d1f0912e9d81fb8" +
		"@ec2-108-128-176-56.eu-west-1.compute.amazonaws.com:5432/d3urgbej3bmchm";
	
	public static final String DATABASE_URL;
	static {
		String dbUrlFromSystemVar = System.getenv("ADB_DATABASE_URL");
		DATABASE_URL = (dbUrlFromSystemVar != null ? dbUrlFromSystemVar : DEFAULT_DB_URL);
	}

	public static final int TIMEOUT_FOR_LONG_OPs_IN_SECs = 20;
	public static final int TIMEOUT_FOR_LONG_OPs_IN_MSECs = (TIMEOUT_FOR_LONG_OPs_IN_SECs * 1000);
	
	public static final int DEFAULT_PAGE_SIZE = 100;
	
	public static final Locale DEFAULT_LOCALE = Locale.US;
	public static final String DEFAULT_TIME_ZONE_ID = "GMT";
	//
	
	//
	//Static initialization
	//
	private static Environment environment;
	
	public static void initialize(Environment environment)
	{
		AppSettings.environment = environment;
	}
	//
	
	
	/*********************************************************
	* SETTINGS FROM the APPLICATION.PROPERTIES *
	**********************************************************/
	//
	//Private static methods
	//
	private static String getPropertyValue(String key)
	{
		return environment.getProperty(key);
	}
	//
	
	//
	//Public static methods
	//
	public static String getMessagesBaseName()
	{
		return getPropertyValue("spring.messages.basename");
	}
	//
}