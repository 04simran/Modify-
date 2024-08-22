package com.example.newapp;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.zegocloud.uikit.prebuilt.call.config.ZegoNotificationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationService;

public class videocalldr extends AppCompatActivity {
 EditText userIdedittext;
 Button strtbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videocalldr);
        userIdedittext = findViewById(R.id.callname);
        strtbtn = findViewById(R.id.startbutton);
        strtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = userIdedittext.getText().toString().trim();
                if(userID.isEmpty()){
                    return;
                }
                //startservice
                startService(userID);
                Intent i = new Intent(videocalldr.this,maincall.class);
                i.putExtra("userID", userID);
               startActivity(i);
                
            }
        });
    }
    void startService(String userID){
        Application application = getApplication(); // Android's application context
        long appID = 1718070428;   // yourAppID
        String appSign = "d957ec0f5dd2a79f799c487e6ee9a0dbd4608faefa1f8286bea58fb51d1d100e";  // yourAppSign
         // yourUserID, userID should only contain numbers, English characters, and '_'.
        String userName = userID;   // yourUserName

        ZegoUIKitPrebuiltCallInvitationConfig callInvitationConfig = new ZegoUIKitPrebuiltCallInvitationConfig();
        callInvitationConfig.notifyWhenAppRunningInBackgroundOrQuit = true;
        ZegoNotificationConfig notificationConfig = new ZegoNotificationConfig();
        notificationConfig.sound = "zego_uikit_sound_call";
        notificationConfig.channelID = "CallInvitation";
        notificationConfig.channelName = "CallInvitation";
        ZegoUIKitPrebuiltCallInvitationService.init(getApplication(), appID, appSign, userID, userName,callInvitationConfig);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ZegoUIKitPrebuiltCallInvitationService.unInit();
    }
}