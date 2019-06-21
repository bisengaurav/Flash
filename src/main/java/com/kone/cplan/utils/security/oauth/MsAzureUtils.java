package com.kone.cplan.utils.security.oauth;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.client.authentication.OAuth2LoginAuthenticationToken;

import com.kone.cplan.jpa.entity.User;
import com.kone.cplan.utils.i18n.Strings;
import com.kone.cplan.utils.security.SecurityUtils;
import com.kone.cplan.utils.spring.AppContextHolder;

/**
 * This class provides utilities for the Microsoft Azure OAuth.
 * 
 * @author Gennadiy Pervukhin
 * @created 20-06-2019
 */
public class MsAzureUtils {
	
	//
	//Constants
	//
	private static final String ATTR_AZURE_USER_ID = "unique_name";
	//
	
	//
	//Private static methods
	//
	private static String extractUserFederationId(OAuth2LoginAuthenticationToken token) {
		return token.getPrincipal().getAttributes().get(ATTR_AZURE_USER_ID).toString();
	}
	
	private static void cancelAuthentication(String errorMessage) {
		//- invalidate the newly created session
		HttpSession session = AppContextHolder.httpSession();
		if (session != null) { session.invalidate(); }
		
		//- throw an authentication exception
		throw (new InsufficientAuthenticationException(errorMessage));
	}
	//

	//
	//Public static methods
	//
	public static void handleAuthentication(AuthenticationSuccessEvent event) {
		
		//STEP #1: extract FederationId from the authentication information and try to find a
		//corresponding SF user
		OAuth2LoginAuthenticationToken token =
			(OAuth2LoginAuthenticationToken)event.getAuthentication();
		String userFederationId = extractUserFederationId(token);
		User sfUser = AppContextHolder.userRepo().findFirstByFederationId(userFederationId);
		
		//throw an exception if the SF user was not found
		if (sfUser == null) {
			String errorMessage = Strings.getAndFormat(
				"message.auth.sf-user-not-found-for-azure-user", userFederationId);
			cancelAuthentication(errorMessage);
		}
		
		//STEP #2: check whether this SF user can use C-Plan
		if (!SecurityUtils.userCanLogin(sfUser)) {
			cancelAuthentication(Strings.get("message.auth.sf-user-cannot-use-cplan"));
		}
		
		//STEP #3: everything is correct. So, we change user in the session context
		AppContextHolder.appSessionContext().changeUser(sfUser);
	}
	//
}