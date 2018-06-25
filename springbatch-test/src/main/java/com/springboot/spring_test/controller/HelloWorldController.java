package com.springboot.spring_test.controller;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	   @Autowired
	    JobLauncher jobLauncher;
	 
	    @Autowired
	    Job processJob;	
	
   @RequestMapping("/abc")
   public String sayHello() {
      return "Hello Spring Boot!!";
   }
   
   @RequestMapping("/invokejob")
   public String handle() throws Exception {

           JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                   .toJobParameters();
           jobLauncher.run(processJob, jobParameters);

       return "Batch job has been invoked";
   }
}