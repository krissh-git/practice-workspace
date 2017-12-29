package com.krishna.design.patterns.behavioral.mediator_1;

public class UserImpl extends User {

    public UserImpl(ChatMediator chatMediator, String name) {
        super(chatMediator, name);
    }

    @Override
    void sendMessage(String message) {
        System.out.println(name + " sending message " + message);
        chatMediator.sendMessage(message, this);
    }

    @Override
    void receiveMessage(String message) {
        System.out.println(name + " received message " + message);
    }
}
