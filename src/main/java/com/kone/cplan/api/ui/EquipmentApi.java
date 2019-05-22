package com.kone.cplan.api.ui;

import com.kone.cplan.api.JpaUtilsForApi;
import com.kone.cplan.api.ui.utils.pagination.PagingUtils;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.helpers.serialization.JsonUtils;
import com.kone.cplan.jpa.filter.EquipmentFilter;
import com.kone.cplan.jpa.repository.EquipmentDetailsRepository;
import com.kone.cplan.jpa.repository.EquipmentRepository;
import com.kone.cplan.utils.dto.SelectOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	//

	//
	//Private static methods
	//
	private static Sort getDefaultSort() {
		return Sort.by(Sort.Direction.ASC, "installationCity__c", "installationStreet__c",
			"accountName", "equipmentType__c", "name");
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
		Pageable pageRequest = PagingUtils.extractOrGetDefaultPageRequest(getDefaultSort());

		//- get and return data
		return OperationResults.newSuccess(equipmentRepo.findByFilter(filter, pageRequest, false));
	}

	/**
	 * @return OperationResults with list of the Countries
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
	 * @return OperationResults with list of the Equipment Types
	 */
	@GetMapping(value = "getEquipmentTypes")
	public OperationResults getEquipmentTypes()
	{
		return OperationResults.newSuccess(
			SelectOption.generateList(equipmentRepo.getEquipmentTypes().toArray())
		);
	}
	//
}
