package org.amuradon.tralon.sigpron.telegram;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageIds {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageIds.class);
	
	private final Map<Integer, String> mapping;
	
	public MessageIds() {
		mapping = new HashMap<>();
		
		try {
			Properties properties = new Properties();
			properties.load(getClass().getClassLoader().getResourceAsStream("/messages.properties"));
			for (Entry<Object,Object> entry : properties.entrySet()) {
				mapping.put(Integer.parseInt(entry.getValue().toString()), entry.getKey().toString());
			}
		} catch (IOException e) {
			LOGGER.error("Could not parse message ids", e);
		}
	}
	
	public String getName(int id) {
		return mapping.getOrDefault(id, String.valueOf(id));
	}
}
