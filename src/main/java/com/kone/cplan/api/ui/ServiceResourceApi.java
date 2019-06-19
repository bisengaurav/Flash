package com.kone.cplan.api.ui;

import com.kone.cplan.api.DataUtilsForApi;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.jpa.entity.ServiceResourceDetails;
import com.kone.cplan.jpa.filter.ServiceResourceFilter;
import com.kone.cplan.jpa.repository.ServiceResourceDetailsRepository;
import com.kone.cplan.jpa.repository.ServiceResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This class provides endpoints for UI API that work with ServiceResource entities.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 24-05-2019
 */
@RestController
@RequestMapping("${cplan.url.ui-api-path}/serviceResource")
public class ServiceResourceApi {

	//
	//Variables
	//
	@Autowired
	private ServiceResourceRepository serviceResourceRepo;
	@Autowired
	private ServiceResourceDetailsRepository serviceResourceDetailsRepo;
	@PersistenceContext
	private EntityManager entityManager;
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
		ServiceResourceDetails.configureFilter(entityManager);
		return DataUtilsForApi.findByIdWithAccessCheck(serviceResourceDetailsRepo, id);
	}

	/**
	 * @param ServiceResourceFilter
	 * @return OperationResults with list of the ServiceResource entities
	 */
	@GetMapping(value = "getAllByFilter")
	public OperationResults getAllByFilter(@RequestParam(name = "filter") String filterJson)
	{
		return DataUtilsForApi.findByFilter(serviceResourceRepo, filterJson,
			ServiceResourceFilter.class, Sort.unsorted());
	}

	/**
	 * @return OperationResults with list of the SelectOptions
	 */
	@GetMapping(value = "getUniqueSalesOrganizations")
	public OperationResults getUniqueSalesOrganizations()
	{
		return DataUtilsForApi.getUniqueSalesOrganizations(serviceResourceRepo);
	}
	//
}
