package com.kone.cplan.utils.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Select Option.
 * 
 * @author Gennadiy Pervukhin
 * @created 15-03-2019
 */
public class SelectOption {
	
	//
	//Constructors
	//
	protected SelectOption() {}
	
	public SelectOption(String label, String name) {
		this.label = label;
		this.name = name;
	}
	
	public SelectOption(String name) {
		this(name, name);
	}
	//
	
	//
	//Variables
	//
	private String label;
	private String name;
	//
	
	//
	//Properties
	//
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//
	
	
	//
	//Public static methods
	//
	public static List<SelectOption> generateList(Object[] list) {
		List<SelectOption> options = new ArrayList<>();
		for (Object item : list) {
			options.add(new SelectOption(item.toString()));
		}
		return options;
	}
	//
}