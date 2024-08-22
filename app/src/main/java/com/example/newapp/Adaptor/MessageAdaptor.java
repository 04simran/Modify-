package com.example.newapp.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newapp.Models.MessageModel;
import com.example.newapp.R;

import java.util.List;

public class MessageAdaptor extends RecyclerView.Adapter<MessageAdaptor.MyViewHolder>{
    List<MessageModel> messageList;
    Context context;

    public MessageAdaptor(List<MessageModel> messageList) {
        this.messageList = messageList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chatView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(chatView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       MessageModel message = messageList.get(position);
       if (message.getSentBy().equals(MessageModel.SENT_BY_ME)){

           holder.leftchatview.setVisibility(View.GONE);
           holder.rightchatview.setVisibility(View.VISIBLE);
           holder.rightTextView.setText(message.getMessage());

       }else{
           holder.rightchatview.setVisibility(View.GONE);
           holder.leftchatview.setVisibility(View.VISIBLE);
           holder.leftTextView.setText(message.getMessage());
       }

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
   LinearLayout leftchatview, rightchatview;
   TextView  leftTextView, rightTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rightchatview = itemView.findViewById(R.id.right_chat_view);
            leftchatview= itemView.findViewById(R.id.left_chat_view);
            leftTextView = itemView.findViewById(R.id.left_chat_text_view);
            rightTextView = itemView.findViewById(R.id.right_chat_text_view);
        }
    }
}
