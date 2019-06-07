package com.kone.cplan.api.ui;

import com.kone.cplan.api.JpaUtilsForApi;
import com.kone.cplan.api.ui.utils.pagination.PagingUtils;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.helpers.serialization.JsonUtils;
import com.kone.cplan.jpa.entity.ServiceResource;
import com.kone.cplan.jpa.filter.ServiceResourceFilter;
import com.kone.cplan.jpa.repository.ServiceResourceDetailsRepository;
import com.kone.cplan.jpa.repository.ServiceResourceRepository;
import com.kone.cplan.utils.dto.SelectOption;
import com.kone.cplan.utils.session.AppSessionContext;
import com.kone.cplan.utils.session.AppSessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

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
	@Autowired
	private AppSessionContext appSessionContext;
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

		AppSessionInfo.UserInfo userInfo = appSessionContext.getCurrentUserInfo();
		if (!userInfo.isAdmin()) {
			if (userInfo.getSalesOrg() == null) {
				return OperationResults.newSuccess(new ArrayList<ServiceResource>());
			}
			filter.setSalesOrganization__c(userInfo.getSalesOrg());
		}

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
		AppSessionInfo.UserInfo userInfo = appSessionContext.getCurrentUserInfo();
		//- If current user's profile is C-Plan Admin then all SalesOrgs are available to him.
		// In other case only his SalesOrg is available.
		if (userInfo.isAdmin()) {
			return OperationResults.newSuccess(
				//- Account's Sales_Organizations__c field, which is used for filtering records by
				// sales org, may contain several sales orgs separated by comma. We need to parse
				// all the fields and extract all sales orgs.
				SelectOption.generateList(serviceResourceRepo.getUniqueSalesOrganizations().stream()
					.flatMap(Pattern.compile(",")::splitAsStream)
					.distinct()
					.toArray(String[]::new)
				)
			);
		} else {
			return OperationResults.newSuccess(userInfo.getSalesOrg() != null
				? Arrays.asList(new SelectOption(userInfo.getSalesOrg()))
				: new ArrayList<SelectOption>());
		}
	}
	//
}
