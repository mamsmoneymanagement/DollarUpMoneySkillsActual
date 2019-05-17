package com.example.dollarupmoneyskills;
/*
This class creates the template for the CustomItem object, which is used to store the items used in the LevelTwoItems class
 */
public class CustomItem {
    private String name; //name of the item
    private double lowerPrice; //the lowerbound of the item's price
    private double higherPrice; //the upperbound of the item's price
    private String uriString; //the uri string associated with the image of the item

    /*
    Constructor of the CustomItem, takes as parameters all four fields
     */
    public CustomItem(String name, double lowerPrice, double higherPrice, String uriString) {
        this.name = name;
        this.lowerPrice = lowerPrice;
        this.higherPrice = higherPrice;
        this.uriString = uriString;
    }
    /*
    Used to generated a price for the item
     */
    public double genPrice(){
        return Math.round(100*((higherPrice-lowerPrice)*Math.random()+lowerPrice))/100.0;
    }
    /*
    Getters for instance variables
     */
    public String getName() {
        return name;
    }

    public double getLowerPrice() {
        return lowerPrice;
    }

    public double getHigherPrice() {
        return higherPrice;
    }

    public String getUriString() {
        return uriString;
    }
    /*
    Method to convert object to a string so it can be passed through an intent
     */
    public String toString(){
        return name+","+lowerPrice+","+higherPrice+","+uriString;
    }
    /*
    Method to convert string to this object so that a string gotten from an intent can be used to get the same object
     */
    public static CustomItem parse(String s){
        String[] data = s.split(",");
        return new CustomItem(data[0],Double.parseDouble(data[1]),Double.parseDouble(data[2]),data[3]);
    }
}
