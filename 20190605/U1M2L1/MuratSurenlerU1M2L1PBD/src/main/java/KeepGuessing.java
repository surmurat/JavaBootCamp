import java.util.Random;
import java.util.Scanner;

public class KeepGuessing {
    public static void main(String[] args) {
        Scanner keepScan = new Scanner(System.in);

        Random r =new Random();
        int x=1+r.nextInt(10);
        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
        int guess=0;
        while(guess!=x){
            System.out.print("Your guess: ");
            guess = keepScan.nextInt();
            if(guess==x){
                System.out.print("That's right!  You\'re a good guesser.");
            }else{
                System.out.println("That is incorrect. Guess again.");
            }
        }
    }
}
