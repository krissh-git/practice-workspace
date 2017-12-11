package com.krishna.spring.boot.jpa.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
        final Configuration configuration = (Configuration) context.getBean("config");
        System.out.println(configuration.hashCode());
        System.out.println(configuration.toString());;
    }
}
