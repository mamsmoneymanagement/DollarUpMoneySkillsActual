package com.example.dollarupmoneyskills;

public class Item {
    private String name;
    private double lowerPrice;
    private double higherPrice;
    private double price;
    private String imageName;

    //constructor
    public Item(String name, double lowerPrice, double higherPrice, String imageName){
        this.name = name;
        this.lowerPrice = lowerPrice;
        this.higherPrice = higherPrice;
        this.imageName = imageName;
        this.price = genPrice();
    }

    public double genPrice(){
        return (higherPrice-lowerPrice)*Math.random()+lowerPrice;
    }

}
