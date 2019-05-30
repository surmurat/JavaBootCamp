package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {

        Scanner subtractScanner = new Scanner(System.in);

        int firstNumber;
        int secondNumber;

        System.out.println("Please enter first number");

        firstNumber = Integer.parseInt(subtractScanner.nextLine());

        System.out.println("Please enter second number");

        secondNumber = Integer.parseInt(subtractScanner.nextLine());

        int subtract = firstNumber - secondNumber;

        System.out.println(subtract);


    }
}
