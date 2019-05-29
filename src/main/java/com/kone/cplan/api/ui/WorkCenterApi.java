package com.kone.cplan.api.ui;

import com.kone.cplan.api.JpaUtilsForApi;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.jpa.repository.WorkCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with WorkCenter entities.
 *
 * @author Andrey Gribanov
 * @created 20-05-2019
 */
@RestController
@RequestMapping("${cplan.url.ui-api-path}/workCenter")
public class WorkCenterApi {

	//
	//Constants
	//
	@Autowired
	private WorkCenterRepository workCenterRepo;
	//

	//
	//Public methods to work with the WorkCenter entity.
	//
	/**
	 * @param Integer id of a WorkCenter entity
	 * @return OperationResults with a WorkCenter entity
	 */
	@GetMapping(value = "getById")
	public OperationResults getById(@RequestParam Integer id) {
		return JpaUtilsForApi.findById(workCenterRepo, id);
	}
	//
}