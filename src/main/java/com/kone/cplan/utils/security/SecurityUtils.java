package com.kone.cplan.utils.security;

import java.util.Set;
import java.util.TreeSet;

import com.kone.cplan.jpa.entity.User;
import com.kone.cplan.jpa.utils.IEntityWithAccessField;
import com.kone.cplan.jpa.utils.IEntityWithSalesOrg;
import com.kone.cplan.jpa.utils.IEntityWithSalesOrgs;
import com.kone.cplan.utils.session.AppSessionInfo;
import com.kone.cplan.utils.spring.AppContextHolder;

/**
 * This class provides utilities for the application security.
 * 
 * @author Gennadiy Pervukhin
 * @created 04-06-2019
 */
public class SecurityUtils {

	//
	//Constants
	//
	private static final Set<String> ADMIN_PROFILES_IDs = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	static {
		//TODO: clarify whether we can hard code these values
		//ADMIN_PROFILES_IDs.add("00ew0000001V7qqAAC"); //KONE: KC3 Agent
		//ADMIN_PROFILES_IDs.add("00e1r000001mw9oAAA"); //KONE: External KC3 Agent
		ADMIN_PROFILES_IDs.add("00ew0000001V7q9AAC"); //KONE: Field Service Administrator
	}
	//
	
	//
	//Public static methods
	//
	public static boolean isAdminUser(User user) {
		return (user != null ? ADMIN_PROFILES_IDs.contains(user.getProfileId()) : false);
	}

	// The method returns true if the current User has access to the record and false otherwise
	public static boolean userHasAccessToRecord(IEntityWithAccessField record)
	{
		AppSessionInfo.UserInfo userInfo = AppContextHolder.getAppSessionContext().getCurrentUserInfo();
		//- if the current User is not a C-Plan admin we should check whether he is allowed to see the record.
		// Depending on the object the record has either 'salesOrganization__c' (may contain null or one
		// Sales Organization) or 'salesOrganizations__c' (may contain any number of Sales Organizations
		// separated by comma) field. User also has 'salesOrganization__c' field. And if the record's
		// salesOrganization__c/salesOrganizations__c field contains the user's Sales Organization
		// then and only then the User is allowed to see the record.
		// C-Plan admin is allowed to see all records.
		if (!userInfo.isAdmin()) {
			if (userInfo.getSalesOrg() == null) { return false; }
			//- check whether the record has 'salesOrganization__c' field or 'salesOrganizations__c' field.
			if (record instanceof IEntityWithSalesOrg) {
				return ((IEntityWithSalesOrg)record).getSalesOrganization__c() != null
					&& ((IEntityWithSalesOrg)record).getSalesOrganization__c()
					.equals(userInfo.getSalesOrg());
			}
			//- if the record has 'salesOrganizations__c' field then we need to check whether the field
			// contains the User's Sales Organization.
			else if (record instanceof IEntityWithSalesOrgs) {
				return ((IEntityWithSalesOrgs) record).getSalesOrganizations__c() != null
					&& ((IEntityWithSalesOrgs) record).getSalesOrganizations__c()
					.matches("^(.*,|)" + userInfo.getSalesOrg() + "(,.*|)$");
			}
		}
		return true;
	}
	//
}