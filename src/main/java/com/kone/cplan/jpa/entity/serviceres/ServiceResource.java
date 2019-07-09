package com.kone.cplan.jpa.entity.serviceres;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_serviceresource")
public class ServiceResource extends AbstractServiceResource implements Serializable {

	//
	//Constants
	//
	private static final long serialVersionUID = -708188788867281161L;
	//

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public ServiceResource() {};
	//
}
