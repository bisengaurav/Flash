package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_fsm_wc_assignment_of_work_center")
public class WcAssignmentOfWorkCenter {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public WcAssignmentOfWorkCenter() {};
	//

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column
	private String preferenceType__c;

	@Column
	private Timestamp startDate__c;

	@Column
	private Timestamp endDate__c;

	@Column(name = "workcenter_id")
	private Integer workCenterId;

	@Column(name = "workcenter_name")
	private String workCenterName;

	@Column
	private Integer serviceResourceId;

	@Column
	private String serviceResourceName;

	@Column
	private String workTypeName;
	//

	//
	//Properties
	//
	public Integer getId() {
		return id;
	}

	public String getPreferenceType__c() {
		return preferenceType__c;
	}

	public Timestamp getStartDate__c() {
		return startDate__c;
	}

	public Timestamp getEndDate__c() {
		return endDate__c;
	}

	public Integer getWorkCenterId() {
		return workCenterId;
	}

	public String getWorkCenterName() {
		return workCenterName;
	}

	public Integer getServiceResourceId() {
		return serviceResourceId;
	}

	public String getServiceResourceName() {
		return serviceResourceName;
	}

	public String getWorkTypeName() {
		return workTypeName;
	}
	//
}
