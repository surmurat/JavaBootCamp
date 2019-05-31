import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {

        Scanner evenScanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int userInput = evenScanner.nextInt();

        if(userInput % 2 == 0)
            System.out.println(userInput + " is even");
        else
            System.out.println(userInput + " is odd");
    }
}
