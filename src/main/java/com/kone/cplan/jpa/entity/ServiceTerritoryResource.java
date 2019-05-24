package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_service_territory_resource")
public class ServiceTerritoryResource {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public ServiceTerritoryResource() {};
	//

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column
	private Integer serviceResource_id;

	@Column
	private String serviceResource_name;
	//

	//
	//Properties
	//
	public Integer getId() {
		return id;
	}

	public Integer getServiceResource_id() {
		return serviceResource_id;
	}

	public String getServiceResource_name() {
		return serviceResource_name;
	}
	//
}
