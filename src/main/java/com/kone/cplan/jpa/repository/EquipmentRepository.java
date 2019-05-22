package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.Equipment;
import com.kone.cplan.jpa.repository.custom.Equipment_RepoExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EquipmentRepository extends JpaRepository<Equipment, Integer>,
	Equipment_RepoExt {

	// TODO: ask KONE about filter by Sales Org
	@Query("SELECT DISTINCT e.installationCountry__c FROM Equipment e ORDER BY e.installationCountry__c")
	List<String> getUniqueCountries();

	@Query("SELECT e.value FROM EquipmentType e ORDER BY e.value")
	List<String> getEquipmentTypes();
}
