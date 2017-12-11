package com.krishna.spring.boot.jpa.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("config")
@ConfigurationProperties(prefix = "app.data")
public class Configuration {

   private String dialect;

   @PostConstruct
   public void post(){
       System.out.println("Configuration created");
   }

    @Override
    public String toString() {
        return "Configuration{" +
                "dialect='" + dialect + '\'' +
                '}';
    }
}
