package com.kone.cplan.jpa.entity.asset;

import com.kone.cplan.jpa.utils.IEntityWithSalesOrgs;
import com.kone.cplan.utils.datatype.DatetimeUtils;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 22-05-2019
 */
@MappedSuperclass
public abstract class AbstractAsset implements IEntityWithSalesOrgs {

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
	private String equipmentTypeValue;

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
	private Date fsmLastValidCliEndDate__c;

	@Column
	private String salesOrganizations__c;
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

	public String getEquipmentTypeValue() {
		return equipmentTypeValue;
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
		if (fsmLastValidCliEndDate__c == null) { return false; }

		Calendar currentUserCalendar = DatetimeUtils.getCalendarForCU();
		DatetimeUtils.resetTimePart(currentUserCalendar);
		//- return true if 'fsmLastValidCliEndDate__c' is today or future. In other case return false.
		return fsmLastValidCliEndDate__c.getTime() >= currentUserCalendar.getTimeInMillis();
	}

	@Override
	public String getSalesOrganizations__c() {
		return salesOrganizations__c;
	}
	//
}
