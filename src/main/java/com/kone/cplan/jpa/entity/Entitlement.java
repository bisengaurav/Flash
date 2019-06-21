package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 22-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_entitlement")
public class Entitlement implements Serializable {

	//
	//Constants
	//
	private static final long serialVersionUID = 6010253443548139289L;
	//

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public Entitlement() {};
	//

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column(unique = true)
	private String sfid;

	@Column(name = "assetid")
	private String assetId;

	@Column
	private String name;

	@Column
	private String coverage__c;

	@Column(name = "startdate")
	private Date startDate;

	@Column(name = "enddate")
	private Date endDate;

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

	public String getAssetId() {
		return assetId;
	}

	public String getName() {
		return name;
	}

	public String getCoverage__c() {
		return coverage__c;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
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
