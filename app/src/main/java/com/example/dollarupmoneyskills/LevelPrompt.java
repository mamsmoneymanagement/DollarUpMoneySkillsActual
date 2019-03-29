package com.example.dollarupmoneyskills;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LevelPrompt extends AppCompatActivity {
    //for commmt
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_prompt);
    }

    public void clickable(View v)
    {
        AlertDialog.Builder _builder = new AlertDialog.Builder(LevelPrompt.this);
        _builder.setMessage(R.string.dialogPaymentQ).setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which)
            {

            }
        }).setNegativeButton(R.string.CANCEL, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });
        _builder.create();


    }



}
