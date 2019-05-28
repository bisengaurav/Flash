package com.kone.cplan.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kone.cplan.helpers.datatype.DatetimeUtils;
import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_work_center_resource")
public class WorkCenterResource {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public WorkCenterResource() {};
	//

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column(name = "workcenter_id")
	private Integer workCenterId;

	@Column(name = "workcenter_name")
	private String workCenterName;

	@Column
	private String preferenceType__c;

	@Column(name = "effectivestartdate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Timestamp effectiveStartDate;

	@Column(name = "effectiveenddate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Timestamp effectiveEndDate;

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

	public Integer getWorkCenterId() {
		return workCenterId;
	}

	public String getWorkCenterName() {
		return workCenterName;
	}

	public String getPreferenceType__c() {
		return preferenceType__c;
	}

	public Timestamp getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public Timestamp getEffectiveEndDate() {
		return effectiveEndDate;
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
