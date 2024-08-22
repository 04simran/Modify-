package com.example.newapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class helpline extends AppCompatActivity {
 FloatingActionButton f1, f2,f3,f4,f5,f6,f7,f8,f9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);
       f1 = findViewById(R.id.f1);
        f2 = findViewById(R.id.f2);
        f3 = findViewById(R.id.f3);
        f4 = findViewById(R.id.f4);
        f5 = findViewById(R.id.f5);
        f6 = findViewById(R.id.f6);
        f7 = findViewById(R.id.f7);
        f8 = findViewById(R.id.f8);
        f9 = findViewById(R.id.f9);
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = "9152987821";
                if(call.length() > 0){
                    String dial = "tel:" + call;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        });
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = "18602662345";
                if(call.length() > 0){
                    String dial = "tel:" + call;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        });
        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = "18002333330";
                if(call.length() > 0){
                    String dial = "tel:" + call;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        });
        f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = "9152987821";
                if(call.length() > 0){
                    String dial = "tel:" + call;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        });
        f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = "4424448830";
                if(call.length() > 0){
                    String dial = "tel:" + call;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        });
        f6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = "9152987821";
                if(call.length() > 0){
                    String dial = "tel:" + call;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        });
        f7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = "4842540530";
                if(call.length() > 0){
                    String dial = "tel:" + call;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        });
        f8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = "9152987821";
                if(call.length() > 0){
                    String dial = "tel:" + call;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        });
        f9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = "9152987821";
                if(call.length() > 0){
                    String dial = "tel:" + call;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        });

    }
}