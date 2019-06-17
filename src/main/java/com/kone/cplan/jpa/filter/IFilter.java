package com.kone.cplan.jpa.filter;

import java.lang.reflect.Field;

/**
 * This interface declares a basic filter for entities
 *
 * @author Andrey Gribanov (Cervello)
 * @created 20-05-2019
 */
public interface IFilter {

	// Returns true if all of the filter's fields are null.
	// And returns false if at least one of the fields is not null.
	default boolean isEmpty() {
		for (Field f : getClass().getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.get(this) != null) {
					return false;
				}
			} catch (IllegalAccessException error) {
				error.printStackTrace();
			}
		}
		return true;
	}
}
