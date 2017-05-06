package com.nit.mail.services.helpers;

import java.util.Properties;

public class EmailReaderUtils {
	static Properties prop = null;
	static {
		try {
			prop = new Properties();
			prop.load(EmailReaderUtils.class.getClassLoader().getResourceAsStream("mailServices.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getPropertiyValue(String key) {
		String value = prop.getProperty(key);
		return value;
	}
	public static void main(String[] args) {
		System.out.println(prop);
	}

}