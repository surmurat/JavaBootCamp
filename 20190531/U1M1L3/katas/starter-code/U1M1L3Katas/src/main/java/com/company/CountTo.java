import java.util.Scanner;

public class CountTo {
    public static void main(String[] args) {

        Scanner countScan = new Scanner(System.in);
        System.out.println("Please enter a number!");

        int userInput = Integer.parseInt(countScan.nextLine());

        for (int i = 0; i <= userInput; i++){
            System.out.println(i);
        }
    }
}
