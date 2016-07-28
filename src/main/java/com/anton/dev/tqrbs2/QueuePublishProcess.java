/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anton.dev.tqrbs2;

import java.util.Date;
import java.util.Random;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author anton
 * http://www.javabydefault.com/2014/11/publish-and-consume-messages-to.html
 */
@Component
public class QueuePublishProcess {

    public static final String QUEUE_NAME = "test.queue";

    @Autowired
    private AmqpAdmin admin;

    @Autowired
    private AmqpTemplate template;

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        QueuePublishProcess publisher = context.getBean(QueuePublishProcess.class);
        publisher.setup();
        publisher.publish();
    }

    private void setup() {
        Exchange exchange = DirectExchange.DEFAULT;
        boolean durable = true;

        for (int i = 1; i <= 5; i++) {
            String queueName = "test.queue." + i;
            Queue q = new Queue(queueName, durable, false, true);
            admin.declareQueue(q);
            BindingBuilder.bind(q).to(exchange).with(queueName);
            System.out.println("Bounded queue " + queueName);
        }
    }

    private void publish() throws Exception {
        for (int i = 0; i < 10; i++) {
            try {
                String sent = i + " Catch the rabbit! " + new Date();

                String queueName = generateQueueName();

                // write message
                template.convertAndSend(queueName, sent);
                System.out.println("Msg Sent to " + queueName + " :  " + sent);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String generateQueueName() {
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((5 - 1) + 1) + 1;
        return "test.queue." + randomNum;
    }
}
