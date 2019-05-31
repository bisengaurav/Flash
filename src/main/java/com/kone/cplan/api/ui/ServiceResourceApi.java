package com.kone.cplan.api.ui;

import com.kone.cplan.api.JpaUtilsForApi;
import com.kone.cplan.api.ui.utils.pagination.PagingUtils;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.helpers.serialization.JsonUtils;
import com.kone.cplan.jpa.filter.ServiceResourceFilter;
import com.kone.cplan.jpa.repository.ServiceResourceDetailsRepository;
import com.kone.cplan.jpa.repository.ServiceResourceRepository;
import com.kone.cplan.utils.dto.SelectOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	private ServiceResourceRepository serviceResourceRepo;
	@Autowired
	private ServiceResourceDetailsRepository serviceResourceDetailsRepo;
	//

	//
	//Private static methods
	//
	private static Sort getDefaultSort() {
		return Sort.by(Sort.Direction.ASC, "name");
	}
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

	/**
	 * @param ServiceResourceFilter
	 * @return OperationResults with list of the ServiceResource entities
	 */
	@GetMapping(value = "getAllByFilter")
	public OperationResults getAllByFilter(@RequestParam(name = "filter") String filterJson)
	{
		//- deserialize parameters
		ServiceResourceFilter filter = JsonUtils.deserialize_typed(filterJson, ServiceResourceFilter.class);

		Pageable pageRequest = PagingUtils.extractOrGetDefaultPageRequest(getDefaultSort());

		//- get and return data
		return OperationResults.newSuccess(serviceResourceRepo.findByFilter(filter, pageRequest));
	}

	/**
	 * @return OperationResults with list of the SelectOptions
	 */
	@GetMapping(value = "getUniqueSalesOrganizations")
	public OperationResults getUniqueSalesOrganizations()
	{
		return OperationResults.newSuccess(
			SelectOption.generateList(serviceResourceRepo.getUniqueSalesOrganizations().toArray())
		);
	}
	//
}
