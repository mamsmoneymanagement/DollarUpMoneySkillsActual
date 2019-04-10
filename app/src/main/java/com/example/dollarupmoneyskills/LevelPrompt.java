package com.example.dollarupmoneyskills;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import java.util.ArrayList;

public class LevelPrompt extends AppCompatActivity {
    //instance variables
    private PaymentBoard board;
    private String[] intentData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_prompt);
        board = new PaymentBoard();
        ImageView image = findViewById(R.id.itemImage);
        intentData = getIntent().getStringExtra("key").split(",");
        image.setImageResource(Integer.parseInt(intentData[0]));
        TextView priceText = findViewById(R.id.priceText);
        priceText.setText("Price: $"+intentData[1]);
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
                image.setImageResource(R.drawable.onedollarfront);
                break;
            case 5:
                image.setImageResource(R.drawable.fivedollarfront);
                break;
            case 10:
                image.setImageResource(R.drawable.tendollarfront);
                break;
            case 20:
                image.setImageResource(R.drawable.twentydollarfront);
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
                        addImage(findViewById(R.id.moneyBoard), 1);
                        board.addOne();
                        TextView view = findViewById(R.id.numOnes);
                        view.setText(""+board.getNumOnes());
                    }
                }).show();
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(board.getNumOnes() == 0) {
                    Toast.makeText(LevelPrompt.this, "You can't remove this bill because you have zero", Toast.LENGTH_SHORT).show();
                }else{
                    removeImage(findViewById(R.id.moneyBoard), 1);
                    board.removeOne();
                    TextView view = findViewById(R.id.numOnes);
                    view.setText(""+board.getNumOnes());
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
                        addImage(findViewById(R.id.moneyBoard), 5);
                        board.addFive();
                        TextView view = findViewById(R.id.numFives);
                        view.setText(""+board.getNumFives());
                    }
                }).show();
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(board.getNumFives() == 0) {
                    Toast.makeText(LevelPrompt.this, "You can't remove this bill because you have zero", Toast.LENGTH_SHORT).show();
                }else{
                    removeImage(findViewById(R.id.moneyBoard), 5);
                    board.removeFive();
                    TextView view = findViewById(R.id.numFives);
                    view.setText(""+board.getNumFives());
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
                        addImage(findViewById(R.id.moneyBoard), 10);
                        board.addTen();
                        TextView view = findViewById(R.id.numTens);
                        view.setText(""+board.getNumTens());
                    }
                }).show();
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(board.getNumTens() == 0) {
                    Toast.makeText(LevelPrompt.this, "You can't remove this bill because you have zero", Toast.LENGTH_SHORT).show();
                }else{
                    removeImage(findViewById(R.id.moneyBoard), 10);
                    board.removeTen();
                    TextView view = findViewById(R.id.numTens);
                    view.setText(""+board.getNumTens());
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
                        addImage(findViewById(R.id.moneyBoard), 20);
                        board.addTwenty();
                        TextView view = findViewById(R.id.numTwenties);
                        view.setText(""+board.getNumTwenties());
                    }
                }).show();
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(board.getNumTwenties() == 0) {
                    Toast.makeText(LevelPrompt.this, "You can't remove this bill because you have zero", Toast.LENGTH_SHORT).show();
                }else{
                    removeImage(findViewById(R.id.moneyBoard), 20);
                    board.removeTwenty();
                    TextView view = findViewById(R.id.numTwenties);
                    view.setText(""+board.getNumTwenties());
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
                            .setPositiveButton("Yes", null).create().show();
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
}
