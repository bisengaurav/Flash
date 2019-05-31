package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity.ServiceResource;
import com.kone.cplan.jpa.filter.ServiceResourceFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceResource_RepoExt {

	List<ServiceResource> findByFilter(ServiceResourceFilter filter, Pageable pageRequest);
}
