package com.example.newapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class videoadapter  extends RecyclerView.Adapter<videoadapter.VideoHolder> {
    List<youtubevideo> youtubevideos;

    public videoadapter() {
    }

    public videoadapter(@NonNull List<youtubevideo> youtubevideos) {
        this.youtubevideos = youtubevideos;
    }
    @NonNull
    @Override


    public videoadapter.VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videoview, parent,false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull videoadapter.VideoHolder holder, int position) {
        holder.videoweb.loadData(youtubevideos.get(position).getVideourl(), "text/html", "utf-8");

    }

    @Override
    public int getItemCount() {
        return youtubevideos.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder {
    WebView videoweb;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            videoweb = itemView.findViewById(R.id.videoview);
            videoweb.getSettings().setJavaScriptEnabled(true);
            videoweb.setWebChromeClient(new WebChromeClient());


        }
    }
}
