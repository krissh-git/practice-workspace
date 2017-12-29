package com.krishna.design.patterns.behavioral.mediator_1;

public interface ChatMediator {

    void addUser(User user);

    void sendMessage(String message,User user);

}
