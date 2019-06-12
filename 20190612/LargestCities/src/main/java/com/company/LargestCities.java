package com.company;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LargestCities {
    public static void main(String[] args) {

        //creating objects using city class
        City newYork = new City("New York", 8654321);
        City losAngeles = new City("Los Angeles", 4563218);
        City chicago = new City( "Chicago", 2716520);
        City denver = new City("Denver", 704621);
        City desMoines = new City("Des Moines", 217521);
        City atlanta = new City("Atlanta", 486213);

        Map<String, City> cities = new HashMap<>();

        //creating list of city
        cities.put("New York", newYork);
        cities.put("California", losAngeles);
        cities.put("Illinois", chicago);
        cities.put("Colorado", denver);
        cities.put("Iowa", desMoines);
        cities.put("Georgia", atlanta);

        //entering user input with Scanner
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter a population (number): ");
       //reading user input and changing into integer
        int popLimit = Integer.parseInt(scan.nextLine());


        System.out.println("Cities with a population larger than " + popLimit);

        //we are getting all the keys for cities
        Set<String> keys = cities.keySet();


        //Prints city has population larger than user input.
        for(String key : keys) {
            if(cities.get(key).getPopulation() > popLimit) {
                System.out.println(key + " : " + cities.get(key).getName());
            }
        }
    }
}
