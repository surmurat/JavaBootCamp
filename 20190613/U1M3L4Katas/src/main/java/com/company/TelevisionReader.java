package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TelevisionReader {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> tvList;

            tvList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>(){});

            for (Television television : tvList) {
                System.out.println("================");
                System.out.println(television.getBrand());
                System.out.println(television.getModel());
                System.out.println(television.getPrice());
                System.out.println(television.getScreenSize());

            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}
