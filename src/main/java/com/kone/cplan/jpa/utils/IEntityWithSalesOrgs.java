package com.kone.cplan.jpa.utils;

/**
 * This interface declares an entity with salesOrganizations__c String field
 *
 * @author Andrey Gribanov (Cervello)
 * @created 11-06-2019
 */
public interface IEntityWithSalesOrgs extends IEntityWithAccessField{

	String getSalesOrganizations__c();
}
