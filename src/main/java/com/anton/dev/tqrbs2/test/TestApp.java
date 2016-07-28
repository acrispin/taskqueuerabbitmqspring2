/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anton.dev.tqrbs2.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author anton
 * http://stackoverflow.com/questions/23173108/spring-amqp-newer-call-listener
 */
public class TestApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("test-spring-config.xml");
        final TestSender bean = context.getBean(TestSender.class);
        bean.sendMessage();        
    }
}
