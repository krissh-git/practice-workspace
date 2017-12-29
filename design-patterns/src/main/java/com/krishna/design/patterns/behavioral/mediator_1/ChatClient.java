package com.krishna.design.patterns.behavioral.mediator_1;

public class ChatClient {

    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediatorImpl();

        User user = new UserImpl(chatMediator, "A");
        User user1 = new UserImpl(chatMediator, "B");
        User user2 = new UserImpl(chatMediator, "C");
        User user3 = new UserImpl(chatMediator, "D");

        chatMediator.addUser(user);
        chatMediator.addUser(user1);
        chatMediator.addUser(user2);
        chatMediator.addUser(user3);

        user.sendMessage("Hi");
    }
}
