package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.Asset;
import com.kone.cplan.jpa.entity.EquipmentType;
import com.kone.cplan.jpa.repository.custom.Asset_RepoExt;
import com.kone.cplan.jpa.repository.custom.IRepoForSalesOrg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * This repository works with the Asset entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface AssetRepository extends JpaRepository<Asset, Integer>, Asset_RepoExt,
	IRepoForSalesOrg {

	@Query("SELECT e.salesOrganizations__c FROM Asset e" +
		" WHERE e.salesOrganizations__c IS NOT NULL" +
		" GROUP BY e.salesOrganizations__c" +
		" ORDER BY e.salesOrganizations__c")
	List<String> getUniqueSalesOrganizations();

	@Query("SELECT e.installationCountry__c FROM Asset e" +
		" WHERE e.installationCountry__c IS NOT NULL" +
		" GROUP BY e.installationCountry__c" +
		" ORDER BY e.installationCountry__c")
	List<String> getUniqueCountries();

	@Query("SELECT e.installationCountry__c FROM Asset e" +
		" WHERE e.installationCountry__c IS NOT NULL" +
		" AND (e.salesOrganizations__c LIKE :salesOrg" +
		" OR e.salesOrganizations__c LIKE CONCAT(:salesOrg, ',%')" +
		" OR e.salesOrganizations__c LIKE CONCAT('%,', :salesOrg, ',%')" +
		" OR e.salesOrganizations__c LIKE CONCAT('%,', :salesOrg))" +
		" GROUP BY e.installationCountry__c" +
		" ORDER BY e.installationCountry__c")
	List<String> getUniqueCountriesBySalesOrg(String salesOrg);

	@Query("SELECT e FROM EquipmentType e ORDER BY e.value")
	List<EquipmentType> getUniqueEquipmentTypes();
}
