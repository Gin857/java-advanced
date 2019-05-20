package com.study.week2;

public class ShapeFactory {
    public static Shape getCircleInstance(){
        return new Circle();
    }
    public  static Shape getRectangleIstance(){
        return new Rectangle();
    }
}
