package com.kone.cplan.jpa.entity.workorder;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.kone.cplan.utils.db.DbSchema;

import java.io.Serializable;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_workorder")
public class WorkOrder extends AbstractWorkOrder implements Serializable {

	//
	//Constants
	//
	private static final long serialVersionUID = -4377897156432335419L;
	//

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public WorkOrder() {};
	//
}
