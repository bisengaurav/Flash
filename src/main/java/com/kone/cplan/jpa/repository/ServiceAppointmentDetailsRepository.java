package com.kone.cplan.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kone.cplan.jpa.entity.serviceappt.ServiceAppointmentDetails;

/**
 * This repository works with the {@link ServiceAppointmentDetails} entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface ServiceAppointmentDetailsRepository extends JpaRepository<ServiceAppointmentDetails, Integer> {
}