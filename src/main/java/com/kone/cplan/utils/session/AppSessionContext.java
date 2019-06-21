package com.kone.cplan.utils.session;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.LocaleResolver;

import com.kone.cplan.jpa.entity.User;
import com.kone.cplan.jpa.repository.UserRepository;
import com.kone.cplan.utils.i18n.L10nParams;

/**
 * This bean provides utilities for user session.
 * 
 * @author Gennadiy Pervukhin
 * @created 29-05-2019
 */
@Component("appSession")
@SessionScope
public class AppSessionContext
{
	//
	//Variables
	//
	@Autowired
	private LocaleResolver localeResolver;
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserRepository userRepo;
	
	private AppSessionInfo sessionInfo;
	//
	
	//
	//Properties
	//
	public AppSessionInfo getSessionInfo() {
		return sessionInfo;
	}
	
	public AppSessionInfo.UserInfo getCurrentUserInfo() {
		return (this.sessionInfo != null ? this.sessionInfo.getUserInfo()
			: new AppSessionInfo.UserInfo(null));
	}
	
	public L10nParams getCurrentL10nParams() {
		return (this.sessionInfo != null ? this.sessionInfo.getL10nParams()
			: new L10nParams(null));
	}
	//
	
	//
	//Private methods
	//
	private void initialize(User sfUser) {
		
		//- initialize an set new session info
		this.sessionInfo = new AppSessionInfo(sfUser);
		
		//- change current locale for the session
		localeResolver.setLocale(this.request, null,
			this.sessionInfo.getL10nParams().buildLocale());
	}
	//
	
	//
	//Public methods
	//
	public void changeUser(String userSfId) {
		this.initialize(userRepo.findBySfId(userSfId));
	}
	
	public void changeUser(User sfUser) {
		this.initialize(sfUser);
	}
	//
}