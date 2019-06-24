package com.kone.cplan.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kone.cplan.jpa.entity._case.CaseDetails;

/**
 * This repository works with the {@link CaseDetails} entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface CaseDetailsRepository extends JpaRepository<CaseDetails, Integer> {
}