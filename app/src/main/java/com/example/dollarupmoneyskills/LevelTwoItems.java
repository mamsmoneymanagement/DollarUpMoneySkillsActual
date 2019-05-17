package com.example.dollarupmoneyskills;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LevelTwoItems extends AppCompatActivity {
    boolean isFinished = false;
    private static final String FILE_NAME = "example.txt";
    private String imgData;
    ArrayList<String> imgDataList = new ArrayList<String>();
    ArrayList<CustomItem> customItemList = new ArrayList<CustomItem>();
    private RecyclerView recyclerView;
    private CustomRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String m_Text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two_items);
        load();
        recyclerView = findViewById(R.id.myRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CustomRecyclerViewAdapter(customItemList);
        recyclerView.setAdapter(adapter);
    }
    protected void onStop(){
        super.onStop();
        Log.v("saving", "123");
        save();
    }
    public void save(){
        String text = "";
        FileOutputStream fos = null;
        for(CustomItem i: customItemList){
            text+=i.toString()+"\n";
        }
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void load(){
        Log.v("Aditya", "Aditya");
        FileInputStream fis = null;
        try{
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while((line = br.readLine()) != null) {
                customItemList.add(CustomItem.parse(line));
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(fis != null){
                try{
                    fis.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        Log.v("dataList", customItemList.toString());
    }
    public void findImage(View view){
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Find where to choose Image")
                .setMessage("")
                .setNegativeButton("Find in Gallery", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        //pickPhoto.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        startActivityForResult(pickPhoto , 1);
                        //isFinished = true;
                    }
                })
                .setPositiveButton("Take Picture with Camera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        //intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        startActivityForResult(intent,0);
                        //isFinished = true;
                    }
                }).show();

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        try{
            imgData = data.getDataString();
            imgDataList.add(imgData);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Give some information about your object.");

            final LinearLayout dataDialog = new LinearLayout(this);
            dataDialog.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            dataDialog.setLayoutParams(layoutParams);
            final TextView name = new TextView(this);
            name.setText("Name");
            name.setTextSize(30);
            name.setTextColor(Color.BLACK);
            final EditText nameInput = new EditText(this);
            nameInput.setInputType(InputType.TYPE_CLASS_TEXT);
            final TextView price = new TextView(this);
            price.setText("Price");
            price.setTextSize(30);
            price.setTextColor(Color.BLACK);
            final EditText priceInput = new EditText(this);
            priceInput.setInputType(InputType.TYPE_CLASS_TEXT);
            dataDialog.addView(name);
            dataDialog.addView(nameInput);
            dataDialog.addView(price);
            dataDialog.addView(priceInput);
            builder.setView(dataDialog);

            builder.setPositiveButton("OK", null);
            final AlertDialog dialog = builder.create();
            dialog.show();
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    boolean works;
                    try{
                        double d = Double.parseDouble(priceInput.getText().toString());
                        works = true;
                    }catch(NumberFormatException e){
                        works = false;
                    }
                    if(nameInput.getText().toString().length() == 0 || !works){
                        if(nameInput.getText().toString().length() == 0) {
                            nameInput.setError("Please set a name for the item.");
                        }
                        if(!works){
                            priceInput.setError("Please set the price to a valid number");
                        }
                    }else{
                        customItemList.add(new CustomItem(nameInput.getText().toString(), Double.parseDouble(priceInput.getText().toString()), Double.parseDouble(priceInput.getText().toString()), imgData));
                        adapter.notifyItemInserted(customItemList.size()-1);
                        dialog.dismiss();
                    }
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
        }catch(Exception e){

        }



    }

    public void onClick(View view) {
        ImageView image = (ImageView)((ViewGroup)view.getParent()).getChildAt(0);
        Intent intent = new Intent(this, CustomLevelPrompt.class);
        CustomItem item = null;
        for(int i=0; i<customItemList.size(); i++){
            if(customItemList.get(i).getName() == image.getTag()){
                item = customItemList.get(i);
                break;
            }
        }
        intent.putExtra("key", item.getUriString()+","+item.genPrice());
        startActivity(intent);
    }




}
