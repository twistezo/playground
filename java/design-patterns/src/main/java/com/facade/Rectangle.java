package com.facade;

/**
 * @author twistezo (01.04.2017)
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}
