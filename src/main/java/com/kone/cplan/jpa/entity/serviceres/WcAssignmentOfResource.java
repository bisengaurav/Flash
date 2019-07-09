package com.kone.cplan.jpa.entity.serviceres;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name= "view_fsm_wc_assignment_of_resource")
public class WcAssignmentOfResource implements Serializable {

	//
	//Constants
	//
	private static final long serialVersionUID = -8678803104744350146L;
	//

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public WcAssignmentOfResource() {};
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
