package com.mdsap.wlf;


import com.mdsap.wlf.mail.SendEmailService;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import  com.mdsap.wlf.engine.*;

import javax.inject.Named;


@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = Logger.getLogger(StartApplication.class);


    @Autowired
    @Named("sendEmailServiceSpringBootImpl")
    private SendEmailService emailServiceSpringBoot;

    @Autowired
    private WlfEngine wlfEngine;

    @Autowired
    private StatusEngine statusEngine;


    public static void main(String[] args) {



        SpringApplication.run(StartApplication.class, args);
    }

    private native void sayHello();

     @Override
    public void run(String... args) throws InterruptedException {

      /*   try {
             emailServiceSpringBoot.sendHtmlEmail();
         } catch (Exception e) {
             e.printStackTrace();
         }

*/
         Integer iterationCount=0;

    while(true)
    {
        iterationCount++;

        log.info("********************************** Iteration "+iterationCount+" is Started **********************************");
        if(statusEngine.checkStatus())
          wlfEngine.startProcess();
        log.info("Iteration  "+iterationCount+" is Finished");

        log.info("Sleep Engine for 5 minutes");
        Thread.sleep(5*60*1000);
    } 

    }


}