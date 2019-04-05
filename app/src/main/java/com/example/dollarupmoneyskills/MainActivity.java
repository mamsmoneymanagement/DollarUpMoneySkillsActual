package com.example.dollarupmoneyskills;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void goToLevelOne(View view){
        Intent intent = new Intent(this, LevelOneItems.class);
        startActivity(intent);
    }
    public void goToSettings(View view){
        Intent intent = new Intent(this, Settings_Menu.class);
        startActivity(intent);


    }


}
