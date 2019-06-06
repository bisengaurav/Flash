package com.kone.cplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

import com.kone.cplan.config.AppSettings;
import com.kone.cplan.utils.i18n.Strings;
import com.kone.cplan.utils.spring.AppContextHolder;

@SpringBootApplication
public class CPlanApplication {

	//
	//Application Entry Point
	//
	public static void main(String[] args) {
		SpringApplication.run(CPlanApplication.class, args);
	}
	//
	
	//
	//Variables
	//
	@Autowired
	private ApplicationContext appContext;
	@Autowired
	private Environment environment;
	@Autowired
	private MessageSource messageSource;
	//

	//
	//Public methods
	//
	@EventListener(ApplicationReadyEvent.class)
	public void initAppAfterStartup()
	{
		//initialize the static utility for application context
		AppContextHolder.initialize(appContext);
		//initialize the static utility class for settings
		AppSettings.initialize(environment);
		//initialize the static utility class for strings
		Strings.setMessageSource(messageSource);
	}
	//
}