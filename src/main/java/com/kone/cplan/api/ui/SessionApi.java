package com.kone.cplan.api.ui;

import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.utils.session.AppSessionContext;
import com.kone.cplan.utils.session.AppSessionInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with application session.
 * 
 * @author Gennadiy Pervukhin
 * @created 30-05-2019
 */
@RestController
@RequestMapping("${cplan.url.ui-api-path}/session")
public class SessionApi {

	//
	//Variables
	//
	@Autowired
	private AppSessionContext sessionContext;
	//
	
	//
	//Public methods
	//
	/**
	 * @return {@link OperationResults} with the {@link AppSessionInfo} instance.
	 */
	@GetMapping(value = "getInfo")
	public OperationResults getSessionInfo() {
		return OperationResults.newSuccess(sessionContext.getSessionInfo());
	}
	
	//TODO: this is a test method that allows to change session context
	@GetMapping(value = "fake_ChangeSfUser")
	public OperationResults fake_ChangeSfUser(@RequestParam String userSfId) {
		sessionContext.changeUser(userSfId);
		return OperationResults.newSuccess(sessionContext.getSessionInfo());
	}
	//
}
