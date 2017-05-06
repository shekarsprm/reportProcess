	package com.nit.pingsite.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

import com.nit.mail.services.utils.EmailUtils;
import com.nit.pingsite.utils.PropertiesReaderUtils;

public class PingServicesImpl {
	public static Logger LOGGER=Logger.getLogger(PingServicesImpl.class);
	public static String getStatus(String url) throws IOException {
     LOGGER.info("#### Enter into the getStatus() Code method is stared ######"); 
		String result = "";
		try {
			URL siteURL = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) siteURL
					.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			int code = connection.getResponseCode();
			
			LOGGER.debug("#### Inside into the url: [="+url+"], status Code=["+code+"]");
	
			if(code!=200){
				 String str[]=PropertiesReaderUtils.getProperty().getProperty("SEND_SERVER_DOWN_EMAILS") .split(";");
				 for(int i=0;i<str.length;i++){
					 	EmailUtils.emailUtils(str[i]);
				 }
			}
		} catch (Exception e) {
			result = "->Red<-";
			LOGGER.info("#### Error into the getStatus()  ######"+e.getMessage());
		}
		
		LOGGER.info("#### Exit into the getStatus() Code method is stared ######");
		return result;
	}

	
}
