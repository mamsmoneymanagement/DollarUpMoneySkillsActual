package com.example.dollarupmoneyskills;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CustomLevelPrompt extends AppCompatActivity {

    //instance variables
    private PaymentBoard board;
    private String[] intentData;
    private double price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_level_prompt);
        board = new PaymentBoard();
        ImageView image = findViewById(R.id.itemImage);
        intentData = getIntent().getStringExtra("key").split(",");
        image.setImageURI(Uri.parse(intentData[0]));
        TextView priceText = findViewById(R.id.priceText);
        price = Math.round(100.0*Double.parseDouble(intentData[1]))/100.0;
        priceText.setText("Price: $"+price);
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
                        addImage(findViewById(R.id.moneyBoard), 1);
                        board.addOne();
                    }
                }).show();
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(board.getNumOnes() == 0) {
                    Toast.makeText(CustomLevelPrompt.this, "You can't remove this bill because you don't have any of them in your payment.", Toast.LENGTH_SHORT).show();
                }else{
                    removeImage(findViewById(R.id.moneyBoard), 1);
                    board.removeOne();
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
                    }
                }).show();
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(board.getNumFives() == 0) {
                    Toast.makeText(CustomLevelPrompt.this, "You can't remove this bill because you don't have any of them in your payment.", Toast.LENGTH_SHORT).show();
                }else{
                    removeImage(findViewById(R.id.moneyBoard), 5);
                    board.removeFive();
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
                    }
                }).show();
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(board.getNumTens() == 0) {
                    Toast.makeText(CustomLevelPrompt.this, "You can't remove this bill because you don't have any of them in your payment.", Toast.LENGTH_SHORT).show();
                }else{
                    removeImage(findViewById(R.id.moneyBoard), 10);
                    board.removeTen();
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
                    }
                }).show();
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(board.getNumTwenties() == 0) {
                    Toast.makeText(CustomLevelPrompt.this, "You can't remove this bill because you don't have any of them in your payment.", Toast.LENGTH_SHORT).show();
                }else{
                    removeImage(findViewById(R.id.moneyBoard), 20);
                    board.removeTwenty();
                    dialog.dismiss();
                }
            }
        });
    }
    public void finishPayment(View view){
        final AlertDialog dialogBox = new AlertDialog.Builder(this)
                .setTitle("Confirm Choice")
                .setMessage("You have payed with $"+board.getAmount()+". Would you like to continue?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", null).show();

        Button positiveButton = dialogBox.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox.dismiss();
                if(Math.ceil(Double.parseDouble(intentData[1])) == board.getAmount() && board.getBillList().size() == board.leastAmountofBills(board.getAmount())){
                    final AlertDialog.Builder builder = new AlertDialog.Builder(dialogBox.getContext());
                    builder.setTitle("How many cents would you get back as change?");

                    final EditText answer = new EditText(dialogBox.getContext());
                    builder.setView(answer);
                    builder.setPositiveButton("Submit Answer", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.v("dataList", ""+(100*(Math.ceil(price)-price)));
                            if(Integer.parseInt(answer.getText().toString()) == Math.round(100*(Math.ceil(price)-price))){
                                new AlertDialog.Builder(builder.getContext())
                                        .setTitle("Great Job!")
                                        .setMessage("Go back to the item screen to buy another item.")
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                try {
                                                    Intent intent = new Intent(CustomLevelPrompt.this, LevelTwoItems.class);
                                                    startActivity(intent);
                                                }catch(Exception e){
                                                    Intent intent = new Intent(CustomLevelPrompt.this, MainActivity.class);
                                                    startActivity(intent);
                                                }
                                            }
                                        }).create().show();
                            }else{
                                Toast.makeText(CustomLevelPrompt.this, "This is not the correct answer. Please try again.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    builder.show();
                }else if(Math.ceil(Double.parseDouble(intentData[1])) == board.getAmount() && board.getBillList().size() != board.leastAmountofBills(board.getAmount())){
                    new AlertDialog.Builder(dialogBox.getContext())
                            .setTitle("Okay Job")
                            .setMessage("You got the right amount, but try using fewer bills.")
                            .setPositiveButton("Try Again", null).create().show();
                }else{
                    new AlertDialog.Builder(dialogBox.getContext())
                            .setTitle("Horrible")
                            .setMessage("Wrong")
                            .setPositiveButton("Try Again", null).create().show();
                }
            }
        });

    }

}
