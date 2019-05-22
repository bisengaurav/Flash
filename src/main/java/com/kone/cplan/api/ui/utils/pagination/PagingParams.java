package com.kone.cplan.api.ui.utils.pagination;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.kone.cplan.config.AppSettings;
import com.kone.cplan.helpers.serialization.JsonUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class encapsulates details of pagination.
 * 
 * @author Gennadiy Pervukhin
 * @created 22-04-2019
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE,
	setterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public class PagingParams {
	
	//
	//Constructors
	//
	/*For JSON-deserialization*/
	protected PagingParams() {}
	
	public PagingParams(int pageNumber, int pageSize, SortingParam sortingParam) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.sortingParams.add(sortingParam);
	}
	//

	//
	//Variables
	//
	private int pageNumber = 0;
	private int pageSize = AppSettings.DEFAULT_PAGE_SIZE;
	private List<SortingParam> sortingParams = new ArrayList<>();
	//
	
	//
	//Properties
	//
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<SortingParam> getSortingParams() {
		return sortingParams;
	}
	//
	
	//
	//Public methods
	//
	public Pageable convertToSpringPageable() {
		return PageRequest.of(this.pageNumber, this.pageSize,
			SortingParam.convertToSpringSort(this.sortingParams));
	}
	//
	
	//
	//Public static methods
	//
	public static Pageable deserializeToSpringPageable(String pagingParamsJson) {
		PagingParams pagingParams = JsonUtils.deserialize_typed(pagingParamsJson, PagingParams.class);
		return (pagingParams != null ? pagingParams.convertToSpringPageable() : null);
	}
	//
}