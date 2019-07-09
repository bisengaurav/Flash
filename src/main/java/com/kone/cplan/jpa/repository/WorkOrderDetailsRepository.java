package com.kone.cplan.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kone.cplan.jpa.entity.workorder.WorkOrderDetails;

/**
 * This repository works with the {@link WorkOrderDetails} entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface WorkOrderDetailsRepository extends JpaRepository<WorkOrderDetails, Integer> {
}