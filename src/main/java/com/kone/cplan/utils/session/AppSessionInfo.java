package com.kone.cplan.utils.session;

import org.springframework.web.context.request.RequestContextHolder;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.kone.cplan.jpa.entity.User;
import com.kone.cplan.utils.i18n.L10nParams;
import com.kone.cplan.utils.i18n.Strings;
import com.kone.cplan.utils.security.SecurityUtils;

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
	@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE,
		isGetterVisibility = Visibility.NONE)
	public static class UserInfo
	{
		//
		//Constructors
		//
		public UserInfo(User user) {
			if (user != null) {
				this.sfId = user.getSfId();
				this.fullName = user.getName();
				this.salesOrg = user.getSalesOrganization__c();
			}
			else {
				this.fullName = Strings.get("label.guest-user-name");
			}
			this.isAdmin = SecurityUtils.isAdminUser(user);
		}
		//
		
		//
		//Variables
		//
		private String sfId;
		private String fullName;
		private String salesOrg;
		private boolean isAdmin = false;
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
		
		public String getSalesOrg() {
			return salesOrg;
		}
		
		public boolean isAdmin() {
			return isAdmin;
		}
		//
	}
	//
}