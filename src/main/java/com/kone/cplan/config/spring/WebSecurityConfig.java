package com.kone.cplan.config.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.kone.cplan.utils.security.oauth.MsAzureUtils;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
	implements ApplicationListener<AuthenticationSuccessEvent>
{
	//
	//Constants
	//
	private static final String[] PATTERNS_FOR_PUBLIC_URLs = new String[] {
		"/static/**", "/favicon.ico", "/error**", "/login", "/logout"
	};
	//

	//
	//Variables
	//
	@Autowired
	private OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService;
	//

	//
	//Protected methods
	//
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//- configure access to URLs
		http
			.authorizeRequests()
				.antMatchers(PATTERNS_FOR_PUBLIC_URLs).permitAll()
				//.anyRequest().permitAll()
				.anyRequest().authenticated();

		//- configure login
		http.oauth2Login().userInfoEndpoint().oidcUserService(oidcUserService)
			.and().loginPage("/login");

		//- configure logout
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

		//http.csrf().disable();
	}
	//

	//
	//Public methods
	//
	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		MsAzureUtils.handleAuthentication(event);
	}
	//
}