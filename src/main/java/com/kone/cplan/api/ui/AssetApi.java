package com.kone.cplan.api.ui;

import com.kone.cplan.api.DataUtilsForApi;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.jpa.entity.*;
import com.kone.cplan.jpa.entity.asset.Asset;
import com.kone.cplan.jpa.entity.asset.EquipmentType;
import com.kone.cplan.jpa.filter.AssetFilter;
import com.kone.cplan.jpa.repository.AssetDetailsRepository;
import com.kone.cplan.jpa.repository.AssetRepository;
import com.kone.cplan.utils.dto.SelectOption;
import com.kone.cplan.utils.session.AppSessionInfo;
import com.kone.cplan.utils.spring.AppContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * This class provides endpoints for UI API that work with Assets.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
@RestController
@RequestMapping("${cplan.url.ui-api-path}/asset")
public class AssetApi {

	//
	//Variables
	//
	@Autowired
	private AssetRepository assetRepo;
	@Autowired
	private AssetDetailsRepository assetDetailsRepo;
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
	//Public methods to work with the Asset entity.
	//
	/**
	 * @param Integer id of an Asset entity
	 * @return OperationResults with a Asset entity
	 */
	@GetMapping(value = "getById")
	public OperationResults getById(@RequestParam Integer id) {
		return DataUtilsForApi.findByIdWithAccessCheck(assetDetailsRepo, id);
	}

	/**
	 * @param AssetFilter
	 * @return OperationResults with list of the Asset entities
	 */
	@SuppressWarnings("unchecked")
	@GetMapping(value = "getAllByFilter")
	public OperationResults getAllByFilter(@RequestParam(name = "filter") String filterJson)
	{
		//- get data
		OperationResults operationResults = DataUtilsForApi.findByFilter(assetRepo, filterJson,
			AssetFilter.class, Sort.unsorted());
		if (!operationResults.isSuccessful()) {
			return operationResults;
		}
		List<Asset> result = (List<Asset>)operationResults.getReturnedObject();

		//- sort data
		/*
		  We decided to use server-side sorting instead of DB-side because of significant difference
		  in speed. We have limitation of 100 records on page, and does not matter whether these
		  records will be taken after sorting or before. In this case we can take 100 first available
		  records and sort them instead of sorting millions of records and taking first 100.
		 */
		result.sort(Comparator
			.comparing(Asset::getInstallationCity__c, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER))
			.thenComparing(Asset::getInstallationStreet__c, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER))
			.thenComparing(Asset::getAccountName, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER))
			.thenComparing(Asset::getName, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER))
		);

		return OperationResults.newSuccess(result);
	}

	/**
	 * @return OperationResults with list of the SelectOptions
	 */
	@GetMapping(value = "getUniqueSalesOrganizations")
	public OperationResults getUniqueSalesOrganizations()
	{
		return DataUtilsForApi.getUniqueSalesOrgs(assetRepo);
	}

	/**
	 * @return OperationResults with list of the SelectOptions
	 */
	@GetMapping(value = "getUniqueCountries")
	public OperationResults getUniqueCountries()
	{
		AppSessionInfo.UserInfo userInfo = AppContextHolder.appSessionContext().getCurrentUserInfo();
		List<String> statuses = (userInfo.isAdmin()
			? assetRepo.getUniqueCountries()
			: assetRepo.getUniqueCountriesBySalesOrg(userInfo.getSalesOrg()));
		
		return OperationResults.newSuccess(SelectOption.generateList(statuses.toArray()));
	}
	//

	/**
	 * @return OperationResults with list of the SelectOptions
	 */
	@GetMapping(value = "getUniqueEquipmentTypes")
	public OperationResults getUniqueEquipmentTypes()
	{
		return OperationResults.newSuccess(convertToSelectOptions(assetRepo.getUniqueEquipmentTypes()));
	}
	//
}