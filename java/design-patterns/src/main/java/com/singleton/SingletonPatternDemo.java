package com.singleton;

/**
 * @author twistezo (22.03.2017)
 */
class SingletonPatternDemo {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();
    }
}
