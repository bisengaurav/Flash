package com.kone.cplan.utils.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JsonUtils {
	
	//
	//Variables
	//
	private static Logger logger = LogManager.getLogger(JsonUtils.class);
	//
	
	//
	//Public static methods
	//
	public static String serialize(Object sourceObject) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(sourceObject);
		} catch (JsonProcessingException e) {
			logger.debug(e.getMessage());
			return null;
		}
	}
	
	public static Object deserialize(String jsonString, Class<?> targetType) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(jsonString, targetType);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return null;
		}
	}
	
	public static <T> T deserialize_typed(String jsonString, Class<T> targetType) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(jsonString, targetType);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return null;
		}
	}
	
	public static <T> T convertObjectToType(Object sourceObject, Class<T> targetType) {
		String jsonString = serialize(sourceObject);
		return deserialize_typed(jsonString, targetType);
	}
	//
}
