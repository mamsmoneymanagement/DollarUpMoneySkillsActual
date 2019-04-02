package com.example.dollarupmoneyskills;

public class PaymentBoard {
    private int numOnes;
    private int numFives;
    private int numTens;
    private int numTwenties;
    //constructor
    public PaymentBoard(){
        this.numOnes = 0;
        this.numFives = 0;
        this.numTens = 0;
        this.numTwenties = 0;
    }
    //returns amount of money on board
    public int getAmount(){
        return numOnes+5*numFives+10*numTens+20*numTwenties;
    }
    public void addOne(){
        this.numOnes += 1;
    }

    public void addFive(){
        this.numFives += 1;
    }

    public void addTen(){
        this.numTens += 1;
    }

    public void addTwenty(){
        this.numTwenties += 1;
    }

    public int getNumOnes(){
        return this.numOnes;
    }

    public int getNumFives(){
        return this.numFives;
    }

    public int getNumTens(){
        return this.numTens;
    }

    public int getNumTwenties(){
        return this.numTwenties;
    }
}
