package com.example.dollarupmoneyskills;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class LevelPromptHard extends AppCompatActivity {
    //instance variables
    private PaymentBoard board;
    private Wallet wallet;
    private String[] intentData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_prompt_hard);
        board = new PaymentBoard();
        ImageView image = findViewById(R.id.itemImage);
        intentData = getIntent().getStringExtra("key").split(",");
        image.setImageResource(Integer.parseInt(intentData[0]));
        TextView priceText = findViewById(R.id.priceText);
        priceText.setText("Price: $"+intentData[1]);
        wallet = new Wallet((int)Math.ceil(Double.parseDouble(intentData[1])));
        ImageButton button = findViewById(R.id.addOne);
        button.setLayoutParams(new LinearLayout.LayoutParams(300,150));
        button = findViewById(R.id.addFive);
        button.setLayoutParams(new LinearLayout.LayoutParams(300,150));
        button = findViewById(R.id.addTen);
        button.setLayoutParams(new LinearLayout.LayoutParams(300,150));
        button = findViewById(R.id.addTwenty);
        button.setLayoutParams(new LinearLayout.LayoutParams(300,150));
    }
    public void addImage(View view, int n){
        ImageView image = new ImageView(this);
        switch(n){
            case 1:
                if(Math.random()<0.5){
                    image.setImageResource(R.drawable.onedollarfront);
                }else{
                    image.setImageResource(R.drawable.onedollarback);
                }
                break;
            case 5:
                if(Math.random()<0.5){
                    image.setImageResource(R.drawable.fivedollarfront);
                }else{
                    image.setImageResource(R.drawable.fivedollarback);
                }
                break;
            case 10:
                if(Math.random()<0.5){
                    image.setImageResource(R.drawable.tendollarfront);
                }else{
                    image.setImageResource(R.drawable.tendollarback);
                }
                break;
            case 20:
                if(Math.random()<0.5){
                    image.setImageResource(R.drawable.twentydollarfront);
                }else{
                    image.setImageResource(R.drawable.twentydollarback);
                }
                break;
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(150, 300);
        image.setLayoutParams(params);
        LinearLayout scroll = findViewById(R.id.scrollLayout);
        scroll.addView(image);
    }
    public void removeImage(View view, int n){
        LinearLayout scroll = findViewById(R.id.scrollLayout);
        int a = board.getBillList().indexOf(n);
        scroll.removeViewAt(a);
    }
    public void addOne(View view){
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Confirm Choice")
                .setMessage("Do you want to pay with this bill?")
                .setNegativeButton("Remove", null)
                .setNeutralButton("Close", null)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(wallet.getNumOnes() == 0){
                            Toast.makeText(LevelPromptHard.this, "You can't add this bill because you don't have any of them in your wallet.", Toast.LENGTH_SHORT).show();
                        }else{
                            addImage(findViewById(R.id.moneyBoard), 1);
                            board.addOne();
                            wallet.removeOne();
                        }
                    }
                }).show();
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(board.getNumOnes() == 0) {
                    Toast.makeText(LevelPromptHard.this, "You can't remove this bill because you don't have any of them in your payment.", Toast.LENGTH_SHORT).show();
                }else{
                    removeImage(findViewById(R.id.moneyBoard), 1);
                    board.removeOne();
                    wallet.addOne();
                    dialog.dismiss();
                }
            }
        });
        Log.v("myTag",board.getBillList().toString());
    }
    public void addFive(View view){
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Confirm Choice")
                .setMessage("Do you want to pay with this bill?")
                .setNegativeButton("Remove", null)
                .setNeutralButton("Close", null)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(wallet.getNumFives() == 0){
                            Toast.makeText(LevelPromptHard.this, "You can't add this bill because you don't have any of them in your wallet.", Toast.LENGTH_SHORT).show();
                        }else{
                            addImage(findViewById(R.id.moneyBoard), 5);
                            board.addFive();
                            wallet.removeFive();
                        }
                    }
                }).show();
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(board.getNumFives() == 0) {
                    Toast.makeText(LevelPromptHard.this, "You can't remove this bill because you don't have any of them in your payment.", Toast.LENGTH_SHORT).show();
                }else{
                    removeImage(findViewById(R.id.moneyBoard), 5);
                    board.removeFive();
                    wallet.addFive();
                    dialog.dismiss();
                }
            }
        });
    }
    public void addTen(View view){
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Confirm Choice")
                .setMessage("Do you want to pay with this bill?")
                .setNegativeButton("Remove", null)
                .setNeutralButton("Close", null)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(wallet.getNumTens() == 0){
                            Toast.makeText(LevelPromptHard.this, "You can't add this bill because you don't have any of them in your wallet.", Toast.LENGTH_SHORT).show();
                        }else{
                            addImage(findViewById(R.id.moneyBoard), 10);
                            board.addTen();
                            wallet.removeTen();
                        }
                    }
                }).show();
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(board.getNumTens() == 0) {
                    Toast.makeText(LevelPromptHard.this, "You can't remove this bill because you don't have any of them in your payment.", Toast.LENGTH_SHORT).show();
                }else{
                    removeImage(findViewById(R.id.moneyBoard), 10);
                    board.removeTen();
                    wallet.addTen();
                    dialog.dismiss();
                }
            }
        });
    }
    public void addTwenty(View view){
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Confirm Choice")
                .setMessage("Do you want to pay with this bill?")
                .setNegativeButton("Remove", null)
                .setNeutralButton("Close", null)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(wallet.getNumTwenties() == 0){
                            Toast.makeText(LevelPromptHard.this, "You can't add this bill because you don't have any of them in your wallet.", Toast.LENGTH_SHORT).show();
                        }else{
                            addImage(findViewById(R.id.moneyBoard), 20);
                            board.addTwenty();
                            wallet.removeTwenty();
                        }
                    }
                }).show();
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(board.getNumTwenties() == 0) {
                    Toast.makeText(LevelPromptHard.this, "You can't remove this bill because you don't have any of them in your payment.", Toast.LENGTH_SHORT).show();
                }else{
                    removeImage(findViewById(R.id.moneyBoard), 20);
                    board.removeTwenty();
                    wallet.addTwenty();
                    dialog.dismiss();
                }
            }
        });
    }
    public void finishPayment(View view){
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Confirm Choice")
                .setMessage("You have payed with $"+board.getAmount()+". Would you like to continue?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", null).show();

        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if(Math.ceil(Double.parseDouble(intentData[1])) == board.getAmount() && board.getBillList().size() == board.leastAmountofBills(board.getAmount())){
                    new AlertDialog.Builder(dialog.getContext())
                            .setTitle("Great Job!")
                            .setMessage("Go back to the item screen to buy another item.")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(LevelPromptHard.this, LevelThreeItems.class);
                                    startActivity(intent);
                                }
                            }).create().show();
                }else if(Math.ceil(Double.parseDouble(intentData[1])) == board.getAmount() && board.getBillList().size() != board.leastAmountofBills(board.getAmount())){
                    new AlertDialog.Builder(dialog.getContext())
                            .setTitle("Okay Job")
                            .setMessage("You got the right amount, but try using fewer bills.")
                            .setPositiveButton("Try Again", null).create().show();
                }else{
                    new AlertDialog.Builder(dialog.getContext())
                            .setTitle("Horrible")
                            .setMessage("Wrong")
                            .setPositiveButton("Try Again", null).create().show();
                }
            }
        });

    }
    public void viewWallet(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Wallet");

        final LinearLayout dataDialog = new LinearLayout(this);
        dataDialog.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        dataDialog.setLayoutParams(layoutParams);

        final TextView viewOne = new TextView(this);
        viewOne.setText("$1 Bills: "+wallet.getNumOnes());
        viewOne.setTextSize(30);
        final TextView viewFive = new TextView(this);
        viewFive.setText("$5 Bills: "+wallet.getNumFives());
        viewFive.setTextSize(30);
        final TextView viewTen = new TextView(this);
        viewTen.setText("$10 Bills: "+wallet.getNumTens());
        viewTen.setTextSize(30);
        final TextView viewTwenty = new TextView(this);
        viewTwenty.setText("$20 Bills: "+wallet.getNumTwenties());
        viewTwenty.setTextSize(30);

        dataDialog.addView(viewOne);
        dataDialog.addView(viewFive);
        dataDialog.addView(viewTen);
        dataDialog.addView(viewTwenty);

        builder.setView(dataDialog);

        builder.show();

        builder.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }
}