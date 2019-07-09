package com.kone.cplan.jpa.entity.serviceres;

import com.kone.cplan.jpa.utils.IEntityWithSalesOrg;

import javax.persistence.*;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@MappedSuperclass
public abstract class AbstractServiceResource implements IEntityWithSalesOrg {

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

	@Column(name = "isactive")
	private Boolean isActive;

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

	public Boolean getActive() {
		return isActive;
	}

	@Override
	public String getSalesOrganization__c() {
		return salesOrganization__c;
	}
	//
}
