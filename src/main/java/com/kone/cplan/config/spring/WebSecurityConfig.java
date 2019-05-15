package com.kone.cplan.config.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//
	//Constants
	//
	private static final String[] PATTERNS_FOR_PUBLIC_URLs = new String[] {
		"/", "/home", "/css/*", "/js/*", "/img/*", "/slds/**", "/logoutSuccess", "/error**", "/test*"
	};
	//
	
	//
	//Protected methods
	//
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers(PATTERNS_FOR_PUBLIC_URLs).permitAll()
				.anyRequest().permitAll()
			.and()
			.formLogin().loginPage("/login").permitAll()
			.and()
			.logout().logoutRequestMatcher(
				new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/logoutSuccess").permitAll();
		
		//http.csrf().disable();
	}
	//
}