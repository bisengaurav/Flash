package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity.Equipment;
import com.kone.cplan.jpa.filter.EquipmentFilter;
import com.kone.cplan.jpa.utils.JpaQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	public Page<Equipment> findByFilter(EquipmentFilter filter, Pageable pageRequest,
		boolean getRecordsCount) {

		if (filter == null) {
			return (new PageImpl<>(new ArrayList<>(), pageRequest, 0));
		}

		//STEP #1: initialize and configure a JPA query builder
		JpaQueryBuilder<Equipment> queryBuilder =
			new JpaQueryBuilder<>(entityManager, Equipment.class);
		queryBuilder.addSimpleConditionIfNotNull("installationCountry__c", "=",
			filter.getInstallationCountry__c());
		queryBuilder.addSimpleConditionIfNotNull("equipmentType__c", "=",
			filter.getEquipmentType__c());
		queryBuilder.addCondition_FieldContains("customerAssetName__c",
			filter.getCustomerAssetName__c(), false);
		queryBuilder.addCondition_FieldContains("equipmentPhoneNumber__c",
			filter.getEquipmentPhoneNumber__c(), false);
		queryBuilder.addCondition_FieldContains("accountName",
			filter.getAccountName(), false);
		queryBuilder.addCondition_FieldContains("soldToName",
			filter.getSoldToName(), false);
		queryBuilder.addCondition_FieldContains("locationName",
			filter.getLocationName(), false);
		queryBuilder.addCondition_FieldContains("installationStreet__c",
			filter.getInstallationStreet__c(), false);
		queryBuilder.addCondition_FieldContains("installationCity__c",
			filter.getInstallationCity__c(), false);
		queryBuilder.addCondition_FieldContains("installationStateProvice__c",
			filter.getInstallationStateProvice__c(), false);

		queryBuilder.addSimpleConditionIfNotNull("fsmLastValidCliEndDate__c",
			(filter.getFsmLastValidCliEndDate__c()) ? ">=" : "<", new Date(System.currentTimeMillis()));

		queryBuilder.setPageRequest(pageRequest);

		//STEP #2: get records for the requested page
		List<Equipment> records = queryBuilder.buildForRecords().getResultList();

		//STEP #3: get total count of records if needed
		Long totalRecordsCount = (getRecordsCount) ? queryBuilder.buildForCount().getSingleResult() : 0L;

		//STEP #4: pack the results in the PageImpl object and return it
		return new PageImpl<>(records, pageRequest, totalRecordsCount);
	}
	//
}
