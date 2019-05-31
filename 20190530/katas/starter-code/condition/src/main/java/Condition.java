import java.sql.SQLOutput;
import java.util.Scanner;

public class Condition {
    public static void main(String[] args) {

        Scanner myScan = new Scanner(System.in);

        int userInt;
        String userInput;

        do{
            System.out.println("Enter a number between 1 to 10.");
            userInput = myScan.nextLine();
            userInt = Integer.parseInt(userInput);
        } while (userInt < 1 && userInt > 10);



    }
}
