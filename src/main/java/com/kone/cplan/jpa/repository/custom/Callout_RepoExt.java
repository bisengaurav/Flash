package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity._case.Callout;
import com.kone.cplan.jpa.filter.IFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * This interface extends the standard repository for the {@link Callout} entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface Callout_RepoExt extends IBasicFindByFilter_RepoExt {

	List<Callout> findByFilter(IFilter filter, Pageable pageRequest);
}