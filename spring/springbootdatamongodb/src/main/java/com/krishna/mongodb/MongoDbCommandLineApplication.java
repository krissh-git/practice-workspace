package com.krishna.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.stream.Collectors;


//@SpringBootApplication
public class MongoDbCommandLineApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoDbCommandLineApplication.class);
    }

    @Override
    public void run(String... strings) {
        userRepository.deleteAll();
        ;

        userRepository.save(new User("krishna"));
        userRepository.save(new User("moorthy"));

        userRepository.findAll().stream().map(User::getName).collect(Collectors.toList()).forEach(System.out::print);


    }
}
