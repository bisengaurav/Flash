package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Integer> {
}
