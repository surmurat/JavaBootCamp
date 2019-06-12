package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WordList {

    public static void main(String[] args) {

        /*String[] wordList = {"byte", "case", "catch", "class", "const", "continue", "do", "double", "else", "extends"};

        for(String element : wordList) {
            System.out.println(element);
        }*/

        List<String> words = new ArrayList<>();

        words.add("byte");
        words.add("case");
        words.add("catch");
        words.add("class");
        words.add("const");
        words.add("continue");
        words.add("do");
        words.add("double");
        words.add("else");
        words.add("extends");

        System.out.println(words);

        Iterator<String> iter = words.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println("words of array");


    }

}
