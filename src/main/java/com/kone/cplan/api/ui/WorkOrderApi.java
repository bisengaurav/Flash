package com.kone.cplan.api.ui;

import com.kone.cplan.api.DataUtilsForApi;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.jpa.repository.WorkOrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with WorkOrder entities.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 29-05-2019
 */
@RestController
@RequestMapping("${cplan.url.ui-api-path}/workOrder")
public class WorkOrderApi {

	//
	//Variables
	//
	@Autowired
	private WorkOrderDetailsRepository workOrderDetailsRepo;
	//

	//
	//Public methods to work with the WorkOrder entity.
	//
	/**
	 * @param Integer id of a WorkOrder entity
	 * @return OperationResults with a WorkOrder entity
	 */
	@GetMapping(value = "getById")
	public OperationResults getById(@RequestParam Integer id) {
		return DataUtilsForApi.findByIdWithAccessCheck(workOrderDetailsRepo, id);
	}
	//
}
