package com.observer;

/**
 * @author twistezo (21.03.2017)
 */
class HexObserver extends Observer {

    HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("Hex string: " + Integer.toHexString(subject.getState()));
    }
}
