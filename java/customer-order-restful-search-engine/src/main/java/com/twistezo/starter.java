package com.twistezo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

import javax.persistence.Persistence;

/**
 * @author twistezo (22.02.2017)
 */

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class starter {

    public static void main(String[] args) {
        SpringApplication.run(starter.class, args);

        /*
        Creating for Intellij Hibernate Console working (Persistence plugin)
         */
        Persistence.createEntityManagerFactory("myPresistenceUnit");
    }

}
