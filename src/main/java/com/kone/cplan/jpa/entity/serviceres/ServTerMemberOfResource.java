package com.kone.cplan.jpa.entity.serviceres;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kone.cplan.utils.db.DbSchema;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_serviceterritorymember_of_resource")
public class ServTerMemberOfResource implements Serializable {

	//
	//Constants
	//
	private static final long serialVersionUID = 7399121655760152785L;
	//

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public ServTerMemberOfResource() {};
	//

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column
	private String name;

	@Column(name = "territorytype")
	private String territoryType;

	@Column
	private String shiftType__c;

	@Column(name = "effectivestartdate")
	private Timestamp effectiveStartDate;

	@Column(name = "effectiveenddate")
	private Timestamp effectiveEndDate;
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

	public String getTerritoryType() {
		return territoryType;
	}

	public String getShiftType__c() {
		return shiftType__c;
	}

	public Timestamp getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public Timestamp getEffectiveEndDate() {
		return effectiveEndDate;
	}
	//
}
