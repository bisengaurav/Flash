package com.kone.cplan.helpers.exception;

/**
 * This exception occurs in runtime and must not be declared in the throws statement.
 * 
 * @author Gennadiy Pervukhin
 */
public class AppRuntimeException extends RuntimeException {

	//
	//Constructors
	//
	public AppRuntimeException(String errorMessage) {
		super(errorMessage);
	}
	
	public AppRuntimeException(Throwable e) {
		super(e);
	}
	//
	
	//
	//Variables
	//
	private static final long serialVersionUID = -6937129469349350829L;
	//
}