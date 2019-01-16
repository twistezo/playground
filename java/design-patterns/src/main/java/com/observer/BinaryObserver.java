package com.observer;

/**
 * @author twistezo (21.03.2017)
 */
class BinaryObserver extends Observer {

    BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("Binary string: " + Integer.toBinaryString(subject.getState()));
    }
}
