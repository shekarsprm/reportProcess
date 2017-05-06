package com.nit.mail.services.helpers;


public class MailServicesConstants {

	

// ********************** EMAIL CONFIGURATION INFO   ********************************** //////
	public static String FROM_EMAIL_ID=null;
public static String FROM_PWD=null;

public static String SERVER_HOST=null;
public static String SERVER_PORT=null;

static{
	
	FROM_EMAIL_ID=EmailReaderUtils.getPropertiyValue("FROM_EMAILID");
	FROM_PWD=EmailReaderUtils.getPropertiyValue("FROM_PWD");
	SERVER_HOST=EmailReaderUtils.getPropertiyValue("SERVER_HOST");
	SERVER_PORT=EmailReaderUtils.getPropertiyValue("SERVER_PORT");
}
	
}
