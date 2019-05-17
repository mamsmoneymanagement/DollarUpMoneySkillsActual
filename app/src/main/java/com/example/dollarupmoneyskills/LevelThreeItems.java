package com.example.dollarupmoneyskills;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LevelThreeItems extends AppCompatActivity {

    private ArrayList<Item> itemList = new ArrayList<Item>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_three_items);

        //Setting all the required fields of the RecyclerView object
        recyclerView = findViewById(R.id.myRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }
    /*
    Method that reads the item data from the items.csv file and creates Item objects
    out of them
     */
    private void readItemData(){
        InputStream is = getResources().openRawResource(R.raw.items);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = "";
        try {
            //Goes through all the lines of the file and then instantiates an Item object for each line
            while((line = reader.readLine()) != null) {
                // Split by ','
                String[] fields = line.split(",");
                Log.v("myTag", Arrays.toString(fields));
                // Read the items
                int n = this.getResources().getIdentifier(fields[3],"drawable",this.getPackageName());
                itemList.add(new Item(fields[0],Double.parseDouble(fields[1]),Double.parseDouble(fields[2]),n));
            }
        } catch (IOException e) {
            Log.wtf("MainActivity","ERROR reading items on line: " + line);
        }
    }
    /*
    Method to go to LevelPrompt with that particular item chosen
     */
    public void onClick(View view) {
        ImageView image = (ImageView)((ViewGroup)view.getParent()).getChildAt(0);
        Intent intent = new Intent(this, LevelPromptHard.class);
        Item item = null;
        //Finding image which has the same as the item chosen
        for(int i=0; i<itemList.size(); i++){
            if(itemList.get(i).getName() == image.getTag()){
                item = itemList.get(i);
                break;
            }
        }
        //sending an intent with the item data into the next activity
        intent.putExtra("key", item.getImageID()+","+item.genPrice());
        startActivity(intent);
    }
}
