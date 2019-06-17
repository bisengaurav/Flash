package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name= "view_service_resource_work_center")
public class ServiceResourceWorkCenter implements Serializable {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public ServiceResourceWorkCenter() {};
	//

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column
	private String name;
	//

	//
	//Properties
	//
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	//
}
