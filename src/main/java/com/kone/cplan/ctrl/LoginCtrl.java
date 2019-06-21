package com.kone.cplan.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kone.cplan.config.AppUrl;
import com.kone.cplan.helpers.datatype.StringUtils;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.utils.i18n.Strings;

/**
 * This is a controller for the custom login page.
 * 
 * @author Gennadiy Pervukhin
 * @created 18-06-2019
 */
@Controller
public class LoginCtrl {
	
	//
	//Constants
	//
	private static final String PARAM_LOGOUT = "logout";
	private static final String PARAM_ERROR = "error";
	
	private static final String ATTR_RESULTS = "results";
	private static final String ATTR_OAUTH_PROVIDERS = "oauthProviders";
	//
	
	//
	//Variables
	//
	@Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
	//
	
	//
	//Private methods
	//
	private static boolean isAuthenticated() {
		boolean isAnonymousUser = (SecurityContextHolder.getContext().getAuthentication()
			instanceof AnonymousAuthenticationToken);
		return !isAnonymousUser;
	}
	
	private static OperationResults extractError(HttpServletRequest request, Model model) {
		
		String errorMessage = null;
		//- try to extract a message from the authentication exception
		HttpSession session = request.getSession(false);
		if (session != null) {
			AuthenticationException exception = (AuthenticationException)session
				.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			if (exception != null) {
				errorMessage = exception.getMessage();
			}
		}
		
		//- try to extract a message from URL-parameters
		if (StringUtils.isEmpty(errorMessage)) {
			errorMessage = request.getParameter(PARAM_ERROR);
		}
		
		//- use the default message
		if (StringUtils.isEmpty(errorMessage)) {
			errorMessage = Strings.get("message.common.unknown-error");
		}
		
		return OperationResults.newError(errorMessage);
	}
	
	@SuppressWarnings("unchecked")
	private void prepareOAuthProviders(Model model) {
		Iterable<ClientRegistration> clientRegistrations = null;
		ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
			.as(Iterable.class);
		if (type != ResolvableType.NONE
			&& ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0]))
		{
			clientRegistrations = (Iterable<ClientRegistration>)clientRegistrationRepository;
		}

		Map<String, String> oauth2AuthenticationUrls = new HashMap<>();
		clientRegistrations.forEach(registration -> oauth2AuthenticationUrls.put(registration.getClientName(),
			AppUrl.URL_START_OAUTH + "/" + registration.getRegistrationId()));
		model.addAttribute(ATTR_OAUTH_PROVIDERS, oauth2AuthenticationUrls);
	}
	
	private String prepareLoginPage(Model model, OperationResults results) {
		//STEP #1: save the results in the model 
		model.addAttribute(ATTR_RESULTS, results);
		
		//STEP #2: save the OAuth providers in the model
		this.prepareOAuthProviders(model);
		
		return AppUrl.VIEW_LOGIN;
	}
	//

	//
	//Public methods
	//
	@GetMapping("/login")
	public String processLogin(HttpServletRequest request, Model model) {
		
		//STEP #1: if a user logged in already, then we redirect him to the home page
		if (isAuthenticated()) {
			return ("redirect:" + AppUrl.PAGE_HOME);
		}
		
		//STEP #2: decide whether we should open the custom login page and show some information there
		Map<String, String[]> parameters = request.getParameterMap();
		if (parameters.containsKey(PARAM_LOGOUT)) {
			return prepareLoginPage(model,
				new OperationResults(true, Strings.get("message.auth.succesful-logout")));
		}
		else if (parameters.containsKey(PARAM_ERROR)) {
			return prepareLoginPage(model, extractError(request, model));
		}
		
		//STEP #3: start automatic login via MS Azure SSO
		return ("redirect:" + AppUrl.PAGE_START_OAUTH_AZURE);
	}
	//
}