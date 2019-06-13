package com.company;


import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {

    public static void main(String[] args) {

        try {
            int petIndex = Pets.choosePet();

            String chosenPet = Pets.retrievePet(petIndex);

            Pets.readPetsFromFile();

            Pets.writePetToFile(chosenPet);
        }catch (NumberFormatException e){
            System.out.println("Please enter a valid number!");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("please choose an available pet");

        }catch (FileNotFoundException e){
            System.out.println("This file is not exist");
        }catch (IOException e){
            System.out.println("There was a trouble writing that file!");
        }finally {
            System.out.println("Have a nice day!");
        }


    }
}
