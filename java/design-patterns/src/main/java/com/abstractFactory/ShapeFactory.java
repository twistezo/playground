package com.abstractFactory;

/**
 * @author twistezo (20.03.2017)
 */
class ShapeFactory extends AbstractFactory {

    Color getColor(String color) {
        return null;
    }

    Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }

        return null;
    }
}
