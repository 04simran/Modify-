package com.example.newapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newapp.Adaptor.MessageAdaptor;
import com.example.newapp.Models.MessageModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatAiactivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView welcometextview;
    EditText messageEdittext;
    ImageButton sendbutton;

    List<MessageModel> messageList;
    MessageAdaptor messageAdaptor;
     String key = "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";

   public  static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
   OkHttpClient client = new OkHttpClient.Builder()
           .readTimeout(60, TimeUnit.SECONDS).build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_aiactivity);

        messageList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        welcometextview = findViewById(R.id.welcome_text);
        messageEdittext = findViewById(R.id.message_edit_text);
        sendbutton = findViewById(R.id.send_btn);
//setup recyclerview

        messageAdaptor = new MessageAdaptor(messageList);
        recyclerView.setAdapter(messageAdaptor);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setStackFromEnd(true);
        recyclerView.setLayoutManager(llm);

        sendbutton.setOnClickListener((v) -> {
            String question = messageEdittext.getText().toString().trim();
         addToChat(question,MessageModel.SENT_BY_ME);
         callAPI(question);
         messageEdittext.setText("");
         welcometextview.setVisibility(View.GONE);

        });


    }
    void addToChat(String message,String sentBy){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageList.add(new MessageModel(message,sentBy));
                messageAdaptor.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(messageAdaptor.getItemCount());

            }
        });

    }


    void AddResonse(String response){
        addToChat(response, MessageModel.SENT_BY_BOT);
    }

    void callAPI(String question){

        JSONObject jsonbody = new JSONObject();
        try {
            jsonbody.put("model", "text-davinci-003");
            jsonbody.put("prompt",question);
            jsonbody.put("max_tokens",1000);
            jsonbody.put("temperature",0);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        RequestBody body = RequestBody.create(jsonbody.toString(),JSON);
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/completions")
                .header("Authorization","Bearer "+key)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                AddResonse("Failed to load the message" +e.getMessage());

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){

                    JSONObject jsonobject = null;
                    try {
                        jsonobject = new JSONObject(response.body().string());
                        JSONArray jsonArray = jsonobject.getJSONArray("choices");
                        String result = jsonArray.getJSONObject(0).getString("text");
                        AddResonse(result.trim());
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }


                }else{
                    AddResonse("Failed to load the message" +response.body().toString());
                }

            }
        });


    }




}