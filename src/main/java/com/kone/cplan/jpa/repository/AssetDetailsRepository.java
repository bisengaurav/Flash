package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.AssetDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This repository works with the AssetDetails entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface AssetDetailsRepository extends JpaRepository<AssetDetails, Integer> {
}
