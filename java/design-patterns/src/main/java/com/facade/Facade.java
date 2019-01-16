package com.facade;

/**
 * @author twistezo (01.04.2017)
 */
class Facade {
    private Shape rectangle;
    private Shape square;

    Facade() {
        rectangle = new Rectangle();
        square = new Square();
    }

    void drawRectangle() {
        rectangle.draw();
    }

    void drawSquare() {
        square.draw();
    }
}
