package com.example.dollarupmoneyskills;

public class Item {
    private String name;
    private double lowerPrice;
    private double higherPrice;
    private double price;
    private int imageID;

    //constructor
    public Item(String name, double lowerPrice, double higherPrice, int imageID){
        this.name = name;
        this.lowerPrice = lowerPrice;
        this.higherPrice = higherPrice;
        this.imageID = imageID;
        this.price = genPrice();
    }

    public int getImageID(){
        return imageID;
    }

    public String getName() {
        return name;
    }

    public double genPrice(){
        return (higherPrice-lowerPrice)*Math.random()+lowerPrice;
    }

}
