package com.kone.cplan.jpa.utils;

import com.kone.cplan.api.DataUtilsForApi;

/**
 * This interface declares an entity with access field. In fact it does not declare any methods,
 * but is used as a base interface for some other interfaces that declare real getters for fields,
 * which are used to check access. See the {@link IEntityWithSalesOrg} and
 * {@link IEntityWithSalesOrgs}.
 * 
 * It helps to re-use some common code for security checks. For example, see the
 * {@link DataUtilsForApi#findByIdWithAccessCheck(CrudRepository, Object)} method.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 11-06-2019
 */
public interface IEntityWithAccessField {
}