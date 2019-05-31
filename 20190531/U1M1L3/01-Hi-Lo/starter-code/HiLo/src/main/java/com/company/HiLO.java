import java.util.Random;
import java.util.Scanner;

public class HiLO {
    public static void main(String[] args) {
        System.out.println("Welcome to Hi-Low!");

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please put your name!");
        String name = myScanner.nextLine();

        System.out.format("OK, %s, here are the rules:%n", name);

        Random random = new Random();
        int rollValue = random.nextInt(100) + 1;

        int numberOfGuess = 0;
        int userGuess = 0;
        int userInt;
        boolean correctGuess = false;

        //userInt = Integer.parseInt(userGuess);

        while(!correctGuess) {
            numberOfGuess++;
            System.out.println("Enter your guess!");
            userGuess = myScanner.nextInt();

            if (userGuess > rollValue) {
                System.out.println("Too High");
            } else if (userGuess < rollValue) {
                System.out.println("Too Low");
            } else{
                correctGuess = true;
            }
        }
        System.out.format("Congratulations, %s! You win!%n", name);
        System.out.format("It took you %d guesses to find my number!%n", numberOfGuess);
    }
}
