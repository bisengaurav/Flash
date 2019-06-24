package com.kone.cplan.jpa.entity.serviceappt;

import com.kone.cplan.jpa.utils.IEntityWithSalesOrg;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@MappedSuperclass
public abstract class AbstractServiceAppointment implements IEntityWithSalesOrg {

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column(unique = true)
	private String sfid;

	@Column(name = "appointmentnumber")
	private String appointmentNumber;

	@Column
	private String status;

	@Column
	private Timestamp scheduledStartOriginal__c;

	@Column
	private Timestamp scheduledEndOriginal__c;

	@Column(name = "serviceresource_id")
	private Integer serviceResourceId;

	@Column(name = "serviceresource_name")
	private String serviceResourceName;

	@Column
	private String salesOrganization__c;
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

	public String getAppointmentNumber() {
		return appointmentNumber;
	}

	public String getStatus() {
		return status;
	}

	public Timestamp getScheduledStartOriginal__c() {
		return scheduledStartOriginal__c;
	}

	public Timestamp getScheduledEndOriginal__c() {
		return scheduledEndOriginal__c;
	}

	public Integer getServiceResourceId() {
		return serviceResourceId;
	}

	public String getServiceResourceName() {
		return serviceResourceName;
	}

	public String getSalesOrganization__c() {
		return salesOrganization__c;
	}
	//
}
