package com.kone.cplan.jpa.entity;

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

	@Column
	private Timestamp earliestStartDate__c;

	@Column
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
