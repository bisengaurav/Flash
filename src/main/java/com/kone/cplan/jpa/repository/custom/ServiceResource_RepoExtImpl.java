package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity.serviceres.ServiceResource;
import com.kone.cplan.jpa.filter.IFilter;
import com.kone.cplan.jpa.filter.ServiceResourceFilter;
import com.kone.cplan.jpa.utils.JpaUtils;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom extension of the standard repository for the {@link ServiceResource} entity.
 * 
 * @author Andrey Gribanov (Cervello)
 */
public class ServiceResource_RepoExtImpl implements ServiceResource_RepoExt {

	//
	//Variables
	//
	@PersistenceContext
	private EntityManager entityManager;
	//

	//
	//Public methods
	//
	@Override
	public List<ServiceResource> findByFilter(IFilter baseFilter, Pageable pageRequest) {

		if (!(baseFilter instanceof ServiceResourceFilter)) {
			return new ArrayList<>();
		}
		ServiceResourceFilter filter = (ServiceResourceFilter) baseFilter;

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ServiceResource> query = cb.createQuery(ServiceResource.class);
		Root<ServiceResource> root = query.from(ServiceResource.class);

		List<Predicate> predicates = new ArrayList<>();

		//- add user's filters from Service Resources page
		if (filter.getName() != null) {
			predicates.add(cb.like(cb.lower(root.get("name")),
				JpaUtils.buildContainsPattern(filter.getName(), false)));
		}
		if (filter.getPhone__c() != null) {
			predicates.add(cb.like(cb.lower(root.get("phone__c")),
				JpaUtils.buildContainsPattern(filter.getPhone__c(), false)));
		}
		if (filter.getSalesOrganization__c() != null) {
			predicates.add(cb.equal(root.get("salesOrganization__c"), filter.getSalesOrganization__c()));
		}

		//- add filter by isActive field (only active ServiceResources are needed)
		predicates.add(cb.equal(root.get("isActive"), true));

		query.select(root).where(predicates.toArray(new Predicate[]{}));

		//- order by 'name'
		query.orderBy(cb.asc(root.get("name")));

		TypedQuery<ServiceResource> typedQuery = entityManager.createQuery(query);
		typedQuery.setMaxResults(pageRequest.getPageSize());

		return typedQuery.getResultList();
	}
	//
}
