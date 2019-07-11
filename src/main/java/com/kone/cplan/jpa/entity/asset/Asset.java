package com.kone.cplan.jpa.entity.asset;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.kone.cplan.utils.db.DbSchema;

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
