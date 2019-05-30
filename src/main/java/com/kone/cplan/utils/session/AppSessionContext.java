package com.kone.cplan.utils.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.kone.cplan.helpers.datatype.StringUtils;
import com.kone.cplan.jpa.repository.UserRepository;

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
	private UserRepository userRepo;
	
	private AppSessionInfo sessionInfo;
	//
	
	//
	//Properties
	//
	public AppSessionInfo getSessionInfo() {
		return sessionInfo;
	}
	//
	
	//
	//Private methods
	//
	private void initialize(String userSfId) {
		this.sessionInfo = null;
		
		if (StringUtils.isNotEmpty(userSfId))
		{
			this.sessionInfo = new AppSessionInfo(userRepo.findBySfId(userSfId));
		}
	}
	//
	
	//
	//Public methods
	//
	public void changeUser(String userSfId) {
		this.initialize(userSfId);
	}
	//
}