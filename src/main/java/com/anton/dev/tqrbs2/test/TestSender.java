/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anton.dev.tqrbs2.test;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author anton
 * http://stackoverflow.com/questions/23173108/spring-amqp-newer-call-listener
 */
@Component
public class TestSender {

    @Autowired
    private RabbitTemplate template;

    public void sendMessage() {
        String msg = "mensaje de test en cola";
        final Message message = new Message(msg.getBytes(), new MessageProperties());
        System.out.println("Enviando: " + msg);
        // template.send("myExchange", "userMesssage", message);        
        template.convertAndSend("myExchange", "userMesssage", msg);
    }

}
