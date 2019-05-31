import java.util.Scanner;

public class CountByThirteen {
    public static void main(String[] args) {
        Scanner countThirteeScan = new Scanner(System.in);
        System.out.println("Please enter a number!");

        int userInput = Integer.parseInt(countThirteeScan.nextLine());

        for (int i = 13; i <= userInput; i++){
            System.out.println(i);
        }
    }
}
