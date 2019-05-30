package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_serviceappointment")
public class ServiceAppointment extends AbstractServiceAppointment implements Serializable {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public ServiceAppointment() {};
	//
}
