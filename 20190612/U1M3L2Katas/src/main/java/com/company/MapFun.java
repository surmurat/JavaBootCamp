package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapFun {
    public static void main(String[] args) {


        HashMap<String, Integer> myCars = new HashMap<>();

        myCars.put("Toyota Camry", 2012);
        myCars.put("Chevy Camero", 1969);
        myCars.put("Hyundai Genesis", 2015);
        myCars.put("Jeep Wrangler", 2006);
        myCars.put("Honda Civic", 2018);
        myCars.put("Toyota Supra", 1995);
        myCars.put("Pontiac GTO", 1964);

        Set<Map.Entry<String, Integer>> myEntries =myCars.entrySet();

        for(Map.Entry<String, Integer> entry : myEntries){
            System.out.println("Key - " + entry.getKey() + " - Value " + entry.getValue());
        }
        // Add Two new entries to the Map
        myCars.put("Ford Explorer", 2012);
        myCars.put("Smart ForTwo", 2013);

        for(Map.Entry<String, Integer> entry : myEntries){
            System.out.println("Key after  - " + entry.getKey() + " - Value " + entry.getValue());
        }

        myCars.remove("Jeep Wrangler");

        for(Map.Entry<String, Integer> entry : myEntries){
            System.out.println("Key after remove - " + entry.getKey() + " - Value " + entry.getValue());
        }




    }
}
