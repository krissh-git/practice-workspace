package com.krishna.creational.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Serializable ,Cloneable{

    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public Object readResolve() throws ObjectStreamException {
        return instance;
    }

    public Object writeReplace() throws ObjectStreamException {
        return instance;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
