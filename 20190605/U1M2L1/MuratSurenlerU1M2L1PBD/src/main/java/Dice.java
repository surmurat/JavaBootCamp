import java.util.Random;

public class Dice {

    public static void main(String[] args) {
        Random r = new Random();

        System.out.println("HERE COMES THE DICE!");

        int first = (int)(Math.random() * 6 + 1);
        int second = (int)(Math.random() * 6 + 1);

        int total = first + second;

        System.out.println("Roll #1: " + first + "");
        System.out.println("Roll #1: " + second + "");
        System.out.println("The total is " + total + "!");

    }

}
