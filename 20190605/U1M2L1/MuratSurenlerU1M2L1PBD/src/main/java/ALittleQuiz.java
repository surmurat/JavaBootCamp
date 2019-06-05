

import java.util.Scanner;

public class ALittleQuiz {
    public static void main(String[] args) {

        Scanner quizScanner = new Scanner(System.in);
        int correct=0;
        System.out.println("Are you ready for a quiz?");
        char answer = quizScanner.next(".").charAt(0);

        if(answer == 'y'){
            System.out.println("Okay, here it comes!");
        }else {
            System.out.println("Please come back when you ready!");
            correct++;
        }

        System.out.println("Q1) What is the capital of Alaska?");

        System.out.println(          "1) Melbourne");
        System.out.println(          "2) Anchorage");
        System.out.println(          "3) Juneau");

        int qFirst = quizScanner.nextInt();

        if (qFirst == 3){
            System.out.println("That's right!");
        }else{
            System.out.println("Unfortunately you picked the wrong answer");
            correct++;
        }

        System.out.println("Q2) Can you store the value \"cat\" in a variable of type int?");
        System.out.println("1) yes");
        System.out.println("2) no");

        int  qSecond = quizScanner.nextInt();

        if(qSecond == 1){
            System.out.println("Sorry, \"cat\" is a string. ints can only store numbers.");
        }else {
            System.out.println("Yes, we can NOT store \"cat\" as a int!");
            correct++;
        }

        System.out.println("Q3) What is the result of 9+6/3?");
        System.out.println("1) 5");
        System.out.println("2) 11");
        System.out.println("3) 15/3");

        int qThird = quizScanner.nextInt();

        if(qThird == 1){
            System.out.println("That's correct!");
        }else {
            System.out.println("That's wrong! Please recalculate it!");
            correct++;
        }

        if (correct==3){
            System.out.println("Welldone! all of your answers are correct!");
        }else {
            System.out.println("Your score is  "+correct+" out of 3");
        }

        System.out.println("Thanks for playing!");


    }
}
