package com.kone.cplan.api.ui;

import com.kone.cplan.api.JpaUtilsForApi;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.jpa.repository.ServiceAppointmentRepository;
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
		return JpaUtilsForApi.findById(serviceAppointmentRepo, id);
	}
	//
}
