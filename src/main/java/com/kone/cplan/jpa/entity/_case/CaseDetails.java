package com.kone.cplan.jpa.entity._case;

import com.kone.cplan.helpers.db.DbSchema;
import com.kone.cplan.jpa.entity.workorder.WorkOrder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 28-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_case_details")
public class CaseDetails extends AbstractCase implements Serializable {

	//
	//Constants
	//
	private static final long serialVersionUID = -8070917679876045919L;
	//

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public CaseDetails() {};
	//

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column
	private String subject;

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

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "caseid", referencedColumnName = "sfid")
	private Set<WorkOrder> workOrders;
	//

	//
	//Properties
	//
	public Integer getId() {
		return id;
	}

	public String getSubject() {
		return subject;
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

	public Set<WorkOrder> getWorkOrders() {
		return workOrders;
	}
	//
}
