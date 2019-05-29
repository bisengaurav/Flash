package com.kone.cplan.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kone.cplan.helpers.datatype.DatetimeUtils;
import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 27-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_case")
public class Case extends AbstractCase {

	//
	//Variables
	//

	@Column
	private String street__c;

	@Column
	private String city__c;

	@Column
	private String stateProvince__c;

	@Column(name = "serviceappointment_id")
	private Integer serviceAppointmentId;

	@Column(name = "appointmentnumber")
	private String appointmentNumber;

	@Column(name = "serviceappointment_status")
	private String serviceAppointmentStatus;

	@Column(name = "serviceresource_id")
	private Integer serviceResourceId;

	@Column(name = "serviceresource_name")
	private String serviceResourceName;

	@Column(name = "serviceterritory_id")
	private Integer serviceTerritoryId;

	@Column(name = "serviceterritory_name")
	private String serviceTerritoryName;

	@Column
	private String assembly__c;

	@Column
	private String locationName;

	@Column(name = "workorder_id")
	private Integer workOrderId;

	@Column(name = "workorder_number")
	private String workOrderNumber;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Timestamp dueDate__c;

	@Column
	private String maintenanceActivityTypeCode__c;
	//

	//
	//Properties
	//
	public String getStreet__c() {
		return street__c;
	}

	public String getCity__c() {
		return city__c;
	}

	public String getStateProvince__c() {
		return stateProvince__c;
	}

	public Timestamp getDueDate__c() {
		return dueDate__c;
	}

	public Integer getServiceAppointmentId() {
		return serviceAppointmentId;
	}

	public String getAppointmentNumber() {
		return appointmentNumber;
	}

	public String getServiceAppointmentStatus() {
		return serviceAppointmentStatus;
	}

	public Integer getServiceResourceId() {
		return serviceResourceId;
	}

	public String getServiceResourceName() {
		return serviceResourceName;
	}

	public Integer getServiceTerritoryId() {
		return serviceTerritoryId;
	}

	public String getServiceTerritoryName() {
		return serviceTerritoryName;
	}

	public String getAssembly__c() {
		return assembly__c;
	}

	public String getLocationName() {
		return locationName;
	}

	public Integer getWorkOrderId() {
		return workOrderId;
	}

	public String getWorkOrderNumber() {
		return workOrderNumber;
	}

	public String getMaintenanceActivityTypeCode__c() {
		return maintenanceActivityTypeCode__c;
	}
	//
}
