import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args) {

        Scanner wordScanner = new Scanner(System.in);

        System.out.print("Enter 5 words: ");

        String newArray[] = new String[5];

        for(int i=0; i<5;i++) {

            newArray[i]=wordScanner.nextLine();
        }

        for(int i=0;i<5;i++){
            System.out.println("Array words are :" + newArray[i]);

        }



    }
}
