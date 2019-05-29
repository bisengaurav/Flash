package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity.Case;
import com.kone.cplan.jpa.filter.CaseFilter;
import com.kone.cplan.jpa.utils.JpaQueryBuilder;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

		//STEP #1: initialize and configure a JPA query builder
		JpaQueryBuilder<Case> queryBuilder =
			new JpaQueryBuilder<>(entityManager, Case.class);
		queryBuilder.addCondition_FieldContains("caseNumber",
			filter.getCaseNumber(), false);
		queryBuilder.addSimpleConditionIfNotNull("createdDate", ">=",
			filter.getCreatedDate());
		queryBuilder.addSimpleConditionIfNotNull("npxResponseDueDate__c", ">=",
			filter.getNpxResponseDueDate__c());
		queryBuilder.addSimpleConditionIfNotNull("entrapment__c", "=", filter.getEntrapment__c());
		queryBuilder.addSimpleConditionIfNotNull("hazard__c", "=", filter.getHazard__c());
		queryBuilder.addSimpleConditionIfNotNull("injury__c", "=", filter.getInjury__c());
		queryBuilder.addCondition_FieldContains("assetName",
			filter.getAssetName(), false);
		queryBuilder.addCondition_FieldContains("locationName",
			filter.getLocationName(), false);
		queryBuilder.addCondition_FieldContains("street__c",
			filter.getStreet__c(), false);
		queryBuilder.addCondition_FieldContains("city__c",
			filter.getCity__c(), false);
		queryBuilder.addCondition_FieldContains("stateProvince__c",
			filter.getStateProvince__c(), false);
		queryBuilder.addCondition_FieldContains("contactName",
			filter.getContactName(), false);
		queryBuilder.addCondition_FieldContains("callerName__c",
			filter.getCallerName__c(), false);
		queryBuilder.addCondition_FieldContains("workOrderNumber",
			filter.getWorkOrderNumber(), false);
		queryBuilder.addCondition_FieldContains("assembly__c",
			filter.getAssembly__c(), false);
		queryBuilder.addCondition_FieldContains("appointmentNumber",
			filter.getAppointmentNumber(), false);
		queryBuilder.addSimpleConditionIfNotNull("serviceAppointmentStatus", "=",
			filter.getServiceAppointmentStatus(), false);
		queryBuilder.addCondition_FieldContains("serviceResourceName",
			filter.getServiceResourceName(), false);
		queryBuilder.addCondition_FieldContains("serviceTerritoryName",
			filter.getServiceTerritoryName(), false);
		queryBuilder.addCondition_FieldContains("caseOwnerTxt__c",
			filter.getCaseOwnerTxt__c(), false);
		queryBuilder.addCondition_FieldContains("salesOrganization__c",
			filter.getSalesOrganization__c(), false);


		// TODO: change created date to yesterday or today
		queryBuilder.addSimpleCondition("createdDate", ">=", new Timestamp(1546290000000L));

		queryBuilder.addSimpleCondition("recordTypeId", "=", "012w0000000V9MrAAK");
		queryBuilder.addSimpleCondition("status", "NOT IN", Arrays.asList("Cancelled", "Completed"));

		queryBuilder.setPageRequest(pageRequest);

		//STEP #2: return records for the requested page
		return queryBuilder.buildForRecords().getResultList();
	}
	//
}
