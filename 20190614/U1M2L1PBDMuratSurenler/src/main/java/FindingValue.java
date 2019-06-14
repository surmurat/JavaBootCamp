import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FindingValue {

    public static void main(String[] args) {

        List<Integer> arrList = new ArrayList<>();
        Random random = new Random();
        Scanner myScanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            arrList.add(random.nextInt(50)+1);
        }
        System.out.println("ArrayList: " + arrList);
        System.out.println("Value to find ");
        String userInput = myScanner.nextLine();
        int userNum = Integer.parseInt(userInput);

        for(int i = 0; i < 10; i++){
            if (arrList.get(i) == userNum){
                System.out.println(userInput + " is in the array");
            }
        }
    }

}
