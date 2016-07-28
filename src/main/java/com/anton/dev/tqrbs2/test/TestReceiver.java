/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anton.dev.tqrbs2.test;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author anton
 * http://stackoverflow.com/questions/23173108/spring-amqp-newer-call-listener
 * 
 */
@Component
public class TestReceiver implements ChannelAwareMessageListener {
    
    private static final Logger LOGGER = LogManager.getLogger(TestReceiver.class);

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        LOGGER.info("Recibiendo: "+ new String(message.getBody()));
    }
}

