package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity.ServiceResource;
import com.kone.cplan.jpa.filter.IFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * This interface extends the standard repository for the {@link ServiceResource} entity.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 16-05-2019
 */
public interface ServiceResource_RepoExt extends IBasicFindByFilter_RepoExt {

	List<ServiceResource> findByFilter(IFilter filter, Pageable pageRequest);
}