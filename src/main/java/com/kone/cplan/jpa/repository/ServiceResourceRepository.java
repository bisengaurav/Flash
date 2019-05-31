package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.ServiceResource;
import com.kone.cplan.jpa.repository.custom.ServiceResource_RepoExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceResourceRepository extends JpaRepository<ServiceResource, Integer>,
	ServiceResource_RepoExt {

	@Query("SELECT s.salesOrganization__c" +
		" FROM ServiceResource s" +
		" WHERE s.salesOrganization__c IS NOT NULL" +
		" GROUP BY s.salesOrganization__c" +
		" ORDER BY s.salesOrganization__c")
	List<String> getUniqueSalesOrganizations();
}