package com.kone.cplan.utils.spring;

import org.springframework.context.ApplicationContext;

import com.kone.cplan.utils.session.AppSessionContext;

/**
 * This class provides static access to the application context and its beans.
 * 
 * @author Gennadiy Pervukhin
 * @created 04-06-2019
 */
public class AppContextHolder {
	
	//
	//Variables
	//
	private static ApplicationContext appContext;
	//
	
	//
	//Public static methods
	//
	public static void initialize(ApplicationContext appContext) {
		AppContextHolder.appContext = appContext;
	}
	
	public static AppSessionContext getAppSessionContext() {
		return appContext.getBean(AppSessionContext.class);
	}
	//

}