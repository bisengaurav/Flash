package com.kone.cplan.api.ui;

import com.kone.cplan.api.JpaUtilsForApi;
import com.kone.cplan.api.ui.utils.pagination.PagingUtils;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.helpers.serialization.JsonUtils;
import com.kone.cplan.jpa.filter.CaseFilter;
import com.kone.cplan.jpa.repository.CaseRepository;
import com.kone.cplan.utils.dto.SelectOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	//Constants
	//
	@Autowired
	private CaseRepository caseRepo;
	//

	//
	//Private static methods
	//
	private static Sort getDefaultSort() {
		return Sort.by(Sort.Direction.DESC, "createdDate");
	}
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
		return JpaUtilsForApi.findById(caseRepo, id);
	}

	/**
	 * @param CaseFilter
	 * @return OperationResults with list of the Case entities
	 */
	@GetMapping(value = "getAllByFilter")
	public OperationResults getAllByFilter(@RequestParam(name = "filter") String filterJson)
	{
		//- deserialize parameters
		CaseFilter filter = JsonUtils.deserialize_typed(filterJson, CaseFilter.class);

		Pageable pageRequest = PagingUtils.extractOrGetDefaultPageRequest(getDefaultSort());

		//- get and return data
		return OperationResults.newSuccess(caseRepo.findByFilter(filter, pageRequest));
	}

	/**
	 * @return OperationResults with list of the SelectOptions
	 */
	@GetMapping(value = "getUniqueSalesOrganizations")
	public OperationResults getUniqueSalesOrganizations()
	{
		return OperationResults.newSuccess(
			SelectOption.generateList(caseRepo.getUniqueSalesOrganizations().toArray())
		);
	}
	//
}
