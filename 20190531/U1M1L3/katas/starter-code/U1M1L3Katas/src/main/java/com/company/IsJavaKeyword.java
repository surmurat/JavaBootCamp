import java.util.Scanner;

public class IsJavaKeyword {
    public static void main(String[] args) {

        Scanner keywordScanner = new Scanner(System.in);

        String keyword1 = "integer";
        String keyword2 = "boolean";
        String keyword3 = "class";
        String keyword4 = "float";
        String keyword5 = "void";
        String keyword6 = "else";

        System.out.println("Please enter a Java keyword?");
        String userInput = keywordScanner.nextLine();

        if (userInput.equals(keyword1)){
            System.out.println("Yes, integer is a Java keyword");
        }else if(userInput.equals(keyword2)){
            System.out.println("Yes, boolean is a Java keyword");
        }else if(userInput.equals(keyword3)){
            System.out.println("Yes, class is a Java keyword");
        }else if(userInput.equals(keyword4)){
            System.out.println("Yes, float is a Java keyword");
        }else if(userInput.equals(keyword5)){
            System.out.println("Yes, void is a Java keyword");
        }else if(userInput.equals(keyword6)){
            System.out.println("Yes, else is a Java keyword");
        }else {
            System.out.println(userInput + " is NOT on the list or you pick the wrong one");
        }
    }
}
