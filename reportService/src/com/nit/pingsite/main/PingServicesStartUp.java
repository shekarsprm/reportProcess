package com.nit.pingsite.main;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;

import com.nit.pingsite.impl.PingServicesImpl;
import com.nit.pingsite.utils.PropertiesReaderUtils;

public class PingServicesStartUp {

	public static Logger LOGGER=Logger.getLogger(PingServicesStartUp.class);
	
	public static String str[]=PropertiesReaderUtils.getProperty().getProperty("NIT_SERVICES_LISTS") .split(";");

	public static void startOperation() {
	
		LOGGER.info("########## Enter PingServicesStartUp services ################ "+new Timestamp(new Date().getTime()));
		
		try{
		for (int i = 0; i < str.length; i++) {
         String status =PingServicesImpl.getStatus(str[i]);
         
         LOGGER.debug("### STATUS IS =["+status+"]");
         
		}	

		}catch(Exception e){
			LOGGER.error("##### Error into the startOperation() "+e.getMessage());
		}
		
		LOGGER.info("########## Exists into PingServicesStartUp services ################ "+new Timestamp(new Date().getTime()));
	}

}
