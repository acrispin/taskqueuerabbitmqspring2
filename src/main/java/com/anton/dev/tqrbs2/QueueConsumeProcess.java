/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anton.dev.tqrbs2;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author anton
 * http://www.javabydefault.com/2014/11/publish-and-consume-messages-to.html
 */
@Component
public class QueueConsumeProcess implements MessageListener {
    
    private static final Logger LOGGER = LogManager.getLogger(QueueConsumeProcess.class);

    @Autowired
    private CachingConnectionFactory connectionFactory;

    public static void main(String[] argv) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        QueueConsumeProcess consumer = context.getBean(QueueConsumeProcess.class);
        consumer.consume();
    }

    private void consume() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("test.queue.1", "test.queue.2", "test.queue.3", "test.queue.4", "test.queue.5");
        container.setMessageListener(new MessageListenerAdapter(this));
        container.start();
    }

    @Override
    public void onMessage(Message msg) {
        LOGGER.info(new String(msg.getBody()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
