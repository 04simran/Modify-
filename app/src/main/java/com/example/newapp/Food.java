package com.example.newapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class Food extends AppCompatActivity {
    ViewPager2 viewPager2;
    ArrayList<ViewPagerItem> viewPagerItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        viewPager2 = findViewById(R.id.viewpager);
        int[] images= {R.drawable.egg,R.drawable.turmeric,R.drawable.blueberries,R.drawable.orange,R.drawable.pumkin,
                R.drawable.brocolli};
        String[] heading = {"Eggs","Turmeric","BlueBerries","Oranges","Pumkin Seeds","Brocolli",};
        String[] desc = {getString(R.string.Eggs),
                getString(R.string.Turmeric),
                getString(R.string.berries),
                getString(R.string.oranges),
                getString(R.string.pumkin),
                getString(R.string.Brocolli),
        };

        viewPagerItemArrayList = new ArrayList<>();
        for (int i = 0; i<images.length;i++){
            ViewPagerItem viewPagerItem = new ViewPagerItem(images[i],heading[i],desc[i]);
            viewPagerItemArrayList.add(viewPagerItem);
        }
        VPAdapter adapter = new VPAdapter(viewPagerItemArrayList);
        viewPager2.setAdapter(adapter);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
    }
}