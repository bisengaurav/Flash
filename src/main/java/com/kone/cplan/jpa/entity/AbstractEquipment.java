package com.kone.cplan.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kone.cplan.helpers.datatype.DatetimeUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 22-05-2019
 */
@MappedSuperclass
abstract class AbstractEquipment implements Serializable {

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column(unique = true)
	private String sfid;

	@Column
	private String name;

	@Column
	private String equipmentType__c;

	@Column
	private String customerAssetName__c;

	@Column
	private String equipmentPhoneNumber__c;

	@Column
	private Integer accountId;

	@Column
	private String accountName;

	@Column
	private Integer soldToId;

	@Column
	private String soldToName;

	@Column
	private Integer locationId;

	@Column
	private String locationName;

	@Column
	private String installationStreet__c;

	@Column
	private String installationCity__c;

	@Column(name = "installation_state_provice__c")
	private String installationStateProvince__c;

	@Column
	private String installationCountry__c;

	@Column
	private Integer serviceTerritoryId;

	@Column
	private String serviceTerritoryName;

	@Column
	private Integer workCenterId;

	@Column
	private String workCenterName;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Date fsmLastValidCliEndDate__c;
	//

	//
	//Properties
	//
	public Integer getId() {
		return id;
	}

	public String getSfid() {
		return sfid;
	}

	public String getName() {
		return name;
	}

	public String getEquipmentType__c() {
		return equipmentType__c;
	}

	public String getCustomerAssetName__c() {
		return customerAssetName__c;
	}

	public String getEquipmentPhoneNumber__c() {
		return equipmentPhoneNumber__c;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public Integer getSoldToId() {
		return soldToId;
	}

	public String getSoldToName() {
		return soldToName;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public String getInstallationStreet__c() {
		return installationStreet__c;
	}

	public String getInstallationCity__c() {
		return installationCity__c;
	}

	public String getInstallationStateProvince__c() {
		return installationStateProvince__c;
	}

	public String getInstallationCountry__c() {
		return installationCountry__c;
	}

	public Integer getServiceTerritoryId() {
		return serviceTerritoryId;
	}

	public String getServiceTerritoryName() {
		return serviceTerritoryName;
	}

	public Integer getWorkCenterId() {
		return workCenterId;
	}

	public String getWorkCenterName() {
		return workCenterName;
	}

	public Boolean getFsmLastValidCliEndDate__c() {
		if (fsmLastValidCliEndDate__c == null) { return null; }
		return fsmLastValidCliEndDate__c.getTime() >= System.currentTimeMillis();
	}
	//
}
