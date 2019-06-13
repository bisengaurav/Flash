package com.kone.cplan.jpa.filter;

/**
 * This class represents a filter for the ServiceResource entities.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 31-05-2019
 */
public class ServiceResourceFilter implements IFilter, IFilterWithSalesOrg {

	//
	//Variables
	//
	private String name;

	private String phone__c;

	private String salesOrganization__c;
	//

	//
	//Properties
	//
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPhone__c() {
		return phone__c;
	}
	public void setPhone__c(String phone__c) {
		this.phone__c = phone__c;
	}

	public String getSalesOrganization__c() {
		return salesOrganization__c;
	}
	@Override
	public void setSalesOrganization__c(String salesOrganization__c) {
		this.salesOrganization__c = salesOrganization__c;
	}
	//
}
