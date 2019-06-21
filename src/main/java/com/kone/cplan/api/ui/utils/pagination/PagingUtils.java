package com.kone.cplan.api.ui.utils.pagination;

import com.kone.cplan.config.AppSettings;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PagingUtils {

	public static Pageable extractOrGetDefaultPageRequest(String pagingParamsJson, Sort sort) {
		Pageable pageRequest = PagingParams.deserializeToSpringPageable(pagingParamsJson);
		if (pageRequest == null) {
			//create a default page request
			pageRequest = PageRequest.of(0, AppSettings.DEFAULT_PAGE_SIZE, sort);
		} else if (pageRequest.getSort().isUnsorted()) {
			//re-construct the page request with default sorting
			pageRequest = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(),
				sort);
		}

		return pageRequest;
	}

	//TODO: REVIEW: rename
	public static Pageable extractOrGetDefaultPageRequest(Sort sort) {
		return extractOrGetDefaultPageRequest(null, sort);
	}
}
