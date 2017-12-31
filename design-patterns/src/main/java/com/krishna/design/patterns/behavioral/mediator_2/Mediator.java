package com.krishna.design.patterns.behavioral.mediator_2;

public class Mediator {

    private boolean isSlotFull;
    private int number;

    public synchronized void storeMessage(int num) {

        while (isSlotFull) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isSlotFull = true;
        number = num;
        notifyAll();
    }


    public synchronized int retrieveMessage(){
        while (!isSlotFull){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isSlotFull = false;
        notifyAll();
        return number;
    }
}
