package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 22-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_asset")
public class Asset extends AbstractAsset implements Serializable {

	//
	//Constants
	//
	private static final long serialVersionUID = 4454638119322037681L;
	//

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public Asset() {};
	//
}
