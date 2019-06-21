package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.ServiceResource;
import com.kone.cplan.jpa.repository.custom.IRepoForSalesOrg;
import com.kone.cplan.jpa.repository.custom.ServiceResource_RepoExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * This repository works with the {@link ServiceResource} entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface ServiceResourceRepository extends JpaRepository<ServiceResource, Integer>,
	ServiceResource_RepoExt, IRepoForSalesOrg
{
	@Query("SELECT s.salesOrganization__c FROM ServiceResource s" +
		" WHERE s.salesOrganization__c IS NOT NULL" +
		" GROUP BY s.salesOrganization__c" +
		" ORDER BY s.salesOrganization__c")
	List<String> getUniqueSalesOrgs();
}