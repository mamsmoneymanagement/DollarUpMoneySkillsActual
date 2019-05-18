package com.example.dollarupmoneyskills;

import java.util.ArrayList;
/*
Class for the Wallet object.
This object is used to store the bills that the user has available to pick in the LevelPromptHard activity
 */
public class Wallet {
    private int excludedBill; //which bill is not in the wallet
    private int numOnes; //number of $1 bills
    private int numFives; //number of $5 bills
    private int numTens; //number of $10 bills
    private int numTwenties; //number of $20 bills
    //constructor for object
    public Wallet(int payment){
        int[] arr = {5,10,20};
        //Determine randomly what bill will be excluded from the wallet
        excludedBill = arr[(int)(Math.random()*3)];
        //This populates the wallet with bills such that the payment can be made
        while(payment >= 20 && excludedBill != 20){
            payment -= 20;
            numTwenties += 1;
        }
        numTwenties += (int)(Math.random()*numTwenties);
        while(payment >= 10 && excludedBill != 10){
            payment -= 10;
            numTens += 1;
        }
        while(payment >= 5 && excludedBill != 5){
            payment -= 5;
            numFives += 1;
        }
        while(payment >= 1){
            payment -= 1;
            numOnes += 1;
        }

        //Add some random amount of bills to the wallet (to increase variability
        numTwenties = (int)(numTwenties*(1+Math.random()));
        numTens = (int)(numTens*(1+Math.random()));
        numFives = (int)(numFives*(1+Math.random()));
        numOnes = (int)(numOnes*(1+Math.random()));

    }

    //Methods to add certain bills to the wallet
    public void addOne(){
        this.numOnes += 1;
    }

    public void addFive() {
        if (excludedBill != 5) {
            this.numFives += 1;
        }
    }

    public void addTen(){
        if (excludedBill != 10) {
            this.numTens += 1;
        }
    }

    public void addTwenty(){
        if (excludedBill != 20) {
            this.numTwenties += 1;
        }
    }

    //Methods to remove certain bills from the wallet
    public void removeOne(){
        if(numOnes > 0) {
            this.numOnes -= 1;
        }
    }

    public void removeFive(){
        if(numFives > 0) {
            this.numFives -= 1;
        }
    }

    public void removeTen(){
        if(numTens > 0) {
            this.numTens -= 1;
        }
    }

    public void removeTwenty(){
        if(numTwenties > 0) {
            this.numTwenties -= 1;
        }
    }

    //Getter methods for instance variables
    public int getExcludedBill(){
        return excludedBill;
    }
    public int getNumOnes() {
        return numOnes;
    }

    public int getNumFives() {
        return numFives;
    }

    public int getNumTens() {
        return numTens;
    }

    public int getNumTwenties() {
        return numTwenties;
    }
}
