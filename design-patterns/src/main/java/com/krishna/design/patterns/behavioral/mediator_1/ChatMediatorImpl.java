package com.krishna.design.patterns.behavioral.mediator_1;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {

    private List<User> userList;

    public ChatMediatorImpl() {
        this.userList = new ArrayList<User>();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void sendMessage(String message, User user) {
        userList.forEach(user1 -> {
            if (user1 != user) {
                user1.receiveMessage(message);
            }
        });
    }
}
