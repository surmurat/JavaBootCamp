package com.company.concreteapproach;

public class Square extends Shape {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void perimeter() {
        super.perimeter();
        System.out.println(4*getSide());
    }

    @Override
    public void area() {
        super.area();
        System.out.println(getSide()*2);
    }

}
