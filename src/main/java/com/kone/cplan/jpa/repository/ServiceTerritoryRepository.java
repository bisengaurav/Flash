package com.kone.cplan.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kone.cplan.jpa.entity.serviceterritory.ServiceTerritory;

/**
 * This repository works with the {@link ServiceTerritory} entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface ServiceTerritoryRepository extends JpaRepository<ServiceTerritory, Integer> {
}