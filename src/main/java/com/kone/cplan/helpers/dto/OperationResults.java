package com.kone.cplan.helpers.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kone.cplan.helpers.exception.ExceptionUtils;
import com.kone.cplan.utils.i18n.Strings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OperationResults {

	//
	//Constructors
	//
	public OperationResults(Boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	public OperationResults(Boolean isSuccessful, Object returnedObject) {
		this(isSuccessful);
		this.returnedObject = returnedObject;
	}

	public OperationResults(Boolean isSuccessful, int code, String message) {
		this(isSuccessful);
		this.code = code;
		this.addMessage(message);
	}

	public OperationResults(Boolean isSuccessful, String message) {
		this(isSuccessful, 0, message);
	}
	
	public OperationResults(Exception error) {
		this(false, 0, ExceptionUtils.extractMessage(error));
	}
	//

	//
	//Variables
	//
	private Boolean isSuccessful;
	private int code;
	private List<String> messages = new ArrayList<String>();
	private Object returnedObject;
	//

	//
	//Properties
	//
	@JsonProperty("isSuccessful")
	public Boolean isSuccessful() {
		return isSuccessful;
	}
	public void setIsSuccessful(Boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	public List<String> getMessages() {
		return messages;
	}

	public Object getReturnedObject() {
		return returnedObject;
	}
	public void setReturnedObject(Object returnedObject) {
		this.returnedObject = returnedObject;
	}
	//

	//
	//Public methods
	//
	public void addMessage(String message)
	{
		if (message != null) {
			this.messages.add(message);
		}
	}

	public void addMessages(Collection<String> newMessages)
	{
		if (newMessages != null) {
			this.messages.addAll(newMessages);
		}
	}
	
	@JsonIgnore
	public String getFirstMessage() {
		return (this.messages.isEmpty() ? null : this.messages.get(0));
	}

	@Override
	public String toString() {
		return "OperationResults [isSuccessful=" + isSuccessful + ", messages="
			+ messages + ", returnedObject=" + returnedObject + "]";
	}
	//
	
	//
	//Public static methods
	//
	public static OperationResults newSuccess(Object returnedObject)
	{
		OperationResults results = new OperationResults(true);
		results.returnedObject = returnedObject;
		return results;
	}
	
	public static OperationResults newError(String message)
	{
		return (new OperationResults(false, message));
	}
	
	public static OperationResults newError(Exception error)
	{
		return (new OperationResults(false, ExceptionUtils.extractMessage(error)));
	}
	
	public static OperationResults newError(String startMessage, Exception error)
	{
		String errorMessage = (startMessage + " " + ExceptionUtils.extractMessage(error));
		return (new OperationResults(false, errorMessage));
	}
	
	public static OperationResults newErrorByKey(String errorKey)
	{
		return (new OperationResults(false, Strings.get(errorKey)));
	}
	
	public static OperationResults newErrorByKey(String errorKey, Object... params)
	{
		return (new OperationResults(false, Strings.getAndFormat(errorKey, params)));
	}
	
	/*public static OperationResults notImplementedError()
	{
		return (new OperationResults(false, "Not implemented yet"));
	}*/
	//
}