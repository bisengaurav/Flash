package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity.Asset;
import com.kone.cplan.jpa.filter.IFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * This interface declares repository with 'findByFilter' method which returns list of Assets.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface Asset_RepoExt extends BasicFindByFilter_RepoExt {

	List<Asset> findByFilter(IFilter filter, Pageable pageRequest);
}
