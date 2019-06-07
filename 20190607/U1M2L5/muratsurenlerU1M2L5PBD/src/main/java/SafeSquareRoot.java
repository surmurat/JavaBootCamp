import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {

        Scanner safeScanner = new Scanner(System.in);

        System.out.println("SQUARE ROOT!");
        System.out.print("Enter a number: ");

        int num = safeScanner.nextInt();

        if(num < 0){
            do{
                System.out.println("You can\'t take the square root of a negative number, silly.");
                System.out.print("Try again: ");
                num = safeScanner.nextInt();
            }while(num<0);
        }
        double root=Math.sqrt(num);
        System.out.println("The square root of "+num+" is "+root);
        }

    }

