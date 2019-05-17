package com.example.dollarupmoneyskills;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
/*
Class that controls the layout of the individual components in the RecyclerView
(i.e. the layout resource file)
 */
class RecyclerViewHolder extends RecyclerView.ViewHolder{
    private ImageView imageView; //imageview in cardview
    private TextView textView; //textview in cardview
    public RecyclerViewHolder(View itemView){
        super(itemView);
        imageView = itemView.findViewById(R.id.itemImage);
        textView = itemView.findViewById(R.id.itemDescription);
    }
    //Method to set image id of imageview
    public void setImageResource(int id){
        imageView.setImageResource(id);
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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

    private ArrayList<Item> itemList; //list of items put into recyclerview

    public RecyclerViewAdapter(ArrayList<Item> itemList){
        this.itemList = itemList;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.item, viewGroup, false);
        return new RecyclerViewHolder(itemView);
    }

    //method to set the elements of each cardview in the recyclerview
    @Override
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int i) {
        recyclerViewHolder.setImageResource(itemList.get(i).getImageID());
        recyclerViewHolder.setImageTag(itemList.get(i).getName());
        recyclerViewHolder.setText(itemList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
