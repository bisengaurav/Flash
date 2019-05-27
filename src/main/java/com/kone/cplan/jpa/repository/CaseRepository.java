package com.kone.cplan.jpa.repository;

import com.kone.cplan.helpers.db.DbSchema;
import com.kone.cplan.jpa.entity.Case;
import com.kone.cplan.jpa.repository.custom.Case_RepoExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CaseRepository extends JpaRepository<Case, Integer>, Case_RepoExt {

	@Query(nativeQuery = true, value = "SELECT sales_organization__c FROM " + DbSchema.C_PLAN + ".case " +
		"WHERE sales_organization__c IS NOT NULL GROUP BY sales_organization__c ORDER BY sales_organization__c")
	List<String> getUniqueSalesOrganizations();

	@Query(nativeQuery = true, value = "SELECT status FROM " + DbSchema.C_PLAN + ".serviceappointment" +
		" WHERE status IS NOT NULL GROUP BY status ORDER BY status")
	List<String> getUniqueStatuses();
}
