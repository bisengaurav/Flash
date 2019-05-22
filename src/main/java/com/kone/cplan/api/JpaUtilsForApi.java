package com.kone.cplan.api;

import com.kone.cplan.helpers.dto.OperationResults;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class JpaUtilsForApi {
	
	//
	//Constants
	//
	private static final String E_RECORD_NOT_FOUND = "Record not found.";
	//
	
	//
	//Public static methods
	//
	public static <IdType> OperationResults findById(CrudRepository<?, IdType> repository,
		IdType entityId)
	{
		Optional<?> optionalResult = repository.findById(entityId);
		return (optionalResult.isPresent()
			? OperationResults.newSuccess(optionalResult.get())
			: OperationResults.newError(E_RECORD_NOT_FOUND));
	}
	//
}