package com.example.dollarupmoneyskills;


import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import static java.security.AccessController.getContext;

/*
Class that controls the layout of the individual components in the RecyclerView
(i.e. the layout resource file)
 */
class CustomRecyclerViewHolder extends RecyclerView.ViewHolder{
    private ImageView imageView; //imageview in cardview
    private TextView textView; //textview in cardview
    public CustomRecyclerViewHolder(View itemView){
        super(itemView);
        imageView = itemView.findViewById(R.id.itemImage);
        textView = itemView.findViewById(R.id.itemDescription);
    }
    //method to set uri of imageview
    public void setImageURI(String id){
        //This block of code is an unsuccessful method of finding the correct orientation of the image
        int rotate = 0;
        try {
            File imageFile = new File(Uri.parse(id).getPath());
            ExifInterface exif = new ExifInterface(imageFile.getAbsolutePath());
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_270:
                    rotate = 270;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    rotate = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    rotate = 90;
                    break;
            }

            Log.i("RotateImage", "Exif orientation: " + orientation);
            Log.i("RotateImage", "Rotate value: " + rotate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        imageView.setImageURI(Uri.parse(id));
        imageView.setRotation(rotate);
    }

    //method to set tag (essentially identifier) of imageview
    public void setImageTag(String tag){
        imageView.setTag(tag);
    }

    //method to set text of text view
    public void setText(String text){
        textView.setText(text);
    }
}

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewHolder>{
    private ArrayList<CustomItem> itemList; //list of items put into recyclerview

    //constructor for adapter object that takes in an CustomItem arraylist
    public CustomRecyclerViewAdapter(ArrayList<CustomItem> itemList){
        this.itemList = itemList;
    }

    //method to create view holder for recyclerview
    @Override
    public CustomRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.item, viewGroup, false);
        return new CustomRecyclerViewHolder(itemView);
    }

    //method to set the elements of each cardview in the recyclerview
    @Override
    public void onBindViewHolder(CustomRecyclerViewHolder recyclerViewHolder, int i) {
        recyclerViewHolder.setImageURI(itemList.get(i).getUriString());
        recyclerViewHolder.setImageTag(itemList.get(i).getName());
        recyclerViewHolder.setText(itemList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
