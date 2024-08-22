package com.example.newapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class Exercise extends AppCompatActivity {
    RecyclerView newvideo;
    Vector<youtubevideo> youtubevideos = new Vector<youtubevideo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        newvideo = findViewById(R.id.videorecycler);
        newvideo.setHasFixedSize(true);
        newvideo.setLayoutManager( new LinearLayoutManager(this));
        youtubevideos.add(new youtubevideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/sFtP0HWvu0k?si=PgOcaMeylu0BpYkV\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"));
        youtubevideos.add(new youtubevideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tjCdGdgx2OU?si=xFYYHLs0h0GHhb3N\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"));
        youtubevideos.add(new youtubevideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/gzjJGtlztx8?si=0rwXyqAlL9v7kuIc\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"));
        youtubevideos.add(new youtubevideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Sxddnugwu-8?si=D2NMxzzpSdxcm_vh\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"));
        youtubevideos.add(new youtubevideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/yqeirBfn2j4?si=4HnDUk0x9ncp9MjN\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"));
        youtubevideos.add(new youtubevideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/iqcAWup2aCE?si=vcMkTUdLfxyIaZVC\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"));
        youtubevideos.add(new youtubevideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/J3VbyPwoMug?si=nXstePTK-yesB0DL\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"));
        youtubevideos.add(new youtubevideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/VpW33Celubg?si=ZA3wkOVxUYb0gj_z\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"));

        videoadapter videooadapter = new videoadapter(youtubevideos);
        newvideo.setAdapter(videooadapter);

    }
}