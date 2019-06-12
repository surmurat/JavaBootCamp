package com.company;

import java.util.*;

public class CarLists {

    public static void main(String[] args) {

        Car camry = new Car("Toyota", "Camry");
        Car corolla = new Car("Toyota", "Corolla");
        Car highlander = new Car("Toyota", "Highlander");

        Car mustang = new Car("Ford", "Mustang");
        Car fusion = new Car("Ford", "Fusion");
        Car taurus = new Car("Ford", "Taurus");

        Car accord = new Car("Honda", "Accord");
        Car civic = new Car("Honda", "Civic");
        Car fit = new Car("Honda", "Fit");

       List<Car> toyotaList = new ArrayList<>();

       toyotaList.add(camry);
        toyotaList.add(camry);
        toyotaList.add(camry);


        List<Car> fordList = new ArrayList<>();
        fordList.add(mustang);
        fordList.add(fusion);
        fordList.add(taurus);

        List<Car> hondaList = new ArrayList<>();
        hondaList.add(accord);
        hondaList.add(civic);
        hondaList.add(fit);

        Map<String, List<Car>> newMap = new HashMap<>();
        newMap.put(camry.getMake(), toyotaList);
        newMap.put(mustang.getMake(), fordList);
        newMap.put(accord.getMake(), hondaList);
        Set<Map.Entry<String, List<Car>>> newEntry = newMap.entrySet();
        for (Map.Entry<String, List<Car>> element : newEntry) {
            for(Car carList: element.getValue()){
                System.out.println("Make: "+ carList.getMake()+ " , Model: "+ carList.getModel());
            }
        }

    }
}
