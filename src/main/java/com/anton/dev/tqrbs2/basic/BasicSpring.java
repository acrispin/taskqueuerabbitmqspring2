/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anton.dev.tqrbs2.basic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author anton
 * https://projects.spring.io/spring-amqp/#quick-start
 */
public class BasicSpring {
    public static void main(String[] args) throws Exception {
        AbstractApplicationContext ctx =
		new ClassPathXmlApplicationContext("basic-context.xml");
	RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        String msg = "Hello, world Rabbit!";
        System.out.println("Enviando Spring: " + msg);
	template.convertAndSend(msg);
	Thread.sleep(1000);
	ctx.destroy();
    }
}
