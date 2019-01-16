package com.abstractFactory;

/**
 * @author twistezo (20.03.2017)
 */
public abstract class AbstractFactory {

    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}
