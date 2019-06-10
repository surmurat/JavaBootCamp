import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("please a number between 1 and 10");
        int userInput = Integer.parseInt(myScanner.nextLine());


        while(userInput < 1 || userInput >10){

            System.out.println("You must enter a number between 1 and 10, please try again.");
            userInput = myScanner.nextInt();
            }
        System.out.println("\nYou entered: "+userInput);
        }
    }

