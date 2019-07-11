package com.kone.cplan.api.ui;

import com.kone.cplan.api.DataUtilsForApi;
import com.kone.cplan.jpa.repository.CaseDetailsRepository;
import com.kone.cplan.utils.dto.OperationResults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with Cases.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 27-05-2019
 */
@RestController
@RequestMapping("${cplan.url.ui-api-path}/case")
public class CaseApi {

	//
	//Variables
	//
	@Autowired
	private CaseDetailsRepository caseDetailsRepo;
	//

	//
	//Public methods to work with the Case entity.
	//
	/**
	 * @param Integer id of a Case entity
	 * @return OperationResults with a Case entity
	 */
	@GetMapping(value = "getById")
	public OperationResults getById(@RequestParam Integer id) {
		return DataUtilsForApi.findByIdWithAccessCheck(caseDetailsRepo, id);
	}
	//
}
