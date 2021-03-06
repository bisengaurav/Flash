package com.kone.cplan.jpa.filter;

import java.sql.Timestamp;

/**
 * This class represents a filter for the Callout entities.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 27-05-2019
 */
public class CalloutFilter implements IFilterWithSalesOrg {

	//
	//Variables
	//
	private String caseNumber;

	private Timestamp createdDate;

	private String status;

	private Boolean entrapment__c;

	private Boolean hazard__c;

	private Boolean injury__c;

	private String assetName;

	private String locationName;

	private String street__c;

	private String city__c;

	private String stateProvince__c;

	private String contactName;

	private String callerName__c;

	private String workOrderNumber;

	private Timestamp dueDate__c;

	private String maintenanceActivityTypeCode__c;

	private String assembly__c;

	private String appointmentNumber;

	private String serviceAppointmentStatus;

	private String serviceResourceName;

	private String serviceTerritoryName;

	private String caseOwnerTxt__c;

	private String salesOrganization__c;
	//

	//
	//Properties
	//
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getEntrapment__c() {
		return entrapment__c;
	}
	public void setEntrapment__c(Boolean entrapment__c) {
		this.entrapment__c = entrapment__c;
	}

	public Boolean getHazard__c() {
		return hazard__c;
	}
	public void setHazard__c(Boolean hazard__c) {
		this.hazard__c = hazard__c;
	}

	public Boolean getInjury__c() {
		return injury__c;
	}
	public void setInjury__c(Boolean injury__c) {
		this.injury__c = injury__c;
	}

	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getStreet__c() {
		return street__c;
	}
	public void setStreet__c(String street__c) {
		this.street__c = street__c;
	}

	public String getCity__c() {
		return city__c;
	}
	public void setCity__c(String city__c) {
		this.city__c = city__c;
	}

	public String getStateProvince__c() {
		return stateProvince__c;
	}
	public void setStateProvince__c(String stateProvince__c) {
		this.stateProvince__c = stateProvince__c;
	}

	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getCallerName__c() {
		return callerName__c;
	}
	public void setCallerName__c(String callerName__c) {
		this.callerName__c = callerName__c;
	}

	public String getWorkOrderNumber() {
		return workOrderNumber;
	}
	public void setWorkOrderNumber(String workOrderNumber) {
		this.workOrderNumber = workOrderNumber;
	}

	public Timestamp getDueDate__c() {
		return dueDate__c;
	}
	public void setDueDate__c(Timestamp dueDate__c) {
		this.dueDate__c = dueDate__c;
	}

	public String getMaintenanceActivityTypeCode__c() {
		return maintenanceActivityTypeCode__c;
	}
	public void setMaintenanceActivityTypeCode__c(String maintenanceActivityTypeCode__c) {
		this.maintenanceActivityTypeCode__c = maintenanceActivityTypeCode__c;
	}

	public String getAssembly__c() {
		return assembly__c;
	}
	public void setAssembly__c(String assembly__c) {
		this.assembly__c = assembly__c;
	}

	public String getAppointmentNumber() {
		return appointmentNumber;
	}
	public void setAppointmentNumber(String appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
	}

	public String getServiceAppointmentStatus() {
		return serviceAppointmentStatus;
	}
	public void setServiceAppointmentStatus(String serviceAppointmentStatus) {
		this.serviceAppointmentStatus = serviceAppointmentStatus;
	}

	public String getServiceResourceName() {
		return serviceResourceName;
	}
	public void setServiceResourceName(String serviceResourceName) {
		this.serviceResourceName = serviceResourceName;
	}

	public String getServiceTerritoryName() {
		return serviceTerritoryName;
	}
	public void setServiceTerritoryName(String serviceTerritoryName) {
		this.serviceTerritoryName = serviceTerritoryName;
	}

	public String getCaseOwnerTxt__c() {
		return caseOwnerTxt__c;
	}
	public void setCaseOwnerTxt__c(String caseOwnerTxt__c) {
		this.caseOwnerTxt__c = caseOwnerTxt__c;
	}

	public String getSalesOrganization__c() {
		return salesOrganization__c;
	}
	@Override
	public void setSalesOrganization__c(String salesOrganization__c) {
		this.salesOrganization__c = salesOrganization__c;
	}
	//
}
