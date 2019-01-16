package com.singleton;

/**
 * @author twistezo (22.03.2017)
 */
class Singleton {
    private static Singleton getInstance = new Singleton();

    private Singleton() { }

    static Singleton getInstance() {
        return getInstance;
    }

    void showMessage() {
        System.out.println("Hello world from Singleton");
    }

}
