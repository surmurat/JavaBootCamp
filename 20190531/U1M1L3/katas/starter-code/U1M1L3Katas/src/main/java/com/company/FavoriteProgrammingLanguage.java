import java.util.Scanner;

public class FavoriteProgrammingLanguage {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter your favorite programing language!");
        String userInput = myScanner.nextLine();



        switch (userInput) {

            case "Java":
            case "java":
                System.out.println("That's what I was looking for! Java is definitely the answer!");
                break;
            case "html":
                System.out.println("That's not what I was looking for!");
                break;
            case "css":
                System.out.println("Not this one too!");
                break;
            case "node.js":
                System.out.println("Try again");
                break;
            default:
                System.out.println("Not Found!");


        }

    }
}
