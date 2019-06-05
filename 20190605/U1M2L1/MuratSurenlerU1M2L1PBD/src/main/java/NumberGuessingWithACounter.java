import java.util.Random;
import java.util.Scanner;

public class NumberGuessingWithACounter {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        Random r = new Random();

        int guessCount = 1;
        int x=1+r.nextInt(10);
        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
        int guess=0;
        while(guess!=x){
            System.out.print("Your guess: ");
            guess = myScan.nextInt();
            if(guess==x){
                System.out.println("That's right!  You\'re a good guesser.");
                System.out.println("It only took you " + guessCount + " tries. ");

            }else{
                System.out.println("That is incorrect. Guess again.");
                guessCount++;

            }

        }
    }
}
