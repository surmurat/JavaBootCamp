import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args) {
        Scanner loopScanner = new Scanner(System.in);

        System.out.println("What number would you like to count to?");
        String userInput= loopScanner.nextLine();
        int userNum = Integer.parseInt(userInput);

        for (int i = 1; i <= userNum; i++){
            System.out.println(i);
        }
    }
}
