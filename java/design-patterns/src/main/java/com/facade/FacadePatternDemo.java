package com.facade;

/**
 * @author twistezo (01.04.2017)
 */
public class FacadePatternDemo {

    public static void main(String[] args) {
        Facade facade = new Facade();

        facade.drawRectangle();
        facade.drawSquare();
    }
}
