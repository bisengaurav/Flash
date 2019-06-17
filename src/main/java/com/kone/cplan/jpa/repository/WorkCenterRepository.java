package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.WorkCenter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This repository works with the WorkCenter entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface WorkCenterRepository extends JpaRepository<WorkCenter, Integer> {
}
