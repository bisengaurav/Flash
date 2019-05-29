package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = DbSchema.C_PLAN, name = "serviceterritory")
public class ServiceTerritory implements Serializable {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public ServiceTerritory() {};
	//

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column(unique = true)
	private String sfid;

	@Column
	private String name;

	@Column
	private String salesOrganization__c;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "serviceterritoryid", referencedColumnName = "sfid")
	private Set<ServiceTerritoryResource> serviceTerritoryResources;
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

	public String getSalesOrganization__c() {
		return salesOrganization__c;
	}

	public Set<ServiceTerritoryResource> getServiceTerritoryResources() {
		return serviceTerritoryResources;
	}
	//
}
