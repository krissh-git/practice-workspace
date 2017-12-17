package com.krishna.jpa.h2;

import com.krishna.jpa.h2.entities.User;
import com.krishna.jpa.h2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserEntityManagerCommandLineRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserEntityManagerCommandLineRunner.class);

    @Autowired
    private UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(UserEntityManagerCommandLineRunner.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info("Hello world");

        final Long aLong = userService.addUser(new User("krishna", "ADMIN"));
        LOGGER.info(aLong.toString());

        final User userById = userService.getUserById(aLong);
        LOGGER.info(userById.toString());

        userService.getUsers().forEach(System.out::print);


    }
}
