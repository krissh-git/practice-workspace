package com.krishna.msuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;


    public void send(String topic, User payload) {
        kafkaTemplate.send(topic, payload);
    }
}
