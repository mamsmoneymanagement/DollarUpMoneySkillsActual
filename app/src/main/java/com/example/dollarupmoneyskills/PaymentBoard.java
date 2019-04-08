package com.example.dollarupmoneyskills;

import java.util.ArrayList;

public class PaymentBoard {
    private int numOnes;
    private int numFives;
    private int numTens;
    private int numTwenties;
    private ArrayList<Integer> billList;
    //constructor
    public PaymentBoard(){
        this.numOnes = 0;
        this.numFives = 0;
        this.numTens = 0;
        this.numTwenties = 0;
        this.billList = new ArrayList<Integer>();
    }
    //returns amount of money on board
    public int getAmount(){
        return numOnes+5*numFives+10*numTens+20*numTwenties;
    }
    public void addOne(){
        this.numOnes += 1;
        this.billList.add(1);
    }

    public void addFive(){
        this.numFives += 1;
        this.billList.add(5);
    }

    public void addTen(){
        this.numTens += 1;
        this.billList.add(10);
    }

    public void addTwenty(){
        this.numTwenties += 1;
        this.billList.add(20);
    }

    public void removeOne(){
        if(numOnes > 0) {
            this.numOnes -= 1;
            this.billList.remove(this.billList.indexOf(new Integer(1)));
        }
    }

    public void removeFive(){
        if(numFives > 0) {
            this.numFives -= 1;
            this.billList.remove(this.billList.indexOf(new Integer(5)));
        }
    }

    public void removeTen(){
        if(numTens > 0) {
            this.numTens -= 1;
            this.billList.remove(this.billList.indexOf(new Integer(10)));
        }
    }

    public void removeTwenty(){
        if(numTwenties > 0) {
            this.numTwenties -= 1;
            this.billList.remove(this.billList.indexOf(new Integer(20)));
        }
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

    public ArrayList<Integer> getBillList(){
        return this.billList;
    }
}
