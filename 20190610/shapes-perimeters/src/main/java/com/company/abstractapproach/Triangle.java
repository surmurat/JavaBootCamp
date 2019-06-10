package com.company.abstractapproach;



public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    @Override
    public void area() {

        double p = (getSideA()+getSideB()+getSideC())/2;
        double a = Math.sqrt(p * (p - sideA) * (p - sideB) * (p-sideC));
        System.out.println(a);

    }


    @Override
    public void perimeter() {
        System.out.println(getSideA()+getSideB()+getSideC());
    }
}
