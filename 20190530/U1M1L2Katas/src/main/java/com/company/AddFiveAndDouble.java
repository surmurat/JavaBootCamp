package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {

        Scanner addAndDoubleScanner = new Scanner(System.in);

        int firstNumber;

        System.out.println("Please enter first number");

        firstNumber = Integer.parseInt(addAndDoubleScanner.nextLine());

        int addAndDouble = (firstNumber + 5) *2;

        System.out.println(addAndDouble);
    }
}
