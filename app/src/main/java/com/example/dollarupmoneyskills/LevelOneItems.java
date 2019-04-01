package com.example.dollarupmoneyskills;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LevelOneItems extends AppCompatActivity {
//l
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one_items);
    }
    public void goToPrompt(View view){
        Intent intent = new Intent(this, LevelPrompt.class);
        startActivity(intent);
    }
}
