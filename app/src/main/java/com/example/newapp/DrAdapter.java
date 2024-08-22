package com.example.newapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DrAdapter extends RecyclerView.Adapter<DrAdapter.ViewHolder> {

    ArrayList<DrModel> drModelArrayList = new ArrayList<>();
    Context context;
    int clicked = 0;
    private  static  final  int REQUEST_CALL = 1;

    public DrAdapter( Context context ,ArrayList<DrModel> drModelArrayList) {
        this.context = context;
        this.drModelArrayList = drModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(context).inflate(R.layout.therapist_item,parent,false );
      ViewHolder viewHolder = new ViewHolder(view);
      return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imagedoc.setImageResource(drModelArrayList.get(position).getDrimg());
        holder.Docname.setText(drModelArrayList.get(position).getDrname());
        holder.Docexp.setText(drModelArrayList.get(position).getDrexp());
        holder.pay.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(context, Paydr.class);
                context.startActivity(intent);
                clicked = 1;
            }
        });

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked<3 && clicked>=1)
                {
                   Intent i = new Intent(context, videocalldr.class);
                    context.startActivity(i);
                    clicked++;
                }else{
                    Toast.makeText(context, "You Have To Do The Payment First", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }






    @Override
    public int getItemCount() {
        return drModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imagedoc;
        TextView Docname, Docexp;
        Button pay , call;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagedoc = itemView.findViewById(R.id.dr_img);
           Docname = itemView.findViewById(R.id.dr_name);
           Docexp = itemView.findViewById(R.id.dr_exp);
           pay = itemView.findViewById(R.id.pay_dr);
           call = itemView.findViewById(R.id.call_dr);

        }

    }
}
