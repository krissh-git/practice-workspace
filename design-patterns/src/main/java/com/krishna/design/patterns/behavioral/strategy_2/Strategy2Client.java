package com.krishna.design.patterns.behavioral.strategy_2;

public class Strategy2Client {
    public static void main(String[] args) {
        Strategy[] strategies = new Strategy[]{new FooStrategySolution(), new BarStrategySearch()};
        for (Strategy strategy : strategies) {
            strategy.solve();
        }
    }
}
