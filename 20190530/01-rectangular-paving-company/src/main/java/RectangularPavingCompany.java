import java.util.Scanner;

public class RectangularPavingCompany {
    public static void main(String[] args) {

        Scanner pavingCompany = new Scanner(System.in);

        int widthFeet;
        int lengthFeet;
        double costOfCement;
        double costOfFraming;


        System.out.println("What is width of driveway?");
        widthFeet = Integer.parseInt(pavingCompany.nextLine());

        System.out.println("What is length of driveway?");
        lengthFeet = Integer.parseInt(pavingCompany.nextLine());

        int area = widthFeet * lengthFeet;
        int  perimeter = (widthFeet + lengthFeet) * 2;
        double sF = widthFeet * lengthFeet;

        System.out.println("What is the cost of cement");
        costOfCement = Double.parseDouble(pavingCompany.nextLine());

        System.out.println("What is the cost of framing?");
        costOfFraming = Double.parseDouble(pavingCompany.nextLine());

        System.out.println("Area of the driveway is " + area + " " + "feet.");
        System.out.println("Perimeter size of driveway is " + perimeter + " " + "feet.");

        System.out.println("The cost of cement will $" + (costOfCement * sF) + " and framing will be $" + (costOfFraming * lengthFeet) + ".");


        //double cementCost = 12.5;  updated
        //double linearCost = 8.25;  modified

        //System.out.println("Total cost of cement is " + "$" +  cementCost * sF + " " + ".");
        //System.out.println("Total cos of framing is " + "$" + linearCost * lengthFeet + " " + ".");







    }
}
