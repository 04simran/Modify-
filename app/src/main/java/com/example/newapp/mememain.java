package com.example.newapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;




public class mememain extends AppCompatActivity {
    ImageView memeimge;
    Button share;
    ProgressBar progressBar;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mememain);
        memeimge = findViewById(R.id.memeimg);
        share = findViewById(R.id.nextmeme);
        progressBar = findViewById(R.id.probar);


        loadImg();
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loadImg();
            }
        });
    }

    public void loadImg(){
        url = "https://meme-api.com/gimme" ;
        progressBar.setVisibility(View.VISIBLE);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                            try {
                                 url = response.getString("url");
                                 Glide.with(mememain.this).load(url).listener(new RequestListener<Drawable>() {
                                     @Override
                                     public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                         progressBar.setVisibility(View.INVISIBLE);
                                         return false;
                                     }

                                     @Override
                                     public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                        progressBar.setVisibility(View.INVISIBLE);
                                         return false;
                                     }
                                 }).into(memeimge);
                             } catch (JSONException e) {
                                 throw new RuntimeException(e);
                             }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

    }


    }
