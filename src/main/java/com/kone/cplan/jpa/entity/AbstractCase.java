package com.kone.cplan.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kone.cplan.helpers.datatype.DatetimeUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 27-05-2019
 */
@MappedSuperclass
abstract class AbstractCase implements Serializable {

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column(name = "casenumber")
	private String caseNumber;

	@Column(name = "createddate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Timestamp createdDate;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Date npxResponseDueDate__c;

	@Column
	private Boolean entrapment__c;

	@Column
	private Boolean hazard__c;

	@Column
	private Boolean injury__c;

	@Column
	private String street__c;

	@Column
	private String city__c;

	@Column
	private String stateProvince__c;

	@Column(name = "recordtypeid")
	private String recordTypeId;

	@Column
	private String callerName__c;

	@Column
	private String status;

	@Column
	private Integer assetId;

	@Column
	private String assetName;

	@Column
	private String locationName;

	@Column
	private String contactName;

	@Column(name = "workorder_id")
	private Integer workOrderId;

	@Column(name = "workorder_number")
	private String workOrderNumber;

	@Column
	private String assemblyNumber__c;

	@Column
	private String assembly__c;

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
	private String salesOrganization__c;
	//

	//
	//Properties
	//
	public Integer getId() {
		return id;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public Date getNpxResponseDueDate__c() {
		return npxResponseDueDate__c;
	}

	public Boolean getEntrapment__c() {
		return entrapment__c;
	}

	public Boolean getHazard__c() {
		return hazard__c;
	}

	public Boolean getInjury__c() {
		return injury__c;
	}

	public String getStreet__c() {
		return street__c;
	}

	public String getCity__c() {
		return city__c;
	}

	public String getStateProvince__c() {
		return stateProvince__c;
	}

	public String getRecordTypeId() {
		return recordTypeId;
	}

	public String getCallerName__c() {
		return callerName__c;
	}

	public String getStatus() {
		return status;
	}

	public Integer getAssetId() {
		return assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public String getLocationName() {
		return locationName;
	}

	public String getContactName() {
		return contactName;
	}

	public Integer getWorkOrderId() {
		return workOrderId;
	}

	public String getWorkOrderNumber() {
		return workOrderNumber;
	}

	public String getAssemblyNumber__c() {
		return assemblyNumber__c;
	}

	public String getAssembly__c() {
		return assembly__c;
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

	public String getSalesOrganization__c() {
		return salesOrganization__c;
	}
	//
}
