package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity.Case;
import com.kone.cplan.jpa.filter.CaseFilter;
import com.kone.cplan.jpa.utils.JpaUtils;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Case_RepoExtImpl implements Case_RepoExt {

	//
	//Variables
	//
	@PersistenceContext
	private EntityManager entityManager;
	//

	//
	//Public methods
	//
	@Override
	public List<Case> findByFilter(CaseFilter filter, Pageable pageRequest) {

		if (filter == null) {
			return (new ArrayList<>());
		}

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Case> query = cb.createQuery(Case.class);
		Root<Case> root = query.from(Case.class);

		List<Predicate> predicates = new ArrayList<>();

		if (filter.getCaseNumber() != null) {
			predicates.add(cb.like(cb.lower(root.get("caseNumber")),
				JpaUtils.buildContainsPattern(filter.getCaseNumber(), false)));
		}
		if (filter.getCreatedDate() != null) {
			predicates.add(cb.greaterThanOrEqualTo(root.get("createdDate"), filter.getCreatedDate()));
		}
		if (filter.getEntrapment__c() != null) {
			predicates.add(cb.equal(root.get("entrapment__c"), filter.getEntrapment__c()));
		}
		if (filter.getHazard__c() != null) {
			predicates.add(cb.equal(root.get("hazard__c"), filter.getHazard__c()));
		}
		if (filter.getInjury__c() != null) {
			predicates.add(cb.equal(root.get("injury__c"), filter.getInjury__c()));
		}
		if (filter.getAssetName() != null) {
			predicates.add(cb.like(cb.lower(root.get("assetName")),
				JpaUtils.buildContainsPattern(filter.getAssetName(), false)));
		}
		if (filter.getLocationName() != null) {
			predicates.add(cb.like(cb.lower(root.get("locationName")),
				JpaUtils.buildContainsPattern(filter.getLocationName(), false)));
		}
		if (filter.getStreet__c() != null) {
			predicates.add(cb.like(cb.lower(root.get("street__c")),
				JpaUtils.buildContainsPattern(filter.getStreet__c(), false)));
		}
		if (filter.getCity__c() != null) {
			predicates.add(cb.like(cb.lower(root.get("city__c")),
				JpaUtils.buildContainsPattern(filter.getCity__c(), false)));
		}
		if (filter.getStateProvince__c() != null) {
			predicates.add(cb.like(cb.lower(root.get("stateProvince__c")),
				JpaUtils.buildContainsPattern(filter.getStateProvince__c(), false)));
		}
		if (filter.getContactName() != null) {
			predicates.add(cb.like(cb.lower(root.get("contactName")),
				JpaUtils.buildContainsPattern(filter.getContactName(), false)));
		}
		if (filter.getCallerName__c() != null) {
			predicates.add(cb.like(cb.lower(root.get("callerName__c")),
				JpaUtils.buildContainsPattern(filter.getCallerName__c(), false)));
		}
		if (filter.getWorkOrderNumber() != null) {
			predicates.add(cb.like(cb.lower(root.get("workOrderNumber")),
				JpaUtils.buildContainsPattern(filter.getWorkOrderNumber(), false)));
		}
		if (filter.getDueDate__c() != null) {
			predicates.add(cb.greaterThanOrEqualTo(root.get("dueDate__c"), filter.getDueDate__c()));
		}
		if (filter.getMaintenanceActivityTypeCode__c() != null) {
			predicates.add(cb.equal(root.get("maintenanceActivityTypeCode__c"),
				filter.getMaintenanceActivityTypeCode__c()));
		}
		if (filter.getAssembly__c() != null) {
			predicates.add(cb.equal(root.get("assembly__c"), filter.getAssembly__c()));
		}
		if (filter.getAppointmentNumber() != null) {
			predicates.add(cb.like(cb.lower(root.get("appointmentNumber")),
				JpaUtils.buildContainsPattern(filter.getAppointmentNumber(), false)));
		}
		if (filter.getServiceAppointmentStatus() != null) {
			predicates.add(cb.equal(root.get("serviceAppointmentStatus"), filter.getServiceAppointmentStatus()));
		}
		if (filter.getServiceResourceName() != null) {
			predicates.add(cb.like(cb.lower(root.get("serviceResourceName")),
				JpaUtils.buildContainsPattern(filter.getServiceResourceName(), false)));
		}
		if (filter.getServiceTerritoryName() != null) {
			predicates.add(cb.like(cb.lower(root.get("serviceTerritoryName")),
				JpaUtils.buildContainsPattern(filter.getServiceTerritoryName(), false)));
		}
		if (filter.getCaseOwnerTxt__c() != null) {
			predicates.add(cb.like(cb.lower(root.get("caseOwnerTxt__c")),
				JpaUtils.buildContainsPattern(filter.getCaseOwnerTxt__c(), false)));
		}

		if (filter.getSalesOrganization__c() != null) {
			predicates.add(cb.or(
				cb.like(root.get("salesOrganizations__c"), filter.getSalesOrganization__c()),
				cb.like(root.get("salesOrganizations__c"), JpaUtils.buildStartsWithPattern(
					filter.getSalesOrganization__c() + ",", true)),
				cb.like(root.get("salesOrganizations__c"), JpaUtils.buildContainsPattern(
					"," + filter.getSalesOrganization__c() + ",", true)),
				cb.like(root.get("salesOrganizations__c"), JpaUtils.buildEndsWithPattern(
					"," + filter.getSalesOrganization__c(), true))));
		}

		// TODO: change created date to yesterday or today
		predicates.add(cb.greaterThanOrEqualTo(root.get("createdDate"), new Timestamp(1546290000000L)));
		predicates.add(cb.equal(root.get("recordTypeId"), "012w0000000V9MrAAK"));
		predicates.add(root.get("status").in(Arrays.asList("Cancelled", "Completed")).not());

		query.select(root).where(predicates.toArray(new Predicate[]{}));
		query.orderBy(cb.desc(root.get("createdDate")));

		TypedQuery<Case> typedQuery = entityManager.createQuery(query);
		typedQuery.setMaxResults(pageRequest.getPageSize());

		return typedQuery.getResultList();
	}
	//
}
