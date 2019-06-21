package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;
import com.kone.cplan.utils.datatype.DatetimeUtils;
import org.hibernate.Session;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Set;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name= "view_work_center__c")
@FilterDef(name = "workCenterFilter", parameters = {
	@ParamDef(name = "currentTimeParam", type = "timestamp")
})
public class WorkCenter implements Serializable {

	//
	//Constants
	//
	private static final long serialVersionUID = -7210909766304672118L;
	//

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
	@Filter(name = "workCenterFilter",
		condition = "(end_date__c >= :currentTimeParam OR end_date__c IS NULL)")
	private Set<WcAssignmentOfWorkCenter> wcAssignmentsOfWorkCenter;
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

	public Set<WcAssignmentOfWorkCenter> getWcAssignmentsOfWorkCenter() {
		return wcAssignmentsOfWorkCenter;
	}
//

	//
	//Public methods
	//
	public static void configureFilter(EntityManager entityManager) {

		//- enable filter and set parameters
		Session session = entityManager.unwrap(Session.class);
		org.hibernate.Filter filter = session.enableFilter("workCenterFilter");

		Calendar currentUserCalendar = DatetimeUtils.getCalendarForCU();
		filter.setParameter("currentTimeParam", new Timestamp(currentUserCalendar.getTimeInMillis()));
	}
	//
}
