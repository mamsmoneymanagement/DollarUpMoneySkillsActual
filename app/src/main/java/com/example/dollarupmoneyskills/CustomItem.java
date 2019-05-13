package com.example.dollarupmoneyskills;

public class CustomItem {
    private String name;
    private double lowerPrice;
    private double higherPrice;
    private String uriString;

    public CustomItem(String name, double lowerPrice, double higherPrice, String uriString) {
        this.name = name;
        this.lowerPrice = lowerPrice;
        this.higherPrice = higherPrice;
        this.uriString = uriString;
    }

    public double genPrice(){
        return Math.round(100*((higherPrice-lowerPrice)*Math.random()+lowerPrice))/100.0;
    }

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

    public String toString(){
        return name+","+lowerPrice+","+higherPrice+","+uriString;
    }

    public static CustomItem parse(String s){
        String[] data = s.split(",");
        return new CustomItem(data[0],Double.parseDouble(data[1]),Double.parseDouble(data[2]),data[3]);
    }
}
