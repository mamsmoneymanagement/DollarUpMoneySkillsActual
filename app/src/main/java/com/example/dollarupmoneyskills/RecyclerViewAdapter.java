package com.example.dollarupmoneyskills;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class RecyclerViewHolder extends RecyclerView.ViewHolder{
    private ImageView imageView;
    private TextView textView;
    public RecyclerViewHolder(View itemView){
        super(itemView);
        imageView = itemView.findViewById(R.id.itemImage);
        textView = itemView.findViewById(R.id.itemDescription);
    }
    public void setImageResource(int id){
        imageView.setImageResource(id);
    }
    public void setImageTag(String tag){
        imageView.setTag(tag);
    }
    public void setText(String text){
        textView.setText(text);
    }
}

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

    private ArrayList<Item> itemList;

    public RecyclerViewAdapter(ArrayList<Item> itemList){
        this.itemList = itemList;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.item, viewGroup, false);
        return new RecyclerViewHolder(itemView);
    }

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
