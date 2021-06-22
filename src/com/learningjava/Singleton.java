package com.learningjava;

public class Singleton {
}

class Singleton1 {
    private static Singleton1 instance;

    private static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

    private Singleton1() {
    }
}

/**
 * 饿汉式
 */
class Singleton2 {
    private static Singleton2 instance=new Singleton2();
    private Singleton2(){}
    public static Singleton2 getInstance() {
        return instance;
    }
}
