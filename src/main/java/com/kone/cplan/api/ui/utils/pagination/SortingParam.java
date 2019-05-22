package com.kone.cplan.api.ui.utils.pagination;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class encapsulates details of a parameter for sorting
 * 
 * @author Gennadiy Pervukhin
 * @created 22-04-2019
 */
public class SortingParam {
	
	//
	//Constructors
	//
	/*For JSON-deserialization*/
	protected SortingParam() {}
	
	public SortingParam(Direction direction, String property) {
		super();
		this.direction = direction;
		this.property = property;
	}
	//
	
	//
	//Variables
	//
	private Direction direction;
	private String property;
	//
	
	//
	//Properties
	//
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	//
	
	//
	//Public methods
	//
	public Sort.Order convertToSpringOrder() {
		return (new Sort.Order(this.direction, this.property));
	}
	//
	
	//
	//Public static methods
	//
	public static Sort convertToSpringSort(Collection<SortingParam> sortingParams) {
		
		List<Sort.Order> orders = new ArrayList<>();
		if (sortingParams != null) {
			for (SortingParam param : sortingParams) {
				orders.add(param.convertToSpringOrder());
			}
		}
		return Sort.by(orders);
	}
	//
}