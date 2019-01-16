package com.observer;

/**
 * @author twistezo (21.03.2017)
 */
abstract class Observer {
    Subject subject;
    abstract void update();
}
