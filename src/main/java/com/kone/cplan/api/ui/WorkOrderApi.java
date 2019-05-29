package com.kone.cplan.api.ui;

import com.kone.cplan.api.JpaUtilsForApi;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.jpa.repository.WorkCenterRepository;
import com.kone.cplan.jpa.repository.WorkOrderRepository;
import com.kone.cplan.utils.dto.SelectOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with WorkOrder entities.
 *
 * @author Andrey Gribanov
 * @created 29-05-2019
 */
@RestController
@RequestMapping("${cplan.url.ui-api-path}/workOrder")
public class WorkOrderApi {

	//
	//Constants
	//
	@Autowired
	private WorkOrderRepository workOrderRepo;
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
		return JpaUtilsForApi.findById(workOrderRepo, id);
	}
	//
}