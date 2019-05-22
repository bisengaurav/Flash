package com.kone.cplan.utils.reflection;

/**
 * This class provides utilities for reflection.
 * 
 * @author Gennadiy Pervukhin
 * @created 28-03-2019
 */
public class ReflectionUtils {

	//
	//Public static methods
	//
	public static boolean fieldExists(Class<?> javaClass, String fieldName) {
		
		//- try to find the field in fields that are explicitly declared in the Java class
		try {
			javaClass.getDeclaredField(fieldName);
			return true;
		}
		catch (NoSuchFieldException | SecurityException error) {}
		
		//- try to find the field in a parent class of the Java class
		if (javaClass.getSuperclass() != null) {
			return fieldExists(javaClass.getSuperclass(), fieldName);
		}
		
		return false;
	}
	//
	
}