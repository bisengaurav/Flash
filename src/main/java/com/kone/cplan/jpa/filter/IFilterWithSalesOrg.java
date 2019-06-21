package com.kone.cplan.jpa.filter;

import com.kone.cplan.api.DataUtilsForApi;

/**
 * This interface declares a filter with 'salesOrganization__c' field.
 * It helps to re-use some common code for filtering different entities. For example, see
 * {@link DataUtilsForApi#findByFilter(BasicFindByFilter_RepoExt, String, Class, Sort)} method.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 11-06-2019
 */
public interface IFilterWithSalesOrg extends IFilter {

	void setSalesOrganization__c(String salesOrg);
}
