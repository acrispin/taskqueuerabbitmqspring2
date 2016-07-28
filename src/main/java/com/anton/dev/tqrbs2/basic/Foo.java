/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anton.dev.tqrbs2.basic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author anton 
 * https://projects.spring.io/spring-amqp/#quick-start
 */
public class Foo {
    
    private static final Logger LOGGER = LogManager.getLogger(Foo.class);

    public void listen(String foo) {
        LOGGER.info("Recibiendo Spring: " + foo);
    }
}
