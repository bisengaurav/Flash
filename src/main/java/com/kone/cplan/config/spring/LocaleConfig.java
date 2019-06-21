package com.kone.cplan.config.spring;

import java.util.Locale;
import java.util.TimeZone;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.kone.cplan.config.AppSettings;

/**
 * This class is used to configure basic features for internationalization.
 * 
 * @author Gennadiy Pervukhin
 * @created 21-06-2018
 */
@Configuration
public class LocaleConfig implements WebMvcConfigurer
{
	@Bean
	public LocaleResolver localeResolver()
	{
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(AppSettings.DEFAULT_LOCALE);
		return localeResolver;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void initAppAfterStartup()
	{
		TimeZone.setDefault(TimeZone.getTimeZone(AppSettings.DEFAULT_TIME_ZONE_ID));
		Locale.setDefault(AppSettings.DEFAULT_LOCALE);
	}

	/*@Bean
	public LocaleChangeInterceptor localeChangeHandler()
	{
		LocaleChangeInterceptor localeChangeHandler = new LocaleChangeInterceptor();
		localeChangeHandler.setParamName("language");
		return localeChangeHandler;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(localeChangeHandler());
	}*/
}