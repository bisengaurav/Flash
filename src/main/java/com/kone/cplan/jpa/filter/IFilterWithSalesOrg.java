package com.kone.cplan.jpa.filter;

/**
 * @author Andrey Gribanov (Cervello)
 * @created 11-06-2019
 */
public interface IFilterWithSalesOrg extends IFilter {

	void setSalesOrganization__c(String salesOrg);
}
