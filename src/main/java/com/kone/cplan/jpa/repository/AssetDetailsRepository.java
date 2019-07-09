package com.kone.cplan.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kone.cplan.jpa.entity.asset.AssetDetails;

/**
 * This repository works with the {@link AssetDetails} AssetDetails entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface AssetDetailsRepository extends JpaRepository<AssetDetails, Integer> {
}