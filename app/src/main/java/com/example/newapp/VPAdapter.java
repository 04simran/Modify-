package com.example.newapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VPAdapter extends RecyclerView.Adapter<VPAdapter.ViewHolder> {

    ArrayList<ViewPagerItem> viewPagerItemArrayList;

    public VPAdapter(ArrayList<ViewPagerItem> viewPagerItemArrayList) {
        this.viewPagerItemArrayList = viewPagerItemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewpager_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ViewPagerItem viewPagerItem = viewPagerItemArrayList.get(position);
        holder.imageView.setImageResource(viewPagerItem.imgid);
        holder.tvheading.setText(viewPagerItem.heading);
        holder.tvdesciption.setText(viewPagerItem.description);

    }

    @Override
    public int getItemCount() {
        return viewPagerItemArrayList.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvheading, tvdesciption;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             imageView = itemView.findViewById(R.id.ivimage);
             tvheading = itemView.findViewById(R.id.tvHeading);
             tvdesciption = itemView.findViewById(R.id.tvDesc);
        }
    }
}
