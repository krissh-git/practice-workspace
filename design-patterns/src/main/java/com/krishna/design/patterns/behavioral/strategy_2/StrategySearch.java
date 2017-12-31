package com.krishna.design.patterns.behavioral.strategy_2;

public abstract class StrategySearch implements Strategy {

    public void solve() {
        preProcess();
        while (!search()) {}
        postProcess();
    }

    protected abstract void postProcess();

    protected abstract boolean search();

    protected abstract void preProcess();
}
