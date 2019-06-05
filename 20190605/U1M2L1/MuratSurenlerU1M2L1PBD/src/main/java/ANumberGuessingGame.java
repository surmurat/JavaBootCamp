import java.util.Scanner;

public class ANumberGuessingGame {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        int first = (int)(Math.random() * 9 + 1);
        System.out.println("I'm thinking of a number from 1 to 10.");
        int firstGuess = myScanner.nextInt();

        if(first == firstGuess){
            System.out.println("That's great you found it!");
        }else {
            System.out.println("I'm sorry " + firstGuess + " is not the correct! my number is " + first + "!");
        }

        int second = (int)(Math.random() * 9 + 1);
        System.out.println("I'm thinking of a number from 1 to 10.");
        int secondGuess = myScanner.nextInt();

        if(second == secondGuess){
            System.out.println("That's great you found it!");
        }else {
            System.out.println("I'm sorry " + secondGuess + " is not the correct! my number is " + second + "!");
        }

        int third = (int)(Math.random() * 9 + 1);
        System.out.println("I'm thinking of a number from 1 to 10.");
        int thirdGuess = myScanner.nextInt();

        if(third == thirdGuess){
            System.out.println("That's great you found it!");
        }else {
            System.out.println("I'm sorry " + thirdGuess + " is not the correct! my number is " + third + "!");
        }


    }
}
