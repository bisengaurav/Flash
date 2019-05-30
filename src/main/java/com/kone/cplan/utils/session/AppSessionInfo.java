package com.kone.cplan.utils.session;

import org.springframework.web.context.request.RequestContextHolder;

import com.kone.cplan.jpa.entity.User;
import com.kone.cplan.utils.i18n.L10nParams;
import com.kone.cplan.utils.i18n.Strings;

/**
 * This class encapsulates details of a session.
 * 
 * @author Gennadiy Pervukhin
 * @created 30-05-2019
 */
public class AppSessionInfo {
	
	//
	//Constructors
	//
	public AppSessionInfo(User user) {
		this.initialize(user);
	}
	//
	
	//
	//Variables
	//
	private String sessionId;
	private UserInfo userInfo;
	private L10nParams l10nParams;
	//
	
	//
	//Properties
	//
	public String getSessionId() {
		return sessionId;
	}
	
	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public L10nParams getL10nParams() {
		return l10nParams;
	}
	//
	
	//
	//Private methods
	//
	private void initialize(User user) {
		//- set session Id
		this.sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
		//- set public UserInfo
		this.userInfo = new UserInfo(user);
		//- set localization parameters
		this.l10nParams = new L10nParams(user);
	}
	//
	


	//
	//Data types
	//
	/**
	 * This class encapsulates details of a User that can be publicly available. We don't want to
	 * make the User entity publicly available, because of security.
	 */
	public static class UserInfo
	{
		//
		//Constructors
		//
		public UserInfo(User user) {
			if (user != null) {
				this.sfId = user.getSfId();
				this.fullName = user.getName();
			}
			else {
				this.fullName = Strings.get("label.guest-user-name");
			}
		}
		//
		
		//
		//Variables
		//
		private String sfId;
		private String fullName;
		//
		
		//
		//Properties
		//
		public String getSfId() {
			return sfId;
		}
		public String getFullName() {
			return fullName;
		}
		//
	}
	//
}