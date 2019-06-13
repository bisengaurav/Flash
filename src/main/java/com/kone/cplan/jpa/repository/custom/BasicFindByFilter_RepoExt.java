package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.filter.IFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BasicFindByFilter_RepoExt {

	List findByFilter(IFilter filter, Pageable pageRequest);
}
