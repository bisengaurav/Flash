package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "resourceabsence")
public class ResourceAbsence {

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column
	private Timestamp start;

	@Column
	private Timestamp end;

	@Column
	private String recordType__c;

	@Column
	private String type;
	//

	//
	//Properties
	//
	public Integer getId() {
		return id;
	}

	public Timestamp getStart() {
		return start;
	}

	public Timestamp getEnd() {
		return end;
	}

	public String getRecordType__c() {
		return recordType__c;
	}

	public String getType() {
		return type;
	}
	//
}
