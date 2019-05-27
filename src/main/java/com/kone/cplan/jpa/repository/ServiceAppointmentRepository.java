package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.ServiceAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceAppointmentRepository extends JpaRepository<ServiceAppointment, Integer> {
}
