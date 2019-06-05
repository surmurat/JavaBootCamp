import java.util.Scanner;

public class SpaceBoxing {
    public static void main(String[] args) {

        Scanner boxScan = new Scanner(System.in);

        System.out.println("Please enter your current earth weight: ");
        float weight = Float.parseFloat(boxScan.nextLine());

        System.out.println("I have information for the following planets:");
        System.out.println("       1. Venus   2. Mars    3. Jupiter");
        System.out.println("       4. Saturn  5. Uranus  6. Neptune");

        System.out.println("Which planet are you visiting?");
        int planet = Integer.parseInt(boxScan.nextLine());

        double planetWeight = 0.00;

        switch (planet) {
            case 1:
                planetWeight = weight * 0.78;
                break;
            case 2:
                planetWeight = weight * 0.39;
                break;
            case 3:
                planetWeight = weight * 2.65;
                break;
            case 4:
                planetWeight = weight * 1.17;
                break;
            case 5:
                planetWeight = weight * 1.05;
                break;
            case 6:
                planetWeight = weight * 1.23;
                break;
            default:
                System.out.println("Please chose valid planet");
        }

        System.out.println("Your weight would be " + planetWeight + " pounds on that planet.");

    }
}
