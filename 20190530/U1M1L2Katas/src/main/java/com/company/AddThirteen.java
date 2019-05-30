package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {

        Scanner addThirteenScanner = new Scanner(System.in);

        int firstNumber;

        firstNumber = Integer.parseInt(addThirteenScanner.nextLine());

        System.out.println(firstNumber + 13);

    }
}
