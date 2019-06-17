package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name= "view_work_center__c")
public class WorkCenter implements Serializable {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public WorkCenter() {};
	//

	//
	//Variables
	//
	@Id
	private Integer id;

	@Column(unique = true)
	private String sfid;

	@Column
	private String name;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "work_center__c", referencedColumnName = "sfid")
	@Where(clause = "end_date__c > CURRENT_DATE OR end_date__c IS NULL")
	private Set<WorkCenterResource> workCenterResources;
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

	public Set<WorkCenterResource> getWorkCenterResources() {
		return workCenterResources;
	}
	//
}
