package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.OrderBy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_service_resource")
public class ServiceResourceDetails extends AbstractServiceResource implements Serializable {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public ServiceResourceDetails() {};
	//

	//
	//Variables
	//
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "serviceresourceid", referencedColumnName = "sfid")
	@Where(clause =
		"(effectiveenddate >= '2019-01-01 00:00:00' AND effectiveenddate < CURRENT_TIMESTAMP + '14 Days')" +
		" OR (effectivestartdate < CURRENT_TIMESTAMP AND effectiveenddate IS NULL)")
	@OrderBy(clause = "name, effectivestartdate")
	private Set<ServiceResourceTerritory> serviceResourceTerritories;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_resource__c", referencedColumnName = "sfid")
	@OrderBy(clause = "name")
	private Set<ServiceResourceWorkCenter> serviceResourceWorkCenters;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "resourceid", referencedColumnName = "sfid")
	@Where(clause = "recordtypeid != '012w0000000V96WAAS' AND (\"end\" >= '2019-01-01 00:00:00' OR \"end\" IS NULL)")
	@OrderBy(clause = "start")
	private Set<ResourceAbsence> resourceAbsences;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "assigned_service_resource__c", referencedColumnName = "sfid")
	@Where(clause = "scheduled_start_original__c >= '2019-01-01 00:00:00'")
	@OrderBy(clause = "scheduled_start_original__c")
	private Set<ServiceResourceAppointment> serviceResourceAppointments;
	//

	//
	//Properties
	//
	public Set<ServiceResourceTerritory> getServiceResourceTerritories() {
		return serviceResourceTerritories;
	}

	public Set<ServiceResourceWorkCenter> getServiceResourceWorkCenters() {
		return serviceResourceWorkCenters;
	}

	public Set<ResourceAbsence> getResourceAbsences() {
		return resourceAbsences;
	}

	public Set<ServiceResourceAppointment> getServiceResourceAppointments() {
		return serviceResourceAppointments;
	}
	//
}
