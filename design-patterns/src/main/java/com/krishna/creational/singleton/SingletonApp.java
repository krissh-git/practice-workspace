package com.krishna.creational.singleton;

import java.io.*;
import java.util.Objects;

public class SingletonApp {


    private static String fileName = "file.ser";

    public static void main(String[] args) throws  CloneNotSupportedException {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);

//        equalityCheck(instance);
//        serialization(instance);

        Singleton instance2 = (Singleton) instance.clone();
        System.out.println(instance2);
        System.out.println("Objects are equal?  "+ Objects.equals(instance,instance2));


    }

    private static void equalityCheck(Singleton instance) {
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance2);
        System.out.println("Objects are equal?  "+ Objects.equals(instance,instance2));
    }

    private static void serialization(Singleton instance) throws IOException, ClassNotFoundException {
        serialize(instance);
        Singleton deserialize = deserialize();
        System.out.println(deserialize);
        System.out.println("Objects are equal?  "+ Objects.equals(instance,deserialize));
    }

    private static void serialize(Singleton instance) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(instance);

        objectOutputStream.close();
        fileOutputStream.close();

    }

    private static Singleton deserialize() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Singleton singleton = (Singleton) objectInputStream.readObject();

        objectInputStream.close();
        fileInputStream.close();

        return singleton;
    }
}
