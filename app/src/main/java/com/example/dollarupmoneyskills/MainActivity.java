package com.example.dollarupmoneyskills;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("myTag", "Danush");
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
