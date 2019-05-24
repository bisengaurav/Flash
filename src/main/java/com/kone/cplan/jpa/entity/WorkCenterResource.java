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

	@Column
	private String preferenceType__c;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Timestamp startDate__c;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Timestamp endDate__c;

	@Column
	private Integer serviceResource_id;

	@Column
	private String serviceResource_name;

	@Column
	private String workType_name;
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

	public Integer getServiceResource_id() {
		return serviceResource_id;
	}

	public String getServiceResource_name() {
		return serviceResource_name;
	}

	public String getWorkType_name() {
		return workType_name;
	}
	//
}
