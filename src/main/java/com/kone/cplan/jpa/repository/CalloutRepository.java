package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.Callout;
import com.kone.cplan.jpa.repository.custom.Callout_RepoExt;
import com.kone.cplan.jpa.repository.custom.IRepoForSalesOrg;
import com.kone.cplan.jpa.utils.CaseUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * This repository works with the Callout entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
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

	@Query("SELECT c.maintenanceActivityTypeCode__c FROM Callout c" +
		" WHERE c.maintenanceActivityTypeCode__c IS NOT NULL" +
		" AND c.recordTypeId = '" + CaseUtils.FIELD_SERVICE_RECORD_TYPE_ID + "'" +
		" AND (c.salesOrganizations__c LIKE :salesOrg" +
		" OR c.salesOrganizations__c LIKE CONCAT(:salesOrg, ',%')" +
		" OR c.salesOrganizations__c LIKE CONCAT('%,', :salesOrg, ',%')" +
		" OR c.salesOrganizations__c LIKE CONCAT('%,', :salesOrg))" +
		" GROUP BY c.maintenanceActivityTypeCode__c" +
		" ORDER BY c.maintenanceActivityTypeCode__c")
	List<String> getUniqueMaintenanceActivityTypeCodesBySalesOrg(String salesOrg);

	@Query("SELECT c.assembly__c FROM Callout c" +
		" WHERE c.assembly__c IS NOT NULL" +
		" AND c.recordTypeId = '" + CaseUtils.FIELD_SERVICE_RECORD_TYPE_ID + "'" +
		" GROUP BY c.assembly__c" +
		" ORDER BY c.assembly__c")
	List<String> getUniqueAssemblies();

	@Query("SELECT c.assembly__c FROM Callout c" +
		" WHERE c.assembly__c IS NOT NULL" +
		" AND c.recordTypeId = '" + CaseUtils.FIELD_SERVICE_RECORD_TYPE_ID + "'" +
		" AND (c.salesOrganizations__c LIKE :salesOrg" +
		" OR c.salesOrganizations__c LIKE CONCAT(:salesOrg, ',%')" +
		" OR c.salesOrganizations__c LIKE CONCAT('%,', :salesOrg, ',%')" +
		" OR c.salesOrganizations__c LIKE CONCAT('%,', :salesOrg))" +
		" GROUP BY c.assembly__c" +
		" ORDER BY c.assembly__c")
	List<String> getUniqueAssembliesBySalesOrg(String salesOrg);

	@Query("SELECT c.status FROM Callout c" +
		" WHERE c.status IS NOT NULL" +
		" AND c.recordTypeId = '" + CaseUtils.FIELD_SERVICE_RECORD_TYPE_ID + "'" +
		" GROUP BY c.status" +
		" ORDER BY c.status")
	List<String> getUniqueStatuses();

	@Query("SELECT c.status FROM Callout c" +
		" WHERE c.status IS NOT NULL" +
		" AND c.recordTypeId = '" + CaseUtils.FIELD_SERVICE_RECORD_TYPE_ID + "'" +
		" AND (c.salesOrganizations__c LIKE :salesOrg" +
		" OR c.salesOrganizations__c LIKE CONCAT(:salesOrg, ',%')" +
		" OR c.salesOrganizations__c LIKE CONCAT('%,', :salesOrg, ',%')" +
		" OR c.salesOrganizations__c LIKE CONCAT('%,', :salesOrg))" +
		" GROUP BY c.status" +
		" ORDER BY c.status")
	List<String> getUniqueStatusesBySalesOrg(String salesOrg);

	@Query("SELECT c.serviceAppointmentStatus FROM Callout c" +
		" WHERE c.serviceAppointmentStatus IS NOT NULL" +
		" AND c.recordTypeId = '" + CaseUtils.FIELD_SERVICE_RECORD_TYPE_ID + "'" +
		" GROUP BY c.serviceAppointmentStatus" +
		" ORDER BY c.serviceAppointmentStatus")
	List<String> getUniqueSAStatuses();

	@Query("SELECT c.serviceAppointmentStatus FROM Callout c" +
		" WHERE c.serviceAppointmentStatus IS NOT NULL" +
		" AND c.recordTypeId = '" + CaseUtils.FIELD_SERVICE_RECORD_TYPE_ID + "'" +
		" AND (c.salesOrganizations__c LIKE :salesOrg" +
		" OR c.salesOrganizations__c LIKE CONCAT(:salesOrg, ',%')" +
		" OR c.salesOrganizations__c LIKE CONCAT('%,', :salesOrg, ',%')" +
		" OR c.salesOrganizations__c LIKE CONCAT('%,', :salesOrg))" +
		" GROUP BY c.serviceAppointmentStatus" +
		" ORDER BY c.serviceAppointmentStatus")
	List<String> getUniqueSAStatusesBySalesOrg(String salesOrg);
}
