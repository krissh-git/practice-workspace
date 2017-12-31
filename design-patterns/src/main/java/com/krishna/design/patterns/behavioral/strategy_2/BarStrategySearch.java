package com.krishna.design.patterns.behavioral.strategy_2;

public class BarStrategySearch extends StrategySearch {
    private int state = 0;

    protected void postProcess() {
        System.out.println("Post Process");
    }

    protected boolean search() {
        state += 1;
        System.out.println("Searching #"+state);
        return state == 3;
    }

    protected void preProcess() {
        System.out.println("Pre Process");

    }
}
