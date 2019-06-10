package com.company.abstractapproach;



public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void area() {

        System.out.println(getRadius() * getRadius() * Math.PI);

    }

    @Override
    public void perimeter() {

        System.out.println(2 * Math.PI * getRadius());
    }
}
