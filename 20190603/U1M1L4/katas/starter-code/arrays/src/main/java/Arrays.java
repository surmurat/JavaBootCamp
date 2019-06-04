import java.util.Scanner;

public class Arrays {




    public static void main(String[] args) {

        /*int[] arr = getArrayInput();
        System.out.println("MIN number => " + getMinNumber(arr));
        System.out.println("MAX number => " + getMaxNumber(arr));
        System.out.println("sum of => " + calcSum(arr));*/

        String[] [] newArr =
                {
                {"a","c","d"},
                {"e","f","g"},
                {"h","i","j"}
            };

        for(String[] element : newArr){
            for(String el : element){
                System.out.println(el + " ");
            }
        }


    }





}
