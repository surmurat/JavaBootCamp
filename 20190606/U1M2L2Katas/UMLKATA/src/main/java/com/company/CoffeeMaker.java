package com.company;

public class CoffeeMaker {
    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;

    public CoffeeMaker(String manufacturer,String model,int carafeSize,int cupsLeft,boolean powered){
        this.manufacturer=manufacturer;
        this.model=model;
        this.carafeSize=carafeSize;
        this.cupsLeft=cupsLeft;
        this.powered=powered;
    }

    public void setManufacturer(String make){
        this.manufacturer=manufacturer;
    }

    public String getManufacturer(){
        return this.manufacturer;
    }

    public void setModel(String model){
        this.model=model;
    }

    public String getModel(){
        return this.model;
    }

    public void setCarafeSize(int carafeSize){
        this.carafeSize=carafeSize;
    }

    public int getCarafeSize(){
        return this.carafeSize;
    }

    public void setCupsLeft(int cupsLeft){
        this.cupsLeft=cupsLeft;
    }

    public int getCupsLeft(){
        return this.cupsLeft;
    }

    public void setPowered(boolean powered){
        this.powered=powered;
    }

    public boolean isPowered(){
        return this.powered;
    }

}



