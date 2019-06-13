package com.company;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ComputerReader {
    public static void main(String[] args) {


        try {
            // Write a csv file using the data from the ArrayList
//            Writer writer = new FileWriter("computers.csv");
//            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
//            beanToCsv.write(carList);
//            writer.close();
            // Read the csv file and print contents to the console

            List<Computer> computersFromCSV =
                    new CsvToBeanBuilder<Computer>(new FileReader("computers.csv")).withType(Computer.class).build().parse();
            // Iterate through the car list and print to console
            for (Computer computer : computersFromCSV) {
                System.out.println("=========================================");
                System.out.println(computer.getBrand());
                System.out.println(computer.getModel());
                System.out.println(computer.getCpu());
                System.out.println(computer.getRam());
            }
            System.out.println("=========================================");
        } catch (Exception e) {
            System.out.println("An error occurred " + e);
        }



    }
}
