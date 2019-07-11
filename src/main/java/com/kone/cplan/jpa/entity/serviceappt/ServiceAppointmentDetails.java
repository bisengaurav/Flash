package com.kone.cplan.jpa.entity.serviceappt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.kone.cplan.utils.db.DbSchema;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_serviceappointment_details")
public class ServiceAppointmentDetails extends AbstractServiceAppointment implements Serializable {

	//
	//Constants
	//
	private static final long serialVersionUID = -8113652763520533722L;
	//

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public ServiceAppointmentDetails() {};
	//

	//
	//Variables
	//
	@Column(name = "lastmodifieddate")
	private Timestamp lastModifiedDate;

	@Column(name = "fsl__pinned__c")
	private Boolean fslPinned__c;

	@Column
	private String blockedReason__c;

	@Column
	private Integer accountId;

	@Column
	private String accountName;

	@Column(name = "workorder_id")
	private Integer workOrderId;

	@Column(name = "workorder_number")
	private String workOrderNumber;

	@Column
	private Integer assetId;

	@Column
	private String assetName;

	@Column(name = "serviceterritory_id")
	private Integer serviceTerritoryId;

	@Column(name = "serviceterritory_name")
	private String serviceTerritoryName;
	//

	//
	//Properties
	//
	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public Boolean getFslPinned__c() {
		return fslPinned__c;
	}

	public String getBlockedReason__c() {
		return blockedReason__c;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public Integer getWorkOrderId() {
		return workOrderId;
	}

	public String getWorkOrderNumber() {
		return workOrderNumber;
	}

	public Integer getAssetId() {
		return assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public Integer getServiceTerritoryId() {
		return serviceTerritoryId;
	}

	public String getServiceTerritoryName() {
		return serviceTerritoryName;
	}
	//
}
