package com.kone.cplan.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kone.cplan.helpers.datatype.DatetimeUtils;
import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(schema = DbSchema.C_PLAN, name = "workorder")
public class WorkOrder implements Serializable {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public WorkOrder() {};
	//

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column(name = "workordernumber")
	private String workOrderNumber;

	@Column
	private String status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Timestamp earliestStartDate__c;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Timestamp dueDate__c;

	@Column
	private String maintenanceActivityTypeCode__c;
	//

	//
	//Properties
	//
	public Integer getId() {
		return id;
	}

	public String getWorkOrderNumber() {
		return workOrderNumber;
	}

	public String getStatus() {
		return status;
	}

	public Timestamp getEarliestStartDate__c() {
		return earliestStartDate__c;
	}

	public Timestamp getDueDate__c() {
		return dueDate__c;
	}

	public String getMaintenanceActivityTypeCode__c() {
		return maintenanceActivityTypeCode__c;
	}
	//
}
