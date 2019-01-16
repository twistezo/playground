package com.decorator;

/**
 * @author twistezo (21.03.2017)
 */
class ShapeDecorator implements Shape {
    Shape decoratedShape;

    ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
