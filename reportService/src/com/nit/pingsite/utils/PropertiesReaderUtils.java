package com.nit.pingsite.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReaderUtils {
	public static Properties getProperty() {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("config/pingNitApplications.properties");
			// load a properties file
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	public static void main(String[] args) {
		System.out.println(PropertiesReaderUtils.getProperty().getProperty("SERVER_HOST"));
	}
}