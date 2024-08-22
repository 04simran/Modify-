package com.example.newapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.newapp.Models.UserModel;
import com.example.newapp.care.Selfcareactivity;
import com.example.newapp.diary.JournalActivity;
import com.example.newapp.ui.signupactivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

   CircleImageView setting,profile;

    TextView viewall;
    FirebaseAuth auth;
    FirebaseDatabase database;
    String id;
     private ImageSlider imageSlider;
     CardView musicc,meme,dayplanner,aitalk,pills,exercise;


    FirebaseStorage storage;
   private  static  final  int REQUEST_CALL = 1;
     private  TextView username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pills = findViewById(R.id.pill);
        exercise = findViewById(R.id.exercise);
        profile = findViewById(R.id.profile);
        database = FirebaseDatabase.getInstance();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        aitalk = findViewById(R.id.ai_talk);
        dayplanner = findViewById(R.id.day_planner);
        username = findViewById(R.id.userrr);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
         setting = findViewById(R.id.setting);
        imageSlider = findViewById(R.id.ImageSliderr);
        musicc = findViewById(R.id.music);
        meme = findViewById(R.id.memes);
        auth = FirebaseAuth.getInstance();
        viewall = findViewById(R.id.view_all);

        id = auth.getCurrentUser().getUid();
         makecall();


 //fetching userprofile
        storage = FirebaseStorage.getInstance();
        database.getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                        UserModel userModel = snapshot.getValue(UserModel.class);
                        Glide.with(getApplicationContext()).load(userModel.getProfileImg()).into(profile);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, userprofile.class));
            }

        });



        //setting
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), setting);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.log_out) {
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(getApplicationContext(), signupactivity.class));
                            finish();

                        }
                        return false;
                    }

                });
                popupMenu.inflate(R.menu.toolbar_menu);
                popupMenu.show();
            }
        });

       exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Exercise.class));
            }
        });


       //opening selfcare
        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Selfcareactivity.class));
            }
        });

        //opening music
        musicc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, music.class));
            }
        });

        //meme
        meme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, mememain.class));
            }
        });




      //fetching username
    database.getReference().child("Users").child(id).addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            UserModel userModel = snapshot.getValue(UserModel.class);
            String hi = userModel.getName();
            username.setText(hi);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });




        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.bottom_home) {
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
                    startActivity(new Intent(getApplicationContext(), Selfcareactivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });

        //open ai
        aitalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChatAiactivity.class));
            }
        });

        dayplanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DayPlannerActivity.class));
            }
        });
           //Sos calling



     pills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), pillreminder.class));
            }
        });

        //creating a list of image foe imageslideree

        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.doc1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.doc2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.doc3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.doc4, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels,ScaleTypes.FIT);
        //

    }

    private void makecall() {
       String call = "18002738255";
       if(call.length() > 0){
           if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
           != PackageManager.PERMISSION_GRANTED){
               ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);

           }


    }






}}