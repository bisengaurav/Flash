package com.kone.cplan.api.ui;

import com.kone.cplan.helpers.dto.OperationResults;
import com.kone.cplan.utils.i18n.L10nData;
import com.kone.cplan.utils.i18n.LanguageData;

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
	 * @param languageCode - code of a language (for example, ru, en_US, but not ru_RU)
	 * @param countryCode - code of a country (for example, ru, US)
	 * @return {@link OperationResults} with the {@link L10nData} instance.
	 */
	@GetMapping(value = "getL10nData")
	public OperationResults getL10nData(@RequestParam String languageCode,
		@RequestParam String countryCode)
	{
		return OperationResults.newSuccess(L10nData.buildNew(languageCode, countryCode));
	}
	
	/**
	 * 
	 * @param languageCode - code of a language (for example, ru, en_US, but not ru_RU)
	 * @return {@link OperationResults} with the {@link LanguageData} instance.
	 */
	@GetMapping(value = "getLanguageData")
	public OperationResults getLanguageData(@RequestParam String languageCode) {
		return OperationResults.newSuccess(LanguageData.buildNew(languageCode));
	}
	//
}
