/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anton.dev.tqrbs2.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author anton
 * http://stackoverflow.com/questions/23173108/spring-amqp-newer-call-listener
 */
public class TestApp {
    
    private static final Logger LOGGER = LogManager.getLogger(TestApp.class);
    
    public static void main(String[] args) {
        LOGGER.info("Iniciacion App.");
        ApplicationContext context = new ClassPathXmlApplicationContext("test-spring-config.xml");
        final TestSender bean = context.getBean(TestSender.class);
        bean.sendMessage();        
    }
}
