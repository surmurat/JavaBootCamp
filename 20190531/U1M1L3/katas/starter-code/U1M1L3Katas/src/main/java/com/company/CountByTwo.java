import java.util.Scanner;

public class CountByTwo {
    public static void main(String[] args) {
        Scanner countByScan = new Scanner(System.in);
        System.out.println("Please enter a number!");

        int userInput = Integer.parseInt(countByScan.nextLine());

        for (int i = 2; i <= userInput; i++){
            System.out.println(i);
        }
    }
}
