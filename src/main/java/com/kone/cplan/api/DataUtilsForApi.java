package com.kone.cplan.api;

import com.kone.cplan.api.ui.utils.pagination.PagingUtils;
import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.helpers.serialization.JsonUtils;
import com.kone.cplan.jpa.filter.IFilterWithSalesOrg;
import com.kone.cplan.jpa.repository.custom.BasicFindByFilter_RepoExt;
import com.kone.cplan.jpa.repository.custom.IRepoForSalesOrg;
import com.kone.cplan.jpa.utils.IEntityWithAccessField;
import com.kone.cplan.utils.dto.SelectOption;
import com.kone.cplan.utils.security.SecurityUtils;
import com.kone.cplan.utils.session.AppSessionInfo;
import com.kone.cplan.utils.spring.AppContextHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;

public class DataUtilsForApi {
	
	//
	//Public static methods
	//
	public static <IdType> OperationResults findById(CrudRepository<?, IdType> repository,
		IdType entityId)
	{
		Optional<?> optionalResult = repository.findById(entityId);
		return (optionalResult.isPresent()
			? OperationResults.newSuccess(optionalResult.get())
			: OperationResults.newErrorByKey("message.common.record-not-found"));
	}

	public static <IdType> OperationResults findByIdWithAccessCheck(
		CrudRepository<? extends IEntityWithAccessField, IdType> repository, IdType entityId)
	{
		Optional<? extends IEntityWithAccessField> optionalResult = repository.findById(entityId);
		// Check whether the record exists
		if (!optionalResult.isPresent()) {
			return OperationResults.newErrorByKey("message.common.record-not-found");
		}
		// Check whether the Current User has access to the record
		if (!SecurityUtils.userHasAccessToRecord(optionalResult.get())) {
			return OperationResults.newErrorByKey("message.common.record-access-denied");
		}
		return OperationResults.newSuccess(optionalResult.get());
	}

	public static OperationResults findByFilter(BasicFindByFilter_RepoExt repo, String filterJson,
		Class<? extends IFilterWithSalesOrg> filterClass, Sort defaultSort)
	{
		//- deserialize parameters
		IFilterWithSalesOrg filter = JsonUtils.deserialize_typed(filterJson, filterClass);
		if (filter == null || filter.isEmpty()) {
			return OperationResults.newErrorByKey("message.common.empty-filter");
		}

		//- check or set Sales Organization
		AppSessionInfo.UserInfo userInfo = AppContextHolder.getAppSessionContext().getCurrentUserInfo();
		if (!userInfo.isAdmin()) {
			if (userInfo.getSalesOrg() == null) {
				return OperationResults.newSuccess(new ArrayList<>());
			}
			filter.setSalesOrganization__c(userInfo.getSalesOrg());
		}

		//- prepare pagination
		Pageable pageRequest = PagingUtils.extractOrGetDefaultPageRequest(defaultSort);

		//- get and return data
		return OperationResults.newSuccess(repo.findByFilter(filter, pageRequest));
	}

	public static OperationResults getUniqueSalesOrganizations(IRepoForSalesOrg repo) {
		AppSessionInfo.UserInfo userInfo = AppContextHolder.getAppSessionContext().getCurrentUserInfo();
		//- If current user's profile is C-Plan Admin then all SalesOrgs are available to him.
		// In other case only his SalesOrg is available.
		if (userInfo.isAdmin()) {
			return OperationResults.newSuccess(
				//- Account's Sales_Organizations__c field, which is used for filtering records by
				// sales org, may contain several sales orgs separated by comma. We need to parse
				// all the fields and extract all sales orgs.
				SelectOption.generateList(repo.getUniqueSalesOrganizations().stream()
					.flatMap(Pattern.compile(",")::splitAsStream)
					.distinct()
					.sorted()
					.toArray(String[]::new)
				)
			);
		} else {
			//- if current user is not assigned sales org, then return empty list. In other case
			// return list contains SelectOption with his sales org.
			return OperationResults.newSuccess(userInfo.getSalesOrg() == null
				? new ArrayList<SelectOption>()
				: Arrays.asList(new SelectOption(userInfo.getSalesOrg()))
			);
		}
	}
	//
}