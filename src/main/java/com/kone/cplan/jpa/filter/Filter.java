package com.kone.cplan.jpa.filter;

import java.lang.reflect.Field;

public interface Filter {

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
