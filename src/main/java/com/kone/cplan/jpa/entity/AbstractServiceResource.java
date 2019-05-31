package com.kone.cplan.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@MappedSuperclass
abstract class AbstractServiceResource implements Serializable {

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column(unique = true)
	private String sfid;

	@Column
	private String name;

	@Column
	private String phone__c;

	@Column
	private String salesOrganization__c;
	//

	//
	//Properties
	//
	public Integer getId() {
		return id;
	}

	public String getSfid() {
		return sfid;
	}

	public String getName() {
		return name;
	}

	public String getPhone__c() {
		return phone__c;
	}

	public String getSalesOrganization__c() {
		return salesOrganization__c;
	}
	//
}
