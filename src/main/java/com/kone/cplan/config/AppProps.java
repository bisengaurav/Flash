package com.kone.cplan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This class provides access to Application Properties defined in the application.properties file.
 * 
 * @author Gennadiy Pervukhin
 * @created 06-03-2019
 */
@Component
public class AppProps {
	
	//
	//Variables
	//
	@Value("${cplan.url.ui-api-path}")
	private String uiApiPath;
	//
	
	//
	//Properties
	//
	public String getUiApiPath() {
		return uiApiPath;
	}
	//
}