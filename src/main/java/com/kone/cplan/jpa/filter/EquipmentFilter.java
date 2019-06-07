package com.kone.cplan.jpa.filter;

/**
 * This class represents a filter for the Equipment entities.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public class EquipmentFilter implements Filter {

	//
	//Variables
	//
	private String installationCountry__c;

	private String equipmentType__c;

	private String customerAssetName__c;

	private String equipmentPhoneNumber__c;

	private String accountName;

	private String soldToName;

	private String locationName;

	private String installationStreet__c;

	private String installationCity__c;

	private String installationStateProvince__c;

	private Boolean fsmLastValidCliEndDate__c;

	private String salesOrganization__c;
	//

	//
	//Properties
	//
	public String getInstallationCountry__c() {
		return installationCountry__c;
	}
	public void setInstallationCountry__c(String installationCountry__c) {
		this.installationCountry__c = installationCountry__c;
	}

	public String getEquipmentType__c() {
		return equipmentType__c;
	}
	public void setEquipmentType__c(String equipmentType__c) {
		this.equipmentType__c = equipmentType__c;
	}

	public String getCustomerAssetName__c() {
		return customerAssetName__c;
	}
	public void setCustomerAssetName__c(String customerAssetName__c) {
		this.customerAssetName__c = customerAssetName__c;
	}

	public String getEquipmentPhoneNumber__c() {
		return equipmentPhoneNumber__c;
	}
	public void setEquipmentPhoneNumber__c(String equipmentPhoneNumber__c) {
		this.equipmentPhoneNumber__c = equipmentPhoneNumber__c;
	}

	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getSoldToName() {
		return soldToName;
	}
	public void setSoldToName(String soldToName) {
		this.soldToName = soldToName;
	}

	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getInstallationStreet__c() {
		return installationStreet__c;
	}
	public void setInstallationStreet__c(String installationStreet__c) {
		this.installationStreet__c = installationStreet__c;
	}

	public String getInstallationCity__c() {
		return installationCity__c;
	}
	public void setInstallationCity__c(String installationCity__c) {
		this.installationCity__c = installationCity__c;
	}

	public String getInstallationStateProvince__c() {
		return installationStateProvince__c;
	}
	public void setInstallationStateProvince__c(String installationStateProvince__c) {
		this.installationStateProvince__c = installationStateProvince__c;
	}

	public Boolean getFsmLastValidCliEndDate__c() {
		return fsmLastValidCliEndDate__c;
	}
	public void setFsmLastValidCliEndDate__c(Boolean fsmLastValidCliEndDate__c) {
		this.fsmLastValidCliEndDate__c = fsmLastValidCliEndDate__c;
	}

	public String getSalesOrganization__c() {
		return salesOrganization__c;
	}
	public void setSalesOrganization__c(String salesOrganization__c) {
		this.salesOrganization__c = salesOrganization__c;
	}
	//
}
