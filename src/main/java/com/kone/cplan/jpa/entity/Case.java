package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 27-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_case")
public class Case extends AbstractCase {

	//
	//Variables
	//
	@EmbeddedId
	private CaseCompositeKey compositeKey;

	@Column
	private String street__c;

	@Column
	private String city__c;

	@Column
	private String stateProvince__c;

	@Column(name = "appointmentnumber")
	private String appointmentNumber;

	@Column(name = "serviceappointment_status")
	private String serviceAppointmentStatus;

	@Column(name = "serviceresource_id")
	private Integer serviceResourceId;

	@Column(name = "serviceresource_name")
	private String serviceResourceName;

	@Column(name = "serviceterritory_id")
	private Integer serviceTerritoryId;

	@Column(name = "serviceterritory_name")
	private String serviceTerritoryName;

	@Column
	private String assembly__c;

	@Column
	private String locationName;

	@Column(name = "workorder_number")
	private String workOrderNumber;

	@Column
	private Timestamp dueDate__c;

	@Column
	private String maintenanceActivityTypeCode__c;
	//

	//
	//Properties
	//
	public CaseCompositeKey getCompositeKey() {
		return compositeKey;
	}

	public Integer getId() {
		return compositeKey.getId();
	}

	public Integer getWorkOrderId() {
		return compositeKey.getWorkOrderId();
	}

	public Integer getServiceAppointmentId() {
		return compositeKey.getServiceAppointmentId();
	}

	public String getStreet__c() {
		return street__c;
	}

	public String getCity__c() {
		return city__c;
	}

	public String getStateProvince__c() {
		return stateProvince__c;
	}

	public Timestamp getDueDate__c() {
		return dueDate__c;
	}

	public String getAppointmentNumber() {
		return appointmentNumber;
	}

	public String getServiceAppointmentStatus() {
		return serviceAppointmentStatus;
	}

	public Integer getServiceResourceId() {
		return serviceResourceId;
	}

	public String getServiceResourceName() {
		return serviceResourceName;
	}

	public Integer getServiceTerritoryId() {
		return serviceTerritoryId;
	}

	public String getServiceTerritoryName() {
		return serviceTerritoryName;
	}

	public String getAssembly__c() {
		return assembly__c;
	}

	public String getLocationName() {
		return locationName;
	}

	public String getWorkOrderNumber() {
		return workOrderNumber;
	}

	public String getMaintenanceActivityTypeCode__c() {
		return maintenanceActivityTypeCode__c;
	}
	//

	//
	//Data Types
	//
	@Embeddable
	public static class CaseCompositeKey implements Serializable {

		@Column(nullable = false)
		private Integer id;

		@Column(name = "workorder_id", nullable = false)
		private Integer workOrderId;

		@Column(name = "serviceappointment_id", nullable = false)
		private Integer serviceAppointmentId;

		public CaseCompositeKey() {}

		public CaseCompositeKey(Integer id, Integer workOrderId, Integer serviceAppointmentId) {
			this.id = id;
			this.workOrderId = workOrderId;
			this.serviceAppointmentId = serviceAppointmentId;
		}

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getWorkOrderId() {
			return workOrderId;
		}
		public void setWorkOrderId(Integer workOrderId) {
			this.workOrderId = workOrderId;
		}

		public Integer getServiceAppointmentId() {
			return serviceAppointmentId;
		}
		public void setServiceAppointmentId(Integer serviceAppointmentId) {
			this.serviceAppointmentId = serviceAppointmentId;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			CaseCompositeKey that = (CaseCompositeKey) o;
			return id.equals(that.id) &&
				workOrderId.equals(that.workOrderId) &&
				serviceAppointmentId.equals(that.serviceAppointmentId);
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, workOrderId, serviceAppointmentId);
		}
	}
	//
}
