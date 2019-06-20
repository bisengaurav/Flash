package com.kone.cplan.config.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.kone.cplan.utils.session.AppSessionContext;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
	implements ApplicationListener<InteractiveAuthenticationSuccessEvent>
{
	//
	//Constants
	//
	private static final String[] PATTERNS_FOR_PUBLIC_URLs = new String[] {
		"/css/*", "/js/*", "/img/*", "/favicon.ico", "/slds/**", "/error**", "/test*"
	};
	//
	
	//
	//Variables
	//
	@Autowired
	private AppSessionContext sessionContext;
	//
	
	//
	//Protected methods
	//
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers(PATTERNS_FOR_PUBLIC_URLs).permitAll()
				//.anyRequest().permitAll()
				.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").permitAll()
			.and()
			.logout().logoutRequestMatcher(
				new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();
		
		//http.csrf().disable();
	}
	//
	
	//
	//Public methods
	//
	//TODO: this is a temp code for testing period until we implement SSO authentication
	@SuppressWarnings("deprecation")
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails testUser = User.withDefaultPasswordEncoder()
			.username("testuser").password("123QWEasd").roles("USER").build();
		return new InMemoryUserDetailsManager(testUser);
	}
	
	//TODO: temp code that changes session context
	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		sessionContext.changeUser("0051w000000tNXoAAM"); //Jonathan heiniger, isAdmin: true, salesOrg: "MKOF"
	}
	//
}