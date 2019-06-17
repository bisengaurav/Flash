package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.WorkOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This repository works with the WorkOrderDetails entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface WorkOrderDetailsRepository extends JpaRepository<WorkOrderDetails, Integer> {
}
