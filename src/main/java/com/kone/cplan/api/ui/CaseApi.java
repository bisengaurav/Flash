package com.kone.cplan.api.ui;

import com.kone.cplan.api.JpaUtilsForApi;
import com.kone.cplan.api.ui.utils.pagination.PagingUtils;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.helpers.serialization.JsonUtils;
import com.kone.cplan.jpa.entity.Case;
import com.kone.cplan.jpa.filter.CaseFilter;
import com.kone.cplan.jpa.repository.CaseDetailsRepository;
import com.kone.cplan.jpa.repository.CaseRepository;
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

import java.util.*;
import java.util.regex.Pattern;

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
	@Autowired
	private CaseDetailsRepository caseDetailsRepo;
	@Autowired
	private AppSessionContext appSessionContext;
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
		return JpaUtilsForApi.findById(caseDetailsRepo, id);
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

		if (filter == null || filter.isEmpty()) {
			return OperationResults.newErrorByKey("message.common.empty-filter");
		}

		AppSessionInfo.UserInfo userInfo = appSessionContext.getCurrentUserInfo();
		if (!userInfo.isAdmin()) {
			if (userInfo.getSalesOrg() == null) {
				return OperationResults.newSuccess(new ArrayList<Case>());
			}
			filter.setSalesOrganization__c(userInfo.getSalesOrg());
		}

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
		AppSessionInfo.UserInfo userInfo = appSessionContext.getCurrentUserInfo();
		//- If current user's profile is C-Plan Admin then all SalesOrgs are available to him.
		// In other case only his SalesOrg is available.
		if (userInfo.isAdmin()) {
			return OperationResults.newSuccess(
				//- Account's Sales_Organizations__c field, which is used for filtering records by
				// sales org, may contain several sales orgs separated by comma. We need to parse
				// all the fields and extract all sales orgs.
				SelectOption.generateList(caseRepo.getUniqueSalesOrganizations().stream()
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

	/**
	 * @return OperationResults with list of the SelectOptions
	 */
	@GetMapping(value = "getUniqueMaintenanceActivityTypeCodes")
	public OperationResults getUniqueMaintenanceActivityTypeCodes()
	{
		return OperationResults.newSuccess(
			SelectOption.generateList(caseRepo.getUniqueMaintenanceActivityTypeCodes().toArray())
		);
	}

	/**
	 * @return OperationResults with list of the SelectOptions
	 */
	@GetMapping(value = "getUniqueAssemblies")
	public OperationResults getUniqueAssemblies()
	{
		return OperationResults.newSuccess(
			SelectOption.generateList(caseRepo.getUniqueAssemblies().toArray())
		);
	}
	//
}
