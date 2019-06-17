package com.kone.cplan.jpa.filter;

/**
 * This interface declares a filter with 'salesOrganization__c' field.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 11-06-2019
 */
public interface IFilterWithSalesOrg extends IFilter {

	void setSalesOrganization__c(String salesOrg);
}
