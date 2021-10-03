package com.motorola;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreeterMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.motorola");
        Greeter greeter = context.getBean(Greeter.class);

        System.out.println(greeter.welcomeGuest());
    }
}
