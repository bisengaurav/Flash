package com.kone.cplan.utils.security;

import java.util.Set;
import java.util.TreeSet;

import com.kone.cplan.jpa.entity.User;
import com.kone.cplan.jpa.utils.IEntityWithAccessField;
import com.kone.cplan.jpa.utils.IEntityWithSalesOrg;
import com.kone.cplan.jpa.utils.IEntityWithSalesOrgs;
import com.kone.cplan.utils.datatype.collection.SetUtils;
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
	//KONE: KC3 Agent
	private static final String PRODILE_ID_KC3_AGENT = "00ew0000001V7qqAAC";
	//KONE: External KC3 Agent
	private static final String PRODILE_ID_EXTERNAL_KC3_AGENT = "00e1r000001mw9oAAA";
	//KONE: Field Service Administrator
	private static final String PRODILE_ID_FIELD_SERVICE_ADMIN = "00ew0000001V7q9AAC";
	
	//Central Management
	private static final String ROLE_ID_CENTRAL_MGMT = "00E20000000huXREAY";
	//FSM: Field Service Management
	private static final String ROLE_ID_FIELD_SERVICE_MGMT = "00Ew0000001zukGEAQ";
	
	
	private static final Set<String> ALLOWED_PROFILES_IDs = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	static {
		ALLOWED_PROFILES_IDs.add(PRODILE_ID_KC3_AGENT);
		ALLOWED_PROFILES_IDs.add(PRODILE_ID_EXTERNAL_KC3_AGENT);
		ALLOWED_PROFILES_IDs.add(PRODILE_ID_FIELD_SERVICE_ADMIN);
	}
	
	private static final Set<String> ADMIN_PROFILES_IDs = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	static {
		ADMIN_PROFILES_IDs.add(PRODILE_ID_FIELD_SERVICE_ADMIN);
	}
	
	private static final Set<String> ADMIN_ROLES_IDs = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	static {
		ADMIN_ROLES_IDs.add(ROLE_ID_CENTRAL_MGMT);
		ADMIN_ROLES_IDs.add(ROLE_ID_FIELD_SERVICE_MGMT);
	}
	//
	
	//
	//Public static methods
	//
	/**
	 * The method determines whether the passed user can log into the app. 
	 */
	public static boolean userCanLogin(User user) {
		if (user == null) { return false; }
		
		return SetUtils.contains(ALLOWED_PROFILES_IDs, user.getProfileId());
	}
	
	public static boolean isAdminUser(User user) {
		if (user == null) { return false; }
		
		return (SetUtils.contains(ADMIN_PROFILES_IDs, user.getProfileId()) &&
			SetUtils.contains(ADMIN_ROLES_IDs, user.getRoleId()));
	}

	// The method returns true if the current User has access to the record and false otherwise
	public static boolean userHasAccessToRecord(IEntityWithAccessField record)
	{
		AppSessionInfo.UserInfo userInfo = AppContextHolder.appSessionContext().getCurrentUserInfo();
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