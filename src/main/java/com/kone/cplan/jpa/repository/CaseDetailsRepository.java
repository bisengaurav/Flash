package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.CaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CaseDetailsRepository extends JpaRepository<CaseDetails, Integer> {

	@Override
	@Query("SELECT c FROM CaseDetails c" +
		" WHERE c.status NOT IN ('Cancelled', 'Completed')" +
		" AND c.recordTypeId = '012w0000000V9MrAAK'" +
		" AND c.id = ?1")
	Optional<CaseDetails> findById(Integer id);
}
