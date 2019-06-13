package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity.Callout;
import com.kone.cplan.jpa.filter.IFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Callout_RepoExt extends BasicFindByFilter_RepoExt {

	List<Callout> findByFilter(IFilter filter, Pageable pageRequest);
}
