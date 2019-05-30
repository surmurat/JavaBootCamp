package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {

        Scanner multiplyScanner = new Scanner(System.in);

        int firstNumber;
        int secondNumber;
        int thirdNumber;

        firstNumber = Integer.parseInt(multiplyScanner.nextLine());

        System.out.println("Please enter first number");

        secondNumber = Integer.parseInt(multiplyScanner.nextLine());

        System.out.println("Please enter first number");

        thirdNumber = Integer.parseInt(multiplyScanner.nextLine());

        System.out.println("Please enter first number");

        int multiply = firstNumber * secondNumber * thirdNumber;

        System.out.println(multiply);



    }
}