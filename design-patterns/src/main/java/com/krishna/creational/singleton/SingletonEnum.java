package com.krishna.creational.singleton;

public enum SingletonEnum {
    INSTANCE;

    public static SingletonEnum getInstance() {
        return INSTANCE;
    }
}
