package com.kone.cplan.jpa.entity.serviceres;

import com.kone.cplan.jpa.entity.serviceappt.ServiceAppointmentOfResource;
import com.kone.cplan.utils.datatype.DatetimeUtils;
import com.kone.cplan.utils.db.DbSchema;

import org.hibernate.Session;
import org.hibernate.annotations.*;
import org.hibernate.annotations.OrderBy;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 30-05-2019
 */
@Entity
@Table(schema = DbSchema.C_PLAN, name = "view_serviceresource")
@FilterDef(name = "serviceResourceDetailsFilter", parameters = {
	@ParamDef(name = "currentTimeParam", type = "timestamp"),
	@ParamDef(name = "currentTimePlusTwoWeeksParam", type = "timestamp"),
	@ParamDef(name = "breakRecordTypeParam", type = "string"),
	@ParamDef(name = "todayParam", type = "timestamp")
})
public class ServiceResourceDetails extends AbstractServiceResource implements Serializable {

	//
	//Constants
	//
	private static final long serialVersionUID = -8718884358520808704L;
	//

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public ServiceResourceDetails() {};
	//

	//
	//Variables
	//
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "serviceresourceid", referencedColumnName = "sfid")
	@Filter(name = "serviceResourceDetailsFilter", condition = "(effectiveenddate >= :currentTimeParam" +
		" AND effectiveenddate < :currentTimePlusTwoWeeksParam)" +
		" OR (effectivestartdate < :currentTimeParam AND effectiveenddate IS NULL)")
	@OrderBy(clause = "name, effectivestartdate")
	private Set<ServTerMemberOfResource> serviceResourceTerritories;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_resource__c", referencedColumnName = "sfid")
	@OrderBy(clause = "name")
	private Set<WcAssignmentOfResource> wcAssignmentsOfResource;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "resourceid", referencedColumnName = "sfid")
	@Filter(name = "serviceResourceDetailsFilter", condition = "recordtypeid != :breakRecordTypeParam" +
		" AND (\"end\" >= :currentTimeParam OR \"end\" IS NULL)")
	@OrderBy(clause = "start")
	private Set<ResourceAbsence> resourceAbsences;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "assigned_service_resource__c", referencedColumnName = "sfid")
	@Filter(name = "serviceResourceDetailsFilter", condition = "schedstarttime >= :todayParam")
	@OrderBy(clause = "schedstarttime")
	private Set<ServiceAppointmentOfResource> serviceAppointmentsOfResource;
	//

	//
	//Properties
	//
	public Set<ServTerMemberOfResource> getServiceResourceTerritories() {
		return serviceResourceTerritories;
	}

	public Set<WcAssignmentOfResource> getWcAssignmentsOfResource() {
		return wcAssignmentsOfResource;
	}

	public Set<ResourceAbsence> getResourceAbsences() {
		return resourceAbsences;
	}

	public Set<ServiceAppointmentOfResource> getServiceAppointmentsOfResource() {
		return serviceAppointmentsOfResource;
	}
	//

	//
	//Public methods
	//
	public static void configureFilter(EntityManager entityManager) {

		//- enable filter and set parameters
		Session session = entityManager.unwrap(Session.class);
		org.hibernate.Filter filter = session.enableFilter("serviceResourceDetailsFilter");

		Calendar currentUserCalendar = DatetimeUtils.getCalendarForCU();
		filter.setParameter("currentTimeParam", new Timestamp(currentUserCalendar.getTimeInMillis()));
		filter.setParameter("currentTimePlusTwoWeeksParam",
			new Timestamp(currentUserCalendar.getTimeInMillis()	+ TimeUnit.DAYS.toMillis(14)));
		filter.setParameter("breakRecordTypeParam", ResourceAbsence.RECORD_TYPE_ID_BREAK);
		DatetimeUtils.resetTimePart(currentUserCalendar);
		filter.setParameter("todayParam", new Timestamp(currentUserCalendar.getTimeInMillis()));
	}
	//
}
