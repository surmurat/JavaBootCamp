package com.company;

public class City {

    //Creating properties.
    private String name;
    private int population;

    //Creating constructor.
    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    // Getter and Setter.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
