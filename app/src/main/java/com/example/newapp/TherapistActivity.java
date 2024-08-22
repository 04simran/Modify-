package com.example.newapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newapp.care.Selfcareactivity;
import com.example.newapp.diary.JournalActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class TherapistActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerview;
    ArrayList<DrModel> drModelArrayList =new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapist);


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_therepist);
        recyclerview = findViewById(R.id.recyclerview_doctor);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        //adding dr data
        drModelArrayList.add(new DrModel(R.drawable.nish, "Dr. Nisha Khanna", "Experience: 21+years"));
        drModelArrayList.add(new DrModel(R.drawable.prerna, "Dr. Prerna Khanna", "Experience: 14+years"));
        drModelArrayList.add(new DrModel(R.drawable.shailja, "Dr. Shailaja Pokhriyal", "Experience: 17+years"));
        drModelArrayList.add(new DrModel(R.drawable.drmadhusudan, "Dr. Madhusudan singh", "Experience: 14+years"));
        drModelArrayList.add(new DrModel(R.drawable.drvisha, "Dr. Vishakha Bhalla", "Experience: 6+years"));
        drModelArrayList.add(new DrModel(R.drawable.nish, "Dr. Nisha Khanna", "Experience: 21+years"));

        DrAdapter adapter = new DrAdapter(this, drModelArrayList);
        recyclerview.setAdapter(adapter);








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
                    return true;
                } else if (itemId == R.id.bottom_selfcare) {
                    startActivity(new Intent(getApplicationContext(), Selfcareactivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });


    }

}