package com.kone.cplan.api.ui;

import com.kone.cplan.api.DataUtilsForApi;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.jpa.repository.ServiceTerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with ServiceTerritory entities.
 *
 * @author Andrey Gribanov
 * @created 20-05-2019
 */
@RestController
@RequestMapping("${cplan.url.ui-api-path}/serviceTerritory")
public class ServiceTerritoryApi {

	//
	//Constants
	//
	@Autowired
	private ServiceTerritoryRepository serviceTerritoryRepo;
	//

	//
	//Public methods to work with the ServiceTerritory entity.
	//
	/**
	 * @param Integer id of a ServiceTerritory entity
	 * @return OperationResults with a ServiceTerritory entity
	 */
	@GetMapping(value = "getById")
	public OperationResults getById(@RequestParam Integer id) {
		return DataUtilsForApi.findByIdWithAccessCheck(serviceTerritoryRepo, id);
	}
	//
}
