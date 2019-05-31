import java.util.Scanner;

public class LuxuryTaxCalculator {
    public static void main(String[] args) {

        Scanner taxScanner = new Scanner(System.in);

        double firstPlayer;
        double secondPlayer;
        double thirdPlayer;

        System.out.println("Please enter first player spending");

        firstPlayer = Double.parseDouble(taxScanner.nextLine());

        System.out.println("Please enter second player spending");

        secondPlayer = Double.parseDouble(taxScanner.nextLine());

        System.out.println("Please enter third player spending");

        thirdPlayer = Double.parseDouble(taxScanner.nextLine());

        double spending = firstPlayer + secondPlayer + thirdPlayer;

        double budget = 40.000000;
        double tax = (spending - 40000000) * 0.18;

        if (spending > budget) {
            System.out.printf("There is outstanding tax balance of %.2f", tax);
        }


    }
}
