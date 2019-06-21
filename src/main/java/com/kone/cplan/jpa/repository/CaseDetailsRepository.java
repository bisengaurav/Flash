package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.CaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This repository works with the {@link CaseDetails} entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface CaseDetailsRepository extends JpaRepository<CaseDetails, Integer> {
}