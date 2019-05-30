package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    public static void main(String[] args) {

        Scanner doubleAndAddScanner = new Scanner(System.in);

        int firstNumber;

        System.out.println("Please enter first number");

        firstNumber = Integer.parseInt(doubleAndAddScanner.nextLine());

        int doubleAndAdd = (firstNumber * 2) + 5;

        System.out.println(doubleAndAdd);




    }
}
