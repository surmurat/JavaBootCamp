import java.util.Random;
import java.util.Scanner;

public class HiLoWithLimitedTries {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int x = 1+r.nextInt(100);

        int tries=1;
        System.out.println("I\'m thinking of a number between 1-100.  You have 7 tries.");
        int guess=0;
        while(x!=guess && tries<=7){
            System.out.print("Guess #"+(tries++)+": ");
            guess = s.nextInt();

            if(x==guess){
                System.out.println("You guessed it!  What are the odds?!?");
                break;
            }
            else if(x>guess && tries<=7){
                System.out.println("Sorry, you are too low.");
            }else if(x<guess && tries<=7){
                System.out.println("Sorry, you are too high.");
            }
        }if(tries>=7 && x!=guess){
            System.out.println("Sorry, you didn\'t guess it in 7 tries. You lose.");
        }
    }
}
