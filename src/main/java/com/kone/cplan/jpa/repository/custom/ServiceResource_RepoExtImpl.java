package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity.ServiceResource;
import com.kone.cplan.jpa.filter.ServiceResourceFilter;
import com.kone.cplan.jpa.utils.JpaQueryBuilder;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


public class ServiceResource_RepoExtImpl implements ServiceResource_RepoExt {

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
	public List<ServiceResource> findByFilter(ServiceResourceFilter filter, Pageable pageRequest) {

		if (filter == null) {
			return (new ArrayList<>());
		}

		//STEP #1: initialize and configure a JPA query builder
		JpaQueryBuilder<ServiceResource> queryBuilder =
			new JpaQueryBuilder<>(entityManager, ServiceResource.class);
		queryBuilder.addCondition_FieldContains("name",
			filter.getName(), false);
		queryBuilder.addCondition_FieldContains("phone__c",
			filter.getPhone__c(), false);
		queryBuilder.addSimpleConditionIfNotNull("salesOrganization__c", "=",
			filter.getSalesOrganization__c());

		queryBuilder.setPageRequest(pageRequest);

		//STEP #2: return records for the requested page
		return queryBuilder.buildForRecords().getResultList();
	}
	//
}
