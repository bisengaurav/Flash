package com.kone.cplan.api.ui;

import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.jpa.entity.User;
import com.kone.cplan.jpa.repository.UserRepository;
import com.kone.cplan.utils.security.SecurityUtils;
import com.kone.cplan.utils.session.AppSessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with User entities.
 *
 * @author Andrey Gribanov
 * @created 24-05-2019
 */
@RestController
@RequestMapping("${cplan.url.ui-api-path}/user")
public class UserApi {

	//
	//Constants
	//
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AppSessionContext appSessionContext;
	//

	//
	//Public methods to work with the User entity.
	//
	/**
	 * @param Integer id of a User entity
	 * @return OperationResults with a User entity
	 */
	@GetMapping(value = "getUserInfo")
	public OperationResults getUserInfo() {
		User currentUser = userRepo.findBySfId(appSessionContext.getCurrentUserInfo().getSfId());
		if (currentUser == null) {
			return OperationResults.newErrorByKey("message.common.record-not-found");
		}
		return OperationResults.newSuccess(new UserWrapper(currentUser));
	}
	//

	//
	//Data Types
	//
	public class UserWrapper {

		//Constructors
		UserWrapper(User user) {
			this.user = user;
			this.isAdmin = SecurityUtils.isAdminUser(user);
		}

		//Variables
		private User user;
		private boolean isAdmin;

		//Properties
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}

		public boolean getIsAdmin() {
			return isAdmin;
		}
		public void setIsAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
		}
	}
	//
}
