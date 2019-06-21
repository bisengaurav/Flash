package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_workorder_details")
public class WorkOrderDetails extends AbstractWorkOrder implements Serializable {

	//
	//Constants
	//
	private static final long serialVersionUID = 1212686421648805343L;
	//

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public WorkOrderDetails() {};
	//

	//
	//Variables
	//

	@Column(name = "lastmodifieddate")
	private Timestamp lastModifiedDate;

	@Column
	private String maintenanceActivityTypeCode__c;

	@Column
	private String assembly__c;

	@Column
	private String description__c;

	@Column
	private Integer accountId;

	@Column
	private String accountName;

	@Column
	private Integer assetId;

	@Column
	private String assetName;

	@Column(name = "serviceterritory_id")
	private Integer serviceTerritoryId;

	@Column(name = "serviceterritory_name")
	private String serviceTerritoryName;

	@Column
	private String locationName;

	@Column
	private Integer caseId;

	@Column(name = "casenumber")
	private String caseNumber;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "work_order__c", referencedColumnName = "sfid")
	private Set<ServiceAppointment> serviceAppointments;
	//

	//
	//Properties
	//
	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public String getMaintenanceActivityTypeCode__c() {
		return maintenanceActivityTypeCode__c;
	}

	public String getAssembly__c() {
		return assembly__c;
	}

	public String getDescription__c() {
		return description__c;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public String getAccountName() {
		return accountName;
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

	public String getLocationName() {
		return locationName;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public Set<ServiceAppointment> getServiceAppointments() {
		return serviceAppointments;
	}
	//
}
