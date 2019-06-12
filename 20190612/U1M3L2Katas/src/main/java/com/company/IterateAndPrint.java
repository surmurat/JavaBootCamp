package com.company;

import java.util.*;

public class IterateAndPrint {

    public static void main(String[] args) {

        Map<String, String> baseballTeam = new HashMap<>();

        baseballTeam.put("Pitcher", "Mike Foltynewicz");
        baseballTeam.put("Catcher", "Brian McCann");
        baseballTeam.put("First Baseman", "Freddie Freeman");
        baseballTeam.put("Second Baseman", "Ozzie Albies");
        baseballTeam.put("Third Baseman", "Josh Donaldson");
        baseballTeam.put("Shortstop", "Dansby Swanson");
        baseballTeam.put("Left Fielder", "Ronald Acuna, Jr.");
        baseballTeam.put("Center Fielder", "Ender Inciarte");
        baseballTeam.put("Right Fielder", "Nick Markakis");



        Set<String> baseballKeys = baseballTeam.keySet(); // set for keys
        for (String key : baseballKeys) {
            System.out.println("Map: baseballTeam keys --     " + key);
        }
        Collection<String> baseballValues = baseballTeam.values(); // collection for values
        for (String values : baseballValues) {
            System.out.println("Map: baseballTeam values --    " + values);
        }
        Set<Map.Entry<String, String>> baseballEntries = baseballTeam.entrySet();
        // Map.Entry goes into each key and value in that given map ** with the use of a loop **
        for (Map.Entry<String, String> entry : baseballEntries) {
            System.out.println("Key --  " + entry.getKey() + "        Value --     "
                    + entry.getValue());
        }

    }

}