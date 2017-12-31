package com.krishna.design.patterns.behavioral.strategy_2;

public class FooStrategySolution extends StrategySolution {
    private int state = 0;

    protected void stop() {
        System.out.println("FOO STOP");
    }

    protected boolean isSolution() {
        return state == 3;
    }

    protected boolean nextTry() {
        state += 1;
        System.out.println("Try #" + state);
        return true;
    }

    protected void start() {
        System.out.println("FOO START");
    }
}
