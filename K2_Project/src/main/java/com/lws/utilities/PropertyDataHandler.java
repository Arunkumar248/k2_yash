package com.lws.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class PropertyDataHandler {
	/**
	 * Returns specified property value from the given property file
	 * 
	 */
	public String getProperty(String fileName, String propertyName)  {
		String propValue = "";
		try {
			Properties props = new Properties();
			ClassLoader classLoader = PropertyDataHandler.class.getClassLoader();
			InputStream input = classLoader.getResourceAsStream( fileName+ ".properties");
			props.load(input);
			propValue = props.getProperty(propertyName);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return propValue;
	}
}
