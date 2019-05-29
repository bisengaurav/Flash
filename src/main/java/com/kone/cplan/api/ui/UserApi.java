package com.kone.cplan.api.ui;

import com.kone.cplan.api.JpaUtilsForApi;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.jpa.repository.UserRepository;
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
	//

	//
	//Public methods to work with the User entity.
	//
	/**
	 * @param Integer id of a User entity
	 * @return OperationResults with a User entity
	 */
	@GetMapping(value = "getUserInfo")
	public OperationResults getById() {
		return JpaUtilsForApi.findById(userRepo, 87813);
	}
	//
}
