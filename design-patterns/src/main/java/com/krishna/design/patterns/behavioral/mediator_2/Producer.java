package com.krishna.design.patterns.behavioral.mediator_2;

public class Producer implements Runnable {

    private Mediator mediator;
    private int id;
    private static int num = 1;

    public Producer(Mediator mediator) {
        this.mediator = mediator;
        this.id = num++;
    }

    @Override
    public void run() {
        int num;
        while (true) {
            num = (int) (Math.random() * 100);
            mediator.storeMessage(num);
            System.out.println("P " + id + "-" + num);
        }
    }
}
