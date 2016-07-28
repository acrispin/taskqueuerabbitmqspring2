/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anton.dev.tqrbs2.basic;

/**
 *
 * @author anton 
 * https://projects.spring.io/spring-amqp/#quick-start
 */
public class Foo {

    public void listen(String foo) {
        System.out.println("Recibiendo Spring: " + foo);
    }
}
