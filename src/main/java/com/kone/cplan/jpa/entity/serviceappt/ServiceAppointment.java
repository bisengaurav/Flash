package com.kone.cplan.jpa.entity.serviceappt;

import javax.persistence.*;

import com.kone.cplan.utils.db.DbSchema;

import java.io.Serializable;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_serviceappointment")
public class ServiceAppointment extends AbstractServiceAppointment implements Serializable {

	//
	//Constants
	//
	private static final long serialVersionUID = -8278167715448857154L;
	//

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public ServiceAppointment() {};
	//
}
