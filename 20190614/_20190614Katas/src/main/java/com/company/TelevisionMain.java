package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TelevisionMain {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> telList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {
            });


            for (Television television : telList) {
                System.out.println("================");
                System.out.println(television.getBrand());
                System.out.println(television.getModel());
                System.out.println(television.getPrice());
                System.out.println(television.getScreenSize());
            }

            int size = 60;

            telList
                    .stream()
                    .filter(b -> b.getScreenSize() > size)
                    .forEach(television -> {
                        System.out.println("--------------------");
                        System.out.println("Brand is " + television.getBrand());
                        System.out.println("Model is " + television.getModel());
                        System.out.println("price is " + television.getPrice());
                        System.out.printf("Screen size is " + television.getScreenSize());
                        System.out.println("--------------------");
                    });

            Map<String, List<Television>> groupedByBrand =
                    telList
                            .stream()
                            .collect(Collectors.groupingBy(b -> b.getBrand()));

            Set<String> keys = groupedByBrand.keySet();
            for(String key : keys) {
                System.out.println("Brand name is " + key);

            }

            double avgScreensize =
                    telList
                            .stream()
                            .mapToInt(b -> b.getScreenSize())
                            .average()
                            .getAsDouble();

            System.out.println("Average Screen size is: " + avgScreensize);

            int maxScreensize =
                    telList
                            .stream()
                            .mapToInt(bike -> bike.getScreenSize())
                            .max()
                            .getAsInt();

            System.out.println("Max Screensize: " + maxScreensize);

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }




    }
}




