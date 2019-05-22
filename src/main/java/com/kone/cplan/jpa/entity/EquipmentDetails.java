package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 22-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_equipment")
public class EquipmentDetails extends AbstractEquipment {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public EquipmentDetails() {};
	//

	//
	//Variables
	//
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "assetid", referencedColumnName = "sfid")
	@Where(clause = "status = 'Active'")
	private Set<SLA> activeSLAs;
	//

	//
	//Properties
	//
	public Set<SLA> getActiveSLAs() {
		return activeSLAs;
	}
	//
}
