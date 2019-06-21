package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_serviceterritorymember_of_territory")
public class ServTerMemberOfTerritory implements Serializable {

	//
	//Constants
	//
	private static final long serialVersionUID = -2413668242256677175L;
	//

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public ServTerMemberOfTerritory() {};
	//

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column(name = "effectivestartdate")
	private Timestamp effectiveStartDate;

	@Column(name = "effectiveenddate")
	private Timestamp effectiveEndDate;

	@Column
	private Integer serviceResource_id;

	@Column
	private String serviceResource_name;

	@Column
	private String phone__c;

	@Column(name = "isactive")
	private Boolean isActive;
	//

	//
	//Properties
	//
	public Integer getId() {
		return id;
	}

	public Timestamp getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public Timestamp getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public Integer getServiceResource_id() {
		return serviceResource_id;
	}

	public String getServiceResource_name() {
		return serviceResource_name;
	}

	public String getPhone__c() {
		return phone__c;
	}

	public Boolean getActive() {
		return isActive;
	}
	//
}
