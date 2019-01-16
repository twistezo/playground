package com.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author twistezo (21.03.2017)
 */
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    int getState() {
        return state;
    }

    void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    void attach(Observer observer) {
        observers.add(observer);
    }

    void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
