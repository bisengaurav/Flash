package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity.Case;
import com.kone.cplan.jpa.filter.CaseFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Case_RepoExt {

	List<Case> findByFilter(CaseFilter filter, Pageable pageRequest);
}
