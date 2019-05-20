package com.study.week2;

public class FactoryTest {
    public static void main(String[] args) {
        Shape cricle = ShapeFactory.getCircleInstance();
        cricle.draw();

        Shape rectangle = ShapeFactory.getRectangleIstance();
        rectangle.draw();
    }
}
