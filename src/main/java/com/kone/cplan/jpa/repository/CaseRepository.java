package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.Case;
import com.kone.cplan.jpa.repository.custom.Case_RepoExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CaseRepository extends JpaRepository<Case, Case.CaseCompositeKey>, Case_RepoExt {

	@Query("SELECT c.salesOrganizations__c FROM Case c" +
		" WHERE c.salesOrganizations__c IS NOT NULL" +
		" AND c.recordTypeId = '012w0000000V9MrAAK'" +
		" AND c.status NOT IN ('Cancelled', 'Completed')" +
		" GROUP BY c.salesOrganizations__c" +
		" ORDER BY c.salesOrganizations__c")
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
