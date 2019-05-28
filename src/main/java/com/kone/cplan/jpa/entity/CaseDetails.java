package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 28-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_case")
public class CaseDetails extends AbstractCase {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public CaseDetails() {};
	//

	//
	//Variables
	//
	@Column(name = "caseownertxt__c")
	private String caseOwnerTxt__c;

	@Column
	private Integer accountId;

	@Column
	private String accountName;

	@Column(name = "contactphone")
	private String contactPhone;

	@Column
	private String callerPhoneNumber__c;

	@Column
	private Boolean fsmContactIsPassenger__c;

	@Column
	private String description;

//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name = "caseid", referencedColumnName = "sfid")
//	private Set<WorkOrder> workOrders;
	//

	//
	//Properties
	//
	public String getCaseOwnerTxt__c() {
		return caseOwnerTxt__c;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public String getCallerPhoneNumber__c() {
		return callerPhoneNumber__c;
	}

	public Boolean getFsmContactIsPassenger__c() {
		return fsmContactIsPassenger__c;
	}

	public String getDescription() {
		return description;
	}

//	public Set<WorkOrder> getWorkOrders() {
//		return workOrders;
//	}
	//
}
