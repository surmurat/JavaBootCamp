package com.company;


import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVWriteAndRead {

    public static void main(String[] args) {


        List<Car> carList = new ArrayList<>();
        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));
        try {
            // Write a csv file using the data from the ArrayList
            Writer writer = new FileWriter("murat_car_list.csv");
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(carList);
            writer.close();
            // Read the csv file and print contents to the console
            List<Car> carsFromCSV =
                    new CsvToBeanBuilder<Car>(new FileReader("murat_car_list.csv")).withType(Car.class).build().parse();
            // Iterate through the car list and print to console
            for (Car car : carsFromCSV) {
                System.out.println("=========================================");
                System.out.println(car.getYear());
                System.out.println(car.getMake());
                System.out.println(car.getModel());
                System.out.println(car.getColor());
            }
            System.out.println("=========================================");
        } catch (Exception e) {
            System.out.println("An error occurred " + e);
        }








    }





}
