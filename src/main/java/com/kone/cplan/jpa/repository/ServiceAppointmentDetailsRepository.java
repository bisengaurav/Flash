package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.ServiceAppointmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This repository works with the ServiceAppointmentDetails entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface ServiceAppointmentDetailsRepository extends JpaRepository<ServiceAppointmentDetails, Integer> {
}
