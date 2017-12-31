package com.krishna.design.patterns.behavioral.mediator_2;

public class Consumer implements Runnable {

    private Mediator mediator;
    private int id;
    private static int num = 1;

    public Consumer(Mediator mediator) {
        this.mediator = mediator;
        this.id = num++;
    }

    @Override
    public void run() {
        int num;
        while (true) {
            num = mediator.retrieveMessage();
            System.out.println("C " + id + "-" + num);
        }
    }
}
