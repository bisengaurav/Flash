package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.Callout;
import com.kone.cplan.jpa.repository.custom.Callout_RepoExt;
import com.kone.cplan.jpa.repository.custom.IRepoForSalesOrg;
import com.kone.cplan.jpa.utils.CaseUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CalloutRepository extends JpaRepository<Callout, String>, Callout_RepoExt, IRepoForSalesOrg {

	@Query("SELECT c.salesOrganizations__c FROM Callout c" +
		" WHERE c.salesOrganizations__c IS NOT NULL" +
		" AND c.recordTypeId = '" + CaseUtils.FIELD_SERVICE_RECORD_TYPE_ID + "'" +
		" GROUP BY c.salesOrganizations__c" +
		" ORDER BY c.salesOrganizations__c")
	List<String> getUniqueSalesOrganizations();

	@Query("SELECT c.maintenanceActivityTypeCode__c FROM Callout c" +
		" WHERE c.maintenanceActivityTypeCode__c IS NOT NULL" +
		" AND c.recordTypeId = '" + CaseUtils.FIELD_SERVICE_RECORD_TYPE_ID + "'" +
		" GROUP BY c.maintenanceActivityTypeCode__c" +
		" ORDER BY c.maintenanceActivityTypeCode__c")
	List<String> getUniqueMaintenanceActivityTypeCodes();

	@Query("SELECT c.assembly__c FROM Callout c" +
		" WHERE c.assembly__c IS NOT NULL" +
		" AND c.recordTypeId = '" + CaseUtils.FIELD_SERVICE_RECORD_TYPE_ID + "'" +
		" GROUP BY c.assembly__c" +
		" ORDER BY c.assembly__c")
	List<String> getUniqueAssemblies();

	@Query("SELECT c.status FROM Callout c" +
		" WHERE c.status IS NOT NULL" +
		" AND c.recordTypeId = '" + CaseUtils.FIELD_SERVICE_RECORD_TYPE_ID + "'" +
		" GROUP BY c.status" +
		" ORDER BY c.status")
	List<String> getUniqueStatuses();
}
