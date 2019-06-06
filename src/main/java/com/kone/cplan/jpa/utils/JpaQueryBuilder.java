package com.kone.cplan.jpa.utils;

import com.kone.cplan.helpers.datatype.StringUtils;
import com.kone.cplan.helpers.exception.AppRuntimeException;
import com.kone.cplan.utils.i18n.Strings;
import com.kone.cplan.utils.reflection.ReflectionUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class builds a JPA TypedQuery.
 * JPA already provides the JPA Criteria API Queries (https://www.objectdb.com/java/jpa/query/criteria),
 * but it looks too complex for our purposes and reduces readability of the code.
 * Used abbreviations:
 * - T = Template.
 *
 * @author Gennadiy Pervukhin
 * @created 26-03-2019
 */
public class JpaQueryBuilder<EntityT> {

	//
	//Constructors
	//
	public JpaQueryBuilder(EntityManager entityManager, Class<EntityT> entityType) {
		super();
		this.entityManager = entityManager;
		this.entityType = entityType;
	}
	//

	//
	//Constants
	//
	private static final String T_OBJECT_ALIAS = "o";
	private static final String T_FIELDS_QUERY = ("SELECT %s FROM %s " + T_OBJECT_ALIAS);
	private static final String T_COUNT_QUERY = ("SELECT count(" + T_OBJECT_ALIAS + ") FROM %s "
		+ T_OBJECT_ALIAS);

	private static final String T_SIMPLE_CONDITION_CASE_SENSITIVE = "%s %s ?%s";
	private static final String T_SIMPLE_CONDITION_CASE_INSENSITIVE = "LOWER(%s) %s LOWER(?%s)";
	private static final String T_CONTAINS_CASE_SENSITIVE = "%s LIKE concat('%%', ?%s, '%%')";
	private static final String T_CONTAINS_CASE_INSENSITIVE = "LOWER(%s) LIKE LOWER(concat('%%', ?%s, '%%'))";

	private static final String ORDER_BY_ITEMS_SEPARATOR = ",";
	private static final String FIELDS_SEPARATOR = ",";
	//

	//
	//Variables
	//
	private EntityManager entityManager;
	private Class<EntityT> entityType;

	private QueryType queryType = QueryType.FIELDS;

	private List<String> fields = new ArrayList<>();
	private Pageable pageRequest;

	private List<String> conditions = new ArrayList<>();
	private List<Object> queryParams = new ArrayList<>();
	//

	//
	//Properties
	//
	public void setFields(Collection<String> fields) {
		this.fields.clear();
		if (fields != null) {
			this.fields.addAll(fields);
		}
	}

	public void setPageRequest(Pageable pageRequest) {
		this.pageRequest = pageRequest;
	}
	//

	//
	//Private methods
	//
	private String joinConditionsByAnd() {
		return String.join(" AND ", this.conditions);
	}

	private void checkFieldInEntity(String field) {
		if (!ReflectionUtils.fieldExists(this.entityType, field)) {
			throw (new IllegalArgumentException(Strings.getAndFormat(
				"message.common.field-not-found-in-object.java", field, this.entityType.getName())));
		}
	}

	private int getIndexOfNewParam() { return this.conditions.size(); }

	private void addCondition(String field, Object value, String conditionTemplate,
		Object... paramsForCondition)
	{
		//STEP #1: check whether the field exists in EntityType
		this.checkFieldInEntity(field);

		//STEP #2: generate and remember a new condition
		this.conditions.add(String.format(conditionTemplate, paramsForCondition));

		//STEP #3: remember value for the condition
		this.queryParams.add(value);
	}

	private String buildBasicQuery() {

		switch (this.queryType) {
			case COUNT:
				return String.format(T_COUNT_QUERY, this.entityType.getName());
			case FIELDS:
				String stringOfFields = (this.fields.isEmpty() ? T_OBJECT_ALIAS
					: joinFields(this.fields));
				return String.format(T_FIELDS_QUERY, stringOfFields, this.entityType.getName());
			default:
				throw (new AppRuntimeException("Unknown query type"));
		}
	}

	private String buildOrderByClause() {

		//- do basic checks
		if (this.queryType != QueryType.FIELDS || this.pageRequest == null
			|| this.pageRequest.getSort().isUnsorted())
		{
			return StringUtils.EMPTY;
		}

		//- add sorting criterions
		List<String> sortingItems = new ArrayList<>();
		for (Sort.Order sortingParam : this.pageRequest.getSort()) {
			//check that the field exists in the Entity
			this.checkFieldInEntity(sortingParam.getProperty());

			//add field name and direction of sorting
			final String sortingItem = (sortingParam.getProperty() + " "
				+ sortingParam.getDirection() + nullHandlingToSql(sortingParam.getNullHandling()));
			sortingItems.add(sortingItem);
		}

		return (" ORDER BY " + joinSortingItems(sortingItems));
	}

	private void setOffsetAndLimit(Query query) {
		if (this.queryType == QueryType.FIELDS && this.pageRequest != null)
		{
			//we expect that Integer will always be enough for offset
			query.setFirstResult((int)this.pageRequest.getOffset());
			query.setMaxResults(this.pageRequest.getPageSize());
		}
	}

	private <ReturnType> TypedQuery<ReturnType> build(QueryType queryType,
		Class<ReturnType> returnTypeClass)
	{
		//STEP #1: generate a basic query
		this.queryType = queryType;
		String jpaQueryString = this.buildBasicQuery();

		//STEP #2: add WHERE clause
		if (this.conditions.size() > 0) {
			jpaQueryString += " WHERE " + this.joinConditionsByAnd();
		}

		//STEP #3: add ORDER BY clause
		jpaQueryString += this.buildOrderByClause();

		//STEP #4: generate a JPA-query and add parameters to it
		TypedQuery<ReturnType> query = entityManager.createQuery(jpaQueryString, returnTypeClass);
		for (int indexOfParam = 0; indexOfParam < this.queryParams.size(); indexOfParam++) {
			query.setParameter(indexOfParam, this.queryParams.get(indexOfParam));
		}

		//STEP #5: set offset and limit
		this.setOffsetAndLimit(query);

		return query;
	}
	//

	//
	//Private static methods
	//
	private static String nullHandlingToSql(Sort.NullHandling nullHandling) {
		switch (nullHandling) {
			case NULLS_FIRST:
				return " NULLS FIRST";
			case NULLS_LAST:
				return " NULLS LAST";
			default:
				return "";
		}
	}

	public static String joinFields(Collection<String> fields) {
		return (CollectionUtils.isEmpty(fields) ? "*" : String.join(FIELDS_SEPARATOR, fields));
	}

	//TODO: AMZ: new method
	public static String joinSortingItems(Collection<String> items) {
		return (CollectionUtils.isEmpty(items) ? "" : String.join(ORDER_BY_ITEMS_SEPARATOR, items));
	}
	//

	//
	//Public methods
	//
	public void addSimpleCondition(String field, String operator, Object value) {
		addSimpleCondition(field, operator, value, true);
	}

	public void addSimpleCondition(String field, String operator, Object value, boolean isCaseSensitive) {
		this.addCondition(field, value,
			isCaseSensitive ? T_SIMPLE_CONDITION_CASE_SENSITIVE : T_SIMPLE_CONDITION_CASE_INSENSITIVE,
			field, operator, this.getIndexOfNewParam());
	}

	public void addSimpleConditionIfNotNull(String field, String operator, Object value) {
		if (value != null) {
			this.addSimpleCondition(field, operator, value, true);
		}
	}

	public void addSimpleConditionIfNotNull(String field, String operator, Object value,
		boolean isCaseSensitive) {
		if (value != null) {
			this.addSimpleCondition(field, operator, value, isCaseSensitive);
		}
	}

	public void addCondition_FieldContains(String field, String value, boolean isCaseSensitive) {

		if (StringUtils.isNotEmpty(value)) {
			String conditionTemplate = (isCaseSensitive ? T_CONTAINS_CASE_SENSITIVE
				: T_CONTAINS_CASE_INSENSITIVE);
			this.addCondition(field, value, conditionTemplate, field, this.getIndexOfNewParam());
		}
	}

	/**
	 * The method adds a condition for a column with JSON-data, to take only those records, where
	 * this JSON-data contains a particular property with a particular value.
	 *
	 * @param entityField - Field that stores JSON-data
	 * @param jsonPropertyName - Name of the property in JSON-data
	 * @param jsonPropertyValue - Value of the JSON-property. It must NOT be blank.
	 * @param isCaseSensitive - Is Case-Sensitive search?
	 */
	public void addCondition_JsonPropertyEquals(String entityField, String jsonPropertyName,
		String jsonPropertyValue, boolean isCaseSensitive)
	{
		if (StringUtils.isNotEmpty(jsonPropertyValue)) {
			//- build a JSON string that we need to search for
			String jsonToSearch = "\"" + jsonPropertyName + "\":\"" + jsonPropertyValue + "\"";

			//- add the "field contains" condition
			this.addCondition_FieldContains(entityField, jsonToSearch, isCaseSensitive);
		}
	}

	public TypedQuery<EntityT> buildForRecords() {
		return this.build(QueryType.FIELDS, this.entityType);
	}

	public TypedQuery<Long> buildForCount() {
		return this.build(QueryType.COUNT, Long.class);
	}
	//

	//
	//Data Types
	//
	public enum QueryType
	{
		FIELDS,
		COUNT
	}
	//
}