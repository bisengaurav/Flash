package com.kone.cplan.jpa.entity;

import com.kone.cplan.helpers.db.DbSchema;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = DbSchema.C_PLAN)
public class User implements Serializable {

	//
	//Constructors
	//
	/*For JPA and JSON-deserialization*/
	public User() {};
	//

	//
	//Variables
	//
	private static final long serialVersionUID = -3052393242729063561L;
	
	@Id
	private Integer id;
	@Column(name = "sfid", unique = true)
	private String sfId;
	@Column(name = "profileid")
	private String profileId;
	
	@Column
	private String name;
	@Column
	private String email;

	@Column(name = "federationidentifier")
	private String federationIdentifier;

	@Column
	private String salesOrganization__c;
	
	/**
	 * This SF field stores only language code and does not include country code. For example, it
	 * may store:
	 * - "ru" (it means Russian language and it can't be "ru_RU", since this language does not have
	 * official dialects)
	 * - "en_US" (it means US dialect of English language).
	 * 
	 * So we can consider that the 2nd part is a dialect, but is not a country code
	 */
	@Column(name = "languagelocalekey")
	private String languageLocaleKey;
	
	/**
	 * This SF field stores language code, country code and may store additional parameters. But
	 * sometimes the values store only some of these codes. These are the examples of data that we
	 * found in SF DB: ru, ru_RU, en_US (but not "en"), fr_FR_EURO.
	 */
	@Column(name = "localesidkey")
	private String localeSidkey;
	
	/**
	 * This SF field stores time zone Ids. For example, Europe/Moscow, America/New_York, GMT, but
	 * not "GMT+0300". 
	 */
	@Column(name = "timezonesidkey")
	private String timezoneSidKey;
	//

	//
	//Properties
	//
	public Integer getId() {
		return id;
	}
	public String getSfId() {
		return sfId;
	}

	public String getProfileId() {
		return profileId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}

	public String getFederationIdentifier() {
		return federationIdentifier;
	}

	public String getSalesOrganization__c() {
		return salesOrganization__c;
	}

	/**
	 * See {@link User#languageLocaleKey}
	 */
	public String getLanguageLocaleKey() {
		return languageLocaleKey;
	}

	/**
	 * See {@link User#localeSidkey}
	 */
	public String getLocaleSidkey() {
		return localeSidkey;
	}

	/**
	 * See {@link User#timezoneSidKey}
	 */
	public String getTimezoneSidKey() {
		return timezoneSidKey;
	}
	//
}