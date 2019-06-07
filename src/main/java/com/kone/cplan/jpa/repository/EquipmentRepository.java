package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.Equipment;
import com.kone.cplan.jpa.entity.EquipmentType;
import com.kone.cplan.jpa.repository.custom.Equipment_RepoExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EquipmentRepository extends JpaRepository<Equipment, Integer>, Equipment_RepoExt {

	@Query("SELECT e.salesOrganizations__c FROM Equipment e" +
		" WHERE e.salesOrganizations__c IS NOT NULL" +
		" GROUP BY e.salesOrganizations__c" +
		" ORDER BY e.salesOrganizations__c")
	List<String> getUniqueSalesOrganizations();

	@Query("SELECT e.installationCountry__c FROM Equipment e" +
		" WHERE e.installationCountry__c IS NOT NULL" +
		" GROUP BY e.installationCountry__c" +
		" ORDER BY e.installationCountry__c")
	List<String> getUniqueCountries();

	@Query("SELECT e FROM EquipmentType e ORDER BY e.value")
	List<EquipmentType> getUniqueEquipmentTypes();
}
