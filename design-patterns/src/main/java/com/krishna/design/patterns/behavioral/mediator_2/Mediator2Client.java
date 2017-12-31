package com.krishna.design.patterns.behavioral.mediator_2;

import java.util.ArrayList;
import java.util.List;

public class Mediator2Client {

    public static void main(String[] args) {
        Mediator mediator = new Mediator();

        List<Thread> threadList = new ArrayList<>();

        threadList.add(new Thread(new Producer(mediator)));
        threadList.add(new Thread(new Producer(mediator)));
        threadList.add(new Thread(new Consumer(mediator)));
        threadList.add(new Thread(new Consumer(mediator)));

        threadList.forEach(Thread::start);
    }
}
