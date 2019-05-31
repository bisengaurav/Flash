package com.kone.cplan.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kone.cplan.helpers.datatype.DatetimeUtils;
import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_service_resource_territory")
public class ServiceResourceTerritory {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public ServiceResourceTerritory() {};
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Timestamp effectiveStartDate;

	@Column(name = "effectiveenddate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
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