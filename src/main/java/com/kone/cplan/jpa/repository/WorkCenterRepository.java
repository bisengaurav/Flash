package com.kone.cplan.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kone.cplan.jpa.entity.workcenter.WorkCenter;

/**
 * This repository works with the {@link WorkCenter} entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface WorkCenterRepository extends JpaRepository<WorkCenter, Integer> {
}