package com.kone.cplan.jpa.utils;

/**
 * This interface declares an entity with 'salesOrganization__c' String field
 *
 * @author Andrey Gribanov (Cervello)
 * @created 11-06-2019
 */
public interface IEntityWithSalesOrg extends IEntityWithAccessField{

	String getSalesOrganization__c();
}
