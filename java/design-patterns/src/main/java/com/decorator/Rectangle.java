package com.decorator;

/**
 * @author twistezo (21.03.2017)
 */
class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
