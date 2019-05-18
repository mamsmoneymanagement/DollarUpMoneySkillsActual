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

    //Methods to go to different activties from this activity
    public void goToLevelOne(View view){
        Intent intent = new Intent(this, LevelOneItems.class);
        startActivity(intent);
    }
    public void goToLevelTwo(View view){
        Intent intent = new Intent(this, LevelTwoItems.class);
        startActivity(intent);
    }
    public void goToLevelThree(View view){
        Intent intent = new Intent(this, LevelThreeItems.class);
        startActivity(intent);
    }

}
