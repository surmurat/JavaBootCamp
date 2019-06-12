package com.company;

import java.util.*;

public class SwapAndPrintLink {

    public static void main(String[] args) {

        /*int [] numbers = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};

        System.out.println("----------------");
        System.out.println("Original Array");

        for(int element : numbers) {
            System.out.println(element);
        }

        int temp = numbers[0];
        numbers[0] = numbers[numbers.length - 1];
        numbers[numbers.length - 1] = temp;

        System.out.println("----------------");
        System.out.println("Swapped Array");

        for(int element : numbers) {
            System.out.println(element);
        }*/

        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(2);
        numbers.add(4);
        numbers.add(5);
        numbers.add(3);
        numbers.add(7);
        numbers.add(6);
        numbers.add(1);
        numbers.add(9);
        numbers.add(10);
        numbers.add(13);
        numbers.add(56);
        numbers.add(43);

        System.out.println(numbers);

        Iterator<Integer> iter = numbers.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }


        Collections.swap(numbers, 0,numbers.size()-1);
        System.out.println(numbers);


    }

}
