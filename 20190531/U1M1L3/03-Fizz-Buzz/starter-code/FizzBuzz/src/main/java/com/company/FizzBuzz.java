import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {

        Scanner fizzScanner = new Scanner(System.in);

        System.out.println("Please enter a number between 1 and 100!");
        int userInput = Integer.parseInt(fizzScanner.nextLine());

        for (int i=0; i <=100; i++){
            if(i%3==0 && i%5==0){
                System.out.println("Fizz");
            }else if(i%5==0){
                System.out.println("Buzz");
            }else if(i%3==0){
                System.out.println("FizzBuzz");
            }
        }
    }
}
