import java.util.Scanner;

public class YourAgeCan {
    public static void main(String[] args) {

        Scanner ageCanScan = new Scanner(System.in);

        System.out.println("Please type your age!");
        int userInput = Integer.parseInt(ageCanScan.nextLine());


        if(userInput >= 18 && userInput <= 21){
            System.out.println("You can vote!");
        }else if(userInput >= 21 && userInput <= 35){
            System.out.println("You can drink alcohol!");
        }else if(userInput >= 35 && userInput <= 55){
            System.out.println("You can be president!");
        }else if(userInput >= 55 && userInput <= 65){
            System.out.println("You are eligible for AARP!");
        }else if(userInput >= 65 && userInput <= 80){
            System.out.println("You can be can retire!");
        }else if(userInput >= 80 && userInput <= 89){
            System.out.println("You are an octogenerian!");
        }else if(userInput >= 100){
            System.out.println("You are more than a century old");
        }
    }
}
