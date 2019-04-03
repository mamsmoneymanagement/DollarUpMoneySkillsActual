package com.example.dollarupmoneyskills;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LevelPrompt extends AppCompatActivity {
    private PaymentBoard board;
    private ArrayList<ImageView> images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_prompt);
        board = new PaymentBoard();
        images = new ArrayList<ImageView>();
    }
    public void addImage(View view){
        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.one_dollar);
        LinearLayout myLayout = (LinearLayout)findViewById(R.id.moneyBoard);
        myLayout.addView(image);
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
                        addImage(findViewById(R.id.moneyBoard));
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
                    board.removeOne();
                    TextView view = findViewById(R.id.numOnes);
                    view.setText(""+board.getNumOnes());
                    dialog.dismiss();
                }
            }
        });
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
                    board.removeTwenty();
                    TextView view = findViewById(R.id.numTwenties);
                    view.setText(""+board.getNumTwenties());
                    dialog.dismiss();
                }
            }
        });
    }
    public void finishPayment(View view){
        new AlertDialog.Builder(this)
                .setTitle("Confirm Choice")
                .setMessage("You have payed with $"+board.getAmount()+". Would you like to continue?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();
    }
}
