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

class CustomRecyclerViewHolder extends RecyclerView.ViewHolder{
    private ImageView imageView;
    private TextView textView;
    public CustomRecyclerViewHolder(View itemView){
        super(itemView);
        imageView = itemView.findViewById(R.id.itemImage);
        textView = itemView.findViewById(R.id.itemDescription);
    }
    public void setImageURI(String id){
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
    public void setImageTag(String tag){
        imageView.setTag(tag);
    }
    public void setText(String text){
        textView.setText(text);
    }
}

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewHolder>{
    private ArrayList<CustomItem> itemList;

    public CustomRecyclerViewAdapter(ArrayList<CustomItem> itemList){
        this.itemList = itemList;
    }
    @Override
    public CustomRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.item, viewGroup, false);
        return new CustomRecyclerViewHolder(itemView);
    }

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
