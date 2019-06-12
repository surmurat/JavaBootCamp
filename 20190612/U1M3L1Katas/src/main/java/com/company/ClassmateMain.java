package com.company;

import java.util.ArrayList;
import java.util.List;

public class ClassmateMain {
    public static void main(String[] args) {

        List<Classmate> classmates = new ArrayList<>();

        Classmate perri = new Classmate("perri","black");
        Classmate michael = new Classmate("michael","blonde");
        Classmate maria = new Classmate("maria","black");
        Classmate eric = new Classmate("eric","black");
        Classmate amorita = new Classmate("amorita","black");

        classmates.add(perri);
        classmates.add(michael);
        classmates.add(maria);
        classmates.add(eric);
        classmates.add(amorita);

        for(Classmate element : classmates){
            System.out.println("My classmate " + element.getName() + " is " + element.getHairColor() + " " + "hair.");
        }


    }
}
