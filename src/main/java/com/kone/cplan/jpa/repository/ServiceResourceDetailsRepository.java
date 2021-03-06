package com.kone.cplan.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kone.cplan.jpa.entity.serviceres.ServiceResourceDetails;

/**
 * This repository works with the {@link ServiceResourceDetails} entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface ServiceResourceDetailsRepository extends JpaRepository<ServiceResourceDetails, Integer> {
}