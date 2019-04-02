package com.example.dollarupmoneyskills;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LevelPrompt extends AppCompatActivity {
    private PaymentBoard board;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_prompt);
        board = new PaymentBoard();
    }
    //Dialog Box
    public void addOne(View view){
        new AlertDialog.Builder(this)
                .setTitle("Confirm Choice")
                .setMessage("Do you want to pay with this bill?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        board.addOne();
                        TextView view = findViewById(R.id.numOnes);
                        view.setText(""+board.getNumOnes());
                    }
                }).create().show();
    }
    public void addFive(View view){
        new AlertDialog.Builder(this)
                .setTitle("Confirm Choice")
                .setMessage("Do you want to pay with this bill?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        board.addFive();
                        TextView view = findViewById(R.id.numFives);
                        view.setText(""+board.getNumFives());
                    }
                }).create().show();
    }
    public void addTen(View view){
        new AlertDialog.Builder(this)
                .setTitle("Confirm Choice")
                .setMessage("Do you want to pay with this bill?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        board.addTen();
                        TextView view = findViewById(R.id.numTens);
                        view.setText(""+board.getNumTens());
                    }
                }).create().show();
    }
    public void addTwenty(View view){
        new AlertDialog.Builder(this)
                .setTitle("Confirm Choice")
                .setMessage("Do you want to pay with this bill?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        board.addTwenty();
                        TextView view = findViewById(R.id.numTwenties);
                        view.setText(""+board.getNumTwenties());
                    }
                }).create().show();
    }
}
