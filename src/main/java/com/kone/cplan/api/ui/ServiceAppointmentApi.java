package com.kone.cplan.api.ui;

import com.kone.cplan.api.DataUtilsForApi;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.jpa.repository.ServiceAppointmentDetailsRepository;
import com.kone.cplan.jpa.repository.ServiceAppointmentRepository;
import com.kone.cplan.utils.dto.SelectOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with ServiceAppointment entities.
 *
 * @author Andrey Gribanov
 * @created 27-05-2019
 */
@RestController
@RequestMapping("${cplan.url.ui-api-path}/serviceAppointment")
public class ServiceAppointmentApi {

	//
	//Constants
	//
	@Autowired
	private ServiceAppointmentRepository serviceAppointmentRepo;
	@Autowired
	private ServiceAppointmentDetailsRepository serviceAppointmentDetailsRepo;
	//

	//
	//Public methods to work with the ServiceAppointment entity.
	//
	/**
	 * @param Integer id of a ServiceAppointment entity
	 * @return OperationResults with a ServiceAppointment entity
	 */
	@GetMapping(value = "getById")
	public OperationResults getById(@RequestParam Integer id) {
		return DataUtilsForApi.findByIdWithAccessCheck(serviceAppointmentDetailsRepo, id);
	}

	/**
	 * @return OperationResults with list of the SelectOptions
	 */
	@GetMapping(value = "getUniqueStatuses")
	public OperationResults getUniqueStatuses()
	{
		return OperationResults.newSuccess(
			SelectOption.generateList(serviceAppointmentRepo.getUniqueStatuses().toArray())
		);
	}
	//
}
