package com.example.newapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newapp.MainActivity;
import com.example.newapp.Models.UserModel;
import com.example.newapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;
import java.util.Map;

public class signupactivity extends AppCompatActivity {
    Button signUp;
    EditText name, email, password;
    TextView signIn;
    FirebaseAuth auth;
    FirebaseDatabase database;
    public  String username;
    public void onStart(){

        super.onStart();
        FirebaseUser CurrentUser = auth.getCurrentUser();
        if(CurrentUser !=  null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);


        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        signUp = findViewById(R.id.login_btn);
        email = findViewById(R.id.email_reg);
        password = findViewById(R.id.password_reg);
        name = findViewById(R.id.name);
        signIn = findViewById(R.id.sign_in);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signupactivity.this, Loginactivity.class));
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
    }
        private void createUser() {
            String userName = name.getText().toString();
            String userEmail = email.getText().toString();
            String userPassword = password.getText().toString();
            if(TextUtils.isEmpty(userName)){
                Toast.makeText(this, "Name is Empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(userEmail)){
                Toast.makeText(this, "Email is Empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(userPassword)){
                Toast.makeText(this, "Password is Empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if(userPassword.length()<6){
                Toast.makeText(this, "Password length must be greater than 6 letters", Toast.LENGTH_SHORT).show();
                return;
            }
            //create user
            auth.createUserWithEmailAndPassword(userEmail, userPassword)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                UserModel userModel = new UserModel(userName,userEmail,userPassword);
                                String id = task.getResult().getUser().getUid();
                                database.getReference().child("Users").child(id).setValue(userModel);
                                Toast.makeText(signupactivity.this, "Registration Successfull",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(signupactivity.this, Loginactivity.class));
                                finish();
                            }
                            else{

                                Toast.makeText(signupactivity.this, "Registration Failed"+task.getException(),Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
    }}
