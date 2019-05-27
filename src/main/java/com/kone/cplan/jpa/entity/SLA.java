package com.kone.cplan.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kone.cplan.helpers.datatype.DatetimeUtils;
import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 22-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_entitlement")
public class SLA {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public SLA() {};
	//

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column(unique = true)
	private String sfid;

	@Column
	private String assetid;

	@Column
	private String name;

	@Column
	private String coverage__c;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Date startdate;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Date enddate;

	@Column
	private String status;

	@Column
	private Float responseTime__c;

	@Column
	private Float responseTimeAfterHours__c;

	@Column
	private String calloutHours__c;

	@Column
	private String serviceHours__c;
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

	public String getCoverage__c() {
		return coverage__c;
	}

	public Date getStartdate() {
		return startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public String getStatus() {
		return status;
	}

	public Float getResponseTime__c() {
		return responseTime__c;
	}

	public Float getResponseTimeAfterHours__c() {
		return responseTimeAfterHours__c;
	}

	public String getCalloutHours__c() {
		return calloutHours__c;
	}

	public String getServiceHours__c() {
		return serviceHours__c;
	}
	//
}
