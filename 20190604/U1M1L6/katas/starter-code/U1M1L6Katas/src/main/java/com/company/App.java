package com.company;

import java.security.PublicKey;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        int[] testArray = {34,45,11,1,78};
        System.out.println("Second largest number is : " + secondLargestNumber(testArray));

        int[] testArr = {1,2,3,4,5,6};

        String[] conArr = {"foo", "bar", "baz"};



        for(int i = testArr.length-1; i>=0; i--){
            System.out.println("Reverse array looks like this: " + testArr[i]);
        }

        System.out.println("Sum of the array is: " + total(testArr));

        System.out.println("Total sum of even number is: " + totalOdd(testArr));

        System.out.println("Total sum of odd number is: " + totalEven(testArr));

        String concat = concatenateString(conArr);
        System.out.println(" The concatenated Sting of all the items in the array is: "+ concat);


        String[] concatArr = {"foo", "bar", "baz", "qux"};
        String[] swapFirstLast = swapFirstAndLast(concatArr);
        System.out.println(" The new array with the Last item and the first item swapped is: " + Arrays.toString(swapFirstLast));






    }

    public static int secondLargestNumber(int[] arr) {

        // Declare initial values for the method.
        int[] sortArray = arr;
        int arrayNum;

        //Algorithm that sorts array inputted by user.

        for (int i = 1; i < sortArray.length; i++) {
            for (int q = i; q > 0; q--) {
                if (sortArray[q] < sortArray[q - 1]) {
                    arrayNum = sortArray[q];
                    sortArray[q] = sortArray[q - 1];
                    sortArray[q - 1] = arrayNum;
                }

            }
        }

        for (int element : sortArray) {
            System.out.println(element);
        }

        //These two variables are for determining the second highest number of the array after it has been sorted.
        int arraySize = sortArray.length;
        int secondLargest = sortArray[arraySize-2];

        return secondLargest;
    }

    public static int[] reverse(int[] arr){


        for(int i=0; i<arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length -i -1];
            arr[arr.length -i -1] = temp;

        }
        return arr;
    }


    public static int total(int[] arr){

        int sum=0;
        for(int element : arr){
            sum += element;
        }
        return sum;
    }

    public static int totalOdd(int[] arr){
        int totalSum = 0;

        for(int i=0; i < arr.length; i++){
            int odd=i%2;
            if(odd !=0){
                totalSum += arr[i];
            }

        }
        return totalSum;
    }

    public static int totalEven(int[] arr){
       int evenSum = 0;

        for(int i=0; i < arr.length; i++){
            int odd=i%2;
            if(odd ==0){
                evenSum += arr[i];
            }
        }

        return evenSum;
    }

    public static String concatenateString(String[] arr){
        String j="";
        for( int i = 0; i < arr.length; i++){
            j += arr[i];
        }
        return j;
    }

    public static String[] swapFirstAndLast(String[] arr){
        String temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length-1] = temp;
        return arr;
    }







    }








