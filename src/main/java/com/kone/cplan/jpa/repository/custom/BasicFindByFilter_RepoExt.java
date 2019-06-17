package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.filter.IFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * This interface declares repository with 'findByFilter' method.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface BasicFindByFilter_RepoExt {

	List findByFilter(IFilter filter, Pageable pageRequest);
}
