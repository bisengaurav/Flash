package com.kone.cplan.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kone.cplan.helpers.datatype.DatetimeUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@MappedSuperclass
abstract class AbstractWorkOrder implements Serializable {

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column(unique = true)
	private String sfid;

	@Column(name = "workordernumber")
	private String workOrderNumber;

	@Column
	private String status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Timestamp earliestStartDate__c;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Timestamp dueDate__c;
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
	//
}
