package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_service_resource")
public class ServiceResource extends AbstractServiceResource implements Serializable {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public ServiceResource() {};
	//
}
