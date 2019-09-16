package com.kone.cplan.utils.spring;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;

import com.kone.cplan.config.AppSettings;
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
	
	public static AppSessionContext appSessionContext() {
		return appContext.getBean(AppSessionContext.class);
	}
	
	public static HttpSession httpSession() {
		ServletRequestAttributes requestAttributes =
			(ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		return (requestAttributes != null ? requestAttributes.getRequest().getSession() : null);
	}
	
	public static LocaleResolver localeResolver() {
		return appContext.getBean(LocaleResolver.class);
	}
	
	public static Locale currentLocale() {
		//STEP #1: try to get a locale associated with the current request
		ServletRequestAttributes requestAttributes =
			(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		if (requestAttributes != null) {
			HttpServletRequest request = requestAttributes.getRequest();
			if (request != null) {
				return localeResolver().resolveLocale(request);
			}
		}
		
		//STEP #2: use the default locale
		return AppSettings.DEFAULT_LOCALE;
	}
	
	public static UserRepository userRepo() {
		return appContext.getBean(UserRepository.class);
	}
	//
}