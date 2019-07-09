package com.kone.cplan.jpa.repository;

import com.kone.cplan.helpers.db.DbSchema;
import com.kone.cplan.jpa.entity.asset.Asset;
import com.kone.cplan.jpa.entity.asset.EquipmentType;
import com.kone.cplan.jpa.repository.custom.Asset_RepoExt;
import com.kone.cplan.jpa.repository.custom.IRepoForSalesOrg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * This repository works with the {@link Asset} entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface AssetRepository extends JpaRepository<Asset, Integer>, Asset_RepoExt,
	IRepoForSalesOrg {

//	@Query("SELECT a.salesOrganizations__c FROM Asset a" +
//		" WHERE a.salesOrganizations__c IS NOT NULL" +
//		" GROUP BY a.salesOrganizations__c" +
//		" ORDER BY a.salesOrganizations__c")

	//- The commented query from above is executed about 50 sec, while we have a 30 sec limitation
	// in Heroku environment for requests. So, we decided to use the native PostgreSQL query below
	// which is executed much faster.
	@Query(nativeQuery = true, value =
		"WITH RECURSIVE cte AS (" +
		"  (SELECT acc.sales_organizations__c FROM " + DbSchema.SALESFORCE + ".asset ass" +
		"  LEFT JOIN " + DbSchema.SALESFORCE + ".account acc ON ass.accountid = acc.sfid" +
		"  WHERE acc.sales_organizations__c IS NOT NULL" +
		"  ORDER BY sales_organizations__c LIMIT 1)" +
		"  UNION ALL" +
		"  SELECT ass.sales_organizations__c FROM cte, LATERAL (" +
		"    SELECT acc.sales_organizations__c FROM " + DbSchema.SALESFORCE + ".asset ass" +
		"    LEFT JOIN " + DbSchema.SALESFORCE + ".account acc ON ass.accountid = acc.sfid" +
		"    WHERE acc.sales_organizations__c IS NOT NULL" +
		"    AND sales_organizations__c > cte.sales_organizations__c" +
		"    ORDER BY sales_organizations__c LIMIT 1" +
		"  ) ass" +
		") TABLE cte")
	List<String> getUniqueSalesOrgs();


//	@Query("SELECT a.installationCountry__c FROM Asset a" +
//		" WHERE a.installationCountry__c IS NOT NULL" +
//		" GROUP BY a.installationCountry__c" +
//		" ORDER BY a.installationCountry__c")

	//- The commented query from above is executed about 50 sec, while we have a 30 sec limitation
	// in Heroku environment for requests. So, we decided to use the native PostgreSQL query below
	// which is executed much faster.
	@Query(nativeQuery = true, value =
		"WITH RECURSIVE cte AS (" +
		"  (SELECT installation_country__c FROM " + DbSchema.SALESFORCE + ".asset" +
		"  WHERE installation_country__c IS NOT NULL" +
		"  ORDER BY installation_country__c LIMIT 1)" +
		"  UNION ALL" +
		"  SELECT ass.installation_country__c FROM cte, LATERAL (" +
		"    SELECT installation_country__c FROM " + DbSchema.SALESFORCE + ".asset" +
		"    WHERE installation_country__c IS NOT NULL" +
		"    AND installation_country__c > cte.installation_country__c" +
		"    ORDER BY installation_country__c LIMIT 1" +
		"  ) ass" +
		") TABLE cte")
	List<String> getUniqueCountries();

	@Query("SELECT a.installationCountry__c FROM Asset a" +
		" WHERE a.installationCountry__c IS NOT NULL" +
		" AND (a.salesOrganizations__c LIKE :salesOrg" +
		" OR a.salesOrganizations__c LIKE CONCAT(:salesOrg, ',%')" +
		" OR a.salesOrganizations__c LIKE CONCAT('%,', :salesOrg, ',%')" +
		" OR a.salesOrganizations__c LIKE CONCAT('%,', :salesOrg))" +
		" GROUP BY a.installationCountry__c" +
		" ORDER BY a.installationCountry__c")
	List<String> getUniqueCountriesBySalesOrg(String salesOrg);

	@Query("SELECT e FROM EquipmentType e ORDER BY e.value")
	List<EquipmentType> getUniqueEquipmentTypes();
}
