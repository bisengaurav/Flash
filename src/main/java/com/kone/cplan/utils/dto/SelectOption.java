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

	public SelectOption(String label, String value) {
		this.label = label;
		this.value = value;
	}

	public SelectOption(String value) {
		this(value, value);
	}
	//

	//
	//Variables
	//
	private String label;
	private String value;
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

	public String getValue() {
		return value;
	}
	public void setName(String value) {
		this.value = value;
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