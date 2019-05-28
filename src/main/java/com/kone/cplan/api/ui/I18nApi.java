package com.kone.cplan.api.ui;

import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.utils.i18n.I18nInfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with internationalization (i18n).
 * 
 * @author Gennadiy Pervukhin
 * @created 29-05-2019
 */
@RestController
@RequestMapping("${cplan.url.ui-api-path}/i18n")
public class I18nApi {

	//
	//Public methods
	//
	/**
	 * 
	 * @param languageTag - codes of a language and country that are separated by dash (for example,
	 * ru-RU, en-US)
	 * @return OperationResults with the {@link I18nInfo} instance.
	 */
	@GetMapping(value = "getI18nInfo")
	public OperationResults getById(@RequestParam String languageTag) {
		return OperationResults.newSuccess(I18nInfo.buildNew(languageTag));
	}
	//
}
