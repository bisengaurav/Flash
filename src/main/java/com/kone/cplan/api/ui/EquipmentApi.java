package com.kone.cplan.api.ui;

import com.kone.cplan.api.JpaUtilsForApi;
import com.kone.cplan.api.ui.utils.pagination.PagingUtils;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.helpers.serialization.JsonUtils;
import com.kone.cplan.jpa.entity.Equipment;
import com.kone.cplan.jpa.entity.EquipmentType;
import com.kone.cplan.jpa.filter.EquipmentFilter;
import com.kone.cplan.jpa.repository.EquipmentDetailsRepository;
import com.kone.cplan.jpa.repository.EquipmentRepository;
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
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * This class provides endpoints for UI API that work with Equipments.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
@RestController
@RequestMapping("${cplan.url.ui-api-path}/equipment")
public class EquipmentApi {

	//
	//Constants
	//
	@Autowired
	private EquipmentRepository equipmentRepo;
	@Autowired
	private EquipmentDetailsRepository equipmentDetailsRepo;
	@Autowired
	private AppSessionContext appSessionContext;
	//

	//
	//Private static methods
	//
	private static List<SelectOption> convertToSelectOptions(List<EquipmentType> equipmentTypes) {
		List<SelectOption> result = new ArrayList<>(equipmentTypes.size());
		for (EquipmentType equipmentType : equipmentTypes) {
			result.add(new SelectOption(equipmentType.getValue(), equipmentType.getApiName()));
		}
		return result;
	}
	//

	//
	//Public methods to work with the Equipment entity.
	//
	/**
	 * @param Integer id of a Equipment entity
	 * @return OperationResults with a Equipment entity
	 */
	@GetMapping(value = "getById")
	public OperationResults getById(@RequestParam Integer id) {
		return JpaUtilsForApi.findById(equipmentDetailsRepo, id);
	}

	/**
	 * @param EquipmentFilter
	 * @return OperationResults with list of the Equipment entities
	 */
	@GetMapping(value = "getAllByFilter")
	public OperationResults getAllByFilter(@RequestParam(name = "filter") String filterJson)
	{
		//- deserialize parameters
		EquipmentFilter filter = JsonUtils.deserialize_typed(filterJson, EquipmentFilter.class);
		if (filter == null || filter.isEmpty()) {
			return OperationResults.newErrorByKey("message.common.empty-filter");
		}

		Pageable pageRequest = PagingUtils.extractOrGetDefaultPageRequest(Sort.unsorted());

		//- get data
		List<Equipment> result = equipmentRepo.findByFilter(filter, pageRequest);

		//- sort data
		/*
		  We decided to use server-side sorting instead of DB-side because of significant difference
		  in speed. We have limitation of 100 records on page, and does not matter whether these
		  records will be taken after sorting or before. In this case we can take 100 first available
		  records and sort them instead of sorting millions of records and taking first 100.
		 */
		result.sort(Comparator
			.comparing(Equipment::getInstallationCity__c, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER))
			.thenComparing(Equipment::getInstallationStreet__c, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER))
			.thenComparing(Equipment::getAccountName, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER))
			.thenComparing(Equipment::getName, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER))
		);

		return OperationResults.newSuccess(result);
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
				SelectOption.generateList(equipmentRepo.getUniqueSalesOrganizations().stream()
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
	@GetMapping(value = "getUniqueCountries")
	public OperationResults getUniqueCountries()
	{
		return OperationResults.newSuccess(
			SelectOption.generateList(equipmentRepo.getUniqueCountries().toArray())
		);
	}
	//

	/**
	 * @return OperationResults with list of the SelectOptions
	 */
	@GetMapping(value = "getUniqueEquipmentTypes")
	public OperationResults getUniqueEquipmentTypes()
	{
		return OperationResults.newSuccess(convertToSelectOptions(equipmentRepo.getUniqueEquipmentTypes()));
	}
	//
}
