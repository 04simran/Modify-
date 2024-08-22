package com.example.newapp.Adaptor;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newapp.AddNewTask;
import com.example.newapp.DayPlannerActivity;
import com.example.newapp.MainActivity;
import com.example.newapp.Models.DayPlannerModel;
import com.example.newapp.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class DayPlannerAdaptor extends RecyclerView.Adapter<DayPlannerAdaptor.MyViewHolder> {
  private List<DayPlannerModel> dayPlannerModelList;
  private DayPlannerActivity activity;
  private FirebaseFirestore firestore;

    public DayPlannerAdaptor(DayPlannerActivity activity,List<DayPlannerModel> dayPlannerModelList) {
        this.dayPlannerModelList = dayPlannerModelList;
       this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.each_task, parent,false);
        firestore= FirebaseFirestore.getInstance();
        return new MyViewHolder(view);
    }

    public void deletetask(int position){
        DayPlannerModel dayPlannerModel = dayPlannerModelList.get(position);
        firestore.collection("task").document(dayPlannerModel.TaskId).delete();
        dayPlannerModelList.remove(position);
        notifyItemRemoved(position);
    }

    public Context getContext(){
        return  activity;

    };

    public  void edittask(int position){
        DayPlannerModel dayPlannerModel = dayPlannerModelList.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("task", dayPlannerModel.getTask());
        bundle.putString("due", dayPlannerModel.getDue());
        bundle.putString("id", dayPlannerModel.TaskId);

        AddNewTask addNewTask = new AddNewTask();
        addNewTask.setArguments(bundle);
        addNewTask.show(activity.getSupportFragmentManager(), addNewTask.getTag());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        DayPlannerModel dayPlannerModel = dayPlannerModelList.get(position);
        holder.mcheckbox.setText(dayPlannerModel.getTask());
        holder.mduedatetv.setText( " Due On" +dayPlannerModel.getDue());

        holder.mcheckbox.setChecked(toboolean(dayPlannerModel.getStatus()));
        holder.mcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    firestore.collection("task").document(dayPlannerModel.TaskId).update("status",1);


                }else{
                    firestore.collection("task").document(dayPlannerModel.TaskId).update("staus",0);
                }
            }
        });

    }
    private Boolean toboolean(int status){
        return status!=0;
    }

    @Override
    public int getItemCount() {
        return dayPlannerModelList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
  TextView mduedatetv;
  CheckBox mcheckbox;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mduedatetv = itemView.findViewById(R.id.due_date_tv);
            mcheckbox = itemView.findViewById(R.id.checkbox);
        }
    }
}
