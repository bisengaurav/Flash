package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;
import com.kone.cplan.jpa.utils.IEntityWithSalesOrg;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.OrderBy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_service_territory")
public class ServiceTerritory implements Serializable, IEntityWithSalesOrg {

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
	@Where(clause = "isactive = true")
	@OrderBy(clause = "service_resource_name")
	private Set<ServiceTerritoryResource> activeServiceTerritoryResources;
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

	public Set<ServiceTerritoryResource> getActiveServiceTerritoryResources() {
		return activeServiceTerritoryResources;
	}
	//
}
