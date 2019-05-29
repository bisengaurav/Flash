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
	@Id
	private Integer id;

	@Column(unique = true)
	private String sfid;

	@Column(name = "federationidentifier")
	private String federationIdentifier;

	@Column(name = "languagelocalekey")
	private String languageLocaleKey;

	@Column
	private String salesOrganization__c;

	@Column(name = "profileid")
	private String profileId;

	@Column
	private String email;

	@Column(name = "timezonesidkey")
	private String timezonesIdKey;
	//

	//
	//Properties
	//
	public Integer getId() {
		return id;
	}

	public String getSfid() {
		return sfid;
	}

	public String getFederationIdentifier() {
		return federationIdentifier;
	}

	public String getLanguageLocaleKey() {
		return languageLocaleKey;
	}

	public String getSalesOrganization__c() {
		return salesOrganization__c;
	}

	public String getProfileId() {
		return profileId;
	}

	public String getEmail() {
		return email;
	}

	public String getTimezonesIdKey() {
		return timezonesIdKey;
	}
	//
}
