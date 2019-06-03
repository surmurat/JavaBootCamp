package com.company;
import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("What is the width of the driveway in feet? ");
        int width = Integer.parseInt(scan.nextLine());

        System.out.print("What is the length of the driveway in feet? ");
        int length = Integer.parseInt(scan.nextLine());

        float cementCost = 0.0f;
        float framingCost = 0.0f;

        System.out.print("What is the cost of cement per square foot? ");
        cementCost = Float.parseFloat(scan.nextLine());

        System.out.print("What is the cost of framing/footers per linear foot? ");

        //framingCost was defined as cementCost now it is changed to as its needed.
        framingCost = Float.parseFloat(scan.nextLine());

        int area = length * width;

        //perimeter operator changed to as addition, it was subtraction.
        int perimeter = 2*length + 2*width;

        System.out.format("The area of the driveway is %d square feet.%n", area);
        System.out.format("The perimeter of the driveway is %d square feet.%n", perimeter);

        //formatting issue solved
        System.out.format("The cost of the cement is $%.2f%n", area*cementCost);

        //calculating the cost of frame operator is changed to * from +, and also formatting issue solved too.
        System.out.format("The cost of the framing/footers is $%.2f%n", perimeter*framingCost);
    }
}
