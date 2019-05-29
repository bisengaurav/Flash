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

	@Query("SELECT c.maintenanceActivityTypeCode__c FROM Case c" +
		" WHERE c.maintenanceActivityTypeCode__c IS NOT NULL" +
		" AND c.recordTypeId = '012w0000000V9MrAAK'" +
		" AND c.status NOT IN ('Cancelled', 'Completed')" +
		" GROUP BY c.maintenanceActivityTypeCode__c" +
		" ORDER BY c.maintenanceActivityTypeCode__c")
	List<String> getUniqueMaintenanceActivityTypeCodes();

	@Query("SELECT c.assembly__c FROM Case c" +
		" WHERE c.assembly__c IS NOT NULL" +
		" AND c.recordTypeId = '012w0000000V9MrAAK'" +
		" AND c.status NOT IN ('Cancelled', 'Completed')" +
		" GROUP BY c.assembly__c" +
		" ORDER BY c.assembly__c")
	List<String> getUniqueAssemblies();
}
