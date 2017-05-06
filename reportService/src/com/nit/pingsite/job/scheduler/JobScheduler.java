package com.nit.pingsite.job.scheduler;

import org.apache.log4j.Logger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.nit.pingsite.job.NitServices;

/**
 * @since 22 Nov,2015
 * @version 1.0.0
 *
 */
public class JobScheduler {

	public static Logger LOGGER=Logger.getLogger(JobScheduler.class);
	public static void main(String[] args) {
		
		try {
			
			// specify the job' s details..
			JobDetail job = JobBuilder.newJob(NitServices.class)
			    .withIdentity("testJob")
			    .build();
			
			// specify the running period of the job
			Trigger trigger = TriggerBuilder.newTrigger()
			      .withSchedule(  
	                    SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(0).repeatForever()).build();  
	    	
			//schedule the job
			SchedulerFactory schFactory = new StdSchedulerFactory();
			Scheduler sch = schFactory.getScheduler();
	    	sch.start();	    	
	    	sch.scheduleJob(job, trigger);		
		
		} catch (SchedulerException e) {
			LOGGER.error("##### Error into the JobScheduler: "+e.getMessage());
		}
	}
	
}
