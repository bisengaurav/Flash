package com.kone.cplan.jpa.entity.serviceappt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kone.cplan.utils.db.DbSchema;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_serviceappointment_of_resource")
public class ServiceAppointmentOfResource implements Serializable {

	//
	//Constants
	//
	private static final long serialVersionUID = 8990795840180839861L;
	//

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public ServiceAppointmentOfResource() {};
	//

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column
	private String sfid;

	@Column(name = "appointmentnumber")
	private String appointmentNumber;

	@Column
	private String status;

	@Column
	private Timestamp scheduledStartOriginal__c;

	@Column
	private Timestamp scheduledEndOriginal__c;

	@Column(name = "fsl__pinned__c")
	private Boolean fslPinned__c;

	@Column(name = "workorder_id")
	private Integer workOrderId;

	@Column(name = "workorder_number")
	private String workOrderNumber;

	@Column
	private Timestamp earliestStartDate__c;

	@Column
	private Timestamp dueDate__c;

	@Column
	private String maintenanceActivityType__c;

	@Column
	private String assembly__c;

	@Column
	private String description__c;

	@Column
	private String locationName;

	@Column
	private String installationStreet__c;

	@Column
	private String installationCity__c;
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

	public Boolean getFslPinned__c() {
		return fslPinned__c;
	}

	public Integer getWorkOrderId() {
		return workOrderId;
	}

	public String getWorkOrderNumber() {
		return workOrderNumber;
	}

	public Timestamp getEarliestStartDate__c() {
		return earliestStartDate__c;
	}

	public Timestamp getDueDate__c() {
		return dueDate__c;
	}

	public String getMaintenanceActivityType__c() {
		return maintenanceActivityType__c;
	}

	public String getAssembly__c() {
		return assembly__c;
	}

	public String getDescription__c() {
		return description__c;
	}

	public String getLocationName() {
		return locationName;
	}

	public String getInstallationStreet__c() {
		return installationStreet__c;
	}

	public String getInstallationCity__c() {
		return installationCity__c;
	}
	//
}
