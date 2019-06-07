import java.util.Random;
import java.util.Scanner;

public class ShorterDoubleDice {
    public static void main(String[] args) {
        System.out.println("HERE COMES THE DICE!");
        System.out.println();

        Random shorterRandom = new Random();

        int roll1;
        int roll2;

        do{
            roll1= 1 + shorterRandom.nextInt(6);
            roll2= 1 + shorterRandom.nextInt(6);

            System.out.println("Roll #1: "+roll1);
            System.out.println("Roll #2: "+roll2);
            int sum = roll1+roll2;
            System.out.println("The total is "+sum+"!");
            System.out.println();

        }while(roll1!=roll2);


    }
}
