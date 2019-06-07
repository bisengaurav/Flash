package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity.Equipment;
import com.kone.cplan.jpa.filter.EquipmentFilter;
import com.kone.cplan.jpa.utils.JpaUtils;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Equipment_RepoExtImpl implements Equipment_RepoExt {

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
	public List<Equipment> findByFilter(EquipmentFilter filter, Pageable pageRequest) {

		if (filter == null) {
			return (new ArrayList<>());
		}

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Equipment> query = cb.createQuery(Equipment.class);
		Root<Equipment> root = query.from(Equipment.class);

		List<Predicate> predicates = new ArrayList<>();

		if (filter.getInstallationCountry__c() != null) {
			predicates.add(cb.equal(root.get("installationCountry__c"), filter.getInstallationCountry__c()));
		}
		if (filter.getEquipmentType__c() != null) {
			predicates.add(cb.equal(root.get("equipmentType__c"), filter.getEquipmentType__c()));
		}
		if (filter.getCustomerAssetName__c() != null) {
			predicates.add(cb.like(cb.lower(root.get("customerAssetName__c")),
				JpaUtils.buildContainsPattern(filter.getCustomerAssetName__c(), false)));
		}
		if (filter.getEquipmentPhoneNumber__c() != null) {
			predicates.add(cb.like(cb.lower(root.get("equipmentPhoneNumber__c")),
				JpaUtils.buildContainsPattern(filter.getEquipmentPhoneNumber__c(), false)));
		}
		if (filter.getAccountName() != null) {
			predicates.add(cb.like(cb.lower(root.get("accountName")),
				JpaUtils.buildContainsPattern(filter.getAccountName(), false)));
		}
		if (filter.getSoldToName() != null) {
			predicates.add(cb.like(cb.lower(root.get("soldToName")),
				JpaUtils.buildContainsPattern(filter.getSoldToName(), false)));
		}
		if (filter.getLocationName() != null) {
			predicates.add(cb.like(cb.lower(root.get("locationName")),
				JpaUtils.buildContainsPattern(filter.getLocationName(), false)));
		}
		if (filter.getInstallationStreet__c() != null) {
			predicates.add(cb.like(cb.lower(root.get("installationStreet__c")),
				JpaUtils.buildContainsPattern(filter.getInstallationStreet__c(), false)));
		}
		if (filter.getInstallationCity__c() != null) {
			predicates.add(cb.like(cb.lower(root.get("installationCity__c")),
				JpaUtils.buildContainsPattern(filter.getInstallationCity__c(), false)));
		}
		if (filter.getInstallationStateProvince__c() != null) {
			predicates.add(cb.like(cb.lower(root.get("installationStateProvince__c")),
				JpaUtils.buildContainsPattern(filter.getInstallationStateProvince__c(), false)));
		}
		if (filter.getFsmLastValidCliEndDate__c() != null) {
			predicates.add(cb.greaterThanOrEqualTo(root.get("fsmLastValidCliEndDate__c"), new Date(System.currentTimeMillis())));
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

		query.select(root).where(predicates.toArray(new Predicate[]{}));

		TypedQuery<Equipment> typedQuery = entityManager.createQuery(query);
		typedQuery.setMaxResults(pageRequest.getPageSize());

		return typedQuery.getResultList();
	}
	//
}
