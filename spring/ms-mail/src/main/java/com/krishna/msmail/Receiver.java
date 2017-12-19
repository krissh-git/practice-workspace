package com.krishna.msmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Receiver {

    @Autowired
    private EmailService emailService;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @KafkaListener(topics = "${spring.kafka.topic.user-created}")
    public void receive(UserDto userDto) {
        emailService.sendSimpleMessage(userDto);
        countDownLatch.countDown();
    }

}
