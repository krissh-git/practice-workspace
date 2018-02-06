package com.krishna.creational.singleton;

import java.io.*;
import java.util.Objects;

public class SingletonEnumApp {

    private static String fileName = "file.ser";


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final SingletonEnum instance = SingletonEnum.getInstance();
        System.out.println(instance);
        equalityCheck(instance);

        serialization(instance);

    }

    private static void equalityCheck(SingletonEnum instance) {
        SingletonEnum instance2 = SingletonEnum.getInstance();
        System.out.println(instance2);
        System.out.println("Objects are equal?  " + Objects.equals(instance, instance2));
    }

    private static void serialization(SingletonEnum instance) throws IOException, ClassNotFoundException {
        serialize(instance);
        SingletonEnum deserialize = deserialize();
        System.out.println(deserialize);
        System.out.println("Objects are equal?  " + Objects.equals(instance, deserialize));
    }

    private static void serialize(SingletonEnum instance) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(instance);

        objectOutputStream.close();
        fileOutputStream.close();

    }

    private static SingletonEnum deserialize() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        SingletonEnum singleton = (SingletonEnum) objectInputStream.readObject();

        objectInputStream.close();
        fileInputStream.close();

        return singleton;
    }
}
