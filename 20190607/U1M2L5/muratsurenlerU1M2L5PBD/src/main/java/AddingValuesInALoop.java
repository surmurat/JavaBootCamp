import java.util.Scanner;

public class AddingValuesInALoop {
    public static void main(String[] args) {
        Scanner loopScanner = new Scanner(System.in);
        System.out.println("I will add up the numbers you give me.");
        int num = 0;
        int sum = 0;
        System.out.print("Number: ");

        num = loopScanner.nextInt();
        sum=num+sum;

        while(num!=0){
            System.out.println("The total so far is "+sum+".");
            System.out.print("Number: ");
            num = loopScanner.nextInt();
            sum=num+sum;
        }
        System.out.println();
        System.out.println("The total is "+sum+".");


    }
}
