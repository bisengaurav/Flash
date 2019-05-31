package com.kone.cplan.api.ui;

import com.kone.cplan.api.JpaUtilsForApi;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.jpa.repository.ServiceResourceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with ServiceResource entities.
 *
 * @author Andrey Gribanov
 * @created 24-05-2019
 */
@RestController
@RequestMapping("${cplan.url.ui-api-path}/serviceResource")
public class ServiceResourceApi {

	//
	//Constants
	//
	@Autowired
	private ServiceResourceDetailsRepository serviceResourceDetailsRepo;
	//

	//
	//Public methods to work with the ServiceResource entity.
	//
	/**
	 * @param Integer id of a ServiceResource entity
	 * @return OperationResults with a ServiceResource entity
	 */
	@GetMapping(value = "getById")
	public OperationResults getById(@RequestParam Integer id) {
		return JpaUtilsForApi.findById(serviceResourceDetailsRepo, id);
	}
	//
}
