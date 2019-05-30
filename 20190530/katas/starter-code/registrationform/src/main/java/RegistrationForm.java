import java.util.Scanner;

public class RegistrationForm {

    public static void main(String[] args) {

        Scanner registrationForm = new Scanner(System.in);

        String firstName;
        String lastName;
        String email;
        String twitterHandle;
        int age;
        String country;
        String profession;
        String system;
        String language;
        String scientist;
        String shortcut;
        String builtPc;
        String superhero;

        System.out.println("What is your first name?");
        firstName = registrationForm.nextLine();

        System.out.println("What is your last name?");
        lastName = registrationForm.nextLine();

        System.out.println("What is your email?");
        email = registrationForm.nextLine();

        System.out.println("What is your Twitter handle?");
        twitterHandle = registrationForm.nextLine();

        System.out.println("What is your age?");
        age = Integer.parseInt(registrationForm.nextLine());

        System.out.println("What is your country?");
        country = registrationForm.nextLine();

        System.out.println("What is your profession?");
        profession = registrationForm.nextLine();

        System.out.println("What is your favorite operating system?");
        system = registrationForm.nextLine();

        System.out.println("What is your favorite programming language?");
        language = registrationForm.nextLine();

        System.out.println("What is your favorite computer scientist?");
        scientist = registrationForm.nextLine();

        System.out.println("What is your favorite keyboard shortcut?");
        shortcut = registrationForm.nextLine();

        System.out.println("Have you ever built your own computer?");
        builtPc = registrationForm.nextLine();

        System.out.println("If you could be any superhero, who would it be?");
        superhero = registrationForm.nextLine();




    }
}
