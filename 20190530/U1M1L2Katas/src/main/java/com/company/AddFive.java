package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {

        Scanner addScanner = new Scanner(System.in);

        int firstNumber;
        int secondNumber;
        int thirdNumber;
        int fourthNumber;
        int fifthNumber;

        System.out.println("Please enter first number");

        firstNumber = Integer.parseInt(addScanner.nextLine());

        System.out.println("Please enter second number");

        secondNumber = Integer.parseInt(addScanner.nextLine());

        System.out.println("Please enter third number");

        thirdNumber = Integer.parseInt(addScanner.nextLine());

        System.out.println("Please enter fourth number");

        fourthNumber = Integer.parseInt(addScanner.nextLine());

        System.out.println("Please enter fifth number");

        fifthNumber = Integer.parseInt(addScanner.nextLine());


        int sum = firstNumber + secondNumber + thirdNumber + fourthNumber + fifthNumber;

        System.out.println(sum);
    }
}
