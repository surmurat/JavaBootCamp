package com.company.interfaces;

import com.company.interfaces.UserIO;


import java.util.Scanner;


public class Input implements UserIO {



    public int readInt(String prompt){
        System.out.printf(prompt);
        Scanner myScan = new Scanner(System.in);
        int userInt = myScan.nextInt();
        return userInt;

    }
    public long readLong(String prompt){
        System.out.println(prompt);
        Scanner lnScanner = new Scanner(System.in);
        long userLong = lnScanner.nextLong();
        return userLong;

    }
    public double readDouble(String prompt){
        System.out.println(prompt);
        Scanner dbScanner = new Scanner(System.in);
        double userDouble = dbScanner.nextDouble();
        return userDouble;

    }
    public float readFloat(String prompt){
        System.out.println(prompt);
        Scanner flscanner = new Scanner(System.in);
        float userFloat = flscanner.nextFloat();
        return userFloat;

    }
    public String readString(String prompt){
        System.out.println(prompt);
        Scanner stScanner = new Scanner(System.in);
        String userString = stScanner.nextLine();
        return userString;

    }
}
