import java.util.Scanner;

public class UltimateQuestion {
    public static void main(String[] args) {
        Scanner ultimateScanner = new Scanner(System.in);

        System.out.println("Please enter a number between 1 - 100!");
        int userInput = Integer.parseInt(ultimateScanner.nextLine());
        int secretNumber = 42;

        if (userInput == secretNumber){
            System.out.println("Great! you found the secret number!");
        }else{
            System.out.println("I think you are getting closer the secret number");
        }


    }
}
