package com.nit.pingsite.job;

import org.apache.log4j.Logger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.nit.pingsite.main.PingServicesStartUp;

public class NitServices implements Job {

	private Logger LOGGER = Logger.getLogger(NitServices.class);
	
	public void execute(JobExecutionContext jExeCtx) throws JobExecutionException {
		LOGGER.info("#### NitServices() is startup ######"); 
		PingServicesStartUp.startOperation();
		LOGGER.info("#### NitServices() is ended ######");
	}
	
}
