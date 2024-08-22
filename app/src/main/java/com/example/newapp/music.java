package com.example.newapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class music extends AppCompatActivity {
    private ArrayList<musiccmodel> my_main_arraylist;
    private musicadapter mymusicadapter;
    private ListView list_song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        list_song = findViewById(R.id.listview_songs);
        my_main_arraylist = new ArrayList<>();
        my_main_arraylist.add(new musiccmodel("Water Flow","water flow sound",R.raw.river,R.drawable.river));
        my_main_arraylist.add(new musiccmodel("Forest/Nature-Background","Nature Background for Calming body",R.raw.forest,R.drawable.forest));
        my_main_arraylist.add(new musiccmodel("Lord Krishna's Flute","Indian Meitation & Relaxation",R.raw.flute,R.drawable.fluit));
        my_main_arraylist.add(new musiccmodel("Forest/Nature-Background","Nature Background for Calming body",R.raw.forest,R.drawable.forest));
        my_main_arraylist.add(new musiccmodel("Relaxing on Beach","Relaxing Music on Beach",R.raw.beach,R.drawable.beach));
        my_main_arraylist.add(new musiccmodel("Jungle/Forest","Meditation with nature",R.raw.birds,R.drawable.birds));
        my_main_arraylist.add(new musiccmodel("Relaxing Music","Meditate-Meditate",R.raw.meditation,R.drawable.meditation));
        my_main_arraylist.add(new musiccmodel("Water Fall","Rain-Relax",R.raw.rainsound,R.drawable.rainfall));
        musicadapter adapter = new musicadapter(this, R.layout.song_item, my_main_arraylist);
        list_song.setAdapter(adapter);
    }
}