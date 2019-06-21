package com.kone.cplan.jpa.repository.custom;

import java.util.List;

/**
 * This interface declares a repository with 'getUniqueSalesOrganizations' method.
 *
 * @author Andrey Gribanov (Cervello)
 * @created 11-06-2019
 */
public interface IRepoForSalesOrg {

	//TODO: rename to getUniqueSalesOrgs?
	List<String> getUniqueSalesOrganizations();
}