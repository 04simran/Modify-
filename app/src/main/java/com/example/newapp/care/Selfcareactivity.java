package com.example.newapp.care;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.newapp.Exercise;
import com.example.newapp.Food;
import com.example.newapp.MainActivity;
import com.example.newapp.R;
import com.example.newapp.TherapistActivity;
import com.example.newapp.diary.JournalActivity;
import com.example.newapp.helpline;
import com.example.newapp.mememain;
import com.example.newapp.music;
import com.example.newapp.pillreminder;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Selfcareactivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    CardView food,exer,fu,musi,pillls,crises;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfcareactivity);
        food = findViewById(R.id.food);
        exer = findViewById(R.id.EXErsiseee);
        fu =findViewById(R.id.FUNN);
        musi=findViewById(R.id.MUSICCC);
        pillls=findViewById(R.id.PILLLS);
        crises = findViewById(R.id.crises);
        bottomNavigationView = findViewById(R.id.bottom_navigation);


        crises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Selfcareactivity.this, helpline.class));
            }
        });

        exer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Selfcareactivity.this, Exercise.class));
            }
        });
        fu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Selfcareactivity.this, mememain.class));
            }
        });
        musi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Selfcareactivity.this, music.class));
            }
        });
        pillls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Selfcareactivity.this, pillreminder.class));
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Selfcareactivity.this, Food.class));
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.bottom_selfcare);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.bottom_home) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.bottom_journal) {
                    startActivity(new Intent(getApplicationContext(), JournalActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.bottom_therepist) {
                    startActivity(new Intent(getApplicationContext(), TherapistActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.bottom_selfcare) {
                    return true;
                }
                return false;
            }
        });
    }
}