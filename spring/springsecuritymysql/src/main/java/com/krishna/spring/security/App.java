package com.krishna.spring.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class App {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        System.out.println(bCryptPasswordEncoder.encode("krishna@123"));
//        System.out.println(bCryptPasswordEncoder.encode("moorthy@123"));

        System.out.println(bCryptPasswordEncoder.matches("krishna@123","$2a$10$0thNwVljwc64rVnIcBFGW.ECbah9/U3SyqJL8Zlusc82ygmWBbakO"));
        System.out.println(bCryptPasswordEncoder.matches("moorthy@123","$2a$10$GedZ5GC63Q90tn9Mgyalye6TPptoINim9wKo0x7Ei5/nvffiNjhva"));

    }
}
