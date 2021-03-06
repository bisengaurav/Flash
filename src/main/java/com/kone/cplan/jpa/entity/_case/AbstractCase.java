package com.kone.cplan.jpa.entity._case;

import com.kone.cplan.jpa.utils.IEntityWithSalesOrgs;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 27-05-2019
 */
@MappedSuperclass
public abstract class AbstractCase implements IEntityWithSalesOrgs {

	//
	//Variables
	//
	@Column
	private String sfid;

	@Column(name = "casenumber")
	private String caseNumber;

	@Column(name = "caseownertxt__c")
	private String caseOwnerTxt__c;

	@Column(name = "createddate")
	private Timestamp createdDate;

	@Column
	private Boolean entrapment__c;

	@Column
	private Boolean hazard__c;

	@Column
	private Boolean injury__c;

	@Column(name = "recordtypeid")
	private String recordTypeId;

	@Column
	private Integer assetId;

	@Column
	private String assetName;

	@Column
	private String callerName__c;

	@Column
	private String status;

	@Column
	private String contactName;

	@Column
	private String salesOrganizations__c;
	//

	//
	//Properties
	//
	public String getSfid() {
		return sfid;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public String getCaseOwnerTxt__c() {
		return caseOwnerTxt__c;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
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

	public String getRecordTypeId() {
		return recordTypeId;
	}

	public Integer getAssetId() {
		return assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public String getCallerName__c() {
		return callerName__c;
	}

	public String getStatus() {
		return status;
	}

	public String getContactName() {
		return contactName;
	}

	@Override
	public String getSalesOrganizations__c() {
		return salesOrganizations__c;
	}
	//
}
