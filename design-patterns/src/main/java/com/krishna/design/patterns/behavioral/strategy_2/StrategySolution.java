package com.krishna.design.patterns.behavioral.strategy_2;

public abstract class StrategySolution implements Strategy {

    public void solve() {

        start();
        while (nextTry() && !isSolution()) {}
        stop();
    }

    protected abstract void stop();

    protected abstract boolean isSolution();

    protected abstract boolean nextTry();

    protected abstract void start();


}
