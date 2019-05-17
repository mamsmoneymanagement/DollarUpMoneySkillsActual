package com.example.dollarupmoneyskills;
/*
This class creates the template for the Item object, which is used to store the items used in the LevelOneItems class
 */
public class Item {
    private String name; //name of the item
    private double lowerPrice; //the lowerbound of the item's price
    private double higherPrice; //the upperbound of the item's price
    private double price; //the item's actual price
    private int imageID; //the image id of the item
    /*
    Constructor of the Item, takes as parameters all the fields except price
     */
    public Item(String name, double lowerPrice, double higherPrice, int imageID){
        this.name = name;
        this.lowerPrice = lowerPrice;
        this.higherPrice = higherPrice;
        this.imageID = imageID;
        this.price = genPrice();
    }
    /*
    Getter methods for instance variables
     */
    public int getImageID(){
        return imageID;
    }

    public String getName() {
        return name;
    }
    //Method to generate a random price based on the upper and lower price bounds
    public double genPrice(){
        return Math.round(100*((higherPrice-lowerPrice)*Math.random()+lowerPrice))/100.0;
    }

    public double getPrice(){
        return price;
    }

}
