import java.util.Scanner;

public class ArrayFunUserArray {



    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("please enter 5 numbers");

        int newArray[] = new int[5];

        for(int i=0; i<5;i++) {

            newArray[i]=myScanner.nextInt();
        }

        for(int i=0;i<5;i++){
            System.out.println("Array values are :" + newArray[i]);

        }







    }
}
