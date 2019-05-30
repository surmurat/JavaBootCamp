package com.company;

import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {
        Scanner averageScanner = new Scanner(System.in);

        float firstInput;
        float secondInput;
        float thirdInput;

        System.out.println("Please input first number");
        firstInput = Float.parseFloat(averageScanner.nextLine());

        System.out.println("Please enter second number");

        secondInput = Float.parseFloat(averageScanner.nextLine());

        System.out.println("Please enter third number");

        thirdInput = Float.parseFloat(averageScanner.nextLine());

        Float average = (firstInput + secondInput + thirdInput) / 3;

        System.out.printf("%.2f", average);


    }
}
