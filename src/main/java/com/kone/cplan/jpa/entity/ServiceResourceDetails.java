package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = DbSchema.C_PLAN, name = "serviceresource")
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
	private Set<ServiceResourceTerritory> serviceResourceTerritories;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_resource__c", referencedColumnName = "sfid")
	private Set<ServiceResourceWorkCenter> serviceResourceWorkCenters;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "resourceid", referencedColumnName = "sfid")
	private Set<ResourceAbsence> resourceAbsences;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "assigned_service_resource__c", referencedColumnName = "sfid")
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
