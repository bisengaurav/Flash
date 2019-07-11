package com.kone.cplan.jpa.entity.serviceterritory;

import com.kone.cplan.jpa.utils.IEntityWithSalesOrg;
import com.kone.cplan.utils.db.DbSchema;

import org.hibernate.annotations.Where;
import org.hibernate.annotations.OrderBy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_serviceterritory")
public class ServiceTerritory implements Serializable, IEntityWithSalesOrg {

	//
	//Constants
	//
	private static final long serialVersionUID = 7253906716565877661L;
	//

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public ServiceTerritory() {};
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

	@Column
	private String salesOrganization__c;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "serviceterritoryid", referencedColumnName = "sfid")
	@Where(clause = "isactive = true")
	@OrderBy(clause = "service_resource_name")
	private Set<ServTerMemberOfTerritory> activeServTerMembersOfTerritory;
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

	public String getSalesOrganization__c() {
		return salesOrganization__c;
	}

	public Set<ServTerMemberOfTerritory> getActiveServTerMembersOfTerritory() {
		return activeServTerMembersOfTerritory;
	}
//
}
