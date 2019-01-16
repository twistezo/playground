package com.observer;

/**
 * @author twistezo (21.03.2017)
 */
class OctalObserver extends Observer {

    OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    void update() {
        System.out.println("Octal string: " + Integer.toOctalString(subject.getState()));

    }
}
