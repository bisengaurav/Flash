package com.kone.cplan.api.ui;

import com.kone.cplan.api.DataUtilsForApi;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.jpa.filter.CalloutFilter;
import com.kone.cplan.jpa.repository.CalloutRepository;
import com.kone.cplan.utils.dto.SelectOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with Callouts.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 13-06-2019
 */
@RestController
@RequestMapping("${cplan.url.ui-api-path}/callout")
public class CalloutApi {

	//
	//Variables
	//
	@Autowired
	private CalloutRepository calloutRepo;
	//

	//
	//Public methods to work with the Callout entity.
	//
	/**
	 * @param CalloutFilter
	 * @return OperationResults with list of the Callout entities
	 */
	@GetMapping(value = "getAllByFilter")
	public OperationResults getAllByFilter(@RequestParam(name = "filter") String filterJson)
	{
		return DataUtilsForApi.findByFilter(calloutRepo, filterJson, CalloutFilter.class, Sort.unsorted());
	}

	/**
	 * @return OperationResults with list of the SelectOptions
	 */
	@GetMapping(value = "getUniqueSalesOrganizations")
	public OperationResults getUniqueSalesOrganizations()
	{
		return DataUtilsForApi.getUniqueSalesOrganizations(calloutRepo);
	}

	/**
	 * @return OperationResults with list of the SelectOptions
	 */
	@GetMapping(value = "getUniqueMaintenanceActivityTypeCodes")
	public OperationResults getUniqueMaintenanceActivityTypeCodes()
	{
		return OperationResults.newSuccess(
			SelectOption.generateList(calloutRepo.getUniqueMaintenanceActivityTypeCodes().toArray())
		);
	}

	/**
	 * @return OperationResults with list of the SelectOptions
	 */
	@GetMapping(value = "getUniqueAssemblies")
	public OperationResults getUniqueAssemblies()
	{
		return OperationResults.newSuccess(
			SelectOption.generateList(calloutRepo.getUniqueAssemblies().toArray())
		);
	}

	/**
	 * @return OperationResults with list of the SelectOptions
	 */
	@GetMapping(value = "getUniqueStatuses")
	public OperationResults getUniqueStatuses()
	{
		return OperationResults.newSuccess(
			SelectOption.generateList(calloutRepo.getUniqueStatuses().toArray())
		);
	}

	/**
	 * @return OperationResults with list of the SelectOptions
	 */
	@GetMapping(value = "getUniqueSAStatuses")
	public OperationResults getUniqueSAStatuses()
	{
		return OperationResults.newSuccess(
			SelectOption.generateList(calloutRepo.getUniqueSAStatuses().toArray())
		);
	}
	//
}
