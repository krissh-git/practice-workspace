package com.krishna.creational.builder;

public class LunchOrderApp {

    public static void main(String[] args) {
        LunchOrder.Builder builder = new LunchOrder.Builder();

        LunchOrder lunchOrder = builder.bread("multi-grain").dressing("salad").meat("chicken").build();

        System.out.println(lunchOrder);
    }
}
