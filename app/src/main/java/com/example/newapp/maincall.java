package com.example.newapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton;
import com.zegocloud.uikit.service.defines.ZegoUIKitUser;

import java.util.Collections;

public class maincall extends AppCompatActivity {
  TextView tv;
    EditText useredit;
    ZegoSendCallInvitationButton voicecall, videocall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maincall);
        useredit = findViewById(R.id.usereditTextText);
        voicecall = findViewById(R.id.voice_call_button);
        videocall = findViewById(R.id.video_call_button);
        tv = findViewById(R.id.userrrrrrrrr);

        String userID = getIntent().getStringExtra("userID");
        tv.setText("Hey  "+userID);
        useredit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String targetUserID = useredit.getText().toString().trim();
                setvideocall(targetUserID);
                setvoicecall(targetUserID);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

     void setvoicecall(String targetUserID){
         voicecall.setIsVideoCall(false);
         voicecall.setResourceID("zego_uikit_call");
         voicecall.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetUserID)));

     }
    void setvideocall(String targetUserID){

        videocall.setIsVideoCall(true);
        videocall.setResourceID("zego_uikit_call");
        videocall.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetUserID)));
        
    }
}