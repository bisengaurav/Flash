package com.kone.cplan.utils.spring;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kone.cplan.jpa.repository.UserRepository;
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
	
	//TODO: rename
	public static AppSessionContext getAppSessionContext() {
		return appContext.getBean(AppSessionContext.class);
	}
	
	public static HttpSession httpSession() {
		ServletRequestAttributes requestAttributes =
			(ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		return (requestAttributes != null ? requestAttributes.getRequest().getSession() : null);
	}
	
	public static UserRepository userRepo() {
		return appContext.getBean(UserRepository.class);
	}
	//

}