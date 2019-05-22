package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 21-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name ="equipment_type__c")
public class EquipmentType {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public EquipmentType() {};
	//

	//
	//Variables
	//
	@Id
	private String apiName;

	@Column
	private String value;
	//

	//
	//Properties
	//
	public String getApiName() {
		return apiName;
	}

	public String getValue() {
		return value;
	}
	//
}
