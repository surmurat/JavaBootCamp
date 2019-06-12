package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Total {

    public static void main(String[] args) {

        /*int [] numbers = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};

        int total = 0;

        for(int element : numbers) {
          total += element;
        }*/

        List<Integer> numbers = new ArrayList<>();

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

        int sum =0;

        while (iter.hasNext()){
            sum += iter.next();
        }


        System.out.println("The sum of all elements in the array is " + sum);

    }

}
