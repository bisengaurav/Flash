package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity.Callout;
import com.kone.cplan.jpa.filter.IFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * This interface declares repository with 'findByFilter' method which returns list of Callouts.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface Callout_RepoExt extends BasicFindByFilter_RepoExt {

	List<Callout> findByFilter(IFilter filter, Pageable pageRequest);
}
