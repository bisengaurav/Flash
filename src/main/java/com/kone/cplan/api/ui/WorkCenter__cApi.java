package com.kone.cplan.api.ui;

import com.kone.cplan.api.JpaUtilsForApi;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.jpa.repository.WorkCenter__cRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with WorkCenter__c entities.
 *
 * @author Andrey Gribanov
 * @created 20-05-2019
 */
@RestController
@RequestMapping("${cplan.url.ui-api-path}/workCenter__c")
public class WorkCenter__cApi {

	//
	//Constants
	//
	@Autowired
	private WorkCenter__cRepository workCenter__cRepo;
	//

	//
	//Public methods to work with the WorkCenter__c entity.
	//
	/**
	 * @param Integer id of a WorkCenter__c entity
	 * @return OperationResults with a WorkCenter__c entity
	 */
	@GetMapping(value = "getById")
	public OperationResults getById(@RequestParam Integer id) {
		return JpaUtilsForApi.findById(workCenter__cRepo, id);
	}
	//
}
