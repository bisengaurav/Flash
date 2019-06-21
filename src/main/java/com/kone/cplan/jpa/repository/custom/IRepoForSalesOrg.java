package com.kone.cplan.jpa.repository.custom;

import java.util.List;

/**
 * This interface declares a repository with the 'getUniqueSalesOrgs' method.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 11-06-2019
 */
public interface IRepoForSalesOrg {

	List<String> getUniqueSalesOrgs();
}