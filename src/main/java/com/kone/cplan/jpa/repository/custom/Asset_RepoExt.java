package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity.Asset;
import com.kone.cplan.jpa.filter.IFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Asset_RepoExt extends BasicFindByFilter_RepoExt {

	List<Asset> findByFilter(IFilter filter, Pageable pageRequest);
}
