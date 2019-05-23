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
        image.setImageURI(Uri.parse(intentData[0])); //setting the image to the same image the user picked in the previous screen
        TextView priceText = findViewById(R.id.priceText);
        price = Math.round(100.0*Double.parseDouble(intentData[1]))/100.0;

        //Making sure there are the right amount of decimal places in the textview
        String p = ""+price;
        String s = p.substring(p.indexOf("."));
        while(s.length() < 3){
            s+="0";
            p+="0";
        }
        priceText.setText("Price: $"+p); //setting the price to the price of the same item that the user picked

        //This block sets the dimensions of the image buttons with the dollar bills
        ImageButton button = findViewById(R.id.addOne);
        button.setLayoutParams(new LinearLayout.LayoutParams(300,150));
        button = findViewById(R.id.addFive);
        button.setLayoutParams(new LinearLayout.LayoutParams(300,150));
        button = findViewById(R.id.addTen);
        button.setLayoutParams(new LinearLayout.LayoutParams(300,150));
        button = findViewById(R.id.addTwenty);
        button.setLayoutParams(new LinearLayout.LayoutParams(300,150));

    }
    /*
    Method to add a certain dollar bill to the scroll view.
    The int n corresponds to the value of the bill
     */
    public void addImage(View view, int n){
        ImageView image = new ImageView(this);
        switch(n){
            case 1:
                //Randomly determines whether to place the frontside or backside of bill
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

        //This block sets the dimensions of the bill and then adds it to the scrollview
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(150, 300);
        image.setLayoutParams(params);
        LinearLayout scroll = findViewById(R.id.scrollLayout);
        scroll.addView(image);
    }
    /*
    Method to remove the first instance of a bill in the scrollview
     */
    public void removeImage(View view, int n){
        LinearLayout scroll = findViewById(R.id.scrollLayout);
        int a = board.getBillList().indexOf(n);
        scroll.removeViewAt(a);
    }
    /*
    Method to add or remove a $1 bill from the payment
     */
    public void changeOne(View view){
        //Creation of dialog prompt
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
        //Adding method to remove $1 bill
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Check to make sure they have a bill before removing it
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
    /*
    Method to add or remove $5 bill from the payment
     */
    public void changeFive(View view){
        //Creation of dialog prompt
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
        //Adding method to remove $1 bill
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Check to make sure they have a bill before removing it
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
    /*
    Method to add or remove $10 bill from the payment
     */
    public void changeTen(View view){
        //Creation of dialog prompt
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
        //Adding method to remove bill as well
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Check to make sure they have a bill before removing it
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
    /*
    Method to add or remove $20 bill from payment
     */
    public void changeTwenty(View view){
        //Creation of dialog prompt
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
        //Adding a remove to remove $20 bill
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Adding condition to make sure that the user has a bill in their payment
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
    /*
    Method to allow the user to submit their payment and see if they got the right answer,
    as well as answer more questions
     */
    public void finishPayment(View view){
        //Creation of dialog prompt that tells user the amount they are paying
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
                //If the user gets the right answer, they are then asked how much change they would get back
                if(Math.ceil(Double.parseDouble(intentData[1])) == board.getAmount() && board.getBillList().size() == board.leastAmountofBills(board.getAmount())){
                    final AlertDialog.Builder builder = new AlertDialog.Builder(dialogBox.getContext());
                    builder.setTitle("How many cents would you get back as change?");

                    final EditText answer = new EditText(dialogBox.getContext());
                    builder.setView(answer);
                    builder.setPositiveButton("Submit Answer", null);
                    final AlertDialog dialog = builder.create();
                    dialog.show();
                    dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.v("dataList", ""+(100*(Math.ceil(price)-price)));
                            //If the user gets the change question correct, they are met with a victory message that prompts them
                            //to go back to the item choosing screen
                            if(answer.getText().toString().equals(""+Math.round(100*(Math.ceil(price)-price)))){
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
                            }
                            //If they don't get the right answer, a toast message notifies them
                            else{
                                Toast.makeText(CustomLevelPrompt.this, "This is not the correct answer. Please try again.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                //If user get the wrong answer for the payment of the item
                else{
                    new AlertDialog.Builder(dialogBox.getContext())
                            .setTitle("Hmmm...")
                            .setMessage("You're on the right track, but not there yet.")
                            .setPositiveButton("Try Again", null).create().show();
                }
            }
        });

    }

}
